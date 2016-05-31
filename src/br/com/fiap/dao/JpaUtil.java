/**
 * 
 */
package br.com.fiap.dao;

import javax.persistence.*;

/**
 * 20160518-Exercise03-JPA / JpaUtil.java
 * FIAP / RM30222 - Vagner Panarello
 */
public class JpaUtil {

	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("javaWeb_aula01");

	public static EntityManager getEntityManager(){
		return emf.createEntityManager(); 
	}
}
