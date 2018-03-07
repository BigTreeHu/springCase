package com.demo.model;

public class User {
	
	  private Integer uid;
	  private String uname;
	  private String usex;
	  private String password;
	  private String email;
	  private Integer did;
	  private String dname;
	public Integer getUid() {
		return uid;
	}
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getUsex() {
		return usex;
	}
	public void setUsex(String usex) {
		this.usex = usex;
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
	public Integer getDid() {
		return did;
	}
	public void setDid(Integer did) {
		this.did = did;
	}
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	@Override
	public String toString() {
		return "User [uid=" + uid + ", uname=" + uname + ", usex=" + usex + ", password=" + password + ", email="
				+ email + ", did=" + did + ", dname=" + dname + "]";
	}
	
	
	  
	  

}
