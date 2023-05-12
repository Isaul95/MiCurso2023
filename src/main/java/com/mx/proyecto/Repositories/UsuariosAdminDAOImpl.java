package com.mx.proyecto.Repositories;

import java.util.List;

import org.apache.xmlbeans.impl.xb.xsdschema.RestrictionDocument.Restriction;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mx.proyecto.entities.UsuariosAdmin;

@Repository
public class UsuariosAdminDAOImpl implements UsuariosAdminDAO{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public UsuariosAdminDAOImpl() {	// Constructor vacio
	}
	
	public UsuariosAdminDAOImpl(SessionFactory sessionFactory) { // Constructor con parametros
		this.sessionFactory = sessionFactory;
	}

	
	
	
// Consulta con hibernate
	@SuppressWarnings("unchecked")// Quitar las advertencias (son las lineas amarillas)
	@Override
	@Transactional() // Es lo equivalente a un commit en oracle (Confirmar los cambios) 
//	recomendble usarlos en-> insert, delete y update
	public List<UsuariosAdmin> obtieneUsuarios() {
		
		final Session session = sessionFactory.getCurrentSession();
		final Criteria criteria = session.createCriteria(UsuariosAdmin.class); // -> SELECT * FROM ESQUEMA.TABLA
		
		criteria.add(Restrictions.eq("idUser",5)); // --> WHERE id_user = 5;
		
		return (List<UsuariosAdmin>) criteria.list();
	}
	
	/**  ------  IMPORTANTE ----
	 * Para consultas por hibernate importante 2 cosas:
	 * 1.- La session actual -> final Session session = sessionFactory.getCurrentSession();
	 * 2.- Usar la Entity/entidad -> (Es la tabla de DB) -> final Criteria criteria = session.createCriteria(UsuariosAdmin.class);
	 */
	
	
	
	

	@Override
	@Transactional() // Es lo equivalente a un commit en oracle (Confirmar los cambios)
	public Integer insertarUsuario(UsuariosAdmin datosAInsertar) {
		
		sessionFactory.getCurrentSession().save(datosAInsertar);// Es para guardar infor a la tabla
//      save = guardar

//		Es si no existe el reg en la tabla se se guarda, si ya existe el reg. se actualiza
//		sessionFactory.getCurrentSession().saveOrUpdate(datosAInsertar);

		return 1;
	}

	
	
	// Eliinar registro con hibernate
	@Override
	@Transactional() // Es lo equivalente a un commit en oracle (Confirmar los cambios)
	public Integer eliminaRegistro(Long idUser) {
		
		UsuariosAdmin ideEntity = new UsuariosAdmin();
		ideEntity.setIdUser(idUser);

		sessionFactory.getCurrentSession().delete(ideEntity);
		
		return 1;
	}

	
	
	
	@Override
	@Transactional()
	public Integer actualizarUsuario(UsuariosAdmin datos) {
		
		sessionFactory.getCurrentSession().update(datos);
		
		return 1;
	}
	
	
	/**
	 * 1.- Reducir codigo
	 * 2.- El tiempo de desarrollo
	 * 3.- La seguridad del codigo(consultas)
	 * 
	 * ------------ JDBC -----------------
	 * 1.- Aqui son querys
	 * 2.- IMPORTANTE: Las consultas especificas{ 
	 * 
	 * EJEMPLO: Tabla de 500 campos TABLA -> USUARIOS
	 * Los campos que necesito -> (ID - NOMBRE_USUARIO) 
	 * 
	 * -> SELECT ID, NOMBRE_USUARIO FROM ESQUEMA.USUARIOS;
	 * }
	 * 
	 * getId
	 * getNombreUsuario
	 * 
	 * 
	 * ---------- HIBERNATE  ---------------
	 * -> (BASURA-> LOS 498 CAMPOS QUE NO NECESITO)
	 * -> SELECT * FROM ESQUEMA.USUARIOS
	 * 
	 * 
	 * campo1
	 * .
	 * 
	 * for(recorrer los 500 campos){
	 * 1 -> campo1, campo2, campo3...... campo 500
	 * 2 -> campo, campo2, campo3.......campo 500
	 * 3 -> 
	 * } 
	 * 
	 * 
	 * -- ejemplo #2: registrar usuario pero verifica antes de insertar que no exista en DB
	 * 
	 * JDBC -> Select * from tabla where nombre = "isaul";
	 * 
	 * if(resp == 1)
	 * 
	 * El usuario no se puede registrar xq ya existe en db
	 * 
	 * else{
	 * dto -> entidad
	 * DAO.save(entidad);
	 * }
	 * 
	 * 
	 * 
	 * 
	 * 
	 */
	
	
	
	
	

}
