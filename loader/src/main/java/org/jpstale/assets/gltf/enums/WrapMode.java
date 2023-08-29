package org.jpstale.assets.gltf.enums;

public enum WrapMode {

    Repeat(10497),//default
    
    EdgeClamp(33071),
    
    MirroredRepeat(33648);
    
    private int value;
    
    private WrapMode(int value) {
        this.value = value;
    }
    
    public int getValue() {
        return value;
    }
}