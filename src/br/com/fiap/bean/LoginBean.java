package br.com.fiap.bean;


import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;



import br.com.fiap.dao.GenericDao;
import br.com.fiap.entity.Usuario;


@ManagedBean
@RequestScoped
public class LoginBean {
	
	private String nome;
	private String senha;
	

    public LoginBean() {
    	nome = senha = "";
      
    }
    
    public String autenticaUsuario(){
    	
    	boolean userFound = false;
    	
    	GenericDao<Usuario> daoUsuario =  new GenericDao<Usuario>(Usuario.class);
    	
    	List<Usuario> users = daoUsuario.listar();
    	Usuario authUser = null;
    
    	for(Usuario u : users){
    		if(u.getNome().equals(this.nome)){
    			userFound = true;
    			System.out.println(u.getNome() + " " + u.getSenha() + " " + u.getId() );
    			if(Integer.parseInt(senha) == Integer.parseInt(u.getSenha())) {
    				authUser = u;
    				break;
    			}
    		}
    	}
    	
    	
    	if (!userFound) {
    		System.out.println("Usuário não encontrado");
    		return "falha";
    	}
    	else if(authUser == null){
    		System.out.println("Senha incorreta");
	    	return "falha";
    	}
    
    	else {
    		ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
    		Map<String,Object> sessionMap = context.getSessionMap();
    		sessionMap.put("userSession", authUser);
    		
    		System.out.println("sucesso");
    		
    		try {
				context.redirect(context.getRequestContextPath() + "/admin/Menu.xhtml");
			} catch (IOException e) {
				e.printStackTrace();
			}

	    	return "sucesso";
    	}
   
    }
    
    
    
    
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}

}
