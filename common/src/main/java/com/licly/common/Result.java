package com.licly.common;

/**
 * 接口返回包装
 *
 * @author licly
 * @date 2020/10/5
 */

public class Result {

    private Integer code = 200;

    private String msg;

    private Result() {}

    public static Result error(Integer code, String msg) {
        Result result = new Result();
        result.code = code;
        result.msg = msg;
        return result;
    }

    public static Result success() {
        return new Result();
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
