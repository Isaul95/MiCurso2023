package com.mx.proyecto.Mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.mx.proyecto.Dto.Alumnos;

public class AlumnosMapper<T> implements RowMapper<Alumnos>{

	public Alumnos mapRow(ResultSet rs, int rowNum) throws SQLException {
		Alumnos objeto = new Alumnos();
		
		objeto.setIdAlumno(rs.getLong("ID_ALUMNO"));
		objeto.setNombre(rs.getString("NOMBRE"));
		objeto.setEdad(rs.getInt("EDAD"));
        objeto.setApellido(rs.getString("APELLIDO"));
        objeto.setPromedio(rs.getDouble("PROMEDIO"));
           
		return objeto;
	}

}
