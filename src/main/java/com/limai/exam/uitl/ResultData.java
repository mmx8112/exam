package com.limai.exam.uitl;

import java.io.Serializable;

public class ResultData implements Serializable {

    private Integer status;
    private Integer errorCode;
    private String msg;
    private Object data;

    public static ResultData success(Object data){
        ResultData resultData = new ResultData();
        resultData.setStatus(1);
        resultData.setMsg("成功");
        resultData.setData(data);
        return resultData;
    }
    public static ResultData fail(int errorCode,String errorMsg){
        ResultData resultData = new ResultData();
        resultData.setStatus(0);
        resultData.setErrorCode(errorCode);
        resultData.setMsg(errorMsg);
        return resultData;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(Integer errorCode) {
        this.errorCode = errorCode;
    }

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
}

