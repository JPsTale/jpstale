package org.jpstale.gamedata.preview;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * 在独立 JVM 进程中启动 3D 预览（macOS 上使用 -XstartOnFirstThread 满足 OpenGL 主线程要求）。
 */
public final class PreviewProcessRunner {

    private static final boolean IS_MAC = System.getProperty("os.name", "").toLowerCase().contains("mac");

    /**
     * 在子进程中启动角色或道具 3D 预览。不阻塞；进程在用户关闭预览窗口后退出。
     *
     * @param gameRoot       游戏根目录（GameServer 的父目录）
     * @param characterPath  角色 .inx 路径（如 char/monster/xxx/xxx.inx），为 null 时表示道具预览
     * @param itemCode       道具代码（仅当 characterPath 为 null 时使用）
     * @return 是否成功启动进程（不代表预览窗口已显示）
     */
    public static boolean launch(String gameRoot, String characterPath, long itemCode) {
        if (gameRoot == null || gameRoot.isEmpty()) {
            return false;
        }
        String javaHome = System.getProperty("java.home");
        String javaBin = javaHome + File.separator + "bin" + File.separator + "java";
        String cp = System.getProperty("java.class.path");

        List<String> cmd = new ArrayList<>();
        cmd.add(javaBin);
        if (IS_MAC) {
            cmd.add("-XstartOnFirstThread");
        }
        cmd.add("-cp");
        cmd.add(cp);
        cmd.add(PreviewLauncher.class.getName());
        cmd.add("--gameRoot");
        cmd.add(gameRoot);
        if (characterPath != null && !characterPath.isEmpty()) {
            cmd.add("--character");
            cmd.add(characterPath);
        } else {
            cmd.add("--item");
            cmd.add(Long.toHexString(itemCode));
        }

        try {
            ProcessBuilder pb = new ProcessBuilder(cmd);
            pb.inheritIO();
            pb.start();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
