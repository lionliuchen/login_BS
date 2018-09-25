/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.login;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import src.DB.DBPool;

/**
 *
 * @author Tom
 */
public class regist extends HttpServlet {

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
        try {            
            String loginname=request.getParameter("loginname");
            String pwd=request.getParameter("pwd");
            String name=request.getParameter("name");
            String qq=request.getParameter("qq");
            String wechat=request.getParameter("wechat");
            String phone=request.getParameter("phone");
            String tu=request.getParameter("tu");
            String depa=request.getParameter("type");
            Connection con=DBPool.getInstance().getConnection();
            String sql="insert into user(name,password,department_id,realname,QQ,wechat,mobile,photo) values(?,?,?,?,?,?,?,?)";
            PreparedStatement pstmt=con.prepareStatement(sql);
            pstmt.setString(1, loginname);
            pstmt.setString(2, pwd);
            pstmt.setString(3, depa);
            pstmt.setString(4, name);
            pstmt.setString(5, qq);
            pstmt.setString(6, wechat);
            pstmt.setString(7, phone);
            pstmt.setString(8, tu);
            pstmt.execute();
            pstmt.close();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(regist.class.getName()).log(Level.SEVERE, null, ex);
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
