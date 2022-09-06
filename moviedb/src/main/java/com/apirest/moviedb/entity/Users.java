package com.apirest.moviedb.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userid;
    @NotBlank(message = "Name cant be null")
    private String username;
    @NotBlank(message = "password cant be null")
    private String password;
    @NotBlank(message = "role cant be null")
    private String role;
    @NotBlank(message = "enable cant be null")
    private int enabled;

    @Override
    public String toString() {
        return "Users{" +
                "userid=" + userid +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", role='" + role + '\'' +
                ", enable=" + enabled +
                '}';
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public int isEnable() {
        return enabled;
    }

    public void setEnable(int enable) {
        this.enabled = enable;
    }

    public Users() {
    }

    public Users(Integer userid, String username, String password, String role, int enable) {
        this.userid = userid;
        this.username = username;
        this.password = password;
        this.role = role;
        this.enabled = enable;
    }
}
