package com.shadow.bean;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="guard_master")
public class GuardBean {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int gid;
	private String g_name;
    private String mobile_num;
    private String address;
    private String email;
    private String set_salary;

	
	public int getGid() {
		return gid;
	}
	public void setGid(int gid) {
		this.gid = gid;
	}
	public String getG_name() {
		return g_name;
	}
	public void setG_name(String g_name) {
		this.g_name = g_name;
	}
	public String getMobile_num() {
		return mobile_num;
	}
	public void setMobile_num(String mobile_num) {
		this.mobile_num = mobile_num;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSet_salary() {
		return set_salary;
	}
	public void setSet_salary(String set_salary) {
		this.set_salary = set_salary;
	}
		
}
