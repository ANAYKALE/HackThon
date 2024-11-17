package entities;

import java.sql.Date;

public class user {
	private int id;
	private String first_name;
	private String last_name;
	private String email;
	private String mobile;
	private Date birth;
	private String password;
	
	public user() {
		
	}
	public user(int id,String first_name,String last_name,String email,String mobile,Date birth,String password)
	{
		this.id=id;
		this.first_name =first_name;
		this.last_name=last_name;
		this.email=email;
		this.mobile=mobile;
		this.birth=birth;
		this.password=password;
	}
	@Override
	public String toString() {
		return "user [id=" + id + ", first_name=" + first_name + ", last_name=" + last_name + ", email=" + email
				+ ", mobile=" + mobile + ", birth=" + birth + ", password=" + password + "]";
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public void setBirth(Date birth) {
		this.birth = birth;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getId() {
		return id;
	}
	public String getFirst_name() {
		return first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public String getEmail() {
		return email;
	}
	public String getMobile() {
		return mobile;
	}
	public Date getBirth() {
		return birth;
	}
	public String getPassword() {
		return password;
	}
}
