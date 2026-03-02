package org.jpstale.gamedata.ui;

import org.jpstale.gamedata.service.SimpleGameDataService;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;

/**
 * 搜索面板
 */
public class SearchPanel extends JPanel {

    private SimpleGameDataService gameDataService;

    // 搜索选项
    private JTextField searchField;
    private JComboBox<String> categoryCombo;
    private JComboBox<String> levelCombo;

    // 结果列表
    private JList<String> resultList;
    private DefaultListModel<String> listModel;

    public SearchPanel(SimpleGameDataService gameDataService) {
        this.gameDataService = gameDataService;
        initializeUI();
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

        // 创建结果列表
        listModel = new DefaultListModel<>();
        resultList = new JList<>(listModel);
        resultList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        resultList.setCellRenderer(new SearchResultCellRenderer());

        JScrollPane scrollPane = new JScrollPane(resultList);
        scrollPane.setBorder(new TitledBorder("搜索结果"));

        add(scrollPane, BorderLayout.CENTER);

        // 设置列表监听器
        resultList.addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                int selectedIndex = resultList.getSelectedIndex();
                if (selectedIndex >= 0) {
                    String selected = listModel.get(selectedIndex);
                    showDetails(selected);
                }
            }
        });
    }

    /**
     * 执行搜索
     */
    private void performSearch() {
        String searchText = searchField.getText().trim();
        String category = (String) categoryCombo.getSelectedItem();
        String levelRange = (String) levelCombo.getSelectedItem();

        // 清空当前结果
        listModel.clear();

        // TODO: 实际的搜索逻辑
        if (!searchText.isEmpty()) {
            // 模拟搜索结果
            listModel.addElement("结果1: " + searchText);
            listModel.addElement("结果2: " + searchText + "_1");
            listModel.addElement("结果3: " + searchText + "_2");
        }
    }

    /**
     * 显示详情
     */
    private void showDetails(String selected) {
        // TODO: 显示选中项的详情
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
    private static class SearchResultCellRenderer extends JLabel implements ListCellRenderer<String> {
        @Override
        public Component getListCellRendererComponent(JList<? extends String> list,
                                                      String value, int index,
                                                      boolean isSelected,
                                                      boolean cellHasFocus) {
            setText(value);
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