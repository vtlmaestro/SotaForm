package controllers;

import dto.AnswerTaskDTO;
import service.impl.AnswerTaskServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by v_minjajlo on 10.02.2017.
 */
@WebServlet(name = "SeeCommentServlet", urlPatterns={"/seecomment"})
public class SeeCommentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding ("UTF-8");
        response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1
        response.setHeader("Pragma", "no-cache"); // HTTP 1.0
        response.setDateHeader("Expires", 0); // Proxies.

        request.setCharacterEncoding ("UTF-8");
        Integer task_id = Integer.valueOf(request.getParameter("id"));
        List<AnswerTaskDTO> answerTaskDTOList = null;
        try {
            answerTaskDTOList = AnswerTaskServiceImpl.getInstance().getListCommentById(task_id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        request.setAttribute("task_id", task_id);
        request.setAttribute("answerTaskDTOList", answerTaskDTOList);
        request.getRequestDispatcher("pages/user/answer.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
