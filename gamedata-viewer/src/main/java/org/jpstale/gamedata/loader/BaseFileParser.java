package org.jpstale.gamedata.loader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 基础文件解析器
 */
public abstract class BaseFileParser {

    /**
     * 读取文件内容，尝试不同的编码格式
     */
    protected List<String> readFileLines(File file) throws IOException {
        List<String> lines = new ArrayList<>();

        // 尝试不同的编码顺序
        Charset[] charsets = {
            Charset.forName("GBK"),    // 简体中文
            Charset.forName("Big5"),    // 繁体中文
            Charset.forName("MS950"),   // 繁体中文变体
            Charset.forName("UTF-8"),    // UTF-8
            Charset.forName("ISO-8859-1") // 拉丁
        };

        IOException lastException = null;
        for (Charset charset : charsets) {
            try (BufferedReader reader = new BufferedReader(
                    new InputStreamReader(new FileInputStream(file), charset))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    // 清理行内容
                    line = line.trim();
                    if (!line.isEmpty()) {
                        lines.add(line);
                    }
                }
                // 成功读取，返回
                return lines;
            } catch (IOException ex) {
                lastException = ex;
                lines.clear(); // 清空部分内容，重试
            }
        }

        throw new IOException("无法使用任何编码读取文件: " + file.getPath(), lastException);
    }

    /**
     * 解析键值对行
     * 格式: *键值 "值" 或 *键值 值
     */
    protected void parseKeyValuePair(String line, ConfigMap config) {
        // 移除注释 *
        if (line.startsWith("*")) {
            line = line.substring(1);
        }

        // 查找第一个空格或制表符
        int separatorIndex = findSeparator(line);
        if (separatorIndex == -1) {
            return;
        }

        String key = line.substring(0, separatorIndex).trim();
        String value = line.substring(separatorIndex).trim();

        // 如果值被引号包围
        if ((value.startsWith("\"") && value.endsWith("\"")) ||
            (value.startsWith("'") && value.endsWith("'"))) {
            value = value.substring(1, value.length() - 1);
        }

        config.put(key, value);
    }

    /**
     * 查找分隔符位置
     */
    private int findSeparator(String line) {
        int spaceIndex = line.indexOf(' ');
        if (spaceIndex != -1) {
            return spaceIndex;
        }
        return line.indexOf('\t');
    }

    /**
     * 解析数值范围
     * 格式: 最小值 最大值
     */
    protected int[] parseRange(String str) {
        String[] parts = str.split("\\s+");
        if (parts.length >= 2) {
            try {
                int min = Integer.parseInt(parts[0]);
                int max = Integer.parseInt(parts[1]);
                return new int[]{min, max};
            } catch (NumberFormatException e) {
                return new int[]{0, 0};
            }
        }
        return new int[]{0, 0};
    }

    /**
     * 解析整数
     */
    protected int parseInt(String str, int defaultValue) {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e) {
            return defaultValue;
        }
    }

    /**
     * 解析布尔值
     */
    protected boolean parseBoolean(String str) {
        return "true".equalsIgnoreCase(str) || "1".equals(str);
    }

    /**
     * 解析数值列表
     */
    protected int[] parseIntArray(String str) {
        String[] parts = str.split("\\s+");
        int[] result = new int[parts.length];
        for (int i = 0; i < parts.length; i++) {
            result[i] = parseInt(parts[i], 0);
        }
        return result;
    }

    /**
     * 简单的配置映射类
     */
    protected static class ConfigMap {
        private final java.util.Map<String, String> map = new java.util.HashMap<>();

        public void put(String key, String value) {
            map.put(key, value);
        }

        public String get(String key) {
            return map.get(key);
        }

        public String get(String key, String defaultValue) {
            return map.getOrDefault(key, defaultValue);
        }

        public int getInt(String key, int defaultValue) {
            String value = get(key);
            if (value != null) {
                try {
                    return Integer.parseInt(value);
                } catch (NumberFormatException e) {
                    return defaultValue;
                }
            }
            return defaultValue;
        }

        public boolean contains(String key) {
            return map.containsKey(key);
        }
    }
}