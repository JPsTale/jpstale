package org.jpstale.gamedata.preview;

import com.jme3.system.JmeCanvasContext;

import java.awt.Canvas;
import javax.swing.JFrame;

/**
 * 持有在主线程创建的 JME Canvas 与预览窗口，供 MainFrame 显示 3D 预览时复用。
 */
public class JmePreviewHolder {

    private final EmbeddedPreviewApp app;
    private final JFrame previewFrame;
    private final Canvas canvas;

    public JmePreviewHolder(EmbeddedPreviewApp app, JFrame previewFrame, Canvas canvas) {
        this.app = app;
        this.previewFrame = previewFrame;
        this.canvas = canvas;
    }

    public EmbeddedPreviewApp getApp() {
        return app;
    }

    public JFrame getPreviewFrame() {
        return previewFrame;
    }

    public Canvas getCanvas() {
        return canvas;
    }

    public void setTitle(String title) {
        if (previewFrame != null) {
            previewFrame.setTitle(title);
        }
    }

    public void showPreview() {
        if (previewFrame != null) {
            previewFrame.setVisible(true);
            previewFrame.toFront();
        }
    }

    public void hidePreview() {
        if (previewFrame != null) {
            previewFrame.setVisible(false);
        }
    }
}
