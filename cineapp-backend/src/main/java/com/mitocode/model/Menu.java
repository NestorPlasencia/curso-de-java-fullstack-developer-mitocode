package com.mitocode.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "menu")
public class Menu {
	
	@Id
	private Integer idMenu;
	
	@Column(name = "nombre", length = 20)
	private String nombre;
	
	@Column(name = "icono", length = 20)
	private String icono;
	
	@Column(name = "url", length = 50)
	private String url;
	
	public Integer getIdMenu() {
		return idMenu;
	}
	
	public void setIdMenu(Integer idMenu) {
		this.idMenu = idMenu;
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getIcono() {
		return icono;
	}
	
	public void setIcono(String icono) {
		this.icono = icono;
	}
	
}
