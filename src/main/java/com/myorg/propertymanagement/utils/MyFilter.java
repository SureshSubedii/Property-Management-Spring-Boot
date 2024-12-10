package com.myorg.propertymanagement.utils;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

@WebFilter("/*") // This will log all HTTP requests
public class MyFilter implements Filter {
    private Logger logger = LoggerFactory.getLogger(MyFilter.class);

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;

        logger.info("Current Route: {}", httpRequest.getRequestURI());
        chain.doFilter(request, response);

    }
}
