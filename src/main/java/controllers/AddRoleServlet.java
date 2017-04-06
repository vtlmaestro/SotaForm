package controllers;

import dto.RoleDTO;
import service.impl.RoleServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Vitaliy on 30.07.2016.
 */
@WebServlet(name = "AddRoleServlet", urlPatterns={"/addRoleServlet"})
public class AddRoleServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String role = request.getParameter("role_name");

        RoleDTO roleDTO = new RoleDTO(role);

        RoleServiceImpl.getInstance().upload(roleDTO);
        request.getRequestDispatcher("pages/common/done.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
