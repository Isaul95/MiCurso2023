package com.mx.proyecto.Repositories;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.mx.proyecto.entities.Empleados;


@Repository
public class EmpleadosDAOImpl extends GenericDAO<Empleados, Long> implements EmpleadosDAO{
	
	// DAO = Data Access Objetc       -> Patron de diseño
		// MVC (Modelo Vista controlador) -> Patron de diseño
	
	

	@Override
	@Transactional
	public Empleados buscarPorCurp(String curp) {
		System.out.println("IMPL->" + curp);
		
		final Session session = sessionFactory.getCurrentSession();
		final Criteria criteria = session.createCriteria(Empleados.class);// -> select * from EMPLEADOS
		
		criteria.add(Restrictions.eq("curp",curp));// -> WHERE curp = 'BHJBSDH3YUGE6732'

		System.out.println("FIN-IMPL->" + criteria);
		
		return (Empleados) criteria.uniqueResult();
	}

	// select * from EMPLEADOS WHERE curp = 
	
	
	
	
}
