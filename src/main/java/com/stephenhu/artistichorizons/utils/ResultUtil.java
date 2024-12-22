package com.stephenhu.artistichorizons.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 工具类，用于封装API返回结果
 * @param <T> 返回数据的类型
 * @author Stephen Hu
 */
@Data
@AllArgsConstructor
@NoArgsConstructor(force = true)
public final class ResultUtil<T> {
    private final Integer code;
    private final String message;
    private final T data;

    /**
     * 构造函数，创建一个成功的响应结果
     * @param data 返回的数据
     */
    public ResultUtil(T data) {
        this.code = 200;
        this.message = "success";
        this.data = data;
    }
    /**
     * 构造函数，根据成功标志和消息创建响应结果
     * @param data 返回的数据
     * @param success 成功标志
     * @param message 响应消息
     */
    public ResultUtil(T data, boolean success, String message) {
        if (success) {
            this.code = 200;
            this.message = "success";
        } else {
            this.code = 500;
            this.message = message;
        }
        this.data = data;
    }
    /**
     * 构造函数，根据状态码和消息创建响应结果
     * @param code 状态码
     * @param message 响应消息
     */
    public ResultUtil(int code, String message) {
        this.code = code;
        this.message = message;
        this.data = null;
    }
    /**
     * 静态方法，创建一个成功的响应结果
     *
     * @param <T>  返回数据的类型
     * @param data 返回的数据
     * @return 成功的 ResultUtil 对象
     */
    public static <T> ResultUtil<T> success(T data) {
        return new ResultUtil<>(data);
    }
    /**
     * 静态方法，创建一个失败的响应结果
     * @param code 状态码
     * @param message 响应消息
     * @param <T> 返回数据的类型
     * @return 失败的 ResultUtil 对象
     */
    public static <T> ResultUtil<T> fail(int code, String message) {
        return new ResultUtil<>(code, message);
    }
}
