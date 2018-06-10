package com.xxz.controller;/**
 * @Author Xiong xz
 * @Date 2018/6/4 0004  13:41
 * @Since 1.0
 **/

import com.xxz.model.Supplier;
import com.xxz.serviceimpl.SupplierServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: spring-boot-test
 * @description:
 * @author: xxz
 * @create: 2018-06-04 13:41
 **/
@Api(value = "查询测试")
@RestController
public class SupplierController {
    private static final Logger LOG = LoggerFactory.getLogger(SupplierController.class);

    @Autowired
    private SupplierServiceImpl supplierServiceImpl;
    @ApiOperation(value = "添加供应商",tags = "")
    @PostMapping("/addsupplier")
    public void saveSupplier(){
        LOG.info("run");
        Supplier supplier= new Supplier();
        supplier.setName("钢铁台球");
        supplier.setAddress("浙江杭州西湖区");
        supplier.setCreateDate(new Date());
        supplier.setLinkman("熊相正");
        supplier.setClubNum(5);
        supplier.setPhone("15268533757");
        supplier.setRevenue(new BigDecimal(100000));
        supplierServiceImpl.saveSupplier(supplier);
    }

    @GetMapping("/getsupplierall")
    public Map<String,Object> getSupplierAll(@RequestParam(name = "pageNumber",required = true) Integer pageNumber,
                                            @RequestParam(name = "pageSize",required = true) Integer pageSize){
        Map<String ,Object> map =new HashMap<>();
        Supplier supplier = new Supplier();
        supplier.setPageNumber(pageNumber);
        supplier.setPageSize(pageSize);
        Integer total = supplierServiceImpl.getSupplierCount();
        List<Supplier> list =supplierServiceImpl.getSupplierAll(supplier);
        map.put("total",total);
        map.put("rows",list);
        return map;
    }
}
