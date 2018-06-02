package com.xxz.model;

import java.util.Date;

public class UserInfo implements Comparable<UserInfo>{
    private Long userId;

    private String passWord;

    private Date startDate;

    private Integer userAge;

    private String userName;

    public UserInfo() {
    }

    public UserInfo(Long userId, String passWord, Date startDate, Integer userAge, String userName) {
        this.userId = userId;
        this.passWord = passWord;
        this.startDate = startDate;
        this.userAge = userAge;
        this.userName = userName;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord == null ? null : passWord.trim();
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Integer getUserAge() {
        return userAge;
    }

    public void setUserAge(Integer userAge) {
        this.userAge = userAge;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    @Override
    public int compareTo(UserInfo o) {
        return 0;
    }
}