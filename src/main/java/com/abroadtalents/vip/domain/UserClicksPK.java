package com.abroadtalents.vip.domain;

import java.io.Serializable;
import java.sql.Date;

public class UserClicksPK implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String username;
    private Date date;
    
    public UserClicksPK() {}

    public UserClicksPK(String username, Date date) {
        this.username = username;
        this.date = date;
    }

    @Override
    public int hashCode() {
        return username.hashCode() + date.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof UserClicksPK) {
        	UserClicksPK other = (UserClicksPK)obj;
            return username.equals(other.username) && date.equals(other.date);
        } else {
            return false;
        }
    }
}
