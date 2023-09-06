package org.jpstale.entity.item;

import lombok.ToString;

/**
 * 元素抗性
 * 
 * @author yanmaoyuan
 *
 */
@ToString
public class AttrResistance {

    public int Bionic[] = new int[2];
    public int Earth[] = new int[2];
    public int Fire[] = new int[2];
    public int Ice[] = new int[2];
    public int Lighting[] = new int[2];
    public int Poison[] = new int[2];
    public int Water[] = new int[2];
    public int Wind[] = new int[2];

    public AttrResistance() {

    }
}