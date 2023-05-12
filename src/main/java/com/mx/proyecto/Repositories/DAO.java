package com.mx.proyecto.Repositories;

import java.io.Serializable;

public interface DAO<T, PK> extends Serializable{
	PK create(final T newInstance);

	   T read(final PK id);

	   void update(final T transientObject);

	   void delete(final PK persistentObjectId);

	   void updateWithNoFlush(final T transientObject);

	   void flush();

	   void saveOrUpdate(final T transientObject);
}
