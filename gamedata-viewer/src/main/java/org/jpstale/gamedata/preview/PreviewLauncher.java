package org.jpstale.gamedata.preview;

import java.util.ArrayList;
import java.util.List;

/**
 * 独立进程入口：供 gamedata-viewer 在 macOS 上通过子进程 + -XstartOnFirstThread 启动 3D 预览，
 * 避免在主进程子线程中跑 JME 触发 libdispatch 断言崩溃。
 * <p>
 * 参数：--gameRoot &lt;路径&gt; [--character &lt;.inx 路径&gt; | --item &lt;物品代码十六进制&gt;]
 */
public class PreviewLauncher {

    public static void main(String[] args) {
        String gameRoot = null;
        String characterPath = null;
        String itemCodeHex = null;
        for (int i = 0; i < args.length; i++) {
            if ("--gameRoot".equals(args[i]) && i + 1 < args.length) {
                gameRoot = args[++i];
            } else if ("--character".equals(args[i]) && i + 1 < args.length) {
                characterPath = args[++i];
            } else if ("--item".equals(args[i]) && i + 1 < args.length) {
                itemCodeHex = args[++i];
            }
        }
        if (gameRoot == null || gameRoot.isEmpty()) {
            System.err.println("用法: PreviewLauncher --gameRoot <路径> [--character <.inx路径> | --item <物品代码十六进制>]");
            System.exit(1);
        }
        try {
            if (itemCodeHex != null && !itemCodeHex.isEmpty()) {
                long code = Long.parseLong(itemCodeHex.replaceFirst("^0x", ""), 16);
                ItemPreviewApp app = new ItemPreviewApp(gameRoot, code);
                app.start();
            } else if (characterPath != null && !characterPath.isEmpty()) {
                ModelPreviewApp app = new ModelPreviewApp(gameRoot, characterPath);
                app.start();
            } else {
                System.err.println("请指定 --character 或 --item");
                System.exit(1);
            }
        } catch (Throwable t) {
            t.printStackTrace();
            System.exit(1);
        }
    }
}
