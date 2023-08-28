package org.jpstale.assets.gltf.enums;

public enum MinFilter {
    
    NEAREST(9728),

    LINEAR(9729),
    
    NEAREST_MIPMAP_NEAREST(9984),
    
    LINEAR_MIPMAP_NEAREST(9985),
    
    NEAREST_MIPMAP_LINEAR(9986),
    
    LINEAR_MIPMAP_LINEAR(9987);
    
    private int value;
    
    private MinFilter(int value) {
        this.value = value;
    }
    
    public int getValue() {
        return value;
    }
}
