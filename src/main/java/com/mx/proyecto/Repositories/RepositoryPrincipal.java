package com.mx.proyecto.Repositories;

import java.util.List;

import com.mx.proyecto.Dto.Alumnos;
import com.mx.proyecto.Dto.Response;

public interface RepositoryPrincipal {
	
	List<Alumnos> getAlumno();
	int contarAlumnosNuevos();
	Response insertAlumno(Alumnos nuevoAlumno);
	int updateAlumno(Alumnos alumno);
	int deleteAlumno(Alumnos alumno);
	int[][] insertMassiveAlumnos(List<Alumnos> nuevosAlumnos);

}
