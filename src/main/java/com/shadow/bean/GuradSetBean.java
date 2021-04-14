package com.shadow.bean;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name= "tbl_set_guards")
public class GuradSetBean {
	
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int setid; 
	private String guard_name;
	private int req_id;
	
	@JsonIgnore
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "req_id", referencedColumnName="req_id",insertable = false,updatable = false)
	private ClientReqBean clientReqBean;
	
	public int getSetid() {
		return setid;
	}
	public ClientReqBean getClientReqBean() {
		return clientReqBean;
	}
	public void setClientReqBean(ClientReqBean clientReqBean) {
		this.clientReqBean = clientReqBean;
	}
	public void setSetid(int setid) {
		this.setid = setid;
	}
	public String getGuard_name() {
		return guard_name;
	}
	public void setGuard_name(String guard_name) {
		this.guard_name = guard_name;
	}
	public int getReq_id() {
		return req_id;
	}
	public void setReq_id(int req_id) {
		this.req_id = req_id;
	}
	
}
