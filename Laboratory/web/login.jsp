<%-- 
    Document   : login
    Created on : 2016-1-28, 5:53:39
    Author     : liu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
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
    </head>
    <body>
        <div class="jumbotron" style=" background: linear-gradient(45deg,#020031 0,#6d3353 100%);">
            <div class="row">
                <div class="col-md-2"></div>
                <div class="col-md-8">
                    <div class="titlecontent">实验室教学安排管理系统</div>
                </div>
                <div class="col-md-2"></div>
            </div>
            <div class="row" style="margin-top: 15%;">
                <div class="col-md-4"></div>
                <div class="col-md-4">
                    <div class="panel panel-primary">
                        <div class="panel-heading"></div>
                        <div class="panel-body">
                            <div class="form-group has-feedback">
                                <input type="text" id="userid" class="form-control" placeholder="用户名">
                                <span class="glyphicon glyphicon-user form-control-feedback"></span>
                            </div>
                            <div class="form-group has-feedback">
                                <input type="password" id="userPWD" class="form-control" placeholder="密码">
                                <span class="glyphicon glyphicon-lock form-control-feedback"></span>
                            </div>
                            <div class="row">
                                <div class="col-xs-4">
                                    <button type="button" class="btn btn-primary btn-block btn-flat" onclick="login();">登  录</button>
                                </div><!-- /.col -->
                            </div>
                            <!--</form>-->
                        </div>
                        <div class="panel-footer">
                            <a href="regist.jsp" class="text-center">新用户注册</a>
                        </div>
                    </div>
                </div>
                <div class="col-md-4"></div>
            </div>
        </div>
        <script src="js/jquery-1.12.2.min.js"></script>
        <script src="js/jmd5.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script>
            function login() {
                var name = document.getElementById("userid").value;                
                var pwd = document.getElementById("userPWD").value;
                var userpwd;
                if($.trim(pwd)!=="123456"){
                    userpwd = $.md5(pwd);
                }
                else{
                    userpwd="123456";
                }
                window.location.href="login?para1="+name+"&para2="+userpwd;
            }
        </script>
    </body>
</html>
