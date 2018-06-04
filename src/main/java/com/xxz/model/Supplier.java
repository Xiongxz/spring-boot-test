package com.xxz.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Date;
@Table(name = "supplier")
public class Supplier extends PaginAtion{
    private Integer id;

    private String name;

    private String linkman;

    private String phone;

    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
    private Date createDate;

    private String address;

    private Integer clubNum;

    private BigDecimal revenue;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getLinkman() {
        return linkman;
    }

    public void setLinkman(String linkman) {
        this.linkman = linkman == null ? null : linkman.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public Integer getClubNum() {
        return clubNum;
    }

    public void setClubNum(Integer clubNum) {
        this.clubNum = clubNum;
    }

    public BigDecimal getRevenue() {
        return revenue;
    }

    public void setRevenue(BigDecimal revenue) {
        this.revenue = revenue;
    }
}