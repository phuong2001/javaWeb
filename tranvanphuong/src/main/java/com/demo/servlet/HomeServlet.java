package com.demo.servlet;

import com.demo.dao.PhoneDao;
import com.demo.entity.PhoneEntity;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "HomeServlet",urlPatterns = {"/home"})
public class HomeServlet extends HttpServlet {
   PhoneDao dao = new PhoneDao();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<PhoneEntity> phones = dao.getAllPhone();
        request.setAttribute("phones", phones);
        request.getRequestDispatcher("listphone.jsp").forward(request, response);
    }

    private void addPhone(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        String name = request.getParameter("name");
        int price = java.lang.Integer.parseInt(request.getParameter("price"));
        String brand = request.getParameter("brand");
        String description = request.getParameter("description");
        PhoneEntity phones = new PhoneEntity(name,price,brand,description);
        dao.insertPhone(phones);
        response.sendRedirect("phone");
    }
}
