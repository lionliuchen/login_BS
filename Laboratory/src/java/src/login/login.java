/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.login;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import src.DB.DBPool;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpSession;
import java.util.Date;

/**
 *
 * @author Tom
 */
public class login extends HttpServlet {

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
        try {
            
            HttpSession session=request.getSession();
            response.setContentType("text/html;charset=UTF-8");
            
            String name=request.getParameter("para1");
            String pwd=request.getParameter("para2");
            Connection con=DBPool.getInstance().getConnection();
            Statement stmt=con.createStatement();
            ResultSet rs=stmt.executeQuery("select * from user where name='"+name+"' and password='"+pwd+"'");
            if(rs.next()){
                session.setAttribute("name", name);
                session.setAttribute("id", rs.getInt(1));
                session.setAttribute("roleid",rs.getInt(10));
                session.setAttribute("phone", rs.getString(9));
                session.setAttribute("departmentid", rs.getInt(4));
                rs.close();
                stmt.close();
                con.close();
                request.getRequestDispatcher("main.jsp").forward(request, response);
            }else{
                rs.close();
                stmt.close();
                con.close();
                request.getRequestDispatcher("login.jsp").forward(request, response);
            }
        } catch (SQLException ex) {
            Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
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
