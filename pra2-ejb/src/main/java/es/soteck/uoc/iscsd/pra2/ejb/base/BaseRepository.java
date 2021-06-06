package es.soteck.uoc.iscsd.pra2.ejb.base;

import java.io.Serializable;
import java.util.List;

public interface BaseRepository<T> {

	T add(T data);

	void delete(Serializable id);

	T update(Serializable id, T data);

	T get(Serializable id);

	List<T> list();
}
