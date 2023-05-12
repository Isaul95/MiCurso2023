package com.mx.proyecto.Repositories;

import java.util.List;

import com.mx.proyecto.Dto.UsuariosAdminDTO;
import com.mx.proyecto.entities.UsuariosAdmin;

public interface UsuariosAdminDAO {
	
	List<UsuariosAdmin> obtieneUsuarios();
	
	Integer insertarUsuario(UsuariosAdmin datosAInsertar);
	
	Integer eliminaRegistro(Long idUser);
	
	Integer actualizarUsuario(UsuariosAdmin datos);
	

}
