package com.xxz.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.xxz.model.userInformation;
@Repository
public interface SpringDataDao extends JpaRepository<userInformation, Integer>{
	
}
