package com.mitocode.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "config")
public class Config {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idConfig;

	@Column(name = "parametro", length = 5)
	private String parametro;

	@Column(name = "valor", length = 25)
	private String valor;

	public Integer getIdConfig() {
		return idConfig;
	}

	public void setIdConfig(Integer idConfig) {
		this.idConfig = idConfig;
	}

	public String getParametro() {
		return parametro;
	}

	public void setParametro(String parametro) {
		this.parametro = parametro;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

}
