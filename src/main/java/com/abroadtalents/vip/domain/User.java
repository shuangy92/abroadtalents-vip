package com.abroadtalents.vip.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Size;

@Entity
@Table(name = "User")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

    @Id
    @Size(max = 64)
    @Column(name = "name", nullable = false, updatable = false)
    private String name;

    @Transient
    private boolean isAdmin = false;
    
    User() {
    }

    public User(final String name) {
        this.name = name;
    }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public boolean getIsAdmin() {
		return isAdmin;
	}
	
	public void setAdmin() {
		this.isAdmin = true;
	}

	@Override
	public String toString() {
		return "User [name=" + name + "]";
	}
}
