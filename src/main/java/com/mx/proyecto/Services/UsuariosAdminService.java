package com.mx.proyecto.Services;

import java.util.List;

import com.mx.proyecto.Dto.UsuariosAdminDTO;
import com.mx.proyecto.entities.UsuariosAdmin;

public interface UsuariosAdminService {

	List<UsuariosAdmin> getUsuarios();
	
	String agregarNuevoUsuario(UsuariosAdminDTO nuevoUsuario);
	
	String eliminarUsuario(UsuariosAdminDTO idUser);
	
	String actualizarUsuario(UsuariosAdmin datos);
	
}
