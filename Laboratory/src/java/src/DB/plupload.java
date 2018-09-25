/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.DB;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.UUID;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;

/**
 *
 * @author Tom
 */
public class plupload extends HttpServlet {
    
    private static final long serialVersionUID = 1L;
    String repositoryPath;
    String uploadPath;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        System.out.println("uploadimage start..........");
        Integer schunk = null;//分割块数
        Integer schunks = null;//总分割数
        String name = null;//文件名
        BufferedOutputStream outputStream = null;
        if (ServletFileUpload.isMultipartContent(request)) {
            try {
                DiskFileItemFactory factory = new DiskFileItemFactory();
                factory.setSizeThreshold(1024);
                factory.setRepository(new File(repositoryPath));//设置临时目录
                ServletFileUpload upload = new ServletFileUpload(factory);
                upload.setHeaderEncoding("UTF-8");
                upload.setSizeMax(5 * 1024 * 1024);//设置附近大小
                List<FileItem> items = upload.parseRequest(request);
                //生成新文件名
                String newFileName = null;
                for (FileItem item : items) {
                    if (!item.isFormField()) {// 如果是文件类型
                        name = item.getName();// 获得文件名
                        newFileName = UUID.randomUUID().toString().replace("-", "").concat(".").concat(FilenameUtils.getExtension(name));
                        if (name != null) {
                            String nFname = newFileName;
                            if (schunk != null) {
                                nFname = schunk + "_" + name;
                            }
                            File savedFile = new File(uploadPath, nFname);
                            item.write(savedFile);
                        }
                    } else {
                        //判断是否带分割信息
                        if (item.getFieldName().equals("chunk")) {
                            schunk = Integer.parseInt(item.getString());
                        }
                        if (item.getFieldName().equals("chunks")) {
                            schunks = Integer.parseInt(item.getString());
                        }
                    }
                }

                if (schunk != null && schunk + 1 == schunks) {
                    outputStream = new BufferedOutputStream(new FileOutputStream(new File(uploadPath, newFileName)));
                    //遍历文件合并
                    for (int i = 0; i < schunks; i++) {
                        File tempFile = new File(uploadPath, i + "_" + name);
                        byte[] bytes = FileUtils.readFileToByteArray(tempFile);
                        outputStream.write(bytes);
                        outputStream.flush();
                        tempFile.delete();
                    }
                    outputStream.flush();
                }
                response.getWriter().write("true~"+newFileName);
            } catch (FileUploadException e) {
                e.printStackTrace();
                response.getWriter().write("false");
            } catch (Exception e) {
                e.printStackTrace();
                response.getWriter().write("false");
            } finally {
                try {
                    if (outputStream != null) {
                        outputStream.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    
    public void init(ServletConfig config) throws ServletException {
        repositoryPath = FileUtils.getTempDirectoryPath();
        uploadPath = config.getInitParameter("uploadPath");
        System.out.println(uploadPath);
        File up;
        up = new File(uploadPath);
        if (!up.exists()) {
            up.mkdir();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
