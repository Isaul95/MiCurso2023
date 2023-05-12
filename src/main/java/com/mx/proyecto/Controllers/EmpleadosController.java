package com.mx.proyecto.Controllers;

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
import com.mx.proyecto.Dto.EmpleadosDTO;
import com.mx.proyecto.Dto.Response;
import com.mx.proyecto.Services.EmpleadosService;


@Controller
@RequestMapping(value="DatosEmpleados")
public class EmpleadosController {
	
	@Autowired
	private EmpleadosService empleadosService;
	
	
	//-----------Agregar Empleado-------------
		@ResponseBody 
		@RequestMapping(value="/agregarEmpleados", method = RequestMethod.POST, produces = "application/json") 
		public Response agregarNuevoEmpleados(@RequestBody EmpleadosDTO curp){
			System.out.println("CONTROL -> " + curp);
			System.out.println("CONTROL -> " + curp.getCurp());
			
			return empleadosService.agregarEmpleado(curp);	
	    }
	
	

}
