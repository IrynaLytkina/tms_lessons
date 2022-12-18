package org.example;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter("/*")                                                                    // 9. Сделать настройки структуры через аннотации

public class CarsFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        String special = ((HttpServletRequest) request).getHeader("Special");   // 6. Создать фильтр, который будет отклонять все запросы если в
                                                                                      // реквест хидере нет спец параметра
        if (special == null && special.equalsIgnoreCase("Special")) {
            System.out.println("Access is allowed");
        } else {
            System.out.println("Access is denied");
        }

        String method = ((HttpServletRequest) request).getMethod();

        if ("GET".equalsIgnoreCase(method)) {                                         // разрешать при этом get запросы
            chain.doFilter(request, response);
        }
    }

    @Override
    public void destroy() {

    }
}
