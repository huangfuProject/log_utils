package com.huangfu.util;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * @author huangfukexing
 * @date 2023/11/20 18:09
 */
public class IpGenerator {
    private final static List<String> IPS = new ArrayList<>();

    static {
        InputStream ipStream = IpGenerator.class.getClassLoader().getResourceAsStream("ips.txt");
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        byte[] bytes = new byte[1024];
        int count = 0;
        try {
            while ((count = ipStream.read(bytes)) > 0) {
                out.write(bytes, 0, count);
            }

            String ipContext = out.toString("utf-8");
            String[] ipArray = ipContext.split("\n");
            IPS.addAll(Arrays.asList(ipArray));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * 随机一个ip
     *
     * @return 返回一个随机ip
     */
    public static String randomAcquisition() {
        int size = IPS.size();
        // 创建一个Random对象
        Random random = new Random();
        // 生成0到10000之间的随机整数
        int randomNumber = random.nextInt(size);
        return IPS.get(randomNumber);
    }

    /**
     * 随机生成一个ip
     *
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

    public static void main(String[] args) throws IOException {
        List<String> ips = new ArrayList<>(10000);
        for (int i = 0; i < 10000; i++) {
            String s = generateRandomIp();
            ips.add(s);
        }


        File file = new File("/Users/huangfukexing/Desktop/ips.txt");
        if (file.exists()) {
            System.out.println(file.delete());
        }

        System.out.println(file.createNewFile());

        PrintWriter printWriter = new PrintWriter(new OutputStreamWriter(new FileOutputStream(file), StandardCharsets.UTF_8));
        for (String ip : ips) {
            printWriter.println(ip);
        }
        printWriter.flush();
        printWriter.close();
    }
}
