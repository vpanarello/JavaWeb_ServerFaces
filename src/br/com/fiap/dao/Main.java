/**
 * 
 */
package br.com.fiap.dao;

import java.util.List;

import br.com.fiap.entity.Livro;

/**
 * 20160530_JavaServerFaces / Main.java
 * FIAP / RM30222 - Vagner Panarello
 */
public class Main {


	public static void main(String[] args) {
		
		GenericDao<Livro> daoLivro = new GenericDao<Livro>(Livro.class);
		
		List<Livro> livros = daoLivro.listar();
		
		for(Livro li : livros){
			System.out.printf("Titulo: %s%n", li.getTitulo());
		}
		

		
		
	}

}
