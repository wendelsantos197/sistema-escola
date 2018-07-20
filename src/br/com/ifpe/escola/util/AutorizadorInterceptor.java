package br.com.ifpe.escola.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class AutorizadorInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object controller)
			throws Exception {

		String uri = request.getRequestURI();
		if (uri.contains("bootstrap") || 
			uri.contains("css") || 
			uri.contains("img") || 
			uri.contains("js") || 
			uri.endsWith("sistema-escola/") || 
			uri.endsWith("efetuarLogin") ||
			uri.endsWith("usuario/add") || 
			uri.endsWith("usuario/save")){

			return true;
		}

		if (request.getSession().getAttribute("usuarioLogado") != null) {
			return true;
		}

		response.sendRedirect("/sistema-escola");
		return false;
	}
}