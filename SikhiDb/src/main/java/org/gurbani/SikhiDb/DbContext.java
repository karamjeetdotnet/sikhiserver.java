package org.gurbani.SikhiDb;

import java.util.Arrays;
import java.util.List;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.gurbani.SikhiDb.Config.HibernateUtil;
import org.hibernate.Session;

public class DbContext<E> {
	protected Session session;
	private Class<E> entityClass;
	public DbContext(Class<E> entityClass) {
		session = HibernateUtil.getCurrentSession();
		this.entityClass = entityClass;
	}
	public E save(E e) {
		List<E> items = saveAll(Arrays.asList(e));
		return items.get(0);
	}
	public void beginTransaction() {
		session.getTransaction().begin();		
	}
	public void commitTransaction() {
		session.getTransaction().commit();		
	}
	public List<E> saveAll(List<E> items) {
		beginTransaction();
		for (E e : items) {
			session.saveOrUpdate(e);
		};
		commitTransaction();
		return items;
	}
	public E find(long id) {
		return session.find(entityClass, id);
	}

	public List<E> findAll() {
		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<E> cq = cb.createQuery(entityClass);
		Root<E> pet = cq.from(entityClass);
		cq.select(pet);
		TypedQuery<E> q = session.createQuery(cq);
		return q.getResultList();
	}

	public void delete(E E) {
		beginTransaction();
		session.delete(E);
		commitTransaction();
	}
}
