package br.com.ddark.repository;

import java.util.List;

import br.com.ddark.entity.AbstractDefaultEntity;

public interface IDefaultRepository<T> {
	
	T findById(Long id);
	
	List<T> findAll();
	
	void delete(Object object);
	
	void save(AbstractDefaultEntity defaultEntity);
	
	void create(Object object);
	
	void update(Object object);

}
