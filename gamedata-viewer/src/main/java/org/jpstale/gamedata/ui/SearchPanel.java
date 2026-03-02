package org.jpstale.gamedata.ui;

import org.jpstale.gamedata.model.SimpleItemData;
import org.jpstale.gamedata.model.SimpleMapData;
import org.jpstale.gamedata.model.SimpleMonsterData;
import org.jpstale.gamedata.model.SimpleNPCData;
import org.jpstale.gamedata.service.GameDataService;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

/**
 * 搜索面板：按关键词、类别、等级筛选怪物/NPC/道具/地图，选中结果后在主窗口显示详情并同步树选中。
 */
public class SearchPanel extends JPanel {

    private final GameDataService gameDataService;

    private JTextField searchField;
    private JComboBox<String> categoryCombo;
    private JComboBox<String> levelCombo;

    private JList<SearchResultItem> resultList;
    private DefaultListModel<SearchResultItem> listModel;

    /** 选中某条搜索结果时回调，参数为 SimpleMonsterData | SimpleNPCData | SimpleItemData | SimpleMapData */
    private Consumer<Object> searchResultListener;

    public SearchPanel(GameDataService gameDataService) {
        this.gameDataService = gameDataService;
        initializeUI();
    }

    public void setSearchResultListener(Consumer<Object> listener) {
        this.searchResultListener = listener;
    }

