package com.huangfu.util;

import com.huangfu.entry.ErrorMessage;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Set;

/**
 * 错误吗生成器
 *
 * @author huangfukexing
 * @date 2023/11/20 19:06
 */
public class ErrorCodeGenerator {
    static Map<String, String> error = new HashMap<>();
    static {
        error.put("500000", "网络错误");
        error.put("500001", "疑似恶意访问视频数据");
        error.put("600000", "视频数据不存在");
        error.put("600001", "视频损坏");
        error.put("600002", "视频通道意外断连");
        error.put("700001", "用户没有查询视频的权限");
        error.put("700002", "视频评论权限异常");
    }
    public static ErrorMessage errorCode(){
        // 将 Map 中的键存储在集合中
        Set<String> keySet = error.keySet();

        // 生成一个随机数，用于选择集合中的一个键
        int randomIndex = new Random().nextInt(keySet.size());

        // 获取选定的键
        String randomKey = keySet.stream().skip(randomIndex).findFirst().orElse(null);

        // 使用选定的键从 Map 中获取相应的值
        String randomValue = error.get(randomKey);

        // 创建一个包含选定键值对的 Map.Entry 对象
            return new ErrorMessage(randomKey, randomValue);
    }
}
