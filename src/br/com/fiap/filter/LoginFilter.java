/**
 * 
 */
package br.com.fiap.filter;

import java.io.IOException;
import java.util.Map;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.fiap.entity.Usuario;


/* Filtro aplicável somente as classes especificadas */
@WebFilter("/admin/*")
public class LoginFilter implements Filter {

 
    public LoginFilter() {

    }


	public void destroy() {

	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		System.out.print("PassingFilter: ");
		
		
		HttpSession session = ((HttpServletRequest)request).getSession(false);
		Usuario user = (Usuario)session.getAttribute("userSession");
		
		
		if (user == null){
			System.out.println("return to login");
			((HttpServletResponse)response)
				.sendRedirect(
						((HttpServletRequest)request)
							.getContextPath() + "/login.faces");
			
		} else {
			System.out.println(user.getNome());
			chain.doFilter(request, response);
		}
		
		
		
		
		
		
		
	
		
//		HttpSession session = ((HttpServletRequest)request).getSession();
//		Usuario user = (Usuario)session.getAttribute("usuario_sessao");
//		
//		if(user == null){
//			((HttpServletResponse)response).sendRedirect("/aula01/bemvindo");
//		}else {
//			// pass the request along the filter chain
//			System.out.printf("Usuário Logado: %s%n", user.getNome());
			
				
		}
		
	

	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
