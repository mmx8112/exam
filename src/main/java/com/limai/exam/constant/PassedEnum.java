package com.limai.exam.constant;

/**
 * @author mahuahua
 */
public enum PassedEnum {
    /**
     * 接受
     */
    ACCEPT_YES(1, "接受"),

    /**
     * 拒绝
     */
    ACCEPT_NO(2, "拒绝");

    private Integer code;
    private String msg;

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    PassedEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public static String getMsgByCode(Integer code) {
        PassedEnum[] enums = PassedEnum.values();
        for (PassedEnum anEnum : enums) {
            if (anEnum.getCode().equals(code)) {
                return anEnum.getMsg();
            }
        }
        return "";
    }


}
