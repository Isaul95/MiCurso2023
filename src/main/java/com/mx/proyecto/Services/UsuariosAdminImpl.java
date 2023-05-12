package com.mx.proyecto.Services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mx.proyecto.Dto.UsuariosAdminDTO;
import com.mx.proyecto.Repositories.UsuariosAdminDAO;
import com.mx.proyecto.entities.UsuariosAdmin;

@Service
public class UsuariosAdminImpl implements UsuariosAdminService{
	
	@Autowired
	private UsuariosAdminDAO usuariosAdminDAO;

	
	@Override
	public List<UsuariosAdmin> getUsuarios() {
		
		List<UsuariosAdmin> listaUsuarios = usuariosAdminDAO.obtieneUsuarios();
		
		return listaUsuarios;
	}


	
	@Override
	public String agregarNuevoUsuario(UsuariosAdminDTO nuevoUsuario) {
		
		UsuariosAdmin datosAInsertar = new UsuariosAdmin(); // declarar un nuevo obj vacio
		datosAInsertar.setIdUser(nuevoUsuario.getIdUser());
		datosAInsertar.setNombreCompleto(nuevoUsuario.getNombreCompleto());
		datosAInsertar.setEdad(nuevoUsuario.getEdad());
		datosAInsertar.setDireccion(nuevoUsuario.getDireccion());
		datosAInsertar.setEstado(nuevoUsuario.getEstado());
		datosAInsertar.setRol(nuevoUsuario.getRol());
		
//		Al final en esta posicion el obj -> datosAInsertar tiene toda la información a insertar en la tabla
		
		Integer resp = usuariosAdminDAO.insertarUsuario(datosAInsertar);
		String respInsert;
		
		if(resp == 0) {
			respInsert = "No se inserto el registro";
		}else {
			respInsert = "Se inserto el registro";
		}
		
		return respInsert;
	}



	@Override
	public String eliminarUsuario(UsuariosAdminDTO idUser) { // delete from tabla where id_usuario = 1
		
		Integer respuesta = usuariosAdminDAO.eliminaRegistro(idUser.getIdUser());
		String respDelete;
		
		if(respuesta == 0) {
			respDelete = "Error al eliminar";
		}else {
			respDelete = "Registro eliminado";
		}
		
		return respDelete;
	}



	@Override
	public String actualizarUsuario(UsuariosAdmin datos) {
		
		Integer respuesta = usuariosAdminDAO.actualizarUsuario(datos);
		String respUpdate;
		
		if(respuesta == 0) {
			respUpdate = "Error al actualizar";
		}else {
			respUpdate = "Registro actualizado";
		}
		return respUpdate;
	}
	
	
	
	
	
	

}// Fin de la clase principal
