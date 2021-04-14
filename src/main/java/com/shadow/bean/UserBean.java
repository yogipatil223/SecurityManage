package com.shadow.bean;

import java.sql.Blob;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="tbl_usr_master")
public class UserBean {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int usrid;
	private String mobilenum;
	
	private String password;
	private String email;
	private String username;
	private String role;
	
	@Transient
	private MultipartFile mulfile;
	public Blob getImageblob() {
		return imageblob;
	}
	public void setImageblob(Blob imageblob) {
		this.imageblob = imageblob;
	}
	private Blob imageblob;
//	@OneToMany(cascade=CascadeType.ALL,fetch = FetchType.LAZY, mappedBy = "userBean" )	
//	private Set<ClientReqBean> clientReqBean = new HashSet<ClientReqBean>() ;
//	
//	public Set<ClientReqBean> getClientReqBean() {
//		return clientReqBean;
//	}
//	public void setClientReqBean(Set<ClientReqBean> clientReqBean) {
//		this.clientReqBean = clientReqBean;
//	}
	
	public MultipartFile getMulfile() {
		return mulfile;
	}
	public void setMulfile(MultipartFile mulfile) {
		this.mulfile = mulfile;
	}
	public int getUsrid() {
		return usrid;
	}
	public void setUsrid(int usrid) {
		this.usrid = usrid;
	}
	public String getMobilenum() {
		return mobilenum;
	}
	public void setMobilenum(String mobilenum) {
		this.mobilenum = mobilenum;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
}
