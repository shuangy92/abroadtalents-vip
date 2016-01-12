package com.abroadtalents.vip.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @NotNull
    @Column(name = "id", nullable = false, updatable = false)
    private long id;

    @NotNull
    @Size(max = 64)
    @Column(name = "name", nullable = false, updatable = false, unique = true)
    private String name;

    private boolean isAdmin = false;
    User() {
    }

    public User(final String name) {
        this.name = name;
    }

    public long getId() {
        return id;
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
