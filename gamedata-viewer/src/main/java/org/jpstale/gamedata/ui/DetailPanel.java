package org.jpstale.gamedata.ui;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;

/**
 * 详情显示面板
 */
public class DetailPanel extends JPanel {

    // 详情信息标签
    private JLabel nameLabel = new JLabel("-");
    private JLabel typeLabel = new JLabel("-");
    private JLabel levelLabel = new JLabel("-");
    private JTextArea detailArea = new JTextArea();

    // 标签页面板
    private JTabbedPane tabbedPane;

    public DetailPanel() {
        initializeUI();
    }

    /**
     * 初始化UI
     */
    private void initializeUI() {
        setLayout(new BorderLayout());
        setBorder(new TitledBorder("详细信息"));

        // 创建头部信息面板
        JPanel headerPanel = new JPanel(new GridBagLayout());
        headerPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = GridBagConstraints.WEST;

        // 名称
        gbc.gridx = 0;
        gbc.gridy = 0;
        headerPanel.add(new JLabel("名称:"), gbc);
        gbc.gridx = 1;
        gbc.gridwidth = 3;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1.0;
        nameLabel.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 16));
        headerPanel.add(nameLabel, gbc);

        // 类型
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.NONE;
        gbc.weightx = 0;
        headerPanel.add(new JLabel("类型:"), gbc);
        gbc.gridx = 1;
        typeLabel.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 14));
        headerPanel.add(typeLabel, gbc);

        // 等级
        gbc.gridx = 2;
        headerPanel.add(new JLabel("等级:"), gbc);
        gbc.gridx = 3;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 0.5;
        levelLabel.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 14));
        headerPanel.add(levelLabel, gbc);

        add(headerPanel, BorderLayout.NORTH);

        // 创建标签页
        tabbedPane = new JTabbedPane();

        // 基础信息标签页
        JPanel basicPanel = createBasicInfoPanel();
        tabbedPane.addTab("基础信息", basicPanel);

        // 属性标签页
        JPanel attributePanel = createAttributePanel();
        tabbedPane.addTab("属性", attributePanel);

        // 掉落物标签页
        JPanel dropPanel = createDropPanel();
        tabbedPane.addTab("掉落物", dropPanel);

        // 技能标签页
        JPanel skillPanel = createSkillPanel();
        tabbedPane.addTab("技能", skillPanel);

        add(tabbedPane, BorderLayout.CENTER);
    }

    /**
     * 创建基础信息面板
     */
    private JPanel createBasicInfoPanel() {
        JPanel panel = new JPanel(new BorderLayout());

        detailArea.setEditable(false);
        detailArea.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 13));
        detailArea.setText("请选择一个项目查看详细信息");

        JScrollPane scrollPane = new JScrollPane(detailArea);
        scrollPane.setBorder(new EmptyBorder(10, 10, 10, 10));

        panel.add(scrollPane, BorderLayout.CENTER);
        return panel;
    }

    /**
     * 创建属性面板
     */
    private JPanel createAttributePanel() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.add(new JLabel("属性信息将在这里显示"), BorderLayout.CENTER);
        return panel;
    }

    /**
     * 创建掉落物面板
     */
    private JPanel createDropPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.add(new JLabel("掉落物信息将在这里显示"), BorderLayout.CENTER);
        return panel;
    }

    /**
     * 创建技能面板
     */
    private JPanel createSkillPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.add(new JLabel("技能信息将在这里显示"), BorderLayout.CENTER);
        return panel;
    }

    /**
     * 显示怪物详情
     */
    public void showMonsterDetail(Object monster) {
        nameLabel.setText("怪物名称");
        typeLabel.setText("怪物");
        levelLabel.setText("等级: " + "?");

        // TODO: 填充实际数据
        String info = "基础数据：\n" +
                "  生命值: 100\n" +
                "  魔法值: 50\n" +
                "  攻击力: 10-20\n" +
                "  防御力: 5\n" +
                "  移动速度: 100\n\n" +
                "特殊属性：\n" +
                "  火焰抗性: 50%\n" +
                "  冰霜抗性: 30%\n" +
                "  毒素抗性: 20%";

        detailArea.setText(info);

        // 切换到基础信息标签页
        tabbedPane.setSelectedIndex(0);
    }

    /**
     * 显示NPC详情
     */
    public void showNPCDetail(Object npc) {
        nameLabel.setText("NPC名称");
        typeLabel.setText("NPC");
        levelLabel.setText("等级: " + "?");

        // TODO: 填充实际数据
        String info = "NPC信息：\n" +
                "  对话：\n" +
                "    欢迎来到普利斯顿内尔大陆！\n" +
                "  交易：\n" +
                "    出售武器\n" +
                "    出售防具\n" +
                "    出售消耗品\n\n" +
                "特殊功能：\n" +
                "  仓库管理员\n" +
                "  传送服务";

        detailArea.setText(info);

        // 切换到基础信息标签页
        tabbedPane.setSelectedIndex(0);
    }

    /**
     * 显示道具详情
     */
    public void showItemDetail(Object item) {
        nameLabel.setText("道具名称");
        typeLabel.setText("道具");
        levelLabel.setText("需要等级: " + "?");

        // TODO: 填充实际数据
        String info = "道具信息：\n" +
                "  类型: 武器\n" +
                "  子类型: 剑\n" +
                "  装备位置: 主手\n\n" +
                "基础属性：\n" +
                "  攻击力: 50-100\n" +
                "  攻击速度: +10%\n" +
                "  命中率: +5%\n\n" +
                "特殊效果：\n" +
                "  火焰伤害: +20\n" +
                "  暴击率: +5%";

        detailArea.setText(info);

        // 切换到基础信息标签页
        tabbedPane.setSelectedIndex(0);
    }

    /**
     * 显示地图详情
     */
    public void showMapDetail(Object map) {
        nameLabel.setText("地图名称");
        typeLabel.setText("地图");
        levelLabel.setText("推荐等级: " + "?");

        // TODO: 填充实际数据
        String info = "地图信息：\n" +
                "  大小: 500x500\n" +
                "  区域: 菲利顿内尔\n" +
                "  类型: 安全区\n\n" +
                "NPC：\n" +
                "  武器商人 x1\n" +
                "  防具商人 x1\n" +
                "  药剂商人 x1\n\n" +
                "怪物：\n" +
                "  蘑菇精 Level 5\n" +
                "  兔妖 Level 8";

        detailArea.setText(info);

        // 切换到基础信息标签页
        tabbedPane.setSelectedIndex(0);
    }

    /**
     * 清空详情
     */
    public void clear() {
        nameLabel.setText("-");
        typeLabel.setText("-");
        levelLabel.setText("-");
        detailArea.setText("请选择一个项目查看详细信息");
    }
}