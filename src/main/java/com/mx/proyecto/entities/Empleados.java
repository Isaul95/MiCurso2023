package com.mx.proyecto.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name= "EMPLEADOS", schema="CURSO_MARZO")
public class Empleados {
//	ID_EMPLEADO
//	NOMBRE_COMPLETO
//	CURP
//	EDAD
//	SEXO
//	DIRECCION
//	TELEFONO
//	ACTIVO
	@Id
	@Column(name= "ID_EMPLEADO", length = 11)
	private Long idEmpleados;
	@Column(name = "NOMBRE_COMPLETO", length = 100)
	private String nombreCompleto;
//	@Column(name = "RFC", length = 13)
//	private String rfc;
	@Column(name = "CURP")
	private String curp;
	@Column(name = "EDAD", length = 3)
	private Long edad;
	@Column(name = "SEXO", length = 1)
	private String sexo;
	@Column(name = "DIRECCION", length = 100)
	private String direccion;
	@Column(name = "TELEFONO", length = 10)
	private Long telefono;
	@Column(name = "ACTIVO", length = 1)
	private Long activo;
	
	
	
	
	public String getCurp() {
		return curp;
	}
	public void setCurp(String curp) {
		this.curp = curp;
	}
	public Long getIdEmpleados() {
		return idEmpleados;
	}
	public void setIdEmpleados(Long idEmpleados) {
		this.idEmpleados = idEmpleados;
	}
	public String getNombreCompleto() {
		return nombreCompleto;
	}
	public void setNombreCompleto(String nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
	}
//	public String getRfc() {
//		return rfc;
//	}
//	public void setRfc(String rfc) {
//		this.rfc = rfc;
//	}
	public Long getEdad() {
		return edad;
	}
	public void setEdad(Long edad) {
		this.edad = edad;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public Long getTelefono() {
		return telefono;
	}
	public void setTelefono(Long telefono) {
		this.telefono = telefono;
	}
	public Long getActivo() {
		return activo;
	}
	public void setActivo(Long activo) {
		this.activo = activo;
	}
	
	
}
