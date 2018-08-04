package org.pstale.assets.gltf.entity;

public class Image extends GlTFProperty {

    /**
     * The uri of the image. (optional)
     * 
     */
    String uri;

    /**
     * The image's MIME type. (optional)<br>
     * Valid values: ["image/jpeg", "image/png"]
     * 
     */
    String mimeType;

    /**
     * The index of the bufferView that contains the image. Use this instead of the image's uri property. (optional)
     * 
     */
    Integer bufferView;
}