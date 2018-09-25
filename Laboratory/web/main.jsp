<%-- 
    Document   : main
    Created on : 2018-3-18, 11:40:40
    Author     : Tom
--%>

<%@page import="java.sql.*"%>
<%@page import="src.DB.DBPool"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    
    String uname,phone;
    Integer uid,roleid,depaid;
    session=request.getSession();
    uid=(Integer)session.getAttribute("id");
    uname=(String)session.getAttribute("name");
    roleid=(Integer)session.getAttribute("roleid");
    phone=(String)session.getAttribute("phone");
    depaid=(Integer)session.getAttribute("departmentid");
    Connection con=DBPool.getInstance().getConnection();
//  教室查询
    Statement stmt=con.createStatement();
    ResultSet rs=stmt.executeQuery("select * from classroom where department_id="+depaid);
//  排课查询
    
    
%>
<html lang="zh-CN">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="">
        <meta name="author" content="">
        <title>实验室教学安排管理</title>
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/dashboard.css" rel="stylesheet">
        <link href="css/font-awesome.min.css" rel="stylesheet">
        <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
        <!--[if lt IE 9]>
          <script src="js/html5shiv.min.js"></script>
          <script src="js/respond.min.js"></script>
        <![endif]-->
    </head>
    <body>
        <nav class="navbar navbar-inverse navbar-fixed-top">
            <div class="container-fluid">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="#">实验室教学安排管理</a>
                </div>
                <div id="navbar" class="navbar-collapse collapse">
                    <ul class="nav navbar-nav navbar-right">
                        <li><a href="#">欢迎<%=uname%></a></li>
                    </ul>                    
                </div>
            </div>
        </nav>

        <div class="container-fluid">
            <div class="row">
                <div class="col-sm-3 col-md-2 sidebar">
                    <ul class="nav nav-sidebar">
                        <li><img class="img-responsive" src="uploadimg/<%=phone%>"></li>
                        <li class="active"><a href="#">基本操作<span class="sr-only">(current)</span></a></li>
                        <li><a href="#">填报</a></li>
                        <li><a href="#">查询</a></li>
                        <li><a href="#">转实验进度表</a></li>
                    </ul>
                    <ul class="nav nav-sidebar">
                        <li class="active"><a href="#">管理操作<span class="sr-only">(current)</span></a></li>
                        <li><a href="#" onclick="bjwh();">班级维护</a></li>
                        <li><a href="#" onclick="xqwh();">学期维护</a></li>
                        <li><a href="#" onclick="zywh();">专业维护</a></li>
                        <li><a href="#" onclick="syswh();">实验室维护</a></li>
                    </ul>
                </div>
                <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main" id="maincontent">
                    <h1 class="page-header">内容显示</h1>
                    <div class="panel panel-danger">
                        <div class="panel-body">
                            <label for="classroom">选择实验室:</label>
                            <select id="classroomid" class="form-control" onchange="showtable(this.value);">
                                <option value="1000">请选择</option>
                                <%
                                    while (rs.next()) {
                                %>
                                <option value="<%=rs.getInt(1)%>"><%=rs.getString(2)+rs.getString(3)%></option>
                                <%    }
                                %>
                            </select>
                        </div>
                    </div>
                    <h2 class="sub-header">实验室课表</h2>
                    <div id="content"></div>
                    <button id="tianbao" type="button" class="btn btn-danger" onclick="tianbao();">填报</button>
                    <div class="hidden" id="additem"></div>
                </div>
            </div>
        </div>
        <script src="js/jquery-1.12.2.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script>
            function bjwh(){
                $.ajax({
                   url:"bjwh.jsp",
                   type:"get",
                   dataType:"html",
                   success:function(htmlstr){
                       $("#maincontent").empty();
                       $("#maincontent").append(htmlstr);
                   }
                });
            };
            
            var roomid;
            function showtable(value){
                roomid=value;
                $.ajax({
                    url:"kcb.jsp",
                    data:{"val":value},
                    type:"get",
                    dataType:"html",
                    success:function(htmlstr){
                        $("#content").empty();
                        $("#content").append(htmlstr);
                    }
                });
            };
            
            function tianbao(){
                $.ajax({
                    url:"additem.jsp",
                    data:{"para":roomid},
                    type:"get",
                    dataType:"html",
                    success:function(htmlstr){
                        $("#additem").empty();
                        $("#additem").removeClass("hidden");
                        $("#additem").append(htmlstr);
                    }
                });
            }
        </script>
    </body>
</html>
