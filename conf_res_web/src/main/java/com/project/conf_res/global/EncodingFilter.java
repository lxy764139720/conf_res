package com.project.conf_res.global;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class EncodingFilter implements Filter {

    private String encoding = "UTF-8";

    public void init(FilterConfig filterConfig) {
        if (filterConfig.getInitParameter("ENCODING") != null) {
            this.encoding = filterConfig.getInitParameter("ENCODING");
        }
    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        request.setCharacterEncoding(this.encoding);
        response.setCharacterEncoding(this.encoding);
        filterChain.doFilter(request, response);
    }

    public void destroy() {
        this.encoding = null;
    }
}
