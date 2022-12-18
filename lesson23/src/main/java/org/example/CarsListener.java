package org.example;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener                                                     // 9. Сделать настройки структуры через аннотации
public class CarsListener implements HttpSessionListener {

    @Override
    public void sessionCreated(HttpSessionEvent se) {             // 7. Создать листенер для логирования при создании сессии

        String id = se.getSession().getId();
        System.out.println("Session ------> " + id);

    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {

    }
}
