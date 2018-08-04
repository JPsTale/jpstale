package org.pstale.assets.gltf.entity;

public class TextureInfo extends GlTFProperty {
    /**
     * The index of the texture. (required)
     * 
     */
    Integer index;
    /**
     * The set index of texture's TEXCOORD attribute used for texture coordinate mapping. (optional)<br>
     * Default: 0<br>
     * Minimum: 0 (inclusive)
     * 
     */
    Integer texCoord;
}