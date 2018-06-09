package com.xxz.mapper;

import com.xxz.model.Supplier;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
public interface SupplierMapper extends Mapper<Supplier> {
    List<Supplier> getSupplierAll(Supplier supplier);
}