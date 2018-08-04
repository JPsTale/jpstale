package org.pstale.assets.gltf.entity;

public class Buffer extends GlTFChildOfRootProperty {

    String uri;

    Integer byteLength;

    /**
     * @return the uri
     */
    public String getUri() {
        return uri;
    }

    /**
     * @param uri the uri to set
     */
    public void setUri(String uri) {
        this.uri = uri;
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
    
}