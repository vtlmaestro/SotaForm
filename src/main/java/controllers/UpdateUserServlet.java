package controllers;

import dto.RoleDTO;
import dto.UserDTO;
import service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;

/**
 * Created by v_minjajlo on 29.07.2016.
 */
@WebServlet(name = "UpdateUserServlet", urlPatterns={"/updateUserServlet"})
public class UpdateUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String login = request.getParameter("login");
        String password = request.getParameter("password");
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String email = request.getParameter("email");
        String sex = request.getParameter("sex");
        int innerTell = Integer.parseInt(request.getParameter("innertell"));
//        LocalDate birthday = LocalDate.parse(request.getParameter("birthday"));
        RoleDTO role = new RoleDTO(request.getParameter("role"));
        role.setId(Integer.valueOf(request.getParameter("role_id")));
        int id = Integer.valueOf(request.getParameter("id"));

        UserDTO userDTO = new UserDTO(login, password, firstName, lastName, email, sex, innerTell, role);
        userDTO.setId(id);
        UserServiceImpl.getInstance().update(userDTO);
        request.getRequestDispatcher("pages/common/done.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
