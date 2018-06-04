package com.xxz.service;

import com.xxz.model.Supplier;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: spring-boot-test
 * @description:
 * @author: xxz
 * @create: 2018-06-04 13:30
 **/
@Service
public interface SupplierService {
    int saveSupplier(Supplier supplier);

    List<Supplier> getSupplierAll(Supplier supplier);
}
