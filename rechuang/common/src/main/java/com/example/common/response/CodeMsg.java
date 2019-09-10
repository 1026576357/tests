package com.example.common.response;

public class CodeMsg {
        private int code;
        private String msg;

    public CodeMsg(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public static CodeMsg SUCCESS= new CodeMsg(0,"success");
    public static CodeMsg FAIL=new CodeMsg(400001,"请求错误");
}
