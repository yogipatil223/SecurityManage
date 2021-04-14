package com.shadow.dao;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.shadow.bean.UserBean;

@Repository
public interface UserDao extends JpaRepository<UserBean, Integer> {
	
	
	@Query(value="select * from tbl_usr_master where mobilenum = :mobilenum and password =:password" , nativeQuery = true)
	public UserBean getUserInfo(@Param("mobilenum") String mobilenum, @Param("password") String password);
	
	
}
