package co.jp.netwisdom.form;

import org.apache.struts.action.ActionForm;

public class UserForm extends ActionForm {
	//姓名
	private String username ;
	//密码
	private String password ;
	//性别
	private String sex ;

	//专业
	private String major ;
	//简介
	private String intro ;
	
	//爱好 TODO
	private String[] hobby ;
	
	private String[] check;

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

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public String getIntro() {
		return intro;
	}

	public void setIntro(String intro) {
		this.intro = intro;
	}

	public String[] getHobby() {
		return hobby;
	}

	public void setHobby(String[] hobby) {
		this.hobby = hobby;
	}

	public String[] getCheck() {
		return check;
	}

	public void setCheck(String[] check) {
		this.check = check;
	}


	
	

}
