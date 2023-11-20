package com.huangfu.util;

import java.util.Random;

/**
 * @author huangfukexing
 * @date 2023/11/20 18:09
 */
public class IpGenerator {

    /**
     * 随机生成一个ip
     * @return 返回一个公网的ip
     */
    public static String generateRandomIp() {
        Random rand = new Random();
        StringBuilder ipBuilder = new StringBuilder();

        for (int i = 0; i < 4; i++) {
            ipBuilder.append(rand.nextInt(256));
            if (i < 3) {
                ipBuilder.append(".");
            }
        }

        return ipBuilder.toString();
    }
}
