package com.proj2.corsFilter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CorsFilter implements Filter {

    public CorsFilter() {
    }

	public void destroy() {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;	
		
		// In order for us to accept requests from other domains, we need to add two request headers
		// First being, 'Access-Control-Allow-Origin' with the value being the domain you are requesting from
		//httpResponse.addHeader("Access-Control-Allow-Origin", "http://52.15.180.249:8080");
		httpResponse.addHeader("Access-Control-Allow-Origin", "http://localhost:4200");
		//httpRequest.add

		// The second being, 'Access-Control-Allow-Methods' with the HTTP Methods you grant access to
		httpResponse.addHeader("Access-Control-Allow-Methods", "GET, PUT, POST, DELETE, OPTIONS");
		httpResponse.setHeader("Access-Control-Max-Age", "3600");
	    httpResponse.setHeader("Access-Control-Allow-Headers", "Content-Type, Access-Control-Allow-Headers, Authorization, X-Requested-With");
		
		chain.doFilter(httpRequest, httpResponse);
	}

	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
