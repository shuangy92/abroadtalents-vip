package com.abroadtalents.vip.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class User {

    @Id
    @NotNull
    @Size(max = 64)
    @Column(name = "name", nullable = false, updatable = false)
    private String name;

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
