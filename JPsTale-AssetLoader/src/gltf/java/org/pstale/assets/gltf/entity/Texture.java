package org.pstale.assets.gltf.entity;

public class Texture extends GlTFProperty {
    /**
     * The index of the sampler used by this texture. When undefined, a sampler with repeat wrapping and auto filtering
     * should be used. (optional)
     */
    Integer sampler;
    /**
     * The index of the image used by this texture. (optional)
     */
    Integer source;
}