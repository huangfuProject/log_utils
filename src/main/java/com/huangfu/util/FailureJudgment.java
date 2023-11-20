package com.huangfu.util;

/**
 * 失败断言
 *
 * @author huangfukexing
 * @date 2023/11/20 18:13
 */
public class FailureJudgment {

    /**
     * 返回本次结果成功还是失败
     *
     * @param winProbability 成功的概率
     * @return 是否成功
     */
    public static boolean simulateLottery(double winProbability) {
        // 模拟抽奖过程
        double randomProbability = Math.random();
        return randomProbability <= winProbability;
    }
}
