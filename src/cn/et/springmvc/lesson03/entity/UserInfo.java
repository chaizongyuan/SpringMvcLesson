package cn.et.springmvc.lesson03.entity;


import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;



public class UserInfo {
	/**
	 * NotNull 属性名 !=null
	 * NotEmpty 属性名!=null &&  !属性名.equals("")
	 */
	@NotEmpty(message="用户名不能为空")
	private String userName;
	@NotEmpty(message="密码不能为空")
	private String password;
	@NotEmpty(message="再次输入不能为空")
	private String repassword;
	// lixin@126.com  
	@Pattern(message="邮箱格式错误",regexp=".+@.+\\..+")
	private String email;
	@NotEmpty(message="年龄不能为空")
	@Min(value=1,message="年龄必须大于1")
	@Max(value=100,message="年龄必须小于100")
	private String age;
	@Size(min=11, max=11,message="手机号码必须是11位")
	private String phone;
	private String weight;
	@Pattern(regexp="^http[s]?:\\/\\/[w]{3}\\.\\w+\\.\\w+",message="个人网址格式错误")
	@NotEmpty(message="网址不能为空")
	private String web;
	@Past (message="出生日期格式不正确,必须为过去时间")
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private String time;
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRepassword() {
		return repassword;
	}
	public void setRepassword(String repassword) {
		this.repassword = repassword;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getWeight() {
		return weight;
	}
	public void setWeight(String weight) {
		this.weight = weight;
	}
	public String getweb() {
		return web;
	}
	public void setweb(String web) {
		this.web = web;
	}
	public String gettime() {
		return time;
	}
	public void settime(String time) {
		this.time = time;
	}
}
