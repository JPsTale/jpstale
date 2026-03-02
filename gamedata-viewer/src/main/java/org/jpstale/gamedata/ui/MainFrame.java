package org.jpstale.gamedata.ui;

import org.jpstale.gamedata.service.SimpleGameDataService;
import org.jpstale.gamedata.service.SimpleGameServiceImpl;
import org.jpstale.gamedata.model.SimpleMonsterData;
import org.jpstale.gamedata.model.SimpleNPCData;
import org.jpstale.gamedata.model.SimpleItemData;
import org.jpstale.gamedata.model.SimpleMapData;
// import org.jpstale.gamedata.service.FullGameServiceImpl;
// import org.jpstale.gamedata.service.RealGameDataService;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.DefaultTreeSelectionModel;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;

import java.awt.*;
import java.io.File;
import java.util.*;

/**
 * 主窗口界面
 */
public class MainFrame extends JFrame {

    private static int DEFAULT_WIDTH = 1200;
    private static int DEFAULT_HEIGHT = 800;

    private SimpleGameDataService gameDataService;

    // UI组件
    private JTextArea logArea;
    private JSplitPane mainSplitPane;
    private JSplitPane rightSplitPane;
    private DetailPanel detailPanel;
    private SearchPanel searchPanel;
    private JLabel statusLabel;

    public MainFrame() {
        // 默认使用简化版服务，但允许切换
        gameDataService = new SimpleGameServiceImpl();

        initializeUI();
        loadTestData(); // 最初加载测试数据
    }

    /**
     * 初始化用户界面
     */
    private void initializeUI() {
        setTitle("JPsTale GameServer 配置查看器");
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // 创建菜单栏
        createMenuBar();

        // 创建主要内容区域
        createMainContent();

        // 创建状态栏
        createStatusBar();
    }

    /**
     * 创建菜单栏
     */
    private void createMenuBar() {
        JMenuBar menuBar = new JMenuBar();

        // 文件菜单
        JMenu fileMenu = new JMenu("文件");

        JMenuItem openItem = new JMenuItem("打开GameServer目录...");
        openItem.addActionListener(e -> openGameServerDirectory());
        fileMenu.add(openItem);

        fileMenu.addSeparator();

        JMenuItem exitItem = new JMenuItem("退出");
        exitItem.addActionListener(e -> System.exit(0));
        fileMenu.add(exitItem);

        menuBar.add(fileMenu);

        // 工具菜单
        JMenu toolsMenu = new JMenu("工具");

        JMenuItem exportItem = new JMenuItem("导出为Groovy脚本...");
        exportItem.addActionListener(e -> exportToGroovy());
        toolsMenu.add(exportItem);

        JMenuItem exportJsonItem = new JMenuItem("导出为JSON...");
        exportJsonItem.addActionListener(e -> exportToJson());
        toolsMenu.add(exportJsonItem);

        toolsMenu.addSeparator();

        JMenuItem statsItem = new JMenuItem("数据统计...");
        statsItem.addActionListener(e -> showDataStatistics());
        toolsMenu.add(statsItem);

        JMenuItem dropAnalysisItem = new JMenuItem("掉落物分析...");
        dropAnalysisItem.addActionListener(e -> showDropAnalysis());
        toolsMenu.add(dropAnalysisItem);

        JMenuItem mapAnalysisItem = new JMenuItem("地图分析...");
        mapAnalysisItem.addActionListener(e -> showMapAnalysis());
        toolsMenu.add(mapAnalysisItem);

        toolsMenu.addSeparator();

        JCheckBoxMenuItem useFullLoader = new JCheckBoxMenuItem("使用完整加载器");
        useFullLoader.addActionListener(e -> toggleLoaderMode(useFullLoader.isSelected()));
        toolsMenu.add(useFullLoader);

        menuBar.add(toolsMenu);

        // 帮助菜单
        JMenu helpMenu = new JMenu("帮助");

        JMenuItem aboutItem = new JMenuItem("关于");
        aboutItem.addActionListener(e -> showAboutDialog());
        helpMenu.add(aboutItem);

        menuBar.add(helpMenu);

        setJMenuBar(menuBar);
    }

