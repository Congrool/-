package cn.newshome.Entity;

import java.sql.Date;
import java.sql.Timestamp;

//TODO:
public class UserEntity {
	private Integer UID;
	private String username;
	private String password;
	private String phone;
	private String email;
	private int gender;
	private String avadar;
	private String created_user;
	private Timestamp created_time;
	private String modified_user;
	private Timestamp modified_time;
	public UserEntity(Integer uID, String username, String password, String phone, String email, int gender,
			String avadar, String created_user, Timestamp created_time, String modified_user, Timestamp modified_time) {
		super();
		UID = uID;
		this.username = username;
		this.password = password;
		this.phone = phone;
		this.email = email;
		this.gender = gender;
		this.avadar = avadar;
		this.created_user = created_user;
		this.created_time = created_time;
		this.modified_user = modified_user;
		this.modified_time = modified_time;
	}
	public UserEntity() {
	}
	public Integer getUID() {
		return UID;
	}
	public void setUID(Integer uID) {
		UID = uID;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getGender() {
		return gender;
	}
	public void setGender(int gender) {
		this.gender = gender;
	}
	public String getAvadar() {
		return avadar;
	}
	public void setAvadar(String avadar) {
		this.avadar = avadar;
	}
	public String getCreated_user() {
		return created_user;
	}
	public void setCreated_user(String created_user) {
		this.created_user = created_user;
	}
	public Timestamp getCreated_time() {
		return created_time;
	}
	public void setCreated_time(Timestamp created_time) {
		this.created_time = created_time;
	}
	public String getModified_user() {
		return modified_user;
	}
	public void setModified_user(String modified_user) {
		this.modified_user = modified_user;
	}
	public Timestamp getModified_time() {
		return modified_time;
	}
	public void setModified_time(Timestamp modified_time) {
		this.modified_time = modified_time;
	}
	
	
}
