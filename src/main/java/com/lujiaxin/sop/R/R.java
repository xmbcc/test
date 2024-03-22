package com.lujiaxin.sop.R;

import lombok.Builder;
import lombok.Data;

import javax.sql.rowset.spi.SyncResolver;

/**
 * 返回结果类
 * @author lujiaxin
 * @date 2023/10/25
 */
@Data
public class R {

    private String msg;
    private Object data;

    private String token;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    private Integer code;
    private Integer count;

    private Boolean success;

    public R(String msg, Object data, Integer code, Integer count, Boolean success) {
        this.msg = msg;
        this.data = data;
        this.code = code;
        this.count = count;
        this.success = success;
    }

    public R(Object data, Integer code, Integer count,Boolean success) {
        this.data = data;
        this.code = code;
        this.count = count;
        this.success = success;
    }

    public R(String msg, Object data, Integer code, Integer count, String token, Boolean success) {
        this.msg = msg;
        this.data = data;
        this.code = code;
        this.count = count;
        this.token = token;
        this.success = success;
    }

    public R(String msg, Object data, String token, Boolean success) {
        this.msg = msg;
        this.data = data;
        this.token = token;
        this.success = success;
    }

    public R(Object data,Integer code,Boolean success){
        this.data = data;
        this.code = code;
        this.success = success;
    }

    public R(Integer code,Boolean success){
        this.code = code;
        this.success = success;
    }

    public static R newInstance(String msg, Object data, Integer code, Integer count, Boolean success){
        return new R(msg,data,code,count,success);
    }

    public R(Integer code, Boolean success, String msg) {
        this.msg = msg;
        this.code = code;
        this.success = success;
    }

    public static R successs(Object data, Integer code, Integer count){
        return new R(data,code,count,true);
    }

    public static R login(Object data,Integer code,Boolean success){
        return new R(data,code,success);
    }

    public static R fail(Integer code,Boolean success,String message){
        return new R(code,success,message);
    }


}
