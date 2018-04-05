package com.fly.utils;

import org.apache.http.HttpStatus;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author : liufei on 2018/3/29
 */
public class Rr extends HashMap<String, Object> implements Serializable {
    private static final long serialVersionUID = 1L;

    public Rr() {
        put("code", 200);
        put("msg", "success");
    }

    public static Rr error(int code, String msg) {
        Rr r = new Rr();
        r.put("code", code);
        r.put("msg", msg);
        return r;
    }

    public static Rr error() {
        return error(HttpStatus.SC_INTERNAL_SERVER_ERROR, "未知异常");
    }

    public static Rr error(String msg) {
        return error(HttpStatus.SC_INTERNAL_SERVER_ERROR, msg);
    }

    public static Rr ok() {
        return new Rr();
    }

    public static Rr ok(Map<String, Object> map) {
        Rr r = new Rr();
        r.putAll(map);
        return r;
    }

    public static Rr ok(Object obj) {
        Rr r = new Rr();
        r.put("data", obj);
        return r;
    }
}
