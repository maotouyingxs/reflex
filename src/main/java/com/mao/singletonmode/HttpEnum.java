package com.mao.singletonmode;

public enum HttpEnum {
    HTTP_200(200,"请求成功！"), HTTP_500(500,"请求失败！");

    private Integer httpCode;
    private String httpMsg;

    public static void main(String[] args) {
        System.out.println(HttpEnum.HTTP_200.httpCode);
        System.out.println(HttpEnum.HTTP_200.httpMsg);
        System.out.println(HttpEnum.HTTP_500.httpCode);
        System.out.println(HttpEnum.HTTP_500.httpMsg);
    }

    HttpEnum(Integer httpCode, String httpMsg) {
        // 执行几次 一次  -- 出现两次因为有两个单独的枚举
        System.out.println("HttpEnum初始化");
        this.httpCode = httpCode;
        this.httpMsg = httpMsg;
    }

    public Integer getHttpCode() {
        return httpCode;
    }

    public void setHttpCode(Integer httpCode) {
        this.httpCode = httpCode;
    }

    public String getHttpMsg() {
        return httpMsg;
    }

    public void setHttpMsg(String httpMsg) {
        this.httpMsg = httpMsg;
    }
}
