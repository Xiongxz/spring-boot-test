package com.xxz.util;

public enum ReturnCode {
    SUCCESS("200","成功"),

    ERROR("400","失败");

    private String status;

    private String msg;

    ReturnCode(String status, String msg) {
        this.status = status;
        this.msg = msg;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }


}
