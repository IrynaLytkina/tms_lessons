package org.example;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/create")
public class CarCreate extends HttpServlet {

    CarInterface carInterface = new CarService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/create.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        int id = Integer.parseInt(req.getParameter("id"));
        String model = req.getParameter("model");
        String year = req.getParameter("year");
        int cost = Integer.parseInt(req.getParameter("cost"));

        Car car = new Car(id, model, year, cost);

        carInterface.save(car);
        List<Car> all = carInterface.getAll();
        req.setAttribute("cars", all);

        resp.sendRedirect("/");
    }
}
