package br.com.fiap.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.com.fiap.dao.GenericDao;
import br.com.fiap.entity.Livro;
import br.com.fiap.entity.Usuario;

@ManagedBean
@RequestScoped
public class UsuariosBean {
	private Usuario usuario;

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public String cadastrarUsuario(){
		GenericDao<Usuario> dao = new GenericDao<Usuario>(Usuario.class);
		
		try {
			dao.adicionar(this.usuario);
			return "sucesso";
		} catch (Exception e) {
			e.printStackTrace();
			return "erro";
		}
	}
	
	public String validaUsuario(){
		GenericDao<Usuario> dao = new GenericDao<Usuario>(Usuario.class);
		
		
		
		
		return null;
	}
}
