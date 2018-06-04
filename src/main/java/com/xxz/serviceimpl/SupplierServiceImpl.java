package com.xxz.serviceimpl;

import com.xxz.mapper.SupplierMapper;
import com.xxz.model.Supplier;
import com.xxz.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: spring-boot-test
 * @description:
 * @author: xxz
 * @create: 2018-06-04 13:32
 **/
@Service
public class SupplierServiceImpl implements SupplierService {

    @Autowired
    private SupplierMapper supplierMapper;

    @Override
    public int saveSupplier(Supplier supplier) {
        return this.supplierMapper.insertSelective(supplier);
    }

    @Override
    public List<Supplier> getSupplierAll(Supplier supplier) {
        return this.supplierMapper.getSupplierAll(supplier);
    }

    public Integer getSupplierCount( ){
        return this.supplierMapper.selectCount(new Supplier());
    }
}
