package com.mx.proyecto.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mx.proyecto.Dto.EmpleadosDTO;
import com.mx.proyecto.Dto.Response;
import com.mx.proyecto.Repositories.EmpleadosDAO;
import com.mx.proyecto.entities.Empleados;


@Service
public class EmpleadosServiceImpl implements EmpleadosService{ // Las reglas de negocio
	
	@Autowired
	private EmpleadosDAO empleadosDAO;
	
	
	
//	1.- Un service para insertar nuevos empleados
//	REGLA I.- Antes de insertar un empleado verificar si ya EXISTE ese usuario en la base de datos
	// Registro
	@Override
	public Response agregarEmpleado(EmpleadosDTO curp) {// select * from tabla where CURP = ?		
		Response response = new Response();
		try {			
			Empleados existeCurp = empleadosDAO.buscarPorCurp(curp.getCurp()); // select * from tabla where CURP = ?
			System.out.println("#29->MI RESPUESTA -> " + existeCurp);
			if(existeCurp != null ){// Es decir existe un reg
				response.setMessage("El usuario ya se encuentra registrado en DB");
				response.setCode(100);
			}else{ // Si no NO EXISTE REG VIENE VACION
				Empleados ob = new Empleados();
				ob.setIdEmpleados(curp.getIdEmpleados());
				ob.setNombreCompleto(curp.getNombreCompleto());
				ob.setCurp(curp.getCurp());
				ob.setEdad(curp.getEdad());
				ob.setSexo(curp.getSexo());
				ob.setDireccion(curp.getDireccion());
				ob.setTelefono(curp.getTelefono());
				ob.setActivo(curp.getActivo());

				empleadosDAO.create(ob);
				response.setMessage("Registro completado");
				response.setCode(200);
			}
		}catch(Exception e) {
			response.setMessage("Ocurrio un error al registrar un nuevo empleado, en la clase: EmpleadosServiceImpl en el metodo: agregarEmpleado");
		}
		return response;
	}
	
	
	
	
	
	
	
	
	

}