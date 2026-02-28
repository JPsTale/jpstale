package org.jpstale.entity;

/**
 * 命中率（Attack Rate/Accuracy）属性类
 * <p>
 * C++对应: sinSubMain.cpp 中的 sinGetAccuracy 函数
 * <p>
 * 命中率计算公式:
 * <pre>
 * 1. 基础命中值 = (Attack_Rating - 对方防御) * 1.4
 * 2. 根据 Accuracy_Table 转换为命中率 (范围 50%~95%)
 * 3. 根据等级差调整: -((对方等级 - 己方等级)/100)*28
 * 4. 限制最终范围: 30% ~ 95%
 * </pre>
 *
 * @see <a href="sinSubMain.cpp:1655-1689">C++ sinGetAccuracy实现</a>
 */
public class AttackRate {

    /**
     * 基础命中率表 - Attack_Rating差值 → 命中率百分比
     * C++ Accuracy_Table 的映射
     */
    private static final int[][] ACCURACY_TABLE = {
            // 此表需要从 C++ sinTable.h 完整复制
            // 格式: {AC_R值, 命中率}
            {-190, 50},   // AC_R < -190 时命中率 50%
            // ... 更多条目需要从 C++ 源码提取
    };

    /**
     * 基础命中率（Attack_Rating）
     * 由装备、属性决定
     */
    int attackRating;

    /**
     * 最终命中率（Accuracy）
     * 计算后的实际命中率百分比
     */
    int accuracy;

    /**
     * 命中率下限
     */
    public static final int MIN_ACCURACY = 30;

    /**
     * 命中率上限
     */
    public static final int MAX_ACCURACY = 95;

    /**
     * 基础命中值下限（对应 50% 命中率）
     */
    public static final int MIN_AC_R = -190;

    /**
     * 基础命中值上限（对应 95% 命中率）
     */
    public static final int MAX_AC_R = 2100;

    /**
     * 默认构造函数
     */
    public AttackRate() {
        this.attackRating = 0;
        this.accuracy = 0;
    }

    /**
     * 构造函数 - 设置基础命中率
     *
     * @param attackRating 基础命中率 (Attack_Rating)
     */
    public AttackRate(int attackRating) {
        this.attackRating = attackRating;
        this.accuracy = 0;
    }

    /**
     * 获取基础命中率（Attack_Rating）
     *
     * @return 基础命中率
     */
    public int getAttackRating() {
        return attackRating;
    }

    /**
     * 设置基础命中率（Attack_Rating）
     *
     * @param attackRating 基础命中率
     */
    public void setAttackRating(int attackRating) {
        this.attackRating = attackRating;
    }

    /**
     * 增加基础命中率
     *
     * @param amount 增加的值
     */
    public void addAttackRating(int amount) {
        this.attackRating += amount;
    }

    /**
     * 获取计算后的命中率
     *
     * @return 命中率百分比 (0-100)
     */
    public int getAccuracy() {
        return accuracy;
    }

    /**
     * 设置计算后的命中率
     *
     * @param accuracy 命中率
     */
    public void setAccuracy(int accuracy) {
        this.accuracy = accuracy;
    }

    /**
     * 计算命中率
     * <p>
     * C++实现逻辑 (sinSubMain.cpp:1655-1689):
     * <pre>
     * int sinGetAccuracy(int desLV , int desDefense)
     * {
     *     AC_R = (Attack_Rating - desDefense) * 1.4;
     *
     *     // 根据 AC_R 查表得到基础命中率
     *     while(1){
     *         if(AC_R < -190) { RealAC = 50; break; }      // 下限 50%
     *         if(AC_R > 2100) { RealAC = 95; break; }      // 上限 95%
     *         if(Accuracy_Table[cnt][1] == 0) break;
     *         if(AC_R >= Accuracy_Table[cnt][0] && AC_R <= Accuracy_Table[cnt+1][0]) {
     *             RealAC = Accuracy_Table[cnt+1][1];
     *             break;
     *         }
     *         cnt++;
     *     }
     *
     *     // 根据等级差调整
     *     Result = RealAC - ((desLV - myLV)/100)*28;
     *
     *     if(Result < 30) Result = 30;   // 下限 30%
     *     if(Result > 95) Result = 95;   // 上限 95%
     *     return Result;
     * }
     * </pre>
     *
     * @param targetDefense 目标防御力
     * @param targetLevel   目标等级
     * @param myLevel       自身等级
     * @return 计算后的命中率 (30-95)
     */
    public int calculateAccuracy(int targetDefense, int targetLevel, int myLevel) {
        // 步骤1: 计算基础命中值
        int acR = (int) ((this.attackRating - targetDefense) * 1.4f);

        // 步骤2: 根据 AC_R 查表得到基础命中率
        int realAC = lookupAccuracyFromTable(acR);

        // 步骤3: 根据等级差调整
        // 目标等级每高 100 级，命中率减少 28%
        float levelDiff = (targetLevel - myLevel) / 100.0f;
        float result = realAC - (levelDiff * 28);

        // 步骤4: 限制范围 30% ~ 95%
        if (result < MIN_ACCURACY) {
            result = MIN_ACCURACY;
        } else if (result > MAX_ACCURACY) {
            result = MAX_ACCURACY;
        }

        this.accuracy = (int) result;
        return this.accuracy;
    }

