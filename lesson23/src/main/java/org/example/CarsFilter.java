package org.example;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter("/*")                                                       // 9. Сделать настройки структуры через аннотации

public class CarsFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        if (((HttpServletRequest) request).getMethod().equalsIgnoreCase("get")) { // 6. Создать фильтр, который будет отклонять все запросы если в
            chain.doFilter(request, response);                                               // реквест хидере нет спец параметра (разрешать при этом get запросы)
        }

        String special = ((HttpServletRequest) request).getHeader("Special");

        if (special == null) {
            throw new ServletException("Enter Special");
        } else {
            chain.doFilter(request, response);
        }
    }

    @Override
    public void destroy() {

    }
}
