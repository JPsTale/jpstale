package org.pstale.assets.gltf.entity;

import java.util.List;

public class Animation extends GlTFProperty {
    
    /**
     * The user-defined name of this object.
     */
    String name;
    
    /**
     * An array of channels, each of which targets an animation's sampler at 
     * a node's property. Different channels of the same animation can't have 
     * equal targets. (required)<br> 
     * Minimum number of items: 1<br> 
     * Array elements:<br> 
     * &nbsp;&nbsp;Targets an animation's sampler at a node's property. 
     * (optional) 
     * 
     */
    List<AnimationChannel> channels;
    /**
     * An array of samplers that combines input and output accessors with an 
     * interpolation algorithm to define a keyframe graph (but not its 
     * target). (required)<br> 
     * Minimum number of items: 1<br> 
     * Array elements:<br> 
     * &nbsp;&nbsp;Combines input and output accessors with an interpolation 
     * algorithm to define a keyframe graph (but not its target). (optional) 
     * 
     */
    List<AnimationSampler> samplers;

}