package org.jpstale.entity;

/**
 * 格挡率（Block Rate）属性类
 * <p>
 * C++对应: sinSubMain.cpp 中的 sinGetBlockRating 函数
 * <p>
 * 格挡说明:
 * <ul>
 * <li>格挡率受基础格挡值 (Chance_Block) 和等级差影响</li>
 * <li>己方等级高于目标时格挡率增加</li>
 * </ul>
 *
 * @see <a href="sinSubMain.cpp:1765-1774">C++ sinGetBlockRating实现</a>
 */
public class BlockRate {

    /**
     * 基础格挡率（Chance_Block）
     */
    int chanceBlock;

    /**
     * 默认构造函数
     */
    public BlockRate() {
        this.chanceBlock = 0;
    }

    /**
     * 构造函数 - 设置基础格挡率
     *
     * @param chanceBlock 基础格挡率
     */
    public BlockRate(int chanceBlock) {
        this.chanceBlock = chanceBlock;
    }

    /**
     * 获取基础格挡率
     *
     * @return 基础格挡率
     */
    public int getChanceBlock() {
        return chanceBlock;
    }

    /**
     * 设置基础格挡率
     *
     * @param chanceBlock 基础格挡率
     */
    public void setChanceBlock(int chanceBlock) {
        this.chanceBlock = chanceBlock;
    }

    /**
     * 增加基础格挡率
     *
     * @param amount 增加的值
     */
    public void addChanceBlock(int amount) {
        this.chanceBlock += amount;
    }

    /**
     * 计算对指定目标的格挡率
     * <p>
     * C++实现逻辑 (sinSubMain.cpp:1765-1774):
     * <pre>
     * int sinGetBlockRating(int desLV)
     * {
     *     fDesLV = (float)desLV;
     *     fMyLV  = (float)sinChar->Level;
     *
     *     Result = (int)(sinChar->Chance_Block + ((fMyLV - fDesLV)/100)*25);
     *     return Result;
     * }
     * </pre>
     *
     * @param targetLevel 目标等级
     * @param myLevel     自身等级
     * @return 计算后的格挡率
     */
    public int calculateBlockRate(int targetLevel, int myLevel) {
        float levelDiff = (myLevel - targetLevel) / 100.0f;

        // 己方每高出目标 100 级，格挡率增加 25%
        int result = (int) (this.chanceBlock + (levelDiff * 25));

        return result;
    }

    /**
     * 计算对指定目标的格挡率（使用内部等级）
     *
     * @param targetLevel 目标等级
     * @return 计算后的格挡率
     */
    public int calculateBlockRate(int targetLevel) {
        return calculateBlockRate(targetLevel, 0); // 需要外部传入 myLevel
    }

    /**
     * 判定是否成功格挡
     *
     * @param targetLevel 目标等级
     * @param myLevel     自身等级
     * @return true 如果成功格挡，false 如果失败
     */
    public boolean isBlocked(int targetLevel, int myLevel) {
        int blockRate = calculateBlockRate(targetLevel, myLevel);
        int random = (int) (Math.random() * 100);
        return random < blockRate;
    }

    /**
     * 判定是否成功格挡（使用内部等级）
     *
     * @param targetLevel 目标等级
     * @return true 如果成功格挡，false 如果失败
     */
    public boolean isBlocked(int targetLevel) {
        return isBlocked(targetLevel, 0); // 需要外部传入 myLevel
    }

    @Override
    public String toString() {
        return "BlockRate{" +
                "chanceBlock=" + chanceBlock +
                '}';
    }
}