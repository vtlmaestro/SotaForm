package controllers;

import dto.AnswerTaskDTO;
import dto.ClientDTO;
import dto.RoleDTO;
import dto.UserDTO;
import helpers.NewSimpleMail;
import service.impl.AnswerTaskServiceImpl;
import service.impl.ClientServiseImpl;
import service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.util.Objects;


/**
 * Created by v_minjajlo on 01.02.2017.
 */
@WebServlet(name = "AddAnswerServlet", urlPatterns={"/addanswer"})
@MultipartConfig(fileSizeThreshold=1024*1024*10, // 10 MB
        maxFileSize=1024*1024*50, // 50 MB
        maxRequestSize=1024*1024*100) // 100 MB
public class AddAnswerServlet extends HttpServlet {

    private static final long serialVersionUID = -7460489985568487062L;
    private static String UPLOAD_DIR = "ImageForTasks\\";
    private String fileName = null;
    private String notFileName = "";


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        String answerTask = request.getParameter("comment");
        int id_task = Integer.parseInt(String.valueOf(request.getParameter("id")));
        String dateComment = request.getParameter("datetask");
        UserDTO userDTO = (UserDTO) request.getSession().getAttribute("user");

        String firstName = userDTO.getFirstName();
        String lastName = userDTO.getLastName();
        String authorAnswerFromSession = firstName.concat(" " + lastName);
        String loginAuthorAnswerFromSession = userDTO.getLogin();

        AnswerTaskDTO answerTaskDTO = new AnswerTaskDTO(answerTask, authorAnswerFromSession, dateComment);
        answerTaskDTO.setId(id_task);
        AnswerTaskServiceImpl.getInstance().InsertAnswer(answerTaskDTO);

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
                uploadFilePath = applicationPath + File.separator + UPLOAD_DIR + id_task;
            } else {
                uploadFilePath = applicationPath + File.separator + UPLOAD_DIR;
            }
        }

        // creates the save directory if it does not exists
        File fileSaveDir = new File(uploadFilePath);
        if (!fileSaveDir.exists()) {
            fileSaveDir.mkdirs();
        }///
        System.out.println("Upload File Directory=" + fileSaveDir.getAbsolutePath());

        //Get all the parts from request and write it to the file on server
        for (Part part : request.getParts()) {
            fileName = getFileName(part);
            try {
                part.write(uploadFilePath + File.separator + fileName);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        answerTask = answerTask +". Для просмотра перейдите по ссылке: http://192.168.109.35:8087/sotaForm/gettaskservlet?id=" + id_task;
        String addComment = "Добавлен комментарий к задаче " + id_task + ": ";
        addComment = addComment.concat(authorAnswerFromSession);

        ClientDTO clientDTO = null;
        try {
            clientDTO = ClientServiseImpl.getInstance().getById(id_task);
        } catch (Exception e) {
            e.printStackTrace();
        }
        int authorInternTell = 0;
        try {
            authorInternTell = clientDTO.getInternaltelauthor();
        } catch (Exception e) {
            e.printStackTrace();
        }
        // получаем пользователя по внутреннему номеру;
        UserDTO userDtoByInternTell = null;
        try {
            userDtoByInternTell = UserServiceImpl.getInstance().getUserByInnerTell(authorInternTell);
        } catch (Exception e) {
            e.printStackTrace();
        }
        String authorLoginTaskFromClientDTO = null;
        try {
            authorLoginTaskFromClientDTO = userDtoByInternTell.getLogin();
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            String authorNameTaskClientDTO = clientDTO.getAuthorTask();
        } catch (Exception e) {
            e.printStackTrace();
        }


        String login = null;
        String password = null;
        String sender = null;
        String recipient = null;

//        if(!authorNameTaskClientDTO.equals(authorAnswerFromSession)){
        try {
            if(!authorLoginTaskFromClientDTO.equals(loginAuthorAnswerFromSession)){
                sender = "v_minjajlo@intelserv.com";
                login = "v_minjajlo";
                password = "123";
                recipient = userDtoByInternTell.getEmail();
            }else{
                sender = userDTO.getEmail();
                login = userDTO.getLogin();
                password = userDTO.getPassword();
                recipient = "v_minjajlo@intelserv.com";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            NewSimpleMail newSimpleMail = new NewSimpleMail(login, password);
            newSimpleMail.sendMail(addComment, answerTask, sender, recipient);
        } catch (Exception e) {
            e.printStackTrace();
        }

        request.setAttribute("id_task", id_task);
        request.getRequestDispatcher("pages/common/updatesuccess.jsp").forward(request, response);

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
