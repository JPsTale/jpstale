package org.jpstale.gamedata;

import org.jpstale.gamedata.ui.MainFrame;

import javax.swing.SwingUtilities;

/**
 * GameServer配置查看器主程序。
 */
public class GameDataViewer {

    public static void main(String[] args) {

        try {
            javax.swing.UIManager.setLookAndFeel(
                javax.swing.UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        SwingUtilities.invokeLater(() -> {
            MainFrame mainFrame = new MainFrame(null);
            mainFrame.setVisible(true);
        });
    }
}