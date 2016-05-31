/**
 * 
 */
package br.com.fiap.dao;

import java.util.List;


import javax.persistence.EntityManager;
import javax.persistence.Query;


/**
 * 20160518-Exercise03-JPA / GenericDao.java
 * FIAP / RM30222 - Vagner Panarello
 */

public class GenericDao<T> implements Dao<T> {

	private final Class<T> classe;
	protected EntityManager em;
	
	public GenericDao(Class<T> classe) {
		this.classe = classe;
	}
	
	@Override
	public void adicionar(T entidade) {
			em = JpaUtil.getEntityManager();
			em.getTransaction().begin();
			em.persist(entidade);
			em.getTransaction().commit();
			em.close();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<T> listar() {
		em = JpaUtil.getEntityManager();
		return em.createQuery("From " + classe.getSimpleName()).getResultList();
	}	
	
	@Override
	public void atualizar(T entidade) {
		em = JpaUtil.getEntityManager();
		em.getTransaction().begin();
		em.merge(entidade);
		em.getTransaction().commit();
		em.close();
	}
	
	@Override
	public void remover(T entidade) {
		em = JpaUtil.getEntityManager();
		em.getTransaction().begin();
		em.remove(em.merge(entidade));
		em.getTransaction().commit();
		em.close();
	}
	
	@Override
	public T buscar(int id) {
		em = JpaUtil.getEntityManager();
		em.getTransaction().begin();
		T entidade = em.find(classe,id);
		em.getTransaction().commit();
		em.close();
		return entidade;
	}
	
	@SuppressWarnings("unchecked")
	public List<T> buscar(String targetColumn, String lookupValue){
		em = JpaUtil.getEntityManager();
		em.getTransaction().begin();
		String tableEntity =  classe.getSimpleName();
		Query q = em.createQuery("select p from " + tableEntity + " p where p."+ targetColumn +" = :var");
		q.setParameter("var", lookupValue);
		List<T> result = (List<T>) q.getResultList();
		em.getTransaction().commit();
		em.close();
		return result;
	}
	
	
	@SuppressWarnings("unchecked")
	public T authentication(String userName, String userPwd) {
		em = JpaUtil.getEntityManager();
		em.getTransaction().begin();
		
		T entidade = (T)em.
				createQuery("From " + classe.getSimpleName() + 
						" Where user = :nome And pwd = :senha")
				.setParameter("nome", userName)
				.setParameter("senha", userPwd)				
				.getSingleResult();
		
		em.getTransaction().commit();
		em.close();

		return entidade;
	}
	
}
