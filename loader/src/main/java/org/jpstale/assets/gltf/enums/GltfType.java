package org.jpstale.assets.gltf.enums;

public enum GltfType {
    SCALAR(1), VEC2(2), VEC3(3), VEC4(4), MAT2(4), MAT3(9), MAT4(16);

    int components;

    private GltfType(int components) {
        this.components = components;
    }
    
    public int getComponents() {
        return components;
    }
}