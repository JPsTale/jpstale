package org.jpstale.assets.gltf.enums;

public enum Target {
    VERTEX_ATTRIBUTE(34962), VERTEX_INDIX(34963);
    
    int value;

    private Target(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}