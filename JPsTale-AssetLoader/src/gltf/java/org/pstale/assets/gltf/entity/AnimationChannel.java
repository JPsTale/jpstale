package org.pstale.assets.gltf.entity;

public class AnimationChannel extends GlTFProperty {
    /**
     * The index of a sampler in this animation used to compute the value for the target. (required)
     * 
     */
    Integer sampler;

    /**
     * The index of the node and TRS property to target. (required)
     * 
     */
    AnimationChannelTarget target;
}