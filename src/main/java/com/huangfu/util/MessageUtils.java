package com.huangfu.util;

import com.huangfu.entry.ErrorMessage;

import java.util.Random;

/**
 * @author huangfukexing
 * @date 2023/11/20 18:58
 */
public class MessageUtils {

    /**
     * 随机生成一个日志
     * @return 返回日志
     */
    public static String generatorMessage() {
        // 创建一个Random对象
        Random random = new Random();
        // 生成0到10000之间的随机整数
        int randomNumber = random.nextInt(10000);
        int ms = random.nextInt(500);
        String ip = IpGenerator.randomAcquisition();
        //百分之99的成功率
        if (FailureJudgment.simulateLottery(0.99)) {
            return String.format("用户查看视频成功|User ID: %s|IP Address: %s|Response Time: %sms", randomNumber, ip, ms);
        } else {
            ErrorMessage errorMessage = ErrorCodeGenerator.errorCode();
            return String.format("%s|User ID: %s|IP Address: %s|Error Code: %s | Response Time: %sms", errorMessage.getMessage(), randomNumber, ip, errorMessage.getCode(), ms);
        }
    }
}
