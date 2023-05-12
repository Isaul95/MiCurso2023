package com.mx.proyecto.Services;

import java.util.List;

import com.mx.proyecto.Dto.Alumnos;
import com.mx.proyecto.Dto.Response;

public interface ServicePrincipal {

	Response getAlumnos();
	int contarAlumnosNuevos();
	Response insertAlumno(Alumnos nuevoAlumno);
	String updateAlumno(Alumnos alumno);
	String deleteAlumno(Alumnos alumno);
    String insertMassiveAlumnos(List<Alumnos> nuevosAlumnos);
}
