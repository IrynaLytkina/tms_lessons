package org.example;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/all")
public class CarList extends HttpServlet {

    CarInterface carInterface = new CarService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String id = req.getParameter("id");
        if (id.isEmpty()) {
            populateCars(req);
            req.getRequestDispatcher("/add.jsp").forward(req, resp);
        } else {
            List<Car> byId = (List<Car>) carInterface.getById(Integer.parseInt(id));
            req.setAttribute("cars", byId);
        }
        
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String search = req.getParameter("search");
        if (search == null) {
            populateCars(req);
        } else {
            List<Car> byId = (List<Car>) carInterface.getById(Integer.parseInt(search));
            req.setAttribute("cars", byId);
        }

        req.getRequestDispatcher("/create.jsp").forward(req, resp);
    }

    private void populateCars(HttpServletRequest request) {
        request.setAttribute("cars", carInterface.getAll());
    }
}