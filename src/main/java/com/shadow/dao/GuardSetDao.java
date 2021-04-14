package com.shadow.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shadow.bean.GuradSetBean;

@Repository
public interface GuardSetDao extends JpaRepository<GuradSetBean, Integer> {

}
