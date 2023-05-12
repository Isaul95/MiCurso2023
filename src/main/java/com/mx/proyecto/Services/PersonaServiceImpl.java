package com.mx.proyecto.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mx.proyecto.Dto.PersonaDTO;
import com.mx.proyecto.Dto.Response;
import com.mx.proyecto.Repositories.PersonaDAO;
import com.mx.proyecto.entities.Persona;


@Service
public class PersonaServiceImpl implements PersonaService{
	
	@Autowired
	private PersonaDAO personaDAO;

	
	
	@Override
	public String getPersona(PersonaDTO idPersona) {
		String respuesta = null;
		
		//	T read(final PK id);
		 Persona objecto = personaDAO.read(idPersona.getIdPersona());// Consulta-->select * from tabla where id_persona = 1;
//		Resultado-objecto SI EXISTE EL REG -> RESL-> com.mx.proyecto.entities
//		Resultado-objecto NO EXISTE EL REG -> '' / null
		 
		 System.out.println(" Propiedas del obj ->" + objecto); //-> RESL-> com.mx.proyecto.entities
		 System.out.println(" Propiedas del obj 1->" + objecto.getIdPersona() + objecto.getNombres()); //-> RESL-> com.mx.proyecto.entities
		
		 if(objecto != null) {
			 respuesta = "Si existe el registro en la base de datos";
		 }else {
			 respuesta = "El registro NO existe";
		 }
		
		return respuesta;
	}



	@Override
	public String guardarPersona(PersonaDTO datos) {
		
		Persona obj = new Persona();
		obj.setIdPersona(datos.getIdPersona());
		obj.setNombres(datos.getNombres());
		obj.setEdad(datos.getEdad());
		obj.setSexo(datos.getSexo());
		
		Long addPersona = personaDAO.create(obj); // Esta linea es el inserto a la tabla
		
		if(addPersona != 0) {
			return "Datos registrados";
		}else {
			return "Error al registrados";
		}
		
	}



	@Override
	public String eliminarPersona(PersonaDTO idPersona) {
		
		personaDAO.delete(idPersona.getIdPersona()); // Eliminar registro

		return "Si elimino";
	}

	/*
	 Recojer datos (NSS, curp, rfc, codigo) - cuando guardes informacion validar:
	 
	 1.- Validar que la curp sea correcta (los dijitos, toda la estrutctura)
	 2.- Validar rfc (los dijitos, toda la estrutctura)
	 3.- codigo (validar que sea todos numeros)
	 4.- NSS (){
			 NSS = 123     -> 0000000123
			 NSS = 123456  -> 0000123456
			 NSS = 12345678-> 0012345678 
			 NSS = 1234567890 <-- Nss son 10 dijitos
	 	}
	 	
	 	if(curp){
	 	if(rfc){
	 	if(codigo)
	 	if(nsss)
	 	save(datos);
	 	
	 	}else{
	 	el rfc esta mal
	 	}
	 	
	 	}else{
	 	 la curp que ingresaste esta mal
	 	}
	 	
	  
	 */
	
	
	
	

	/*
	 1.- Verificar si el ide que se manda desde el postman no sea null o cero (Incorrecto) --> "No se cumple"
	 2.1- Verifica/consultar si existe la persona con ese id
	 2.2- Evaluar Si existe el estado conusltado por el ide
	 
	 1.- Verificar si el ide que se manda desde el postman no sea null, cero o letras (Incorrecto) --> "No se cumple"
	 */
	@Override
	public Response eliminarPersonaId(PersonaDTO idPersona) { // 3A
		Response response = new Response(); 
		
		try {
		
			if(idPersona.getIdPersona() != null || idPersona.getIdPersona() != 0 || validaNumerico(idPersona.getIdPersona()) ) { // Regla #1
				
//				validar que no sean letras
	
				 Persona existeReg = personaDAO.read(idPersona.getIdPersona()); // Regla #2.1
				 //select * from persona where id-persona = ?
				
				 if(existeReg != null) {//Regla #2.2
					 personaDAO.delete(idPersona.getIdPersona()); // Elimina reg
					 response.setMessage("Persona eliminada correctamente");
					 response.setCode(200); // Codigos de respuesta HTTP
				 }else {
					 	response.setMessage("La información no existe");
						response.setCode(100); // Codigos de respuesta HTTP
				 }
			}else {
				response.setMessage("Los datos enviados son incorrectos");
				response.setCode(500); // Codigos de respuesta HTTP
			}
			
		}catch(Exception e) {
			response.setMessage("Ocurrio error al intentar eliminar la persona");
		}
		
		return response;
	}



	private boolean validaNumerico(Long idPersona) { // Long idPersona -> Long 5
		
		
		return false;
	}


/*
ID
NOMBRE_COMPLETO
RFC
CURP
EDAD
SEXO (Campo que va a recibir M = masculino y F = femenino)
DIRECCION
NSS (Campo que va a recibir numeros 10 dijitos)
TELEFONO
ACTIVO (Campo que va a recibir 0 = BAJA y 1 = ACTIVO)

 
 1.- Un service para insertar nuevos empleados
REGLA I.- Antes de insertar un empleado verificar si ya EXISTE ese usuario en la base de datos

 	"ID":"1",
    "NOMBRE_COMPLETO":"ISAUL HERNANDEZ",
    "RFC":"FSRWR3748",
    "CURP":"DSREWYTQ124",
    "EDAD":"23",
    "SEXO":"M",
    "DIRECCION":"Mexico",
    "NSS":"1234567",
    "TELEFONO":"1234567890",
    "ACTIVO": 1

public Response savePersona(PersonaDTO datos) {
 
 //->select * from EMPLEADOS where CURP = DESDE_POSTMAN;
 
 Empleados existeReg = personaDAO.read(datos.getCurp());
 
	if(existeReg != null){
	
		Empleado obj = new=...
		obj.settt
		
		save(obj);
		mensaje("Empleado agregado correctamnetre");
	}else{
		mensaje("El empleado ya existe en la base de datos");
	}

}







2.- Servicio para eliminar un empleado 
REGLA I.- Se puede eliminar siempre y cuando este dado de baja, si no esta dado de baja
ese empleado mostrar un mensaje de -> "Imposible eliminar Empleado, Sigue Laborando (Activo)...! ", 
En caso contrario el siguiente mensaje -> "Empleado eliminado correctamente"
 
 
 	
 */
	

	
	
}
