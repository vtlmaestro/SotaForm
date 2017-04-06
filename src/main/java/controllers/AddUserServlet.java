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
 * Created by v_minjajlo on 26.07.2016.
 */
@WebServlet(name = "AddUserServlet", urlPatterns={"/addUserServlet"})
public class AddUserServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String login = request.getParameter("login");
        String password = request.getParameter("password");
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String email = request.getParameter("email");
        String sex = request.getParameter("sex");
        int innerTell = Integer.parseInt(request.getParameter("innertell"));
//        LocalDate birthday = LocalDate.parse(request.getParameter("birthday"));
        int role_id = Integer.valueOf(request.getParameter("role_id"));
        RoleDTO role = new RoleDTO();
        if(role_id==2) {
            role.setId(2);
        }else{
            role.setId(role_id);
        }

        UserDTO userDTO = new UserDTO(login, password, firstName, lastName, email, sex, innerTell, role);


        UserServiceImpl.getInstance().upload(userDTO);
        request.getRequestDispatcher("pages/common/done.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);

    }
}
