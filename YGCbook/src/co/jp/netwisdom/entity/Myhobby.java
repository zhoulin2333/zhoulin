package co.jp.netwisdom.entity;

import java.util.Date;


public class Myhobby {

	private String username;
	private String hobby;

	public Myhobby() {
		super();
	}
	public Myhobby(String username, String hobby ) {
		super();
		this.username = username;
		this.hobby = hobby;

	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getHobby() {
		return hobby;
	}
	public void setHobby(String hobby) {
		this.hobby = hobby;
	}
	
	

}
