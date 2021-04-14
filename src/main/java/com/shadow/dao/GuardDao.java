package com.shadow.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shadow.bean.GuardBean;

@Repository
public interface GuardDao extends JpaRepository<GuardBean, Integer> {

	
}
