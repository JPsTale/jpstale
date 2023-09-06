package org.jpstale.entity.item;

import lombok.ToString;

/**
 * 防御能力
 * 
 * @author yanmaoyuan
 *
 */
@ToString
public class AttrDefence {
    public float Absorb[] = new float[2]; // 吸收
    public float Defence[] = new float[2]; // 防御
    public float Block_Rating[] = new float[2]; // (盾牌)格挡率
}
