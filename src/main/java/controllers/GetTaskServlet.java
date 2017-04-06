package controllers;

import dto.ClientDTO;
import dto.TaskDTO;
import service.impl.ClientServiseImpl;
import service.impl.TaskServiceImpl;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Locale;

/**
 * Created by v_minjajlo on 05.01.2017.
 */
@WebServlet(name = "GetTaskServlet", urlPatterns={"/gettaskservlet"})
public class GetTaskServlet extends HttpServlet {

    public static List<File> listFileName = new ArrayList<>();
    String[] arrayOnlyName = null;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding ("UTF-8");
//        response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1
//        response.setHeader("Pragma", "no-cache"); // HTTP 1.0
//        response.setDateHeader("Expires", 0); // Proxies.
        response.setHeader("Expires", "Mon, 26 Jul 1997 05:00:00 GMT");
        response.setHeader("Cache-Control", "no-cache, must-revalidate");
        response.setHeader("Cache-Control", "post-check=0,pre-check=0");
        response.setHeader("Cache-Control", "max-age=0");
        response.setHeader("Pragma", "no-cache");

        Integer task_id = Integer.valueOf(request.getParameter("id"));
        String idTask = String.valueOf(task_id);
        String dirName = "D:\\imageSotaForm\\ImageForTasks\\"+idTask;
        TaskDTO task = null;
        try {
            task = TaskServiceImpl.getInstance().getById(task_id);
        } catch (Exception e) {
            e.printStackTrace();
        }

        ClientDTO clientDTO = null;
        try {
            clientDTO = ClientServiseImpl.getInstance().getById(task_id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        String str = "Вложений нет!";
        request.setAttribute("task", task);
        request.setAttribute("clientDTO", clientDTO);
        request.setAttribute("task_id", task_id);
        File file = new File(dirName);
        if(file.isDirectory()){
            System.out.println ("Kaтaлoг " + dirName);
            File arrayName[] = file.listFiles();
            for (int i = 0 ; i < arrayName.length; i ++) {
                File f = new File(dirName + "/" + arrayName[i]);
                if(f.isDirectory()){
                    System.out.println (arrayName[i]);
                }else{
                    listFileName.add(arrayName[i]);
//                    for (File token : listFileName){
//                        System.out.println(token);
//                    }
                }
            }
        }else{
            request.setAttribute("notFound", str);
            System.out.println (dirName + " - не содержит вложенных файлов!");
        }
        arrayOnlyName = file.list();
        try {
            if (task == null){
                idTask = "Задача с указанным номером не создана!";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        request.setAttribute("idTask", idTask);
        request.setAttribute("arrayOnlyName", arrayOnlyName);
        request.getRequestDispatcher("pages/user/descriptiontask.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}


