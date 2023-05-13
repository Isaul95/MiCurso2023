package com.mx.proyecto.Repositories;

import com.mx.proyecto.entities.Empleados;

public interface EmpleadosDAO extends DAO<Empleados, Long>{

	// Declaracion de metodos
	// int nombreMetodo(Parametros obj);
	
	// update(Entity), create(Entity), read(ID), delete(ID, crup, nombre)
	
	Empleados buscarPorCurp(String curp);
	
}

// Moverle codigo para ejemplo