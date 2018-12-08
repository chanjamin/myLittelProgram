package com.example.springbootweb;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@Component
@WebFilter(value = "/")//注意，这里和url-pattern 是不一样的
public class EchoFilter implements Filter {
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        response.getWriter().println("echo filter");
        System.out.println("filter");
        chain.doFilter(request,response);
    }
}
