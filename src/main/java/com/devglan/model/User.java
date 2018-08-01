package com.devglan.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity(name="userdb")
public class User {

    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE)
    private long id;
    
    @Column(nullable=false)
    private String username;
    
    @Column(name="pass", nullable=false)
    @JsonIgnore
    @NotBlank
    private String password;
    
    @Column(length=25)
    private String phone;
    
    @Column(nullable=false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date createdAt;

    @Column(nullable=true)
    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    private Date updateAt;

    @Column(nullable=true)
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastLogin;
    
    public User() {
		super();
	}

	public long getId() {
        return id;
    }

    public void setId(long id) {
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

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdateAt() {
		return updateAt;
	}

	public void setUpdateAt(Date updateAt) {
		this.updateAt = updateAt;
	}

	public Date getLastLogin() {
		return lastLogin;
	}

	public void setLastLogin(Date lastLogin) {
		this.lastLogin = lastLogin;
	}
	
}