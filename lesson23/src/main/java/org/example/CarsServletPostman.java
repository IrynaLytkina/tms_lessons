package org.example;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.time.LocalTime;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/cars")                                                      // 9. Сделать настройки структуры через аннотации

public class CarsServletPostman extends HttpServlet {
    private Map<String, String> cars = new HashMap<>();
    private LocalTime lastRequest;

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.addCookie(new Cookie("Request",String.valueOf(lastRequest)));   // 4. Вернуть в куках время последнего обращения к серверу
        lastRequest = LocalTime.now();
        req.getSession();
        super.service(req, resp);

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Enumeration<String> parameterNames = req.getParameterNames();             // 3а. Получать список всех машин
        while (parameterNames.hasMoreElements()) {
            String key = parameterNames.nextElement();
            System.out.println("Cars " + key + " ---> " + req.getParameter(key));
        }

        String three = req.getParameter("three");                          // 3b. Получить машину по ее id
        System.out.println(three);

        String six = req.getParameter("six");                              // 3c. Сохранить данные о новой машине
        resp.getOutputStream().print(cars.get(six));

        resp.sendRedirect("http://127.0.0.1:8080/lesson23-0.1/cars.html");  // 8. Проверить редирект на html страницу

        req.getSession();

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String six = req.getParameter("six");                    // 3d. Обновить данные существующих машин
        String seven = req.getParameter("seven");
        cars.put(six, seven);

    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String six = req.getParameter("six");                     // 3e. Удалить машину
        cars.remove(six);

    }
}