    /**
     * 创建主要内容区域
     */
    private void createMainContent() {
        // 创建左侧搜索面板
        searchPanel = new SearchPanel(gameDataService);

        // 创建简单的树
        DefaultTreeModel model = createTreeModel(gameDataService);
        JTree tree = new JTree(model);
        JScrollPane treeScrollPane = new JScrollPane(tree);
        treeScrollPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        // 创建右侧详情面板
        detailPanel = new DetailPanel();
        JScrollPane detailScrollPane = new JScrollPane(detailPanel);
        detailScrollPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        // 创建右侧分割面板（中部：文件列表，右侧：详情）
        rightSplitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
        rightSplitPane.setLeftComponent(treeScrollPane);
        rightSplitPane.setRightComponent(detailScrollPane);
        rightSplitPane.setDividerLocation(300);

        // 创建主分割面板（左侧：搜索，右侧：列表和详情）
        mainSplitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
        mainSplitPane.setLeftComponent(searchPanel);
        mainSplitPane.setRightComponent(rightSplitPane);
        mainSplitPane.setDividerLocation(350);

        // 创建底部日志面板
        logArea = new JTextArea();
        logArea.setEditable(false);
        logArea.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 12));
        JScrollPane logScrollPane = new JScrollPane(logArea);
        logScrollPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        logScrollPane.setPreferredSize(new Dimension(-1, 150));

        // 设置主要布局
        setLayout(new BorderLayout());
        add(mainSplitPane, BorderLayout.CENTER);
        add(logScrollPane, BorderLayout.SOUTH);

        // 添加树选择监听器
        tree.addTreeSelectionListener(new TreeSelectionListener() {
            @Override
            public void valueChanged(TreeSelectionEvent e) {
                handleTreeSelection(e);
            }
        });
    }

    /**
     * 创建状态栏
     */
    private void createStatusBar() {
        JPanel statusPanel = new JPanel(new BorderLayout());
        statusPanel.setBorder(new EmptyBorder(2, 5, 2, 5));

        statusLabel = new JLabel("就绪");
        statusPanel.add(statusLabel, BorderLayout.WEST);

        JLabel dateLabel = new JLabel(new java.util.Date().toString());
        statusPanel.add(dateLabel, BorderLayout.EAST);

        add(statusPanel, BorderLayout.SOUTH);
    }

    /**
     * 加载测试数据
     */
    private void loadTestData() {
        SwingWorker<Void, String> worker = new SwingWorker<Void, String>() {
            @Override
            protected Void doInBackground() throws Exception {
                // 加载测试数据
                gameDataService.loadGameData(null);
                publish("已加载测试数据");
                return null;
            }

            @Override
            protected void process(java.util.List<String> chunks) {
                for (String message : chunks) {
                    log(message);
                }
            }

            @Override
            protected void done() {
                updateTree();
                updateStatusText("就绪");
            }
        };
        worker.execute();
    }

    /**
     * 加载游戏数据
     */
    private void loadGameData() {
        SwingWorker<Void, String> worker = new SwingWorker<Void, String>() {
            @Override
            protected Void doInBackground() throws Exception {
                // 尝试从默认路径加载
                String defaultPath = "/Users/yanmaoyuan/3060/GameServer";
                File gameServerDir = new File(defaultPath);

                if (gameServerDir.exists()) {
                    publish("从默认路径加载: " + defaultPath);
                    gameDataService.loadGameData(gameServerDir);
                } else {
                    publish("未找到GameServer目录，请使用文件菜单手动选择");
                }

                return null;
            }

            @Override
            protected void process(java.util.List<String> chunks) {
                for (String message : chunks) {
                    log(message);
                }
            }

            @Override
            protected void done() {
                updateUI();
                updateTree();
            }
        };

        worker.execute();
    }

    /**
     * 打开GameServer目录
     */
    private void openGameServerDirectory() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        fileChooser.setDialogTitle("选择GameServer目录");

        if (fileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            File selectedDir = fileChooser.getSelectedFile();

            SwingWorker<Void, String> worker = new SwingWorker<Void, String>() {
                @Override
                protected Void doInBackground() throws Exception {
                    publish("正在加载数据: " + selectedDir.getAbsolutePath());
                    gameDataService.loadGameData(selectedDir);
                    return null;
                }

                @Override
                protected void process(java.util.List<String> chunks) {
                    for (String message : chunks) {
                        log(message);
                    }
                }

                @Override
                protected void done() {
                    updateUI();
                    log("数据加载完成");
                }
            };

            worker.execute();
        }
    }

    /**
     * 导出为Groovy脚本
     */
    private void exportToGroovy() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("导出Groovy脚本");
        fileChooser.setFileFilter(new javax.swing.filechooser.FileNameExtensionFilter("Groovy文件 (*.groovy)", "groovy"));
        fileChooser.setSelectedFile(new java.io.File("gamedata.groovy"));

        if (fileChooser.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();

            SwingWorker<Void, String> worker = new SwingWorker<Void, String>() {
                @Override
                protected Void doInBackground() throws Exception {
                    try {
                        publish("正在导出Groovy脚本...");

                        try (java.io.PrintWriter writer = new java.io.PrintWriter(new java.io.FileWriter(file))) {
                            writer.println("// JPsTale GameServer Data Export");
                            writer.println("// Exported at: " + new java.util.Date());
                            writer.println();

                            // 导出怪物数据
                            writer.println("// ========== 怪物数据 ==========");
                            for (SimpleMonsterData monster : gameDataService.getAllMonsters()) {
                                writer.printf("monster {\n");
                                writer.printf("    id = '%s'\n", monster.getId());
                                writer.printf("    name = '%s'\n", monster.getName());
                                writer.printf("    level = %d\n", monster.getLevel());
                                writer.printf("    life = %d\n", monster.getLife());
                                writer.printf("    attack = [%d, %d]\n", monster.getMinAttack(), monster.getMaxAttack());
                                writer.printf("    defense = %d\n", monster.getDefense());
                                writer.printf("    exp = %d\n", monster.getExperience());
                                if (monster.getDropItems() != null && !monster.getDropItems().isEmpty()) {
                                    writer.printf("    drops = '%s'\n", monster.getDropItems());
                                }
                                writer.printf("}\n\n");
                            }

                            // 导出NPC数据
                            writer.println("// ========== NPC数据 ==========");
                            for (SimpleNPCData npc : gameDataService.getAllNPCs()) {
                                writer.printf("npc {\n");
                                writer.printf("    id = '%s'\n", npc.getId());
                                writer.printf("    name = '%s'\n", npc.getName());
                                writer.printf("    level = %d\n", npc.getLevel());
                                writer.printf("    isShopkeeper = %s\n", npc.isShopkeeper());
                                writer.printf("}\n\n");
                            }

                            // 导出地图数据
                            writer.println("// ========== 地图数据 ==========");
                            for (SimpleMapData map : gameDataService.getAllMaps()) {
                                writer.printf("map {\n");
                                writer.printf("    id = '%s'\n", map.getId());
                                writer.printf("    name = '%s'\n", map.getName());
                                writer.printf("    minLevel = %d\n", map.getMinLevel());
                                writer.printf("    maxLevel = %d\n", map.getMaxLevel());
                                writer.printf("    monsterCount = %d\n", map.getMonsterCount());
                                if (map.getMonsters() != null && !map.getMonsters().isEmpty()) {
                                    writer.printf("    monsters = '%s'\n", map.getMonsters());
                                }
                                writer.printf("}\n\n");
                            }
                        }

                        publish("Groovy脚本导出完成: " + file.getAbsolutePath());

                    } catch (Exception e) {
                        publish("导出失败: " + e.getMessage());
                    }
                    return null;
                }

                @Override
                protected void process(java.util.List<String> chunks) {
                    for (String message : chunks) {
                        log(message);
                    }
                }
            };

            worker.execute();
        }
    }

    /**
     * 导出为JSON
     */
    private void exportToJson() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("导出JSON文件");
        fileChooser.setFileFilter(new javax.swing.filechooser.FileNameExtensionFilter("JSON文件 (*.json)", "json"));
        fileChooser.setSelectedFile(new java.io.File("gamedata.json"));

        if (fileChooser.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();

            SwingWorker<Void, String> worker = new SwingWorker<Void, String>() {
                @Override
                protected Void doInBackground() throws Exception {
                    try {
                        publish("正在导出JSON数据...");

                        // 使用Gson导出
                        com.google.gson.Gson gson = new com.google.gson.GsonBuilder()
                            .setPrettyPrinting()
                            .create();

                        // 创建数据容器
                        java.util.Map<String, Object> data = new java.util.HashMap<>();
                        data.put("monsters", gameDataService.getAllMonsters());
                        data.put("npcs", gameDataService.getAllNPCs());
                        data.put("items", gameDataService.getAllItems());
                        data.put("maps", gameDataService.getAllMaps());
                        data.put("exportTime", new java.util.Date().toString());

                        // 写入文件
                        try (java.io.FileWriter writer = new java.io.FileWriter(file)) {
                            gson.toJson(data, writer);
                        }

                        publish("JSON导出完成: " + file.getAbsolutePath());

                    } catch (Exception e) {
                        publish("导出失败: " + e.getMessage());
                    }
                    return null;
                }

                @Override
                protected void process(java.util.List<String> chunks) {
                    for (String message : chunks) {
                        log(message);
                    }
                }
            };

            worker.execute();
        }
    }

    /**
     * 显示数据统计
     */
    private void showDataStatistics() {
        DataStatisticsDialog dialog = new DataStatisticsDialog(this, gameDataService);
        dialog.setVisible(true);
    }

    /**
     * 显示掉落物分析
     */
    private void showDropAnalysis() {
        String itemId = JOptionPane.showInputDialog(this, "请输入要查询的物品代码:", "掉落物分析", JOptionPane.QUESTION_MESSAGE);

        if (itemId != null && !itemId.trim().isEmpty()) {
            // 创建结果窗口
            JDialog resultDialog = new JDialog(this, "掉落物分析 - 物品代码: " + itemId, false);
            resultDialog.setSize(600, 400);
            resultDialog.setLocationRelativeTo(this);

            JTextArea textArea = new JTextArea();
            textArea.setEditable(false);
            textArea.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 12));
            JScrollPane scrollPane = new JScrollPane(textArea);
            resultDialog.add(scrollPane);

            // 查找掉落该物品的怪物
            StringBuilder result = new StringBuilder();
            result.append("掉落物品 ").append(itemId).append(" 的怪物:\n");
            result.append("=================================\n\n");

            int count = 0;
            for (SimpleMonsterData monster : gameDataService.getAllMonsters()) {
                if (monster.getDropItems() != null && monster.getDropItems().contains("[" + itemId + "]")) {
                    count++;
                    result.append(String.format("%3d. %-20s (等级 %d) - %s\n",
                        count, monster.getName(), monster.getLevel(), monster.getId()));
                    if (count >= 100) {
                        result.append("\n... (最多显示100个结果)\n");
                        break;
                    }
                }
            }

            if (count == 0) {
                result.append("没有找到掉落该物品的怪物。");
            } else {
                result.append(String.format("\n总共找到 %d 个怪物\n", count));
            }

            textArea.setText(result.toString());
            textArea.setCaretPosition(0);

            resultDialog.setVisible(true);
        }
    }

    /**
     * 显示地图分析
     */
    private void showMapAnalysis() {
        JDialog resultDialog = new JDialog(this, "地图分析", false);
        resultDialog.setSize(700, 500);
        resultDialog.setLocationRelativeTo(this);

        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);
        textArea.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 12));
        JScrollPane scrollPane = new JScrollPane(textArea);
        resultDialog.add(scrollPane);

        // 分析地图数据
        StringBuilder result = new StringBuilder();
        result.append("地图分析报告\n");
        result.append("=================================\n\n");

        // 按怪物数量排序
        java.util.List<SimpleMapData> maps = new ArrayList<>(gameDataService.getAllMaps());
        maps.sort((a, b) -> Integer.compare(b.getMonsterCount(), a.getMonsterCount()));

        result.append("怪物数量最多的地图 (Top 20):\n");
        result.append("---------------------------------\n");
        for (int i = 0; i < Math.min(20, maps.size()); i++) {
            SimpleMapData map = maps.get(i);
            result.append(String.format("%3d. %-20s - %d个怪物 (等级 %d-%d)\n",
                i + 1, map.getName(), map.getMonsterCount(), map.getMinLevel(), map.getMaxLevel()));
        }

        result.append("\n\n各级别地图分布:\n");
        result.append("---------------------------------\n");
        Map<String, Integer> levelRangeCount = new TreeMap<>();
        Map<String, java.util.List<String>> rangeMaps = new HashMap<>();

        for (SimpleMapData map : gameDataService.getAllMaps()) {
            if (map.getMonsterCount() > 0) {
                String range = String.format("%d-%d", map.getMinLevel(), map.getMaxLevel());
                levelRangeCount.put(range, levelRangeCount.getOrDefault(range, 0) + 1);

                rangeMaps.computeIfAbsent(range, k -> new java.util.ArrayList<>()).add(map.getName());
            }
        }

        for (Map.Entry<String, Integer> entry : levelRangeCount.entrySet()) {
            result.append(String.format("%s: %d个地图\n", entry.getKey(), entry.getValue()));
        }

        textArea.setText(result.toString());
        textArea.setCaretPosition(0);

        resultDialog.setVisible(true);
    }

    /**
     * 切换加载器模式
     */
    private void toggleLoaderMode(boolean useFullLoader) {
        SwingWorker<Void, String> worker = new SwingWorker<Void, String>() {
            @Override
            protected Void doInBackground() throws Exception {
                publish("正在切换加载器模式...");

                gameDataService = new SimpleGameServiceImpl();
                publish("已切换到简化模式");
                loadTestData(); // 重新加载测试数据

                return null;
            }

            @Override
            protected void process(java.util.List<String> chunks) {
                for (String message : chunks) {
                    log(message);
                }
            }

            @Override
            protected void done() {
                updateTree();
                updateStatusText("就绪");
            }
        };
        worker.execute();
    }


    /**
     * 显示关于对话框
     */
    private void showAboutDialog() {
        String message = "<html>" +
                "<h2>JPsTale GameServer 配置查看器</h2>" +
                "<p>版本: 1.0.0-SNAPSHOT</p>" +
                "<p>用于查看和管理Priston Tale游戏服务器配置文件</p>" +
                "<hr>" +
                "<p>支持的功能：</p>" +
                "<ul>" +
                "<li>查看怪物配置 (.inf)</li>" +
                "<li>查看NPC配置 (.npc)</li>" +
                "<li>查看地图刷怪点 (.spm/.spp/.spc)</li>" +
                "<li>查看道具配置 (.txt)</li>" +
                "</ul>" +
                "<p>&copy; 2026 JPsTale Project</p>" +
                "</html>";

        JOptionPane.showMessageDialog(this, message, "关于", JOptionPane.INFORMATION_MESSAGE);
    }

    /**
     * 更新UI
     */
    private void updateUI() {
        // 更新树模型等UI组件
        updateTree();
    }

    /**
     * 创建树模型
     */
    private DefaultTreeModel createTreeModel(SimpleGameDataService gameDataService) {
        DefaultMutableTreeNode root = new DefaultMutableTreeNode("游戏数据");

        // 创建分类节点
        DefaultMutableTreeNode monsterNode = new DefaultMutableTreeNode(
            "怪物 (" + gameDataService.getAllMonsters().size() + ")");
        DefaultMutableTreeNode npcNode = new DefaultMutableTreeNode(
            "NPC (" + gameDataService.getAllNPCs().size() + ")");
        DefaultMutableTreeNode itemNode = new DefaultMutableTreeNode(
            "道具 (" + gameDataService.getAllItems().size() + ")");
        DefaultMutableTreeNode mapNode = new DefaultMutableTreeNode(
            "地图 (" + gameDataService.getAllMaps().size() + ")");

        // 添加到根节点
        root.add(monsterNode);
        root.add(npcNode);
        root.add(itemNode);
        root.add(mapNode);

        // 添加具体数据
        for (SimpleMonsterData monster : gameDataService.getAllMonsters()) {
            monsterNode.add(new DefaultMutableTreeNode(monster));
        }

        for (SimpleNPCData npc : gameDataService.getAllNPCs()) {
            npcNode.add(new DefaultMutableTreeNode(npc));
        }

        for (SimpleItemData item : gameDataService.getAllItems()) {
            itemNode.add(new DefaultMutableTreeNode(item));
        }

        for (SimpleMapData map : gameDataService.getAllMaps()) {
            mapNode.add(new DefaultMutableTreeNode(map));
        }

        return new DefaultTreeModel(root);
    }

    /**
     * 更新树形结构
     */
    private void updateTree() {
        // 获取当前的树组件
        JTree currentTree = null;
        if (rightSplitPane != null && rightSplitPane.getLeftComponent() instanceof JScrollPane) {
            JScrollPane scrollPane = (JScrollPane) rightSplitPane.getLeftComponent();
            if (scrollPane.getViewport().getView() instanceof JTree) {
                currentTree = (JTree) scrollPane.getViewport().getView();
            }
        }

        if (currentTree != null) {
            // 更新树模型
            DefaultTreeModel newModel = createTreeModel(gameDataService);
            currentTree.setModel(newModel);

            // 重新添加监听器
            currentTree.addTreeSelectionListener(new TreeSelectionListener() {
                @Override
                public void valueChanged(TreeSelectionEvent e) {
                    handleTreeSelection(e);
                }
            });

            log("数据树已更新: " +
                gameDataService.getAllMonsters().size() + " 怪物, " +
                gameDataService.getAllNPCs().size() + " NPC, " +
                gameDataService.getAllItems().size() + " 道具, " +
                gameDataService.getAllMaps().size() + " 地图");
        }
    }

    /**
     * 处理树选择事件
     */
    private void handleTreeSelection(TreeSelectionEvent e) {
        DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) e.getPath().getLastPathComponent();
        Object userObject = selectedNode.getUserObject();

        if (userObject instanceof SimpleMonsterData) {
            displayMonsterDetails((SimpleMonsterData) userObject);
        } else if (userObject instanceof SimpleNPCData) {
            displayNPCDetails((SimpleNPCData) userObject);
        } else if (userObject instanceof SimpleItemData) {
            displayItemDetails((SimpleItemData) userObject);
        } else if (userObject instanceof SimpleMapData) {
            displayMapDetails((SimpleMapData) userObject);
        }
    }

    /**
     * 显示怪物详情
     */
    private void displayMonsterDetails(SimpleMonsterData monster) {
        // 直接显示文本信息
        clearDetailPanel();

        StringBuilder details = new StringBuilder();

        // 基本信息
        details.append("========== 基本信息 ==========\n");
        details.append("怪物名称: ").append(monster.getName()).append("\n");
        details.append("怪物ID: ").append(monster.getId()).append("\n");
        if (monster.getModelName() != null) {
            details.append("模型名称: ").append(monster.getModelName()).append("\n");
        }
        details.append("等级: ").append(monster.getLevel()).append("\n");
        details.append("性质: ").append(monster.getNature() != null ? monster.getNature() : "未知").append("\n");
        if (monster.getUndead() > 0) {
            details.append("不死属性: 是\n");
        }

        // 基础属性
        details.append("\n========== 基础属性 ==========\n");
        details.append("力量: ").append(monster.getStrength()).append("\n");
        details.append("精神: ").append(monster.getSpirit()).append("\n");
        details.append("才能: ").append(monster.getTalent()).append("\n");
        details.append("敏捷: ").append(monster.getDexterity()).append("\n");
        details.append("体质: ").append(monster.getHealth()).append("\n");

        // 战斗属性
        details.append("\n========== 战斗属性 ==========\n");
        details.append("生命值: ").append(monster.getLife()).append("\n");
        if (monster.getMinAttack() > 0 || monster.getMaxAttack() > 0) {
            details.append("攻击力: ").append(monster.getMinAttack()).append(" - ").append(monster.getMaxAttack()).append("\n");
        }
        if (monster.getAttackSpeed() > 0) {
            details.append("攻击速度: ").append(monster.getAttackSpeed()).append("\n");
        }
        if (monster.getAttackRating() > 0) {
            details.append("命中率: ").append(monster.getAttackRating()).append("\n");
        }
        if (monster.getCriticalHit() > 0) {
            details.append("必杀率: ").append(monster.getCriticalHit()).append("\n");
        }
        if (monster.getShootingRange() > 0) {
            details.append("攻击范围: ").append(monster.getShootingRange()).append("\n");
        }
        details.append("防御力: ").append(monster.getDefense()).append("\n");
        if (monster.getChanceBlock() > 0) {
            details.append("格挡率: ").append(monster.getChanceBlock()).append("\n");
        }
        if (monster.getAbsorption() > 0) {
            details.append("吸收率: ").append(monster.getAbsorption()).append("\n");
        }
        details.append("经验值: ").append(monster.getExperience()).append("\n");

        // 元素抗性
        if (monster.getFire() > 0 || monster.getIce() > 0 || monster.getLightning() > 0 ||
            monster.getPoison() > 0 || monster.getEarth() > 0) {
            details.append("\n========== 元素抗性 ==========\n");
            if (monster.getFire() > 0) details.append("火焰抗性: ").append(monster.getFire()).append("\n");
            if (monster.getIce() > 0) details.append("冰霜抗性: ").append(monster.getIce()).append("\n");
            if (monster.getLightning() > 0) details.append("雷电抗性: ").append(monster.getLightning()).append("\n");
            if (monster.getPoison() > 0) details.append("毒素抗性: ").append(monster.getPoison()).append("\n");
            if (monster.getEarth() > 0) details.append("大地抗性: ").append(monster.getEarth()).append("\n");
        }

        // 移动和视野
        if (monster.getMoveSpeed() > 0 || monster.getSight() > 0 || monster.getSizeLevel() > 0) {
            details.append("\n========== 移动属性 ==========\n");
            if (monster.getMoveSpeed() > 0) {
                details.append("移动速度: ").append(String.format("%.2f", monster.getMoveSpeed())).append("\n");
            }
            if (monster.getSight() > 0) {
                details.append("视野范围: ").append(monster.getSight()).append("\n");
            }
            if (monster.getSizeLevel() > 0) {
                details.append("尺寸等级: ").append(monster.getSizeLevel()).append("\n");
            }
        }

        // 掉落物信息
        if (monster.getDropItems() != null && !monster.getDropItems().isEmpty()) {
            details.append("\n========== 掉落物 ==========\n");
            details.append(monster.getDropItems()).append("\n");
        }

        detailPanel.setText(details.toString());
        updateStatusText("查看怪物: " + monster.getName());
    }

    /**
     * 显示NPC详情
     */
    private void displayNPCDetails(SimpleNPCData npc) {
        // 清空或重置详情面板
        clearDetailPanel();

        StringBuilder details = new StringBuilder();

        // 基本信息
        details.append("========== 基本信息 ==========\n");
        details.append("NPC名称: ").append(npc.getName()).append("\n");
        details.append("NPC ID: ").append(npc.getId()).append("\n");
        if (npc.getModelName() != null) {
            details.append("模型名称: ").append(npc.getModelName()).append("\n");
        }
        details.append("等级: ").append(npc.getLevel()).append("\n");
        details.append("类型: ").append(npc.isShopkeeper() ? "商人" : "普通NPC").append("\n");

        // 商店商品
        if (npc.isShopkeeper()) {
            if (npc.getSellAttackItems() != null && npc.getSellAttackItems().length > 0) {
                details.append("\n========== 攻击装备 ==========\n");
                for (String item : npc.getSellAttackItems()) {
                    if (item != null) {
                        details.append("- ").append(item).append("\n");
                    }
                }
            }

            if (npc.getSellDefenceItems() != null && npc.getSellDefenceItems().length > 0) {
                details.append("\n========== 防御装备 ==========\n");
                for (String item : npc.getSellDefenceItems()) {
                    if (item != null) {
                        details.append("- ").append(item).append("\n");
                    }
                }
            }

            if (npc.getSellEtcItems() != null && npc.getSellEtcItems().length > 0) {
                details.append("\n========== 其他道具 ==========\n");
                for (String item : npc.getSellEtcItems()) {
                    if (item != null) {
                        details.append("- ").append(item).append("\n");
                    }
                }
            }
        }

        // 特殊功能
        if (npc.getFunctions() != null && !npc.getFunctions().isEmpty()) {
            details.append("\n========== 特殊功能 ==========\n");
            details.append(npc.getFunctions()).append("\n");
        }

        // NPC对话
        if (npc.getMessages() != null && npc.getMessages().length > 0) {
            details.append("\n========== NPC对话 ==========\n");
            for (String message : npc.getMessages()) {
                if (message != null) {
                    details.append(message).append("\n");
                }
            }
        }

        detailPanel.setText(details.toString());
        updateStatusText("查看NPC: " + npc.getName());
    }

    /**
     * 显示道具详情
     */
    private void displayItemDetails(SimpleItemData item) {
        clearDetailPanel();

        StringBuilder details = new StringBuilder();

        // 基本信息
        details.append("========== 基本信息 ==========\n");
        details.append("道具名称: ").append(item.getName()).append("\n");
        if (item.getEnName() != null && !item.getEnName().isEmpty()) {
            details.append("英文名: ").append(item.getEnName()).append("\n");
        }
        details.append("道具ID: ").append(item.getId()).append("\n");
        details.append("类别: ").append(getCategoryName(item.getCategory())).append("\n");

        // 基础属性
        details.append("\n========== 基础属性 ==========\n");
        details.append("等级需求: ").append(item.getLevel()).append("\n");
        if (item.getPrice() > 0) {
            details.append("价格: ").append(item.getPrice()).append("\n");
        }
        if (item.getWeight() > 0) {
            details.append("重量: ").append(item.getWeight()).append("\n");
        }

        // 需求属性
        if (item.getStrengthReq() > 0 || item.getSpiritReq() > 0 ||
            item.getTalentReq() > 0 || item.getDexterityReq() > 0 ||
            item.getHealthReq() > 0) {
            details.append("\n========== 属性需求 ==========\n");
            if (item.getStrengthReq() > 0) {
                details.append("力量需求: ").append(item.getStrengthReq()).append("\n");
            }
            if (item.getSpiritReq() > 0) {
                details.append("精神需求: ").append(item.getSpiritReq()).append("\n");
            }
            if (item.getTalentReq() > 0) {
                details.append("才能需求: ").append(item.getTalentReq()).append("\n");
            }
            if (item.getDexterityReq() > 0) {
                details.append("敏捷需求: ").append(item.getDexterityReq()).append("\n");
            }
            if (item.getHealthReq() > 0) {
                details.append("体质需求: ").append(item.getHealthReq()).append("\n");
            }
        }

        // 攻击属性
        if (item.getMinDamage() > 0 || item.getMaxDamage() > 0 ||
            item.getAttackSpeed() > 0 || item.getAttackRating() > 0 ||
            item.getCriticalHit() > 0) {
            details.append("\n========== 攻击属性 ==========\n");
            if (item.getMinDamage() > 0 || item.getMaxDamage() > 0) {
                details.append("攻击力: ").append(item.getMinDamage()).append(" - ").append(item.getMaxDamage()).append("\n");
            }
            if (item.getAttackSpeed() > 0) {
                details.append("攻击速度: ").append(item.getAttackSpeed()).append("\n");
            }
            if (item.getAttackRating() > 0) {
                details.append("命中率: ").append(item.getAttackRating()).append("\n");
            }
            if (item.getCriticalHit() > 0) {
                details.append("必杀率: ").append(item.getCriticalHit()).append("\n");
            }
        }

        // 防御属性
        if (item.getDefense() > 0 || item.getChanceBlock() > 0 ||
            item.getAbsorption() > 0) {
            details.append("\n========== 防御属性 ==========\n");
            if (item.getDefense() > 0) {
                details.append("防御力: ").append(item.getDefense()).append("\n");
            }
            if (item.getChanceBlock() > 0) {
                details.append("格挡率: ").append(item.getChanceBlock()).append("\n");
            }
            if (item.getAbsorption() > 0) {
                details.append("吸收率: ").append(item.getAbsorption()).append("\n");
            }
        }

        // 元素抗性
        if (item.getFireResist() > 0 || item.getIceResist() > 0 ||
            item.getLightningResist() > 0 || item.getPoisonResist() > 0 ||
            item.getEarthResist() > 0) {
            details.append("\n========== 元素抗性 ==========\n");
            if (item.getFireResist() > 0) {
                details.append("火焰抗性: ").append(item.getFireResist()).append("\n");
            }
            if (item.getIceResist() > 0) {
                details.append("冰霜抗性: ").append(item.getIceResist()).append("\n");
            }
            if (item.getLightningResist() > 0) {
                details.append("雷电抗性: ").append(item.getLightningResist()).append("\n");
            }
            if (item.getPoisonResist() > 0) {
                details.append("毒素抗性: ").append(item.getPoisonResist()).append("\n");
            }
            if (item.getEarthResist() > 0) {
                details.append("大地抗性: ").append(item.getEarthResist()).append("\n");
            }
        }

        // 耐久度
        if (item.getDurability() > 0 || item.getMaxDurability() > 0) {
            details.append("\n========== 耐久度 ==========\n");
            details.append("当前耐久: ").append(item.getDurability()).append("\n");
            details.append("最大耐久: ").append(item.getMaxDurability()).append("\n");
        }

        // 特殊效果
        if (item.getSpecialEffect() != null && !item.getSpecialEffect().isEmpty()) {
            details.append("\n========== 特殊效果 ==========\n");
            details.append(item.getSpecialEffect()).append("\n");
        }

        detailPanel.setText(details.toString());
        updateStatusText("查看道具: " + item.getName());
    }

    /**
     * 根据类别代码获取类别名称
     */
    private String getCategoryName(int category) {
        switch (category) {
            case 1: return "武器";
            case 2: return "防具";
            case 3: return "饰品";
            case 4: return "双手武器";
            case 5: return "消耗品";
            default: return "未知(" + category + ")";
        }
    }

    /**
     * 显示地图详情
     */
    private void displayMapDetails(SimpleMapData map) {
        clearDetailPanel();

        StringBuilder details = new StringBuilder();
        details.append("地图名称: ").append(map.getName()).append("\n");
        details.append("地图ID: ").append(map.getId()).append("\n");
        details.append("最低等级: ").append(map.getMinLevel()).append("\n");
        details.append("最高等级: ").append(map.getMaxLevel()).append("\n");

        if (map.getMonsterCount() > 0) {
            details.append("\n怪物数量: ").append(map.getMonsterCount()).append("\n");
            if (map.getRespawnTime() > 0) {
                details.append("刷新间隔: ").append(map.getRespawnTime()).append(" 秒\n");
            }
        }

        if (map.getMonsters() != null && !map.getMonsters().isEmpty()) {
            details.append("\n怪物列表:\n").append(map.getMonsters()).append("\n");
        }

        if (map.isHasStartPoint()) {
            details.append("\n有出生点\n");
        }

        // TODO: 添加getDescription方法到SimpleMapData
        // if (map.getDescription() != null && !map.getDescription().isEmpty()) {
        //     details.append("\n描述: ").append(map.getDescription()).append("\n");
        // }

        detailPanel.append(details.toString());
        updateStatusText("查看地图: " + map.getName());
    }

    /**
     * 清空详情面板
     */
    private void clearDetailPanel() {
        detailPanel.setText("");
    }

    /**
     * 记录日志
     */
    private void log(String message) {
        logArea.append("[" + new java.text.SimpleDateFormat("HH:mm:ss").format(new java.util.Date()) + "] " + message + "\n");
        logArea.setCaretPosition(logArea.getDocument().getLength());
    }

    /**
     * 更新状态栏文本
     */
    private void updateStatusText(String text) {
        if (statusLabel != null) {
            statusLabel.setText(text);
        }
    }
}