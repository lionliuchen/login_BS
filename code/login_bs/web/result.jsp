<%-- 
    Document   : result
    Created on : 2018-9-22, 13:19:09
    Author     : zhang
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
