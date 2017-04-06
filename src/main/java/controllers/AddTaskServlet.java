package controllers;

import dto.*;
import helpers.MyUtilMail;
import helpers.NewSimpleMail;
import service.impl.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

import static dao.impl.CrudDAO.LAST_TASK_ID;

/**
 * Created by v_minjajlo on 03.11.2016.
 */
@WebServlet(name = "AddTaskServlet", urlPatterns={"/addtaskservlet"})
@MultipartConfig(fileSizeThreshold=1024*1024*10, // 10 MB
        maxFileSize=1024*1024*50, // 50 MB
        maxRequestSize=1024*1024*100) // 100 MB
public class AddTaskServlet extends HttpServlet {

    private static final long serialVersionUID = 205242440643911308L;
    private static String UPLOAD_DIR = "ImageForTasks\\";
    private String fileName = null;
    private String notFileName = "";

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding ("UTF-8");
        response.setHeader("Expires", "Mon, 26 Jul 1997 05:00:00 GMT");
        response.setHeader("Cache-Control", "no-cache, must-revalidate");
        response.setHeader("Cache-Control", "post-check=0,pre-check=0");
        response.setHeader("Cache-Control", "max-age=0");
        response.setHeader("Pragma", "no-cache");

        String dateTaskDTO = request.getParameter("datetask");
        String description = request.getParameter("description");
        String texterror = request.getParameter("texterror");
        String subject = request.getParameter("subject");

        TaskDTO taskDTO = new TaskDTO();
        taskDTO.setDateTask(dateTaskDTO);
        taskDTO.setTextError(texterror);
        taskDTO.setDescription(description);
        taskDTO.setSubject(subject);
        TaskServiceImpl.getInstance().upload(taskDTO);

        ClientDTO clientDTO = new ClientDTO();
        UserDTO userDTO = (UserDTO) request.getSession().getAttribute("user");
        String firstName = userDTO.getFirstName();
        String lastName = userDTO.getLastName();
        String authorTask = firstName.concat(" "+lastName);
        int internalTelAuthor = userDTO.getInnerTell();

        String email = request.getParameter("email");
        String edrpou = request.getParameter("edrpou");
        String phoneClient = request.getParameter("phoneclient");
//        String authorTask = request.getParameter("authorquest");
//        int internaltelauthor = Integer.valueOf(request.getParameter("phoneauthorquest"));

        clientDTO.setAuthorTask(authorTask);
        clientDTO.setEdrpou(edrpou);
        clientDTO.setEmail(email);
        clientDTO.setPhoneClient(phoneClient);
        clientDTO.setInternaltelauthor(internalTelAuthor);
        ClientServiseImpl.getInstance().upload(clientDTO);

        // Загрузка файлов:
        //////////////////////////////////////////////////////////////////////////////////////////
        // gets absolute path of the web application
//        String applicationPath = request.getServletContext().getRealPath("");
        String applicationPath = "D:\\imageSotaForm";

        // constructs path of the directory to save uploaded file
        String uploadFilePath = null;
        for (Part part : request.getParts()) {
            fileName = getFileName(part);
            if (!Objects.equals(notFileName, fileName)) {
                uploadFilePath = applicationPath + File.separator + UPLOAD_DIR + LAST_TASK_ID ;
            } else {
                uploadFilePath = applicationPath + File.separator + UPLOAD_DIR;
            }
        }
        // creates the save directory if it does not exists
        File fileSaveDir = new File(uploadFilePath);
            if (!fileSaveDir.exists()) {
            fileSaveDir.mkdirs();
        }

        System.out.println("Upload File Directory="+fileSaveDir.getAbsolutePath());


        //Get all the parts from request and write it to the file on server
        for (Part part : request.getParts()) {
                fileName = getFileName(part);
                try {
                    part.write(uploadFilePath + File.separator + fileName);
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }
        /////////////////////////////////////////////////////////

        int lastInsertId = LAST_TASK_ID;
        request.setAttribute("lastInsertId", lastInsertId);
//        request.setAttribute("message", " Данные загружены успешно!");

        description = description + ". Для просмотра перейдите по ссылке: http://192.168.109.35:8087/sotaForm/gettaskservlet?id=" + LAST_TASK_ID;
        String login = userDTO.getLogin();
        String password = userDTO.getPassword();
        String sender = userDTO.getEmail();
        String recipient = "v_minjajlo@intelserv.com";
        try {
            NewSimpleMail newSimpleMail = new NewSimpleMail(login, password);
            newSimpleMail.sendMail(subject, description, sender, recipient);
        } catch (Exception e) {
            e.printStackTrace();
        }
        request.getRequestDispatcher("pages/common/response.jsp").forward(request,response);
    }

    /**
     * Utility method to get file name from HTTP header content-disposition
     */
        private String getFileName(Part part) {
        String contentDisp = part.getHeader("content-disposition");
        System.out.println("content-disposition header= "+contentDisp);
        String[] tokens = contentDisp.split(";");
        for (String token : tokens) {
            if (token.trim().startsWith("filename")) {
                return token.substring(token.indexOf("=") + 2, token.length()-1);
            }
        }
        return "";
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
