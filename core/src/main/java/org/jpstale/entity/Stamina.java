package org.jpstale.entity;

/**
 * 耐力（Stamina）属性类
 * <p>
 * C++对应: sinSubMain.cpp 中的 sinUseStamina 和 sinSetRegen 函数
 * <p>
 * 耐力系统说明:
 * <ul>
 * <li>耐力在奔跑时消耗，站立/行走时恢复</li>
 * <li>消耗和恢复公式基于体重、力量和等级</li>
 * <li>StaminaFunction 决定耐力消耗倍率</li>
 * </ul>
 *
 * @see <a href="sinSubMain.cpp:1546-1556">C++ sinUseStamina实现</a>
 * @see <a href="sinSubMain.cpp:1565-1586">C++ sinSetRegen实现</a>
 */
public class Stamina {

    /**
     * 状态：静止/站立
     */
    public static final int STATE_IDLE = 0;

    /**
     * 状态：行走
     */
    public static final int STATE_WALK = 1;

    /**
     * 状态：奔跑
     */
    public static final int STATE_RUN = 2;

    /**
     * 功能模式：普通
     */
    public static final int FUNCTION_NORMAL = 0;

    /**
     * 功能模式：模式1
     */
    public static final int FUNCTION_1 = 1;

    /**
     * 功能模式：模式2
     */
    public static final int FUNCTION_2 = 2;

    /**
     * 功能模式：模式3
     */
    public static final int FUNCTION_3 = 3;

    /**
     * 当前耐力值
     */
    short stamina;

    /**
     * 最大耐力值
     */
    short maxStamina;

    /**
     * 耐力恢复加成
     */
    short staminaRegen;

    /**
     * 耐力功能模式
     */
    int staminaFunction;

    /**
     * 当前状态
     */
    int currentState;

    /**
     * 体力/负重（当前）
     */
    int weightCurrent;

    /**
     * 体力/负重（最大）
     */
    int weightMax;

    /**
     * 角色等级
     */
    int level;

    /**
     * 角色力量
     */
    int strength;

    /**
     * 默认构造函数
     */
    public Stamina() {
        this.stamina = 1000;
        this.maxStamina = 1000;
        this.staminaRegen = 0;
        this.staminaFunction = FUNCTION_NORMAL;
        this.currentState = STATE_IDLE;
        this.weightCurrent = 0;
        this.weightMax = 1000;
        this.level = 1;
        this.strength = 10;
    }

    /**
     * 构造函数 - 设置最大耐力
     *
     * @param maxStamina 最大耐力值
     */
    public Stamina(int maxStamina) {
        this.stamina = (short) maxStamina;
        this.maxStamina = (short) maxStamina;
    }

    /**
     * 获取当前耐力值
     *
     * @return 当前耐力
     */
    public short getStamina() {
        return stamina;
    }

    /**
     * 设置当前耐力值
     *
     * @param stamina 当前耐力
     */
    public void setStamina(short stamina) {
        this.stamina = stamina;
        if (this.stamina < 0) this.stamina = 0;
        if (this.stamina > this.maxStamina) this.stamina = this.maxStamina;
    }

    /**
     * 获取最大耐力值
     *
     * @return 最大耐力
     */
    public short getMaxStamina() {
        return maxStamina;
    }

    /**
     * 设置最大耐力值
     *
     * @param maxStamina 最大耐力
     */
    public void setMaxStamina(short maxStamina) {
        this.maxStamina = maxStamina;
    }

    /**
     * 增加耐力值
     *
     * @param amount 增加量
     */
    public void addStamina(int amount) {
        setStamina((short) (this.stamina + amount));
    }

    /**
     * 减少耐力值
     *
     * @param amount 减少量
     */
    public void consumeStamina(int amount) {
        setStamina((short) (this.stamina - amount));
    }

    /**
     * 获取耐力恢复加成
     *
     * @return 恢复加成
     */
    public short getStaminaRegen() {
        return staminaRegen;
    }

    /**
     * 设置耐力恢复加成
     *
     * @param staminaRegen 恢复加成
     */
    public void setStaminaRegen(short staminaRegen) {
        this.staminaRegen = staminaRegen;
    }

    /**
     * 获取功能模式
     *
     * @return 功能模式
     */
    public int getStaminaFunction() {
        return staminaFunction;
    }

    /**
     * 设置功能模式
     *
     * @param staminaFunction 功能模式
     */
    public void setStaminaFunction(int staminaFunction) {
        this.staminaFunction = staminaFunction;
    }

    /**
     * 获取当前状态
     *
     * @return 当前状态
     */
    public int getCurrentState() {
        return currentState;
    }

