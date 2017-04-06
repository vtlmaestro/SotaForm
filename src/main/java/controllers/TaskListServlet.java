package controllers;

import dto.TaskDTO;
import service.impl.TaskServiceImpl;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by v_minjajlo on 30.01.2017.
 */
@WebServlet(name = "TaskListServlet", urlPatterns={"/tasklist"})
public class TaskListServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<TaskDTO> taskDTOList = null;
        try {
            taskDTOList = TaskServiceImpl.getInstance().getAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        request.setAttribute("taskDTOList", taskDTOList);
        request.getRequestDispatcher("pages/common/tasklist.jsp").forward(request,response);
//                try {
//                    taskDTOList.getClass().getField(request.getParameter("id"));
//        } catch (NoSuchFieldException e) {
//            e.printStackTrace();
//        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
