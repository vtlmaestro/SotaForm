package controllers;

import java.io.File;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import static dao.impl.CrudDAO.LAST_TASK_ID;


@WebServlet(name = "AddImageServlet", urlPatterns={"/addimageservlet"})
@MultipartConfig(fileSizeThreshold=1024*1024*10, // 10 MB
        maxFileSize=1024*1024*50, // 50 MB
        maxRequestSize=1024*1024*100) // 100 MB
public class AddImageServlet extends HttpServlet {

    private static final long serialVersionUID = 205242440643911308L;

    /**
     * Directory where uploaded files will be saved, its relative to
     * the web application directory.
     */
//    public static String NewNameDir = String.valueOf(LAST_TASK_ID);

    private static String UPLOAD_DIR = "ImageForTasks\\";


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding ("UTF-8");
        int lastInsertId = LAST_TASK_ID;
        request.setAttribute("lastInsertId", lastInsertId);
        // gets absolute path of the web application
//        String applicationPath = request.getServletContext().getRealPath("");
        String applicationPath = "D:\\imageSotaForm";
        // constructs path of the directory to save uploaded file
        String uploadFilePath = applicationPath + File.separator + UPLOAD_DIR + LAST_TASK_ID;
//        String uploadFilePath = applicationPath + File.separator + LAST_TASK_ID;

        // creates the save directory if it does not exists
        File fileSaveDir = new File(uploadFilePath);
        if (!fileSaveDir.exists()) {
            fileSaveDir.mkdirs();
        }
        System.out.println("Upload File Directory="+fileSaveDir.getAbsolutePath());

        String fileName = null;
        //Get all the parts from request and write it to the file on server
        for (Part part : request.getParts()) {
            fileName = getFileName(part);
            try {
                part.write(uploadFilePath + File.separator + fileName);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        request.setAttribute("message", " ???????????? ?????????????????? ??????????????!");
        request.getRequestDispatcher("pages/common/response.jsp").forward(request, response);
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

