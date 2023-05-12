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
import com.mx.proyecto.Dto.UsuariosAdminDTO;
import com.mx.proyecto.Services.UsuariosAdminService;
import com.mx.proyecto.entities.UsuariosAdmin;

@Controller
@RequestMapping("UsuariosAdmin")
public class UsuariosAdminController {
	
	@Autowired
	private UsuariosAdminService usuariosAdminService;
	
	
	// consulta
	@ResponseBody
    @RequestMapping(value="/getUsuariosAdmin", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity < List<UsuariosAdmin> > obtenerUsuarios(){
		final HttpHeaders httpHeaders = new HttpHeaders();

		List<UsuariosAdmin> respuesta = usuariosAdminService.getUsuarios();
		
		httpHeaders.setContentType(MediaType.APPLICATION_JSON);
		
		return new ResponseEntity <List<UsuariosAdmin>> (respuesta, httpHeaders, HttpStatus.OK);	
    }
	
	
	
	// agregar registros por hibernate
		@ResponseBody
	    @RequestMapping(value="/insertarRegistros", method = RequestMethod.POST, produces = "application/json")
		public ResponseEntity < String > insertarNuevoUsuario(@RequestBody UsuariosAdminDTO nuevoUsuario){
			final HttpHeaders httpHeaders = new HttpHeaders();

			String respuesta = usuariosAdminService.agregarNuevoUsuario(nuevoUsuario);
			
			httpHeaders.setContentType(MediaType.APPLICATION_JSON);
			
			return new ResponseEntity <String> (respuesta, httpHeaders, HttpStatus.OK);	
	    }
		
		
		
		// Eliminar registro
		@ResponseBody
	    @RequestMapping(value="/eliminarUsuario", method = RequestMethod.POST, produces = "application/json")
		public ResponseEntity < String > eliminarUsuario(@RequestBody UsuariosAdminDTO idUser){
			final HttpHeaders httpHeaders = new HttpHeaders();

			String respuesta = usuariosAdminService.eliminarUsuario(idUser);
			
			httpHeaders.setContentType(MediaType.APPLICATION_JSON);
			
			return new ResponseEntity <String> (respuesta, httpHeaders, HttpStatus.OK);	
	    }
		
		
		
		// Actualizar registro
		@ResponseBody
	    @RequestMapping(value="/actualizarDatos", method = RequestMethod.POST, produces = "application/json")
		public ResponseEntity < String > actualizarDatosUsuario(@RequestBody UsuariosAdmin datos){
			final HttpHeaders httpHeaders = new HttpHeaders();

			String respuesta = usuariosAdminService.actualizarUsuario(datos);
			
			httpHeaders.setContentType(MediaType.APPLICATION_JSON);
			
			return new ResponseEntity <String> (respuesta, httpHeaders, HttpStatus.OK);	
	    }
	

}
