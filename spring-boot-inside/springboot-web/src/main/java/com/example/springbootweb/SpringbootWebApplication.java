package com.example.springbootweb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;

@ServletComponentScan
@SpringBootApplication
public class SpringbootWebApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringbootWebApplication.class, args);
    }

    @Configuration
    class Config {
        @Bean
        public FilterRegistrationBean filterRegistrationBean() {
            FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
            filterRegistrationBean.setFilter(
                    (request, response, chain) -> {
                        response.getWriter().println("anonymous filter");
                        chain.doFilter(request, response);
                    });
            filterRegistrationBean.setUrlPatterns(Collections.singleton("/*"));
            return filterRegistrationBean;
        }

        @Bean
        public ServletRegistrationBean servletRegistrationBean() {
            ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean();
            servletRegistrationBean.setServlet(
                    new HttpServlet() {
                        @Override
                        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
                            resp.getWriter().println("anonymous servlet");
                        }
                    });
            servletRegistrationBean.setUrlMappings(Collections.singleton("/echo2"));
            return servletRegistrationBean;
        }
    }
}
