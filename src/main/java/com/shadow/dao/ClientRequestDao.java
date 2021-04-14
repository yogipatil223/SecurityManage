package com.shadow.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.shadow.bean.ClientReqBean;

@Repository
public interface ClientRequestDao extends JpaRepository<ClientReqBean, Integer> {

	@Query(value = "SELECT * FROM tbl_client_request where g_set_status = 0 ", nativeQuery = true)
	public List<ClientReqBean> getAllClientReq();
	
	@Query(value = "SELECT * FROM tbl_client_request a inner join tbl_usr_master b on a.client_id = b.usrid where  b.usrid='10'  ", nativeQuery = true)
	public List<ClientReqBean> getAllClientReqSet();
	
	@Modifying(clearAutomatically = true)
	@Query(value = "update  tbl_client_request set bill_status='Paid' where req_id =:req_id ",nativeQuery = true)
	public void updateStatus(@Param("req_id") int req_id);
	
	@Modifying(clearAutomatically = true)
	@Query(value = "update  tbl_client_request set g_set_status = 1 where req_id =:req_id ",nativeQuery = true)
	public void updateSetGuardStatus(@Param("req_id") int req_id);
	
}
