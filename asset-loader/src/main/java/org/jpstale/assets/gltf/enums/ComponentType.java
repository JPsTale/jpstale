package org.jpstale.assets.gltf.enums;
public enum ComponentType {
    BYTE(5120, 1),

    UNSIGNED_BYTE(5121, 1),

    SHORT(5122, 2),

    UNSIGNED_SHORT(5123, 2),

    // INT(5124, 4),

    UNSIGNED_INT(5125, 4),

    FLOAT(5126, 4);

    int value;
    int bytes;

    private ComponentType(int value, int bytes) {
        this.value = value;
        this.bytes = bytes;
    }
    
    public int getValue() {
        return value;
    }
    
    public int getBytes() {
        return bytes;
    }
}