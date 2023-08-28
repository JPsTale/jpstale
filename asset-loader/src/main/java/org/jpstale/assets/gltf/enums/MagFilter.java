package org.jpstale.assets.gltf.enums;

public enum MagFilter {

    NEAREST(9728),
    
    LINEAR(9729);
    
    private int value;
    
    private MagFilter(int value) {
        this.value = value;
    }
    
    public int getValue() {
        return value;
    }
}