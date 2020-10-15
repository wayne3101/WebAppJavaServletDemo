package org.webappjava.controller.web;



import org.webappjava.dao.ICategoryDAO;
import org.webappjava.service.ICategoryService;
import org.webappjava.service.INewsService;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/Home"})
public class HomeController extends HttpServlet {

    @Inject
    private ICategoryService categoryService;

    @Inject
    private INewsService newsService;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        long categoryId = 1L;
        request.setAttribute("categories", categoryService.findAll());
        request.setAttribute("news", newsService.findByCategoryId(categoryId));
        RequestDispatcher rd = request.getRequestDispatcher("/views/web/home.jsp");
        rd.forward(request, response);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

}
