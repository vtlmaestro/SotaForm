package controllers;

import dto.UserDTO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by v_minjajlo on 03.02.2017.
 */
@WebServlet(name = "AddCommentServlet", urlPatterns={"/addcomment"})
public class AddCommentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int id_task = Integer.parseInt(String.valueOf(request.getParameter("id")));
        request.setAttribute("id_task", id_task);
        UserDTO userDTO = (UserDTO) request.getSession().getAttribute("user");
        if (userDTO != null) {
            request.getRequestDispatcher("pages/user/addcommentform.jsp").forward(request,response);
        }else{
            request.getSession().setAttribute("id_task", id_task);
            response.sendRedirect(request.getContextPath() + "/pages/user/addcommentform.jsp");
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
