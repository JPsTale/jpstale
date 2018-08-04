package org.pstale.assets.gltf.entity;

public class BufferView extends GlTFChildOfRootProperty {
    
    Integer buffer = 0;
    
    Integer byteOffset = 0;
    
    Integer byteStride;
    
    Integer byteLength;
    
    Integer target;

    /**
     * @return the buffer
     */
    public Integer getBuffer() {
        return buffer;
    }

    /**
     * @param buffer the buffer to set
     */
    public void setBuffer(Integer buffer) {
        this.buffer = buffer;
    }

    /**
     * @return the byteOffset
     */
    public Integer getByteOffset() {
        return byteOffset;
    }

    /**
     * @param byteOffset the byteOffset to set
     */
    public void setByteOffset(Integer byteOffset) {
        this.byteOffset = byteOffset;
    }

    /**
     * @return the byteStride
     */
    public Integer getByteStride() {
        return byteStride;
    }

    /**
     * @param byteStride the byteStride to set
     */
    public void setByteStride(Integer byteStride) {
        this.byteStride = byteStride;
    }

    /**
     * @return the byteLength
     */
    public Integer getByteLength() {
        return byteLength;
    }

    /**
     * @param byteLength the byteLength to set
     */
    public void setByteLength(Integer byteLength) {
        this.byteLength = byteLength;
    }

    /**
     * @return the target
     */
    public Integer getTarget() {
        return target;
    }

    /**
     * @param target the target to set
     */
    public void setTarget(Integer target) {
        this.target = target;
    }
    
}