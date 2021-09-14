package com.usta.cmapp.security;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.*;

import com.usta.cmapp.control.LoginController;

public class FilterCheck implements Filter{

	private FilterConfig config;
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		this.config = filterConfig;
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		if (((HttpServletRequest)request).getSession().getAttribute(LoginController.AUTH_KEY)==null){
			((HttpServletResponse)response).sendRedirect("../login/login.faces");
		}else{
			chain.doFilter(request, response);
		}	
	}

	@Override
	public void destroy() {
		config = null;
	}

}
