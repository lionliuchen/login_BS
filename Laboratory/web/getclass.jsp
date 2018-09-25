<%-- 
    Document   : getclass
    Created on : 2018-3-27, 11:07:23
    Author     : Tom
--%>

<%@page import="src.DB.DBPool"%>
<%@page import="java.sql.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    Integer proid=Integer.parseInt(request.getParameter("para2"));
    Integer gradeid=Integer.parseInt(request.getParameter("para1"));
    Connection con = DBPool.getInstance().getConnection();
    Statement cstmt = con.createStatement();
    ResultSet crs = cstmt.executeQuery("select * from class where profession_id="+proid+" and grade_id="+gradeid);
%>
<select id="class">
    <%
        while (crs.next()) {
    %>
    <option value="<%=crs.getInt(1)%>"><%=crs.getString(2)%></option>
    <%
        }
    %>
</select>