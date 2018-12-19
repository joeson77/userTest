package org.lanqiao.entity;

public class User {
    private String username;

    private String password;

    private String birthday;

    private Integer age;

    private String email;

    @Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + ", birthday=" + birthday + ", age=" + age
				+ ", email=" + email + "]";
	}

	public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }
}