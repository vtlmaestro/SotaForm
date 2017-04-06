package controllers;

//import com.aspose.words.Document;
//import com.aspose.words.PdfCompliance;
//import com.aspose.words.SaveFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import static controllers.GetTaskServlet.listFileName;

/**
 * Created by v_minjajlo on 13.03.2017.
 */
@WebServlet(name = "LoadFileServlet", urlPatterns={"/loadfile"})
public class LoadFileServlet extends HttpServlet {

    private String docx = ".docx";
    private String pdf = ".pdf";
    private String png = ".png";
    private String txt = ".txt";
    private String jpg = ".jpg";
    private String changePath = null;
    /**
     * Called from the web-app index page (because the POST method is chosen for the input form).
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//        response.setHeader("Expires", "Mon, 26 Jul 1997 05:00:00 GMT");
//        response.setHeader("Cache-Control", "no-cache, must-revalidate");
//        response.setHeader("Cache-Control", "post-check=0,pre-check=0");
//        response.setHeader("Cache-Control", "max-age=0");
//        response.setHeader("Pragma", "no-cache");

        String path = null;
        int index = Integer.parseInt(String.valueOf(request.getParameter("id")));
        for (int i = 0; i < listFileName.size(); i++) {
            if (i == index) {
                path = String.valueOf(listFileName.get(i));
            }
        }

        changePath = path.replace('\\', '/');

        // Get the output format selected by the user.
        String formatType = "DOC";

//        try {
            // Open the stream. Read only access is enough for Aspose.Words to load a document.
//            InputStream stream = new FileInputStream(changePath);

            // Load the entire document into memory.
//            com.aspose.words.Document doc = new com.aspose.words.Document(stream);
//            com.aspose.words.PdfCompliance = new com.aspose.words.PdfCompliance(stream);

            // You can close the stream now, it is no longer needed because the document is in memory.
//            stream.close();

            // Once we have a document, we can save it to a file, stream or send to the client's browser.
            // We just send the document to the browser in this case.
//            sendToBrowser(doc, changePath, formatType, true, response);
//            response.flushBuffer();
//        }
//        catch (Exception e)
//        {
//            throw new RuntimeException(e);
//        }
//    }

            /**
             * Sends the document to the client's browser.
             */
//    private void sendToBrowser(Document doc, String demoName, String formatType, boolean openNewWindow, HttpServletResponse response)
//            throws Exception {
//        String extension = formatType;
//
//        String fileName = demoName + "." + extension;
//
//        // Add the Response header
//        if (openNewWindow)
//            response.setHeader("content-disposition", "attachment; filename=" + fileName);
//        else
//            response.addHeader("content-disposition", "inline; filename=" + fileName);
//
//
//        response.setContentType("application/msword");
//        doc.save(response.getOutputStream(), SaveFormat.DOC);
//        if (changePath.endsWith(docx)) { // проверка расширения файла
//            response.setContentType("application/msword");
//            doc.save(response.getOutputStream(), SaveFormat.DOC);
//        } else {
//            if (changePath.endsWith(pdf)) {
//                response.setContentType("application/pdf");
//                doc.save(response.getOutputStream(), SaveFormat.PDF);
//            } else {
//                if (changePath.endsWith(png)) {
//                    response.setContentType("png");
//                    doc.save(response.getOutputStream(), SaveFormat.PNG);
//                }else {
//                    if(changePath.endsWith(txt)){
//                        response.setContentType("txt");
//                        doc.save(response.getOutputStream(), SaveFormat.TEXT);
//                    }else {
//                        if(changePath.endsWith(jpg)){
//                            response.setContentType("jpeg");
//                            doc.save(response.getOutputStream(), SaveFormat.JPEG);
//                        }
//                    }
//                }
//            }
//        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
