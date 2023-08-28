package org.jpstale.assets.gltf;

import java.io.IOException;

/**
 * @title Main
 * @author yanmaoyuan
 * @date 2018年8月1日
 * @version 1.0
 */
public class Main {

    /**
     * @param args
     */
    public static void main(String[] args) throws IOException {
        Stage2Gltf stage2gltf = new Stage2Gltf();

        stage2gltf.init();
        stage2gltf.load("Field/Greedy/Greedy.smd");
        stage2gltf.createWhiteGltf();
    }

}
