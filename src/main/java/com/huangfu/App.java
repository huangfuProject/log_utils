package com.huangfu;

import com.huangfu.util.MessageUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Random;

/**
 * Hello world!
 */
public class App {
    private static final Logger logger = LogManager.getLogger(App.class);

    public static void main(String[] args) {
        int count = Integer.parseInt(args[0]);
        for (int i = 0; i < count; i++) {
            logger.info(MessageUtils.generatorMessage());
        }
    }
}
