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
    public boolean equals(Object object) {
        if (object instanceof UserClicksPK) {
        	UserClicksPK pk = (UserClicksPK)object;
            return username.equals(pk.username) && date.equals(pk.date);
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return (int)(username.hashCode() + date.hashCode());
    }
}
