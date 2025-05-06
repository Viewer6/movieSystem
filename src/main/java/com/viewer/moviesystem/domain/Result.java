package com.viewer.moviesystem.domain;

import com.viewer.moviesystem.emuns.ResultCode;
import lombok.Data;

// 统一返回结果
@Data
public class Result<T> {
    private Integer code;
    private String message;
    private T data;

    public static  <T> Result<T> success(T data){
        Result<T> result = new Result<>();

        result.setCode(ResultCode.SUCCESS.getCode());
        result.setMessage(ResultCode.SUCCESS.getMeg());
        result.setData(data);

        return result;
    }
    public static  <T>  Result<T> error(T data){
        Result<T> result = new Result<>();

        result.setCode(ResultCode.ERROR.getCode());
        result.setMessage(ResultCode.ERROR.getMeg());
        result.setData(data);

        return result;
    }

    public static  <T>  Result<T> fail(ResultCode failedLogin) {
        return Result.fail(failedLogin, null);
    }

    public static  <T>  Result<T> fail(Integer code, String msg){
        Result<T> result = new Result<>();
        result.setCode(code);
        result.setMessage(msg);

        return result;
    }

    public static  <T>  Result<T> fail(ResultCode failedLogin, T data) {
        Result<T> result = new Result<>();

        result.setCode(failedLogin.getCode());
        result.setMessage(failedLogin.getMeg());
        result.setData(data);

        return result;
    }
}