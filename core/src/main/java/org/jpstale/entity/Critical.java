package org.jpstale.entity;

import org.jpstale.entity.job.JobConstant;

/**
 * 必杀率（暴击）属性类
 * <p>
 * C++对应: sinCharStatus.cpp 中的 Critical 逻辑
 * <p>
 * 暴击计算规则:
 * <ul>
 * <li>Critical[0] - 基础暴击率，由装备/物品决定</li>
 * <li>Critical[1] - 根据职业决定的属性加成：
 *   <ul>
 *   <li>祭司/魔法师 → Spirit (精神)</li>
 *   <li>机械兵/武士/枪兵/骑士 → Strength (力量)</li>
 *   <li>弓箭手/魔枪手 → Dexterity (敏捷)</li>
 *   </ul>
 * </li>
 * </ul>
 *
 * @see <a href=" Damage.cpp:296-316">C++ Critical实现</a>
 */
public class Critical {

    /**
     * 基础暴击率（Critical[0]）
     * 由装备、物品、buff等提供
     */
    int criticalRate;

    /**
     * 暴击伤害加成（Critical[1]）
     * 根据职业类型，从对应的属性中获取加成
     */
    int criticalDamageBonus;

    /**
     * 默认构造函数
     */
    public Critical() {
        this.criticalRate = 0;
        this.criticalDamageBonus = 0;
    }

    /**
     * 构造函数 - 设置基础暴击率
     *
     * @param criticalRate 基础暴击率
     */
    public Critical(int criticalRate) {
        this.criticalRate = criticalRate;
        this.criticalDamageBonus = 0;
    }

    /**
     * 构造函数 - 设置所有暴击属性
     *
     * @param criticalRate       基础暴击率
     * @param criticalDamageBonus 暴击伤害加成
     */
    public Critical(int criticalRate, int criticalDamageBonus) {
        this.criticalRate = criticalRate;
        this.criticalDamageBonus = criticalDamageBonus;
    }

    /**
     * 获取基础暴击率
     *
     * @return 基础暴击率
     */
    public int getCriticalRate() {
        return criticalRate;
    }

    /**
     * 设置基础暴击率
     *
     * @param criticalRate 基础暴击率
     */
    public void setCriticalRate(int criticalRate) {
        this.criticalRate = criticalRate;
    }

    /**
     * 增加暴击率
     *
     * @param amount 增加的暴击率
     */
    public void addCriticalRate(int amount) {
        this.criticalRate += amount;
    }

    /**
     * 获取暴击伤害加成
     *
     * @return 暴击伤害加成
     */
    public int getCriticalDamageBonus() {
        return criticalDamageBonus;
    }

    /**
     * 设置暴击伤害加成
     *
     * @param criticalDamageBonus 暴击伤害加成
     */
    public void setCriticalDamageBonus(int criticalDamageBonus) {
        this.criticalDamageBonus = criticalDamageBonus;
    }

    /**
     * 增加暴击伤害加成
     *
     * @param amount 增加的暴击伤害加成
     */
    public void addCriticalDamageBonus(int amount) {
        this.criticalDamageBonus += amount;
    }

    /**
     * 根据职业代码获取暴击伤害加成的属性值
     * <p>
     * C++实现逻辑 (Damage.cpp:299-316):
     * <pre>
     * switch( lpCurPlayer->smCharInfo.JOB_CODE ) {
     *     case JOBCODE_PRIESTESS:
     *     case JOBCODE_MAGICIAN:
     *         TransAttackData.Critical[1] = lpCurPlayer->smCharInfo.Spirit;   //精神
     *         break;
     *     case JOBCODE_MECHANICIAN:
     *     case JOBCODE_FIGHTER:
     *     case JOBCODE_PIKEMAN:
     *     case JOBCODE_KNIGHT:
     *         TransAttackData.Critical[1] = lpCurPlayer->smCharInfo.Strength;  //力量
     *         break;
     *     case JOBCODE_ARCHER:
     *     case JOBCODE_ATALANTA:
     *         TransAttackData.Critical[1] = lpCurPlayer->smCharInfo.Dexterity; //敏捷
     *         break;
     * }
     * </pre>
     *
     * @param jobCode 职业代码
     * @param strength   力量属性值
     * @param dexterity  敏捷属性值
     * @param spirit     精神属性值
     * @return 基于职业的暴击伤害加成值
     */
    public static int getCriticalBonusByJob(long jobCode, int strength, int dexterity, int spirit) {
        // 祭司系和法师系 - 使用精神
        if (jobCode == JobConstant.JOB_CODE_PRIESTESS
                || jobCode == JobConstant.JOB_CODE_MAGICIAN
                || jobCode == JobConstant.JOB_CODE_PRIEST
                || jobCode == JobConstant.JOB_CODE_SAINTESS
                || jobCode == JobConstant.JOB_CODE_BISHOP
                || jobCode == JobConstant.JOB_CODE_SAINTESS
                || jobCode == JobConstant.JOB_CODE_VALHALLA
                || jobCode == JobConstant.JOB_CODE_CELESTIAL
                || jobCode == JobConstant.JOB_CODE_ARCHMAGE) {
            return spirit;
        }

        // 战士系 - 使用力量
        if (jobCode == JobConstant.JOB_CODE_MECHANICIAN
                || jobCode == JobConstant.JOB_CODE_FIGHTER
                || jobCode == JobConstant.JOB_CODE_PIKEMAN
                || jobCode == JobConstant.JOB_CODE_KNIGHT
                || jobCode == JobConstant.JOB_CODE_WARRIOR
                || jobCode == JobConstant.JOB_CODE_COMBATANT
                || jobCode == JobConstant.JOB_CODE_METALLEADER
                || jobCode == JobConstant.JOB_CODE_CHAMPION
                || jobCode == JobConstant.JOB_CODE_LANCELOT
                || jobCode == JobConstant.JOB_CODE_HEAVYMETAL
                || jobCode == JobConstant.JOB_CODE_IMMORTALWARRIOR
                || jobCode == JobConstant.JOB_CODE_HOLYKNIGHT
                || jobCode == JobConstant.JOB_CODE_PALADIN
                || jobCode == JobConstant.JOB_CODE_SAINTKNIGHT
                || jobCode == JobConstant.JOB_CODE_ROYALKNIGHT
                || jobCode == JobConstant.JOB_CODE_VALKYRIE) {
            return strength;
        }

        // 弓箭手系 - 使用敏捷
        if (jobCode == JobConstant.JOB_CODE_ARCHER
                || jobCode == JobConstant.JOB_CODE_ATALANTA
                || jobCode == JobConstant.JOB_CODE_HUNTERMASTER
                || jobCode == JobConstant.JOB_CODE_DIONS_DISCIPLE
                || jobCode == JobConstant.JOB_CODE_SAGITTARION) {
            return dexterity;
        }

        // 默认返回力量
        return strength;
    }

    /**
     * 计算最终暴击伤害
     * <p>
     * 暴击伤害公式: 基础伤害 * (1 + criticalDamageBonus / 100)
     *
     * @param baseDamage 基础伤害值
     * @return 暴击时的最终伤害
     */
    public int calculateCriticalDamage(int baseDamage) {
        return baseDamage + (baseDamage * criticalDamageBonus) / 100;
    }

    @Override
    public String toString() {
        return "Critical{" +
                "criticalRate=" + criticalRate +
                ", criticalDamageBonus=" + criticalDamageBonus +
                '}';
    }
}