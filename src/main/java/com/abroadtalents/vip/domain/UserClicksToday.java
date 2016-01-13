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

    @OneToOne
    @Id
    @JoinColumn(name="username", referencedColumnName="name", updatable = false)
    private User user;
    
    @Column(name = "clicks", nullable = false, updatable = false)
    private int clicks;
    
    UserClicksToday() {
    }

    public UserClicksToday(final String username, final int clicks) {
    	User user = new User(username);
        this.user = user;
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


}

