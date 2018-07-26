package com.shiro.web.vo;

/**
 * Created by SQ_BXZ on 2018-07-26.
 */
public class User {

	private Integer id;
	private Integer age;
	private String username;
	private String password;

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "User{" +
				"id=" + id +
				", age=" + age +
				", username='" + username + '\'' +
				", password='" + password + '\'' +
				'}';
	}
}
