package org.jpstale.gamedata.ui;

import org.jpstale.gamedata.model.*;
import org.jpstale.gamedata.service.SimpleGameDataService;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.util.List;

/**
 * 数据统计对话框
 */
public class DataStatisticsDialog extends JDialog {
    private SimpleGameDataService gameDataService;

    public DataStatisticsDialog(JFrame parent, SimpleGameDataService gameDataService) {
        super(parent, "数据统计", true);
        this.gameDataService = gameDataService;
        initializeUI();
        setSize(800, 600);
        setLocationRelativeTo(parent);
    }

    private void initializeUI() {
        setLayout(new BorderLayout());
        add(createTabbedPane(), BorderLayout.CENTER);
        add(createButtonPanel(), BorderLayout.SOUTH);
    }

    private JTabbedPane createTabbedPane() {
        JTabbedPane tabbedPane = new JTabbedPane();

        tabbedPane.addTab("怪物统计", createMonsterStatsPanel());
        tabbedPane.addTab("NPC统计", createNPCStatsPanel());
        tabbedPane.addTab("地图统计", createMapStatsPanel());
        tabbedPane.addTab("掉落物统计", createDropStatsPanel());

        return tabbedPane;
    }

    private JPanel createMonsterStatsPanel() {
        JPanel panel = new JPanel(new BorderLayout());

        // 统计数据
        List<SimpleMonsterData> monsters = gameDataService.getAllMonsters();

        // 等级统计
        Map<String, Integer> levelDistribution = calculateLevelDistribution(monsters);

        // 创建内容
        JScrollPane scrollPane = new JScrollPane();
        JPanel contentPanel = new JPanel(new GridBagLayout());
        scrollPane.setViewportView(contentPanel);
        contentPanel.setBorder(new EmptyBorder(10, 10, 10, 10));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = GridBagConstraints.WEST;

        // 总体统计
        gbc.gridx = 0; gbc.gridy = 0;
        contentPanel.add(new JLabel("<html><b>怪物总数:</b></html>"), gbc);
        gbc.gridx = 1;
        contentPanel.add(new JLabel(String.valueOf(monsters.size())), gbc);

        // 平均等级
        gbc.gridx = 0; gbc.gridy = 1;
        contentPanel.add(new JLabel("<html><b>平均等级:</b></html>"), gbc);
        gbc.gridx = 1;
        double avgLevel = monsters.stream().mapToInt(SimpleMonsterData::getLevel).average().orElse(0);
        contentPanel.add(new JLabel(String.format("%.1f", avgLevel)), gbc);

        // 等级分布
        gbc.gridx = 0; gbc.gridy = 2; gbc.gridwidth = 2;
        contentPanel.add(new JLabel(" "), gbc);
        gbc.gridx = 0; gbc.gridy = 3; gbc.gridwidth = 1;
        contentPanel.add(new JLabel("<html><b>等级分布:</b></html>"), gbc);

        int y = 4;
        for (Map.Entry<String, Integer> entry : levelDistribution.entrySet()) {
            gbc.gridx = 0; gbc.gridy = y;
            contentPanel.add(new JLabel(entry.getKey()), gbc);
            gbc.gridx = 1;
            contentPanel.add(new JLabel(entry.getValue() + " 个"), gbc);
            y++;
        }

        panel.add(scrollPane, BorderLayout.CENTER);

        return panel;
    }

