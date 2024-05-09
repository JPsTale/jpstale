package org.jpstale.utils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

/**
 * desc:
 *
 * @author yanmaoyuan
 * @date 2023/10/13
 */
public class CP51959 {
    public static void main(String[] args) throws IOException {
        Charset.forName("CP51949");
        File file = new File("/Users/yanmaoyuan/repo/pstale/Source/J_Server/Argentina/a_clanText.h");
        Scanner scan = new Scanner(file, "CP51949");
        while (scan.hasNextLine()) {
            System.out.println(scan.nextLine());
        }
        scan.close();
    }
}
