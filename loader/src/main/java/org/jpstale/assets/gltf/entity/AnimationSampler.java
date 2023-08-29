package org.jpstale.assets.gltf.entity;

public class AnimationSampler extends GlTFProperty {
    /**
     * The index of an accessor containing keyframe input values, e.g., time. (required)
     * 
     */
    Integer input;
    /**
     * Interpolation algorithm. (optional)<br>
     * Default: "LINEAR"<br>
     * Valid values: ["LINEAR", "STEP", "CATMULLROMSPLINE", "CUBICSPLINE"]
     * 
     */
    String  interpolation;
    /**
     * The index of an accessor, containing keyframe output values. (required)
     * 
     */
    Integer output;
}