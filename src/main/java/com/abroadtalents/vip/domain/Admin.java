package com.abroadtalents.vip.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Admin {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @NotNull
    @Column(name = "id", nullable = false, updatable = false)
    private long id;

    @NotNull
    @Size(max = 64)
    @Column(name = "name", nullable = false, updatable = false, unique = true)
    private String name;

    Admin() {
    }

    public Admin(final String name) {
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

	@Override
	public String toString() {
		return "Admin [name=" + name + "]";
	}
}
