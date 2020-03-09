package ren.oliver.mybatis.simplify.entity;

import java.io.Serializable;

public class User implements Serializable{
	
    private Integer id;

    private String username;

    private String realname;

    private String mobile;

    private String email;

    private String note;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getRealname() {
		return realname;
	}

	public void setRealname(String realname) {
		this.realname = realname;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", realname="
				+ realname + ", mobile=" + mobile + ", email="
				+ email + ", note=" + note + "]";
	}
    
}