    private JPanel createNPCStatsPanel() {
        JPanel panel = new JPanel(new BorderLayout());

        List<SimpleNPCData> npcs = gameDataService.getAllNPCs();

        // 统计数据
        int shopkeeperCount = 0;
        Map<Integer, Integer> levelCount = new TreeMap<>();

        for (SimpleNPCData npc : npcs) {
            if (npc.isShopkeeper()) {
                shopkeeperCount++;
            }
            int level = npc.getLevel();
            levelCount.put(level, levelCount.getOrDefault(level, 0) + 1);
        }

        // 创建内容
        JScrollPane scrollPane = new JScrollPane();
        JPanel contentPanel = new JPanel(new GridBagLayout());
        scrollPane.setViewportView(contentPanel);
        contentPanel.setBorder(new EmptyBorder(10, 10, 10, 10));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = GridBagConstraints.WEST;

        // 总体统计
        gbc.gridx = 0; gbc.gridy = 0;
        contentPanel.add(new JLabel("<html><b>NPC总数:</b></html>"), gbc);
        gbc.gridx = 1;
        contentPanel.add(new JLabel(String.valueOf(npcs.size())), gbc);

        gbc.gridx = 0; gbc.gridy = 1;
        contentPanel.add(new JLabel("<html><b>商人数量:</b></html>"), gbc);
        gbc.gridx = 1;
        contentPanel.add(new JLabel(String.valueOf(shopkeeperCount)), gbc);

        gbc.gridx = 0; gbc.gridy = 2;
        contentPanel.add(new JLabel("<html><b>普通NPC:</b></html>"), gbc);
        gbc.gridx = 1;
        contentPanel.add(new JLabel(String.valueOf(npcs.size() - shopkeeperCount)), gbc);

        // 等级分布
        gbc.gridx = 0; gbc.gridy = 3; gbc.gridwidth = 2;
        contentPanel.add(new JLabel(" "), gbc);
        gbc.gridx = 0; gbc.gridy = 4; gbc.gridwidth = 1;
        contentPanel.add(new JLabel("<html><b>等级分布:</b></html>"), gbc);

        int y = 5;
        for (Map.Entry<Integer, Integer> entry : levelCount.entrySet()) {
            gbc.gridx = 0; gbc.gridy = y;
            contentPanel.add(new JLabel("等级 " + entry.getKey() + ":"), gbc);
            gbc.gridx = 1;
            contentPanel.add(new JLabel(entry.getValue() + " 个"), gbc);
            y++;
        }

        panel.add(scrollPane, BorderLayout.CENTER);

        return panel;
    }

    private JPanel createMapStatsPanel() {
        JPanel panel = new JPanel(new BorderLayout());

        List<SimpleMapData> maps = gameDataService.getAllMaps();

        // 统计数据
        int mapsWithMonsters = 0;
        int totalMonsters = 0;
        Map<String, Integer> levelRangeCount = new TreeMap<>();

        for (SimpleMapData map : maps) {
            if (map.getMonsterCount() > 0) {
                mapsWithMonsters++;
                totalMonsters += map.getMonsterCount();
            }

            String range = String.format("%d-%d", map.getMinLevel(), map.getMaxLevel());
            levelRangeCount.put(range, levelRangeCount.getOrDefault(range, 0) + 1);
        }

        // 创建内容
        JScrollPane scrollPane = new JScrollPane();
        JPanel contentPanel = new JPanel(new GridBagLayout());
        scrollPane.setViewportView(contentPanel);
        contentPanel.setBorder(new EmptyBorder(10, 10, 10, 10));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = GridBagConstraints.WEST;

        // 总体统计
        gbc.gridx = 0; gbc.gridy = 0;
        contentPanel.add(new JLabel("<html><b>地图总数:</b></html>"), gbc);
        gbc.gridx = 1;
        contentPanel.add(new JLabel(String.valueOf(maps.size())), gbc);

        gbc.gridx = 0; gbc.gridy = 1;
        contentPanel.add(new JLabel("<html><b>有怪物的地图:</b></html>"), gbc);
        gbc.gridx = 1;
        contentPanel.add(new JLabel(String.valueOf(mapsWithMonsters)), gbc);

        gbc.gridx = 0; gbc.gridy = 2;
        contentPanel.add(new JLabel("<html><b>总刷怪数:</b></html>"), gbc);
        gbc.gridx = 1;
        contentPanel.add(new JLabel(String.valueOf(totalMonsters)), gbc);

        // 等级范围分布
        gbc.gridx = 0; gbc.gridy = 3; gbc.gridwidth = 2;
        contentPanel.add(new JLabel(" "), gbc);
        gbc.gridx = 0; gbc.gridy = 4; gbc.gridwidth = 1;
        contentPanel.add(new JLabel("<html><b>等级范围分布:</b></html>"), gbc);

        int y = 5;
        for (Map.Entry<String, Integer> entry : levelRangeCount.entrySet()) {
            gbc.gridx = 0; gbc.gridy = y;
            contentPanel.add(new JLabel(entry.getKey()), gbc);
            gbc.gridx = 1;
            contentPanel.add(new JLabel(entry.getValue() + " 个地图"), gbc);
            y++;
        }

        panel.add(scrollPane, BorderLayout.CENTER);

        return panel;
    }

