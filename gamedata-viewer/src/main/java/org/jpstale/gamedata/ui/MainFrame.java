package org.jpstale.gamedata.ui;

import org.jpstale.gamedata.service.SimpleGameDataService;
import org.jpstale.gamedata.service.SimpleGameServiceImpl;
// import org.jpstale.gamedata.service.FullGameServiceImpl;
import org.jpstale.gamedata.service.FullGameSimpleServiceImpl;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import java.awt.*;
import java.io.File;

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

        // 创建中间树的模型
        JTree tree = new JTree();
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
                // TODO: 处理树节点选择事件
                log("选中了: " + e.getPath().getLastPathComponent());
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
        // TODO: 实现导出Groovy脚本功能
        JOptionPane.showMessageDialog(this, "Groovy脚本导出功能开发中...", "提示", JOptionPane.INFORMATION_MESSAGE);
    }

    /**
     * 导出为JSON
     */
    private void exportToJson() {
        // TODO: 实现导出JSON功能
        JOptionPane.showMessageDialog(this, "JSON导出功能开发中...", "提示", JOptionPane.INFORMATION_MESSAGE);
    }

    /**
     * 切换加载器模式
     */
    private void toggleLoaderMode(boolean useFullLoader) {
        SwingWorker<Void, String> worker = new SwingWorker<Void, String>() {
            @Override
            protected Void doInBackground() throws Exception {
                publish("正在切换加载器模式...");

                if (useFullLoader) {
                    gameDataService = new FullGameSimpleServiceImpl();
                    publish("已切换到完整加载器模式");
                } else {
                    gameDataService = new SimpleGameServiceImpl();
                    publish("已切换到简化模式");
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
    }

    /**
     * 更新树形结构
     */
    private void updateTree() {
        DefaultMutableTreeNode root = new DefaultMutableTreeNode("游戏数据");

        // 怪物节点
        DefaultMutableTreeNode monsterNode = new DefaultMutableTreeNode(
            "怪物 (" + gameDataService.getAllMonsters().size() + ")");
        root.add(monsterNode);

        // NPC节点
        DefaultMutableTreeNode npcNode = new DefaultMutableTreeNode(
            "NPC (" + gameDataService.getAllNPCs().size() + ")");
        root.add(npcNode);

        // 道具节点
        DefaultMutableTreeNode itemNode = new DefaultMutableTreeNode(
            "道具 (" + gameDataService.getAllItems().size() + ")");
        root.add(itemNode);

        // 地图节点
        DefaultMutableTreeNode mapNode = new DefaultMutableTreeNode(
            "地图 (" + gameDataService.getAllMaps().size() + ")");
        root.add(mapNode);

        // 更新树模型
        // TODO: 实际更新JTree组件
        System.out.println("数据已更新: " +
            gameDataService.getAllMonsters().size() + " 怪物, " +
            gameDataService.getAllNPCs().size() + " NPC, " +
            gameDataService.getAllItems().size() + " 道具, " +
            gameDataService.getAllMaps().size() + " 地图");
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