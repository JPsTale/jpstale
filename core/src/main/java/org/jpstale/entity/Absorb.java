package org.jpstale.entity;

/**
 * 伤害吸收（Absorb）属性类
 * <p>
 * C++对应: sinSubMain.cpp 中的 sinGetAbsorb 函数
 * <p>
 * 伤害吸收说明:
 * <ul>
 * <li>Absorption - 基础伤害吸收值，由装备提供</li>
 * <li>对不死系怪物有额外的吸收加成 (sinUndeadAbsorb)</li>
 * </ul>
 *
 * @see <a href="sinSubMain.cpp:1778-1791">C++ sinGetAbsorb实现</a>
 */
public class Absorb {

    /**
     * 怪物类型：普通
     */
    public static final int TYPE_NORMAL = 0;

    /**
     * 怪物类型：不死系 (Undead)
     */
    public static final int TYPE_UNDEAD = 1;

    /**
     * 基础伤害吸收值
     */
    int absorption;

    /**
     * 对不死系怪物的额外吸收值
     */
    int undeadAbsorb;

    /**
     * 默认构造函数
     */
    public Absorb() {
        this.absorption = 0;
        this.undeadAbsorb = 0;
    }

    /**
     * 构造函数 - 设置基础吸收值
     *
     * @param absorption 基础伤害吸收
     */
    public Absorb(int absorption) {
        this.absorption = absorption;
        this.undeadAbsorb = 0;
    }

    /**
     * 获取基础伤害吸收值
     *
     * @return 吸收值
     */
    public int getAbsorption() {
        return absorption;
    }

    /**
     * 设置基础伤害吸收值
     *
     * @param absorption 吸收值
     */
    public void setAbsorption(int absorption) {
        this.absorption = absorption;
    }

    /**
     * 增加基础伤害吸收
     *
     * @param amount 增加的吸收值
     */
    public void addAbsorption(int amount) {
        this.absorption += amount;
    }

    /**
     * 获取对不死系怪物的额外吸收值
     *
     * @return 不死系额外吸收
     */
    public int getUndeadAbsorb() {
        return undeadAbsorb;
    }

    /**
     * 设置对不死系怪物的额外吸收值
     *
     * @param undeadAbsorb 额外吸收值
     */
    public void setUndeadAbsorb(int undeadAbsorb) {
        this.undeadAbsorb = undeadAbsorb;
    }

    /**
     * 增加对不死系怪物的额外吸收
     *
     * @param amount 增加的额外吸收
     */
    public void addUndeadAbsorb(int amount) {
        this.undeadAbsorb += amount;
    }

    /**
     * 计算对指定类型目标的伤害吸收
     * <p>
     * C++实现逻辑 (sinSubMain.cpp:1778-1791):
     * <pre>
     * int sinGetAbsorb(int Type)
     * {
     *     switch(Type){
     *         case SIN_MONSTER_UNDEAD:
     *             return sinChar->Absorption + sinUndeadAbsorb;
     *             break;
     *         default:
     *             return sinChar->Absorption;
     *             break;
     *     }
     *     return TRUE;
     * }
     * </pre>
     *
     * @param targetType 目标类型 (TYPE_NORMAL 或 TYPE_UNDEAD)
     * @return 伤害吸收值
     */
    public int calculateAbsorb(int targetType) {
        switch (targetType) {
            case TYPE_UNDEAD:
                return this.absorption + this.undeadAbsorb;
            case TYPE_NORMAL:
            default:
                return this.absorption;
        }
    }

    /**
     * 计算普通目标的伤害吸收
     *
     * @return 伤害吸收值
     */
    public int calculateAbsorb() {
        return calculateAbsorb(TYPE_NORMAL);
    }

    /**
     * 应用伤害吸收
     * <p>
     * 伤害公式: 实际伤害 = 基础伤害 - 吸收值
     * 吸收值不能超过基础伤害（不会造成治疗效果）
     *
     * @param baseDamage 基础伤害
     * @param targetType 目标类型
     * @return 吸收后的实际伤害
     */
    public int applyAbsorb(int baseDamage, int targetType) {
        int absorb = calculateAbsorb(targetType);
        int actualDamage = baseDamage - absorb;
        if (actualDamage < 0) {
            actualDamage = 0;
        }
        return actualDamage;
    }

    /**
     * 应用伤害吸收（默认普通目标）
     *
     * @param baseDamage 基础伤害
     * @return 吸收后的实际伤害
     */
    public int applyAbsorb(int baseDamage) {
        return applyAbsorb(baseDamage, TYPE_NORMAL);
    }

    @Override
    public String toString() {
        return "Absorb{" +
                "absorption=" + absorption +
                ", undeadAbsorb=" + undeadAbsorb +
                '}';
    }
}