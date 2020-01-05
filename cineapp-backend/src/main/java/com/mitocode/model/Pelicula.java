package com.mitocode.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


@ApiModel(description = "Datos de la pelicula")
@Entity
@Table(name = "pelicula")
public class Pelicula {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idPelicula;

	@ApiModelProperty(notes = "Nombres debe tener minimo 3 caracteres")
	@Size(min = 3, message = "[nombre] Minimo 3 caracteres")
	@Column(name = "nombre", nullable = false, length = 255)
	private String nombre;

	@ApiModelProperty(notes = "Resena debe tener minimo 3 caracteres")
	@Size(min = 3, message = "[resena] Minimo 3 caracteres")
	@Column(name = "resena", nullable = false, length = 255)
	private String resena;

	@ApiModelProperty(notes = "Duracion debe tener minimo 3 caracteres")
	@Min(value = 1 )
	@Column(name = "duracion", nullable = false, length = 3)
	private Integer duracion;
	
	@ApiModelProperty(notes = "Fecha de la publicacion")
	@NotNull
	@Column(name = "fecha_publicacion", nullable = false)
	private LocalDate fechaPublicacion;

	@ApiModelProperty(notes = "URL Portada debe tener minimo 3 caracteres")
	@Size(min = 3, message = "[urlPortada] Minimo 3 caracteres")
	@Column(name = "urlPortada", nullable = false, length = 255)
	private String urlPortada;
	
	@ApiModelProperty(notes = "Datos del genero")
	@NotNull
	@ManyToOne
	@JoinColumn(name = "id_genero", nullable = false, foreignKey = @ForeignKey(name = "fk_pelicula_genero"))
	private Genero genero;

	public Integer getIdPelicula() {
		return idPelicula;
	}

	public void setIdPelicula(Integer idPelicula) {
		this.idPelicula = idPelicula;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getResena() {
		return resena;
	}

	public void setResena(String resena) {
		this.resena = resena;
	}

	public Integer getDuracion() {
		return duracion;
	}

	public void setDuracion(Integer duracion) {
		this.duracion = duracion;
	}

	public LocalDate getFechaPublicacion() {
		return fechaPublicacion;
	}

	public void setFechaPublicacion(LocalDate fechaPublicacion) {
		this.fechaPublicacion = fechaPublicacion;
	}

	public String getUrlPortada() {
		return urlPortada;
	}

	public void setUrlPortada(String urlPortada) {
		this.urlPortada = urlPortada;
	}

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}

}