    /**
     * 设置当前状态
     *
     * @param currentState 当前状态
     */
    public void setCurrentState(int currentState) {
        this.currentState = currentState;
    }

    /**
     * 计算奔跑时的耐力消耗
     * <p>
     * C++实现逻辑 (sinSubMain.cpp:1546-1556):
     * <pre>
     * void sinUseStamina()
     * {
     *     DeCreaSTM = 0;
     *     if(lpCurPlayer->MotionInfo->State == CHRMOTION_STATE_RUN){
     *         // 耐力消耗公式
     *         DeCreaSTM = (float)((1000 + sinChar->Weight[0]) /
     *             (sinChar->Weight[1] + (sinChar->Strength/2) + 500) + 0.4);
     *     }
     * }
     * </pre>
     *
     * @return 每帧（约为4次/秒）的耐力消耗
     */
    public float calculateRunConsume() {
        if (currentState != STATE_RUN) {
            return 0;
        }

        float consume = (1000.0f + weightCurrent) / (weightMax + (strength / 2) + 500) + 0.4f;
        return consume;
    }

    /**
     * 计算耐力恢复速度
     * <p>
     * C++实现逻辑 (sinSubMain.cpp:1508-1528):
     * <pre>
     * // 静止时恢复
     * InCreaSTM = 3.8 + sinChar->Level/7 + sinChar->Stamina_Regen;
     *
     * // 行走时恢复 (乘以 0.6)
     * InCreaSTM = (3.8 + sinChar->Level/7 + sinChar->Stamina_Regen) * 0.6;
     * </pre>
     *
     * @return 每帧（约4次/秒）的耐力恢复量
     */
    public float calculateRegen() {
        float regen;

        switch (staminaFunction) {
            case FUNCTION_1:
                regen = 3.8f + level / 7.0f + staminaRegen;
                break;
            case FUNCTION_2:
                regen = 3.3f + level / 7.0f + staminaRegen;
                break;
            case FUNCTION_3:
                regen = 2.9f + level / 7.0f + staminaRegen;
                break;
            default:
                regen = 3.8f + level / 7.0f + staminaRegen;
                break;
        }

        if (currentState == STATE_WALK) {
            regen = regen * 0.6f;
        } else if (currentState == STATE_IDLE) {
            // 静止恢复已经是 regen
        } else if (currentState == STATE_RUN) {
            // 奔跑时不会恢复
            return 0;
        }

        return regen;
    }

    /**
     * 每帧更新耐力
     * <p>
     * C++实现逻辑 (sinSubMain.cpp:1565-1586):
     * <pre>
     * void sinSetRegen()
     * {
     *     // 消耗
     *     if(DeCreaSTM){
     *         fTempSTM_Decre += DeCreaSTM/(70/4);
     *         if(fTempSTM_Decre >= 1){
     *             sinSetStamina(sinGetStamina() - (short)fTempSTM_Decre);
     *         }
     *     }
     *     // 恢复
     *     if(InCreaSTM){
     *         fTempSTM_Incre += InCreaSTM/(70/4);
     *         // ... 类似逻辑
     *     }
     * }
     * </pre>
     *
     * @param frames 经过的帧数（每秒约 70 帧）
     */
    public void update(int frames) {
        // 计算消耗
        float consumePerFrame = calculateRunConsume() / (70.0f / 4);
        if (consumePerFrame > 0) {
            float totalConsume = consumePerFrame * frames;
            while (totalConsume >= 1) {
                consumeStamina(1);
                totalConsume -= 1;
            }
        }

        // 计算恢复
        float regenPerFrame = calculateRegen() / (70.0f / 4);
        if (regenPerFrame > 0) {
            float totalRegen = regenPerFrame * frames;
            while (totalRegen >= 1) {
                addStamina(1);
                totalRegen -= 1;
            }
        }
    }

    /**
     * 是否可以奔跑
     *
     * @return true 如果耐力足够
     */
    public boolean canRun() {
        // 需要至少 1 点耐力才能跑
        return stamina > 0;
    }

    /**
     * 获取耐力百分比
     *
     * @return 0.0 ~ 1.0
     */
    public float getPercentage() {
        return (float) stamina / maxStamina;
    }

    /**
     * 是否处于疲惫状态（耐力耗尽）
     *
     * @return true 如果耐力为 0
     */
    public boolean isExhausted() {
        return stamina <= 0;
    }

    @Override
    public String toString() {
        return "Stamina{" +
                "stamina=" + stamina +
                ", maxStamina=" + maxStamina +
                ", state=" + currentState +
                '}';
    }
}