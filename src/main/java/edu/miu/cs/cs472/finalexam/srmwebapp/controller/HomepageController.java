package edu.miu.cs.cs472.finalexam.srmwebapp.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "HomepageController", urlPatterns = {"", "/home", "/index"})
public class HomepageController extends HttpServlet {

    public HomepageController() {
        // NOOP
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("pagename", "home");
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/views/index.jsp");
        requestDispatcher.forward(request, response);
    }
}
