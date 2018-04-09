package com.example.v6rest.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the t_store database table.
 * 
 */
@Entity
@Table(name="t_store")
@NamedQuery(name="TStore.findAll", query="SELECT t FROM TStore t")
public class TStore implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String name;

	public TStore() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

}