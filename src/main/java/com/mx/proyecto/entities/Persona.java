package com.mx.proyecto.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PERSONA", schema = "CURSOADMIN")
public class Persona {
	
	@Id
	@Column(name = "ID_PERSONA", unique = true, nullable = false, precision = 11, scale = 0)
	private Long idPersona;
	@Column(name = "NOMBRES", length = 100)
	private String nombres;
	@Column(name = "EDAD", length = 5)
	private String edad;
	@Column(name = "SEXO", length = 20)
	private String sexo;
	
	
	public Long getIdPersona() {
		return idPersona;
	}
	public void setIdPersona(Long idPersona) {
		this.idPersona = idPersona;
	}
	public String getNombres() {
		return nombres;
	}
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}
	public String getEdad() {
		return edad;
	}
	public void setEdad(String edad) {
		this.edad = edad;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

}
