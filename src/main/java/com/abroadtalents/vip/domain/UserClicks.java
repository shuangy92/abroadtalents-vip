package com.abroadtalents.vip.domain;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "User_Clicks")
@IdClass(UserClicksPK.class)
public class UserClicks implements Serializable {
	private static final long serialVersionUID = 1L;
    
	@Id
    @Column(name="username", nullable = false, updatable = false)
    private String username;
    
    @Id
    @Size(max = 64)
    @Column(name = "date", nullable = false, updatable = false)
    private Date date;
    
    @ManyToOne
    @Id
    @PrimaryKeyJoinColumn(name="username", referencedColumnName="name")
    private User user;
    
    @Column(name = "clicks", nullable = false, updatable = false)
    private int clicks;
    
    UserClicks() {
    }

    public UserClicks(final String username, final Date date, final int clicks) {
    	User user = new User(username);
        this.user = user;
        this.date = date;
        this.clicks = clicks;
    }
    
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
		this.username = user.getName();
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getClicks() {
		return clicks;
	}

	public void setClicks(int clicks) {
		this.clicks = clicks;
	}

	@Override
	public String toString() {
		return "UserClicks [name=" + user.getName() + ", date=" + date + ", clicks=" + clicks + "]";
	}



}

