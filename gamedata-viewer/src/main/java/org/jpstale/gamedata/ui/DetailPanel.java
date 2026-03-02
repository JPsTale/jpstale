package org.jpstale.gamedata.ui;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;

/**
 * 详情显示面板
 */
public class DetailPanel extends JScrollPane {

    private JTextArea detailArea;

    public DetailPanel() {
        initializeUI();
    }

    /**
     * 初始化UI
     */
    private void initializeUI() {
        detailArea = new JTextArea();
        detailArea.setEditable(false);
        detailArea.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 12));
        detailArea.setBorder(new EmptyBorder(10, 10, 10, 10));

        // 将文本区域放在滚动面板中
        this.setViewportView(detailArea);
        this.setBorder(new TitledBorder("详细信息"));
        this.setPreferredSize(new Dimension(-1, 200));
    }

    public void setText(String text) {
        detailArea.setText(text);
    }

    public void append(String text) {
        detailArea.append(text);
    }

    public String getText() {
        return detailArea.getText();
    }

    public void clear() {
        detailArea.setText("");
    }

    public Component getComponent() {
        return detailArea;
    }
}