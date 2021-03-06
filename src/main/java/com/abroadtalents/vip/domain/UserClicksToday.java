package com.abroadtalents.vip.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "User_Clicks_Today")
public class UserClicksToday implements Serializable {
	private static final long serialVersionUID = 1L;
    
	@Id
    @Column(name="username", nullable = false, updatable = false)
    private String username;
    
    @Column(name = "clicks", nullable = false)
    private int clicks;
    
    @OneToOne
    @JoinColumn(name="username", referencedColumnName="name", updatable = false)
    private User user;
    
    UserClicksToday() {
    }

    public UserClicksToday(final String username, final int clicks) {
    	User user = new User(username);
        this.user = user;
        this.username = username;
        this.clicks = clicks;
    }

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	public int getClicks() {
		return clicks;
	}

	public void setClicks(int clicks) {
		this.clicks = clicks;
	}

	@Override
	public String toString() {
		return "UserClicksToday [name=" + user.getName() + ", clicks=" + clicks + "]";
	}

	@Override
	public int hashCode() {
		return user.hashCode() + clicks;
	}

	@Override
	public boolean equals(Object obj) {
        if (obj instanceof UserClicksToday) {
        	UserClicksToday other = (UserClicksToday)obj;
            return user.equals(other.user) && (clicks == other.clicks);
        } else {
            return false;
        }
	}



}

