package org.demo.entity;

public class Users {
	
	private Integer id;//主键id

    private String userName;//用户名

    private String userPwd;//用户密码
    
    private String userTel;//用户手机号
    
    private Integer userIntegral;//用户积分
    
    private Integer userState;//账号状态 0正常 1封号
    
    private String ex1;//扩展字段1
    
    private String ex2;//扩展字段2
    
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPwd() {
		return userPwd;
	}

	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}

	public String getUserTel() {
		return userTel;
	}

	public void setUserTel(String userTel) {
		this.userTel = userTel;
	}

	public Integer getUserIntegral() {
		return userIntegral;
	}

	public void setUserIntegral(Integer userIntegral) {
		this.userIntegral = userIntegral;
	}

	public Integer getUserState() {
		return userState;
	}

	public void setUserState(Integer userState) {
		this.userState = userState;
	}

	public String getEx1() {
		return ex1;
	}

	public void setEx1(String ex1) {
		this.ex1 = ex1;
	}

	public String getEx2() {
		return ex2;
	}

	public void setEx2(String ex2) {
		this.ex2 = ex2;
	}

	@Override
	public String toString() {
		return "Users [id=" + id + ", userName=" + userName + ", userPwd=" + userPwd + ", userTel=" + userTel
				+ ", userIntegral=" + userIntegral + ", userState=" + userState + ", ex1=" + ex1 + ", ex2=" + ex2 + "]";
	}

}
