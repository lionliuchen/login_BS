/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import src.DB.DBPool;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Tom
 */
public class commitkb extends HttpServlet {

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
            response.setContentType("text/html;charset=UTF-8");
            Integer week=Integer.parseInt(request.getParameter("para1"));
            String section=request.getParameter("para2");
            Integer classid=Integer.parseInt(request.getParameter("para3"));
            String kcm=request.getParameter("para4");
            String cy=request.getParameter("para5");
            String[] cycle=cy.split("-");            
            Integer roomid=Integer.parseInt(request.getParameter("para6"));
            HttpSession s=request.getSession();
            String username=(String)s.getAttribute("name");
            String phone=(String)s.getAttribute("phone");
            Integer id=(Integer)s.getAttribute("id");
            Connection con=DBPool.getInstance().getConnection();
            ResultSet rs;
            PreparedStatement stmt=con.prepareStatement("insert into timetable(section,classroom_id,user_id,class_id,course,cycle,week) value(?,?,?,?,?,?,?)");
            PreparedStatement pstmt=con.prepareStatement("select * from timetable where class_id=? and section=? and week=? and cycle=?");
            pstmt.setInt(1, classid);
            pstmt.setString(2, section);
            pstmt.setInt(3, week);
            for (String cycle1 : cycle) {
                pstmt.setString(4, cycle1);
                rs=pstmt.executeQuery();
                if(rs.next()){
                    request.getRequestDispatcher("result.jsp?para=false").forward(request, response);
                    break;
                }else{
                    stmt.setString(1,section);
                    stmt.setInt(2, roomid);
                    stmt.setInt(3,id);
                    stmt.setInt(4,classid);
                    stmt.setString(5, kcm);
                    stmt.setInt(7, week);
                    for(String cycle2:cycle){
                        stmt.setString(6, cycle2);
                        stmt.execute();
                    }
                    request.getRequestDispatcher("result.jsp?para=true").forward(request, response);
                }
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(commitkb.class.getName()).log(Level.SEVERE, null, ex);
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
