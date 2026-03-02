package org.jpstale.gamedata;

import org.jpstale.gamedata.ui.MainFrame;

import javax.swing.SwingUtilities;

/**
 * GameServer配置查看器主程序
 */
public class GameDataViewer {

    public static void main(String[] args) {
        // 设置系统外观
        try {
            javax.swing.UIManager.setLookAndFeel(
                javax.swing.UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        // 在事件调度线程中创建GUI
        SwingUtilities.invokeLater(() -> {
            MainFrame mainFrame = new MainFrame();
            mainFrame.setVisible(true);
        });
    }
}