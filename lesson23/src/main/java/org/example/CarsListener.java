package org.example;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener                                                     // 9. Сделать настройки структуры через аннотации
public class CarsListener implements HttpSessionListener {

    @Override
    public void sessionCreated(HttpSessionEvent se) {            // 7. Создать листенер для логирования при создании сессии
        HttpSession session = se.getSession();
        Integer count = (Integer) session.getAttribute("count");
        if (count == null) {
            session.setAttribute("count", 1);
        } else {
            session.setAttribute("count", count + 1);
        }
        System.out.println("sessionCreated - " + count);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        HttpSession session = se.getSession();
        Integer count = (Integer) session.getAttribute("count");
        if (count == null) {
            session.setAttribute("count", 1);
        } else {
            session.setAttribute("count", count + 1);
        }
        System.out.println("sessionDestroyed - " + session);
    }
}
