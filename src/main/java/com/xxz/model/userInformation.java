package com.xxz.model;

import javax.persistence.*;

@Table(name = "user_information")
public class userInformation {
    @Id
    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "user_age")
    private Integer userAge;

    @Column(name = "user_name")
    private String userName;

    /**
     * @return user_id
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * @param userId
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * @return user_age
     */
    public Integer getUserAge() {
        return userAge;
    }

    /**
     * @param userAge
     */
    public void setUserAge(Integer userAge) {
        this.userAge = userAge;
    }

    /**
     * @return user_name
     */
    public String getUserName() {
        return userName;
    }

    /**
     * @param userName
     */
    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }
}