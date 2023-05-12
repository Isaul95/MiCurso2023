package com.mx.proyecto.Repositories;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ParameterizedPreparedStatementSetter;
import org.springframework.stereotype.Repository;

import com.mx.proyecto.Dto.Alumnos;
import com.mx.proyecto.Dto.Response;
import com.mx.proyecto.Mapper.AlumnosMapper;

//CONSULTAS A BASE DE DATOS
//IMPLEMENTACIÓN DEL REPOSITORIO

@Repository
public class RepositoryPrincipalImpl implements RepositoryPrincipal{

	@Autowired
	private DataSource dataSource;  //PARA LA CONEXIÓN A LA BASE DE DATOS
	
	JdbcTemplate jdbcTemplate = new JdbcTemplate(); // ES EL QUE NOS VA A PERMITIR HACER CONSULTAS A LA BASE DE DATOS MEDIANTE UNA CONEXIÓN A BASE DE DATOS
	
	public List<Alumnos> getAlumno() {
		jdbcTemplate.setDataSource(getDataSource());
		return jdbcTemplate.query("SELECT * FROM CURSO_MARZO.ALUMNOS_2", new AlumnosMapper<Alumnos>());
	}

	
	public Response insertAlumno(Alumnos nuevoAlumno) {
		Response respuesta = new Response();
		try {
		jdbcTemplate.setDataSource(getDataSource());
		respuesta.setCode(jdbcTemplate.update("INSERT INTO ALUMNOS_2(ID_ALUMNO,NOMBRE,EDAD) VALUES (?,?,?)", new Object[] {nuevoAlumno.getIdAlumno(),nuevoAlumno.getNombre(),nuevoAlumno.getEdad()}));
		return respuesta;
	}catch(org.springframework.dao.DuplicateKeyException DKE) {
		respuesta.setCode(-1);
		respuesta.setMessage("El id a insertar: "+nuevoAlumno.getIdAlumno()+" ya existe en la base de datos, verifique.");
		return respuesta;
	}
	}
	
	@Override
	public int updateAlumno(Alumnos alumno) {
		jdbcTemplate.setDataSource(getDataSource());
		return jdbcTemplate.update("UPDATE ALUMNOS SET NOMBRE = ?, EDAD = ? WHERE ID_ALUMNO = ? ",new Object[] {alumno.getNombre(),alumno.getEdad(),alumno.getIdAlumno()});
	}
	
	@Override
	public int deleteAlumno(Alumnos alumno) {
		jdbcTemplate.setDataSource(getDataSource());
		return jdbcTemplate.update("DELETE FROM ALUMNOS WHERE ID_ALUMNO = ?",new Object[] {alumno.getIdAlumno()});
	}
	
	@Override
	public int[][] insertMassiveAlumnos(List<Alumnos> nuevosAlumnos) {
		jdbcTemplate.setDataSource(getDataSource());
		return jdbcTemplate.batchUpdate("INSERT INTO ALUMNOS(NOMBRE,EDAD) VALUES (?,?)",
				nuevosAlumnos, 10, 
				new ParameterizedPreparedStatementSetter<Alumnos>() {
					@Override
					public void setValues(PreparedStatement ps, Alumnos alumno) throws SQLException {
						  ps.setString(1,alumno.getNombre());
						  ps.setInt(2, alumno.getEdad());   
					}
                }
		);
	}


	public int contarAlumnosNuevos() {
		System.out.println("LLEGANDO AL METODO contarAlumnosNuevos DE LA CLASE IMPLEMENTACIÓN DEL REPOSITORIO");
		return 1245;
	}
	

	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}






	
	

}
