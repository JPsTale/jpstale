package org.pstale.assets.gltf.entity;

public class AnimationChannelTarget extends GlTFProperty {
    /**
     * The index of the node to target. (optional)
     * 
     */
    Integer node;
    /**
     * The name of the node's TRS property to modify, or the "weights" of the Morph Targets it instantiates.
     * (required)<br>
     * Valid values: ["translation", "rotation", "scale", "weights"]
     * 
     */
    String  path;
}