    /**
     * 简化版命中率计算（不包含等级差调整）
     *
     * @param targetDefense 目标防御力
     * @return 计算后的命中率 (30-95)
     */
    public int calculateAccuracy(int targetDefense) {
        return calculateAccuracy(targetDefense, 0, 0);
    }

    /**
     * 从命中表查找命中率
     * <p>
     * Accuracy_Table 是按 AC_R 值区间映射到命中率的查找表
     *
     * @param acR 基础命中值
     * @return 基础命中率
     */
    private int lookupAccuracyFromTable(int acR) {
        // 边界检查
        if (acR <= MIN_AC_R) {
            return 50;  // 下限 50%
        }
        if (acR >= MAX_AC_R) {
            return 95;  // 上限 95%
        }

        // 线性插值计算命中率
        // AC_R 值越大，命中率越高
        // 范围映射: [-190, 2100] -> [50, 95]
        int effectiveRange = MAX_AC_R - MIN_AC_R;  // 2290
        int valueRange = acR - MIN_AC_R;  // 相对于下限的值 (0 ~ 2290)

        // 线性映射到 50-95
        int accuracy = 50 + (int) ((valueRange * 45.0f) / effectiveRange);

        // 限制范围
        if (accuracy < 50) accuracy = 50;
        if (accuracy > 95) accuracy = 95;

        return accuracy;
    }

    /**
     * 计算怪物对玩家的命中率
     * <p>
     * C++实现逻辑 (sinSubMain.cpp:1692-1710):
     * <pre>
     * int sinGetMonsterAccuracy(int MonsterLV , int MonsterAttack_Rating)
     * {
     *     AC_R = (MonsterAttack_Rating - sinChar->Defence) * 2;
     *     // ... 类似的查表逻辑
     * }
     * </pre>
     *
     * @param monsterAttackRating 怪物攻击力
     * @param playerDefense       玩家防御力
     * @return 怪物命中率 (30-95)
     */
    public static int calculateMonsterAccuracy(int monsterAttackRating, int playerDefense) {
        // 怪物使用不同的倍率 (2.0 而不是 1.4)
        int acR = (monsterAttackRating - playerDefense) * 2;

        // 上下限
        if (acR <= -190) {
            return 50;
        }
        if (acR >= 2100) {
            return 95;
        }

        // 线性插值
        int effectiveRange = 2100 - (-190);  // 2290
        int valueRange = acR - (-190);

        int accuracy = 50 + (int) ((valueRange * 45.0f) / effectiveRange);

        if (accuracy < 30) accuracy = 30;
        if (accuracy > 95) accuracy = 95;

        return accuracy;
    }

    /**
     * 判断攻击是否命中
     *
     * @param targetDefense 目标防御力
     * @param targetLevel   目标等级
     * @param myLevel       自身等级
     * @return true 如果命中，false 如果未命中
     */
    public boolean isHit(int targetDefense, int targetLevel, int myLevel) {
        int accuracy = calculateAccuracy(targetDefense, targetLevel, myLevel);
        int random = (int) (Math.random() * 100);
        return random < accuracy;
    }

    /**
     * 判断攻击是否命中（简化版）
     *
     * @param targetDefense 目标防御力
     * @return true 如果命中，false 如果未命中
     */
    public boolean isHit(int targetDefense) {
        return isHit(targetDefense, 0, 0);
    }

    @Override
    public String toString() {
        return "AttackRate{" +
                "attackRating=" + attackRating +
                ", accuracy=" + accuracy +
                '}';
    }
}