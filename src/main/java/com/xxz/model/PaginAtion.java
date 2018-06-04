package com.xxz.model;


import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @program: spring-boot-test
 * @description:
 * @author: xxz
 * @create: 2018-06-04 11:51
 **/
public class PaginAtion {
    @JsonIgnore
    public Integer pageNumber;
    @JsonIgnore
    public Integer pageSize;

    public Integer rownumber;

    public PaginAtion() {
    }

    public PaginAtion(Integer pageNumber, Integer pageSize, Integer rownumber) {
        this.pageNumber = pageNumber;
        this.pageSize = pageSize;
        this.rownumber = rownumber;
    }

    public Integer getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(Integer pageNumber) {
        this.pageNumber = pageNumber;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getRownumber() {
        return rownumber;
    }

    public void setRownumber(Integer rownumber) {
        this.rownumber = rownumber;
    }
}