    private JPanel createDropStatsPanel() {
        JPanel panel = new JPanel(new BorderLayout());

        // 收集所有掉落物
        Map<String, Integer> dropCount = new TreeMap<>();
        Map<String, String> dropNameMap = new HashMap<>();
        int monstersWithDrops = 0;

        for (SimpleMonsterData monster : gameDataService.getAllMonsters()) {
            if (monster.getDropItems() != null && !monster.getDropItems().isEmpty()) {
                monstersWithDrops++;

                // 解析掉落物字符串
                String drops = monster.getDropItems();
                String[] items = drops.split(", ");

                for (String item : items) {
                    // 提取物品代码
                    if (item.contains("[")) {
                        String code = item.substring(item.indexOf("[") + 1, item.indexOf("]"));
                        String name = item.substring(0, item.indexOf("[")).trim();

                        dropCount.put(code, dropCount.getOrDefault(code, 0) + 1);
                        dropNameMap.put(code, name);
                    }
                }
            }
        }

        // 创建内容
        JScrollPane scrollPane = new JScrollPane();
        JPanel contentPanel = new JPanel(new GridBagLayout());
        scrollPane.setViewportView(contentPanel);
        contentPanel.setBorder(new EmptyBorder(10, 10, 10, 10));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = GridBagConstraints.WEST;

        // 总体统计
        gbc.gridx = 0; gbc.gridy = 0;
        contentPanel.add(new JLabel("<html><b>有掉落物的怪物:</b></html>"), gbc);
        gbc.gridx = 1;
        contentPanel.add(new JLabel(String.valueOf(monstersWithDrops)), gbc);

        gbc.gridx = 0; gbc.gridy = 1;
        contentPanel.add(new JLabel("<html><b>不同掉落物数量:</b></html>"), gbc);
        gbc.gridx = 1;
        contentPanel.add(new JLabel(String.valueOf(dropCount.size())), gbc);

        // 掉落物列表
        gbc.gridx = 0; gbc.gridy = 2; gbc.gridwidth = 2;
        contentPanel.add(new JLabel(" "), gbc);
        gbc.gridx = 0; gbc.gridy = 3; gbc.gridwidth = 1;
        contentPanel.add(new JLabel("<html><b>掉落物列表 (显示前20个):</b></html>"), gbc);

        int y = 4;
        int count = 0;
        // 按掉落数量排序
        List<Map.Entry<String, Integer>> sortedDrops = new ArrayList<>(dropCount.entrySet());
        sortedDrops.sort(Map.Entry.<String, Integer>comparingByValue().reversed());

        for (Map.Entry<String, Integer> entry : sortedDrops) {
            if (count >= 20) break;

            gbc.gridx = 0; gbc.gridy = y;
            String name = dropNameMap.getOrDefault(entry.getKey(), entry.getKey());
            contentPanel.add(new JLabel(name + " [" + entry.getKey() + "]"), gbc);
            gbc.gridx = 1;
            contentPanel.add(new JLabel(entry.getValue() + " 个怪物掉落"), gbc);
            y++;
            count++;
        }

        panel.add(scrollPane, BorderLayout.CENTER);

        return panel;
    }

    private Map<String, Integer> calculateLevelDistribution(List<SimpleMonsterData> monsters) {
        Map<String, Integer> distribution = new TreeMap<>();

        for (SimpleMonsterData monster : monsters) {
            int level = monster.getLevel();
            String range;

            if (level <= 20) range = "1-20";
            else if (level <= 40) range = "21-40";
            else if (level <= 60) range = "41-60";
            else if (level <= 80) range = "61-80";
            else if (level <= 100) range = "81-100";
            else if (level <= 120) range = "101-120";
            else range = "121+";

            distribution.put(range, distribution.getOrDefault(range, 0) + 1);
        }

        return distribution;
    }

    private JPanel createButtonPanel() {
        JPanel panel = new JPanel(new FlowLayout());

        JButton closeButton = new JButton("关闭");
        closeButton.addActionListener(e -> dispose());
        panel.add(closeButton);

        return panel;
    }
}