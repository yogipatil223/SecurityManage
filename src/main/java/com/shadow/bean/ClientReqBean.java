package com.shadow.bean;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "tbl_client_request")
public class ClientReqBean {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int req_id;
	private String address;
	private int tot_guard;
	private String req_on_date;
	private int days;
	private int bill;
	private String bill_status;
	private int client_id;
	private int g_set_status;
	
	public int getG_set_status() {
		return g_set_status;
	}

	public void setG_set_status(int g_set_status) {
		this.g_set_status = g_set_status;
	}

	public int getClient_id() {
		return client_id;
	}

	public void setClient_id(int client_id) {
		this.client_id = client_id;
	}

	public String getBill_status() {
		return bill_status;
	}

	public void setBill_status(String bill_status) {
		this.bill_status = bill_status;
	}
	//@JsonIgnore
	//@JsonBackReference
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "client_id", referencedColumnName="usrid",insertable = false,updatable = false)
	private UserBean userBean;
	

	@OneToMany(cascade=CascadeType.ALL,fetch = FetchType.LAZY, mappedBy = "clientReqBean")	
	private Set<GuradSetBean> guardSetBean = new HashSet<GuradSetBean>() ;
	
	
	
	public Set<GuradSetBean> getGuardSetBean() {
		return guardSetBean;
	}

	public void setGuardSetBean(Set<GuradSetBean> guardSetBean) {
		this.guardSetBean = guardSetBean;
	}

	public ClientReqBean() {
	}
	
	public ClientReqBean(UserBean userBean ) {		
		
		this.userBean = userBean;
	}
	
	
	public UserBean getUserBean() {
		return userBean;
	}
	public void setUserBean(UserBean userBean) {
		this.userBean = userBean;
	}
	public int getReq_id() {
		return req_id;
	}
	public void setReq_id(int req_id) {
		this.req_id = req_id;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getTot_guard() {
		return tot_guard;
	}
	public void setTot_guard(int tot_guard) {
		this.tot_guard = tot_guard;
	}
	public String getReq_on_date() {
		return req_on_date;
	}
	public void setReq_on_date(String req_on_date) {
		this.req_on_date = req_on_date;
	}
	public int getDays() {
		return days;
	}
	public void setDays(int days) {
		this.days = days;
	}
	public int getBill() {
		return bill;
	}
	public void setBill(int bill) {
		this.bill = bill;
	}

	
	
	
}
