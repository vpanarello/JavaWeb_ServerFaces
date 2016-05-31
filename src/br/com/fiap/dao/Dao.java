/**
 * 
 */
package br.com.fiap.dao;
import java.util.List;

/**
 * 20160518-Exercise03-JPA / Dao.java
 * FIAP / RM30222 - Vagner Panarello
 */
public interface Dao<T> {
	
	void adicionar(T entidade);
	List<T> listar();
	void atualizar(T entidade);
	void remover(T entidade);
	T buscar(int id);
	
}
