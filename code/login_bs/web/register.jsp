<%-- 
    Document   : register
    Created on : 2018-9-22, 13:12:45
    Author     : zhang
--%>
<%@page import="java.sql.*"%>
<%@page import="src.DB.DBPool"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    Connection con=DBPool.getInstance().getConnection();
    Statement stmt=con.createStatement();
    ResultSet rs=stmt.executeQuery("select * from document");
%>
<html lang="zh-CN">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Login Page</title>
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/font-awesome.min.css" rel="stylesheet">
        <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
        <!--[if lt IE 9]>
          <script src="js/html5shiv.min.js"></script>
          <script src="js/respond.min.js"></script>
        <![endif]-->
        <link href="css/index.css" rel="stylesheet">
        <link href="dist/summernote.css" rel="stylesheet">
    </head>
    <body>
        <div class="jumbotron" style=" background: linear-gradient(45deg,#020031 0,#6d3353 100%);">
            <div class="row">
                <div class="col-md-2"></div>
                <div class="col-md-8">
                    <div class="titlecontent">注册千年之狐</div>
                </div>
                <div class="col-md-2"></div>
            </div>
            <div class="row" style="margin-top: 10%;">
                <div class="col-md-4"></div>
                <div class="col-md-4">
                    <div class="panel panel-primary">
                        <div class="panel-heading"><p class="login-box-msg">新用户注册</p></div>
                        <div class="panel-body">

                            <div class="form-group">
                                <label for="loginname">注册名:<i class=" fa fa-asterisk" style=" color: #c9302c;"></i></label>
                                <input type="text" id="loginname" class="form-control" placeholder="LoginName">
                            </div>
                            <div class="form-group">
                                <label for="PWD">密码:<i class=" fa fa-asterisk" style=" color: #c9302c;"></i></label>
                                <input type="password" id="PWD" class="form-control" placeholder="Password">
                            </div>
                            <div class="form-group">
                                <label for="PWDconfirm">确认密码:<i class=" fa fa-asterisk" style=" color: #c9302c;"></i></label>
                                <input type="password" id="PWDconfirm" class="form-control" placeholder="Confirm Password">
                            </div>
                            <div class="form-group">
                                <label for="name">真实姓名:<i class=" fa fa-asterisk" style=" color: #c9302c;"></i></label>
                                <input type="text" id="name" class="form-control" placeholder="your name">
                            </div>
                            <div class="form-group">
                                <label for="qq">QQ号码:</label>
                                <input type="text" id="qq" class="form-control" placeholder="your QQ">
                            </div>
                            <div class="form-group">
                                <label for="wechat">微信号码:</label>
                                <input type="text" id="wechat" class="form-control" placeholder="your wechat">
                            </div>
                            <div class="form-group">
                                <label for="phone">电话号码:</label>
                                <input type="text" id="phone" class="form-control" placeholder="your phone">
                            </div>
                            <div class="form-group">
                                <label for="usertypee">所属部门:<i class=" fa fa-asterisk" style=" color: #c9302c;"></i></label>
                                <select id="usertype" class="form-control">
                                    <option value="1000">请选择</option>
                                    <%
                                        while (rs.next()) {
                                    %>
                                    <option value="<%=rs.getInt(1)%>"><%=rs.getString(2)%></option>
                                    <%    }
                                    %>
                                </select>
                            </div>
                            <div class="form-group">
                                <label for="pic">照片:</label>                                
                                <input type="button" value="选择文件" id="browse">
                                <input type="button" value="开始上传" id="upload-btn">
                                <ul id="file-list"></ul>
                            </div>
                            <input type="hidden" id="tupianpath" value=" " />
                            <div class="row">
                                <div class="col-xs-4">
                                    <button type="button" id="reg" class="btn btn-primary btn-block btn-flat" onclick="regkk();">Register</button>
                                </div><!-- /.col -->
                            </div>

                        </div>
                    </div>
                </div>
                <div class="col-md-4"></div>
            </div>
        </div>
        <script src="js/jquery-1.12.2.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script src="dist/summernote.min.js"></script>
        <script src="dist/lang/summernote-zh-CN.js"></script>
        <script src="js/jmd5.js"></script>
        <script src="js/plupload.full.min.js"></script>
        <script src="js/upload/uploadimg.js"></script>
        <script>
            function regkk(){
//                alert("123");
                var loginname=document.getElementById("loginname").value;
                var pwd=$.md5(document.getElementById("PWD").value);
                var pwdconfirm=$.md5(document.getElementById("PWDconfirm").value);
                var name=document.getElementById("name").value;
                var qq=document.getElementById("qq").value;
                var wechat=document.getElementById("wechat").value;
                var phone=document.getElementById("phone").value;
                var type=$("#usertype option:selected").val();
                var tupian=document.getElementById("tupianpath").value;
                if(loginname.length===0){
                    alert("Loging name don't empty!");
                    $("#loginname").focus();
                    return false;
                }
                if(name.length===0){
                    alert("Your name don't empty!");
                    $("#name").focus();
                    return false;
                }
                if(pwd.lenght===0){
                    alert("password don't empty!");
                    $("#PWD").focus();
                    return false;
                }
                if(pwd!==pwdconfirm){
                    alert("password and confirm password is not batch!");
                    $("#PWD").focus();
                    return false;
                }
                if(type===1000){
                    alert("请选择所属部门");
                    $("#usertype").focus();
                    return false;
                }
                $.ajax({
                    url:"regist",
                    data:{"loginname":loginname,"pwd":pwd,"name":name,"qq":qq,"wechat":wechat,"phone":phone,"tu":tupian,"type":type},
                    type:"get",
                    dataType:"html",
                    success:function(){
                        alert("regist is success!");
                        location.href="login.jsp";
                    }
                });
            }
        </script>
    </body>
</html>

