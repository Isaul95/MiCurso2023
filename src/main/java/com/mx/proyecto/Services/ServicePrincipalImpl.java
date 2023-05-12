package com.mx.proyecto.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mx.proyecto.Dto.Alumnos;
import com.mx.proyecto.Dto.Response;
import com.mx.proyecto.Repositories.RepositoryPrincipal;

//TODA LA LOGICA DEL NEGOCIO
//IMPLEMENTACI�N DEL SERVICIO
//OPERACIONES CON DATOS
//VALIDACIONES
//LLENADO DE INFORMACION
@Service
public class ServicePrincipalImpl implements ServicePrincipal{

	@Autowired
	private RepositoryPrincipal repositoryPrincipal;
	
	
	public Response getAlumnos() {
		Response respuesta = new Response();
		List<Alumnos> alumnos = repositoryPrincipal.getAlumno();
		// TODO Auto-generated method stub
		if(alumnos!=null && alumnos.size()>0) {
			respuesta.setCode(1);
			respuesta.setMessage("Informaci�n de alumnos");
			respuesta.setContent(alumnos);
		}
		else {
			respuesta.setCode(-1);
			respuesta.setMessage("No se encontr� informaci�n de los alumnos, verifique.");
		}
		return respuesta;
	}

	public int contarAlumnosNuevos() {
	
		System.out.println("LLEGANDO AL METODO contarAlumnosNuevos DE LA CLASE IMPLEMENTACI�N DEL SERVICIO");
		return repositoryPrincipal.contarAlumnosNuevos();
	}

	public Response insertAlumno(Alumnos nuevoAlumno) {
		Response respuesta = new Response();
		
		 if(nuevoAlumno.getNombre().length() >50) { // Rafael isaul -> 12  caracteres  // Si 12 > 50
			 respuesta.setCode(-2);
			 respuesta.setMessage("El nombre es m�s largo de 50 caracteres");
		 }
		 else if(nuevoAlumno.getNombre().equals("FERMIN")||nuevoAlumno.getNombre().contains("FERMIN")) {
			 respuesta.setCode(-3);
			 respuesta.setMessage("EL NOMBRE ES UN DEUDOR Y NO SE PERMITE INSERTAR");
		 }
		 else {
			 respuesta = repositoryPrincipal.insertAlumno(nuevoAlumno);

				String respuestaFinal = "";
				//SI LA VARIABLE RESPUESTA ES IGUAL A 1
				if(respuesta.getCode()==1) {
					respuesta.setMessage("�Se insert� correctamente!");
				}
				
				//SINO
				else if(respuesta.getCode()==0) {
					respuesta.setMessage("�No se insert� correctamente!");
				}
		 }
		return respuesta;
	}

	@Override
	public String updateAlumno(Alumnos alumno) {
		int respuesta = repositoryPrincipal.updateAlumno(alumno);
		
		String respuestaFinal = "";
		//SI LA VARIABLE RESPUESTA ES IGUAL A 1
		if(respuesta==1) {
			respuestaFinal = "�Se actualiz� correctamente!";
		}
		
		//SINO
		else {
			respuestaFinal = "�No se actualiz� correctamente!";
		}
		
		
		return respuestaFinal;
	}

	@Override
	public String deleteAlumno(Alumnos alumno) {
		int respuesta = repositoryPrincipal.deleteAlumno(alumno);
		String respuestaFinal = "";
		//SI LA VARIABLE RESPUESTA ES IGUAL A 1
		if(respuesta==1) {
			respuestaFinal = "�Se elimin� correctamente!";
		}
		
		//SINO
		else {
			respuestaFinal = "�No se elimin� correctamente!";
		}
		
		
		return respuestaFinal;
	}
	@Override
	public String insertMassiveAlumnos(List<Alumnos> nuevosAlumnos) {
		repositoryPrincipal.insertMassiveAlumnos(nuevosAlumnos);
		return "Se agregaron correctamente";
	}


}

