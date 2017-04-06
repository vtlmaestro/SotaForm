package controllers;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;



/**
 * Created by v_minjajlo on 23.01.2017.
 */
@WebServlet(name = "ShowImageServlet", urlPatterns={"/showimage"})
@MultipartConfig(fileSizeThreshold=1024*1024*10, // 10 MB
        maxFileSize=1024*1024*50, // 50 MB
        maxRequestSize=1024*1024*100) // 100 MB
public class ShowImageServlet extends HttpServlet {

    private String docx = ".docx";
    private String pdf = ".pdf";
    private String png = ".png";
    private String txt = ".txt";
    private String jpg = ".jpg";
    private int idTask;
    private String fileName;


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        request.setCharacterEncoding("UTF-8");
//        response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1
//        response.setHeader("Pragma", "no-cache"); // HTTP 1.0
//        response.setDateHeader("Expires", 0); // Proxies.
        response.setHeader("Expires", "Mon, 26 Jul 1997 05:00:00 GMT");
        response.setHeader("Cache-Control", "no-cache, must-revalidate");
        response.setHeader("Cache-Control", "post-check=0,pre-check=0");
        response.setHeader("Cache-Control", "max-age=0");
        response.setHeader("Pragma", "no-cache");

        idTask = Integer.parseInt(String.valueOf(request.getParameter("idTask")));
        fileName = request.getParameter("name");

        String dirName = "D:\\imageSotaForm\\ImageForTasks\\"+idTask+"\\"+fileName;

        File fileName = new File(dirName);
        byte[] screen = getBytesFromFile(fileName);

        if (dirName.endsWith(docx)) { // проверка расширения файла
            response.setContentType("application/msword");
        } else {
            if (dirName.endsWith(pdf)) {
                response.setContentType("application/pdf");
            } else {
                if (dirName.endsWith(png)) {
                    response.setContentType("png");
                }else {
                    if(dirName.endsWith(txt)){
                        response.setContentType("txt");
                    }else {
                        if(dirName.endsWith(jpg)){
                            response.setContentType("jpeg");
                        }
                    }
                }
            }
        }

        OutputStream os = response.getOutputStream();
        BufferedOutputStream bos = new BufferedOutputStream(os);
        bos.write(screen, 0, screen.length);
        bos.close();
//        request.getRequestDispatcher("pages/admin/screen.jsp").forward(request,response);
    }


    public synchronized  byte[] getBytesFromFile(File file) throws IOException {
        InputStream is = new FileInputStream(file);
        // Get the size of the file
        long length = file.length();
        if (length > Integer.MAX_VALUE) {
            // File is too large
        }
        // Create the byte array to hold the data
        byte[] bytes = new byte[(int) length];
        // Read in the bytes
        int offset = 0;
        int numRead = 0;
        while (offset < bytes.length && (numRead = is.read(bytes, offset, bytes.length - offset)) >= 0) {
            offset += numRead;
        }
        // Ensure all the bytes have been read in
        if (offset < bytes.length) {
            throw new IOException("Could not completely read file " + file.getName());
        }
        // Close the input stream and return bytes
        is.close();
        return bytes;
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
