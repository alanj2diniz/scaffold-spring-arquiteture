package br.com.ddark.repository;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.ddark.entity.AbstractDefaultEntity;

@Repository
public class DefaultRepository<T> implements IDefaultRepository<T> {
	
	protected final Logger logger = LoggerFactory.getLogger(getClass());
	
	private Class<T> type;
	
	@PersistenceContext
	private EntityManager entityManager;
	
	public DefaultRepository() {
		Type t = getClass().getGenericSuperclass();
		ParameterizedType pt = (ParameterizedType) t;
		this.type = (Class) pt.getActualTypeArguments()[0];
	}
	
	@Transactional
	public T findById(Long id) {
		return this.entityManager.find(type, id);
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public List<T> findAll() {
		return createSession().createCriteria(type).list();
	}

	@Transactional
	public void delete(Object object) {
		this.entityManager.remove(object);
	}

	@Transactional
	public void save(AbstractDefaultEntity defaultEntity) {
		if(defaultEntity.getCodigo() == null) {
			this.entityManager.persist(defaultEntity);
		} else {
			this.entityManager.merge(defaultEntity);
		}
	}
	
	@Transactional
	public void create(Object object) {
		this.entityManager.persist(object);
	}

	@Transactional
	public void update(Object object) {
		this.entityManager.merge(object);
	}
	protected Session createSession() {
		return (Session) this.entityManager.getDelegate();
	}
	
	protected EntityManager getEntityManager() {
		return this.entityManager;
	}
}
