package cn.thinkingme.train.test;

import java.util.Arrays;

public class User {
	public String username;
	public String age;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "User [username=" + username + ", age=" + age + "]";
	}

	public static void main(String[] args) {
		System.out.println(String.join(";", new String[]{"asdasd","asdasda"}));
	}
}
