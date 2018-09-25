<%-- 
    Document   : result
    Created on : 2018-4-1, 13:14:00
    Author     : Tom
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    String flag=request.getParameter("para");
    System.out.println(flag);
    if("true".equals(flag)){
%>
<h3>ok!</h3>
<%
    }else{
%>
<h3>error!</h3>
<%
    }
%>