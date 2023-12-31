package com.huangfu.entry;

/**
 * @author huangfukexing
 * @date 2023/11/20 19:14
 */
public class ErrorMessage {
    private String code;
    private String message;

    public ErrorMessage(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