    /**
     * 初始化UI
     */
    private void initializeUI() {
        setLayout(new BorderLayout());
        setBorder(new TitledBorder("搜索"));

        // 创建搜索输入区域
        JPanel searchPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // 搜索文本框
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.weightx = 1.0;
        searchField = new JTextField(20);
        searchField.getDocument().addDocumentListener(new SearchDocumentListener());
        searchField.setToolTipText("输入要搜索的名称");
        searchPanel.add(searchField, gbc);

        // 分类选择
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.weightx = 0.5;
        gbc.gridy = 1;
        searchPanel.add(new JLabel("类别:"), gbc);

        categoryCombo = new JComboBox<>();
        categoryCombo.addItem("全部");
        categoryCombo.addItem("怪物");
        categoryCombo.addItem("NPC");
        categoryCombo.addItem("道具");
        categoryCombo.addItem("地图");
        categoryCombo.setToolTipText("选择要搜索的类别");
        categoryCombo.addActionListener(e -> performSearch());
        gbc.gridx = 1;
        searchPanel.add(categoryCombo, gbc);

        // 等级选择
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        searchPanel.add(new JLabel("等级:"), gbc);

        levelCombo = new JComboBox<>();
        levelCombo.addItem("全部");
        for (int i = 1; i <= 120; i += 5) {
            levelCombo.addItem(i + "-" + (i + 4));
        }
        levelCombo.setToolTipText("选择等级范围");
        levelCombo.addActionListener(e -> performSearch());
        gbc.gridx = 1;
        searchPanel.add(levelCombo, gbc);

        // 搜索按钮
        JButton searchButton = new JButton("搜索");
        searchButton.addActionListener(e -> performSearch());
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.CENTER;
        searchPanel.add(searchButton, gbc);

        // 清除按钮
        JButton clearButton = new JButton("清除");
        clearButton.addActionListener(e -> {
            searchField.setText("");
            categoryCombo.setSelectedIndex(0);
            levelCombo.setSelectedIndex(0);
            performSearch();
        });
        gbc.gridy = 4;
        searchPanel.add(clearButton, gbc);

        add(searchPanel, BorderLayout.NORTH);

        // 创建结果列表（泛型 SearchResultItem）
        listModel = new DefaultListModel<>();
        resultList = new JList<>(listModel);
        resultList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        resultList.setCellRenderer(new SearchResultCellRenderer());

        JScrollPane scrollPane = new JScrollPane(resultList);
        scrollPane.setBorder(new TitledBorder("搜索结果"));

        add(scrollPane, BorderLayout.CENTER);

        resultList.addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                int selectedIndex = resultList.getSelectedIndex();
                if (selectedIndex >= 0 && searchResultListener != null) {
                    SearchResultItem item = listModel.get(selectedIndex);
                    searchResultListener.accept(item.getEntity());
                }
            }
        });
    }

    /**
     * 执行搜索：按关键词（名称/ID/物品代码）、类别、等级范围筛选
     */
    private void performSearch() {
        String searchText = searchField.getText().trim().toLowerCase();
        String category = (String) categoryCombo.getSelectedItem();
        String levelRange = (String) levelCombo.getSelectedItem();
        int levelMin = parseLevelMin(levelRange);
        int levelMax = parseLevelMax(levelRange);

        listModel.clear();

        // 未选具体类别且未输入关键词时不显示结果，避免一次加载过多
        if ("全部".equals(category) && searchText.isEmpty()) {
            return;
        }

        if ("全部".equals(category) || "怪物".equals(category)) {
            for (SimpleMonsterData m : gameDataService.getAllMonsters()) {
                if (!inLevelRange(m.getLevel(), levelMin, levelMax)) continue;
                if (!matchesSearch(m, searchText, true)) continue;
                listModel.addElement(SearchResultItem.monster(m));
            }
        }
        if ("全部".equals(category) || "NPC".equals(category)) {
            for (SimpleNPCData n : gameDataService.getAllNPCs()) {
                if (!inLevelRange(n.getLevel(), levelMin, levelMax)) continue;
                if (!matchesSearch(n, searchText)) continue;
                listModel.addElement(SearchResultItem.npc(n));
            }
        }
        if ("全部".equals(category) || "道具".equals(category)) {
            for (SimpleItemData i : gameDataService.getAllItems()) {
                if (!inLevelRange(i.getLevel(), levelMin, levelMax)) continue;
                if (!matchesSearch(i, searchText)) continue;
                listModel.addElement(SearchResultItem.item(i));
            }
        }
        if ("全部".equals(category) || "地图".equals(category)) {
            for (SimpleMapData m : gameDataService.getAllMaps()) {
                if (!mapLevelOverlap(m.getMinLevel(), m.getMaxLevel(), levelMin, levelMax)) continue;
                if (!matchesSearch(m, searchText)) continue;
                listModel.addElement(SearchResultItem.map(m));
            }
        }
    }

    private static int parseLevelMin(String levelRange) {
        if (levelRange == null || "全部".equals(levelRange)) return 0;
        int dash = levelRange.indexOf('-');
        if (dash <= 0) return 0;
        try {
            return Integer.parseInt(levelRange.substring(0, dash).trim());
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    private static int parseLevelMax(String levelRange) {
        if (levelRange == null || "全部".equals(levelRange)) return 999;
        int dash = levelRange.indexOf('-');
        if (dash < 0) return 999;
        try {
            return Integer.parseInt(levelRange.substring(dash + 1).trim());
        } catch (NumberFormatException e) {
            return 999;
        }
    }

    private static boolean inLevelRange(int level, int rangeMin, int rangeMax) {
        if (rangeMin == 0 && rangeMax >= 999) return true;
        return level >= rangeMin && level <= rangeMax;
    }

    private static boolean mapLevelOverlap(int mapMin, int mapMax, int rangeMin, int rangeMax) {
        if (rangeMin == 0 && rangeMax >= 999) return true;
        return mapMax >= rangeMin && mapMin <= rangeMax;
    }

    private static boolean matchesSearch(SimpleMonsterData m, String search, boolean allowEmpty) {
        if (search.isEmpty()) return allowEmpty;
        return (m.getName() != null && m.getName().toLowerCase().contains(search))
            || (m.getId() != null && m.getId().toLowerCase().contains(search));
    }

    private static boolean matchesSearch(SimpleNPCData n, String search) {
        if (search.isEmpty()) return true;
        return (n.getName() != null && n.getName().toLowerCase().contains(search))
            || (n.getId() != null && n.getId().toLowerCase().contains(search));
    }

    private static boolean matchesSearch(SimpleItemData i, String search) {
        if (search.isEmpty()) return true;
        if (i.getName() != null && i.getName().toLowerCase().contains(search)) return true;
        if (i.getId() != null && i.getId().toLowerCase().contains(search)) return true;
        if (i.getEnName() != null && i.getEnName().toLowerCase().contains(search)) return true;
        // 支持十六进制物品代码
        String hex = search.replaceAll("\\s", "");
        if (hex.startsWith("0x")) hex = hex.substring(2);
        if (hex.length() <= 8 && hex.matches("[0-9a-fA-F]+")) {
            try {
                long code = Long.parseLong(hex, 16);
                if (i.getItemCode() == code) return true;
            } catch (NumberFormatException ignored) { }
        }
        return false;
    }

    private static boolean matchesSearch(SimpleMapData m, String search) {
        if (search.isEmpty()) return true;
        return (m.getName() != null && m.getName().toLowerCase().contains(search))
            || (m.getId() != null && m.getId().toLowerCase().contains(search));
    }

    /**
     * 单条搜索结果：类型标签 + 显示文本 + 实体对象
     */
    public static final class SearchResultItem {
        private final String typeLabel;
        private final String displayText;
        private final Object entity;

        private SearchResultItem(String typeLabel, String displayText, Object entity) {
            this.typeLabel = typeLabel;
            this.displayText = displayText;
            this.entity = entity;
        }

        static SearchResultItem monster(SimpleMonsterData m) {
            String text = (m.getName() != null ? m.getName() : m.getId()) + " (Lv." + m.getLevel() + ")";
            return new SearchResultItem("怪物", text, m);
        }

        static SearchResultItem npc(SimpleNPCData n) {
            String text = (n.getName() != null ? n.getName() : n.getId()) + " (Lv." + n.getLevel() + ")";
            return new SearchResultItem("NPC", text, n);
        }

        static SearchResultItem item(SimpleItemData i) {
            String text = (i.getName() != null ? i.getName() : i.getId()) + " (Lv." + i.getLevel() + ")";
            return new SearchResultItem("道具", text, i);
        }

        static SearchResultItem map(SimpleMapData m) {
            String text = m.getName() != null ? m.getName() : m.getId();
            return new SearchResultItem("地图", text, m);
        }

        public String getTypeLabel() { return typeLabel; }
        public String getDisplayText() { return displayText; }
        public Object getEntity() { return entity; }

        @Override
        public String toString() {
            return "[" + typeLabel + "] " + displayText;
        }
    }

    /**
     * 搜索文本监听器
     */
    private class SearchDocumentListener implements DocumentListener {
        @Override
        public void insertUpdate(DocumentEvent e) {
            performSearch();
        }

        @Override
        public void removeUpdate(DocumentEvent e) {
            performSearch();
        }

        @Override
        public void changedUpdate(DocumentEvent e) {
            performSearch();
        }
    }

    /**
     * 搜索结果单元格渲染器
     */
    private static class SearchResultCellRenderer extends JLabel implements ListCellRenderer<SearchResultItem> {
        @Override
        public Component getListCellRendererComponent(JList<? extends SearchResultItem> list,
                                                      SearchResultItem value, int index,
                                                      boolean isSelected,
                                                      boolean cellHasFocus) {
            setText(value == null ? "" : value.toString());
            setOpaque(true);

            if (isSelected) {
                setBackground(list.getSelectionBackground());
                setForeground(list.getSelectionForeground());
            } else {
                setBackground(list.getBackground());
                setForeground(list.getForeground());
            }

            setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

            return this;
        }
    }
}