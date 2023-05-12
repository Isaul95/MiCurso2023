package com.mx.proyecto.Controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mx.proyecto.Dto.PersonaDTO;
import com.mx.proyecto.Dto.Response;
import com.mx.proyecto.Services.PersonaService;
import com.mx.proyecto.entities.UsuariosAdmin;

@Controller
@RequestMapping("/Persona") // nombre del controller
public class PersonaController {
	
	@Autowired
	private PersonaService personaService;
	
	
	
	// consultar una persona por su identificador 
	@ResponseBody
    @RequestMapping(value="/getPersona", method = RequestMethod.POST, produces = "application/json")
	public String getPersona(@RequestBody PersonaDTO idPersona){
		
		String respuesta = personaService.getPersona(idPersona);
		
		return respuesta;	
    }
	
	
	
	// Registro de nueva persona 
	@ResponseBody
    @RequestMapping(value="/guardarPersona", method = RequestMethod.POST, produces = "application/json")
	public String guardarPersona(@RequestBody PersonaDTO datos){
		
		String respuesta = personaService.guardarPersona(datos);
		
		return respuesta;	
    }
	
	
	
	// Eliminar persona 
	@ResponseBody
    @RequestMapping(value="/eliminarPersona", method = RequestMethod.POST, produces = "application/json")
	public String eliminarPersona(@RequestBody PersonaDTO idPersona){
		
		String respuesta = personaService.eliminarPersona(idPersona);
		
		return respuesta;	
    }

	
	// Eliminar persona con clase Response
	@ResponseBody
    @RequestMapping(value="/eliminarPersonaId", method = RequestMethod.POST, produces = "application/json")
	public Response eliminarPersonaId(@RequestBody PersonaDTO idPersona){
		
		return personaService.eliminarPersonaId(idPersona);
		
		
    }
	

}
