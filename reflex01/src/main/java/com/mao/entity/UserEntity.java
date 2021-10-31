package com.mao.entity;

/**
 * @author renshilin
 * @date 2021-10-31
 */
public class UserEntity {
    private String userName;

    public String getPubUserName() {
        System.out.println("getPubUserName 执行了");
        return pubUserName;
    }

    public void setPubUserName(String pubUserName) {
        this.pubUserName = pubUserName;
    }

    public String pubUserName;

    public UserEntity() {
        System.out.println("对象创建了");
    }

    public UserEntity(String userName) {
        this.userName = userName;
    }

    public UserEntity(String userName, String pubUserName) {
        this.userName = userName;
        this.pubUserName = pubUserName;
    }

    public String getUserName() {
        System.out.println("getUserName 执行了");
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    private String getPriUserName() {
        System.out.println("getUserName 执行了");
        return userName;
    }
}
