package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;
import src.DB.DBPool;

public final class register_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");

    Connection con=DBPool.getInstance().getConnection();
    Statement stmt=con.createStatement();
    ResultSet rs=stmt.executeQuery("select * from document");

      out.write("\n");
      out.write("<html lang=\"zh-CN\">\n");
      out.write("    <head>\n");
      out.write("        <meta charset=\"utf-8\">\n");
      out.write("        <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n");
      out.write("        <title>Login Page</title>\n");
      out.write("        <link href=\"css/bootstrap.min.css\" rel=\"stylesheet\">\n");
      out.write("        <link href=\"css/font-awesome.min.css\" rel=\"stylesheet\">\n");
      out.write("        <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->\n");
      out.write("        <!--[if lt IE 9]>\n");
      out.write("          <script src=\"js/html5shiv.min.js\"></script>\n");
      out.write("          <script src=\"js/respond.min.js\"></script>\n");
      out.write("        <![endif]-->\n");
      out.write("        <link href=\"css/index.css\" rel=\"stylesheet\">\n");
      out.write("        <link href=\"dist/summernote.css\" rel=\"stylesheet\">\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <div class=\"jumbotron\" style=\" background: linear-gradient(45deg,#020031 0,#6d3353 100%);\">\n");
      out.write("            <div class=\"row\">\n");
      out.write("                <div class=\"col-md-2\"></div>\n");
      out.write("                <div class=\"col-md-8\">\n");
      out.write("                    <div class=\"titlecontent\">注册千年之狐</div>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"col-md-2\"></div>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"row\" style=\"margin-top: 10%;\">\n");
      out.write("                <div class=\"col-md-4\"></div>\n");
      out.write("                <div class=\"col-md-4\">\n");
      out.write("                    <div class=\"panel panel-primary\">\n");
      out.write("                        <div class=\"panel-heading\"><p class=\"login-box-msg\">新用户注册</p></div>\n");
      out.write("                        <div class=\"panel-body\">\n");
      out.write("\n");
      out.write("                            <div class=\"form-group\">\n");
      out.write("                                <label for=\"loginname\">注册名:<i class=\" fa fa-asterisk\" style=\" color: #c9302c;\"></i></label>\n");
      out.write("                                <input type=\"text\" id=\"loginname\" class=\"form-control\" placeholder=\"LoginName\">\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"form-group\">\n");
      out.write("                                <label for=\"PWD\">密码:<i class=\" fa fa-asterisk\" style=\" color: #c9302c;\"></i></label>\n");
      out.write("                                <input type=\"password\" id=\"PWD\" class=\"form-control\" placeholder=\"Password\">\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"form-group\">\n");
      out.write("                                <label for=\"PWDconfirm\">确认密码:<i class=\" fa fa-asterisk\" style=\" color: #c9302c;\"></i></label>\n");
      out.write("                                <input type=\"password\" id=\"PWDconfirm\" class=\"form-control\" placeholder=\"Confirm Password\">\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"form-group\">\n");
      out.write("                                <label for=\"name\">真实姓名:<i class=\" fa fa-asterisk\" style=\" color: #c9302c;\"></i></label>\n");
      out.write("                                <input type=\"text\" id=\"name\" class=\"form-control\" placeholder=\"your name\">\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"form-group\">\n");
      out.write("                                <label for=\"qq\">QQ号码:</label>\n");
      out.write("                                <input type=\"text\" id=\"qq\" class=\"form-control\" placeholder=\"your QQ\">\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"form-group\">\n");
      out.write("                                <label for=\"wechat\">微信号码:</label>\n");
      out.write("                                <input type=\"text\" id=\"wechat\" class=\"form-control\" placeholder=\"your wechat\">\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"form-group\">\n");
      out.write("                                <label for=\"phone\">电话号码:</label>\n");
      out.write("                                <input type=\"text\" id=\"phone\" class=\"form-control\" placeholder=\"your phone\">\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"form-group\">\n");
      out.write("                                <label for=\"usertypee\">所属部门:<i class=\" fa fa-asterisk\" style=\" color: #c9302c;\"></i></label>\n");
      out.write("                                <select id=\"usertype\" class=\"form-control\">\n");
      out.write("                                    <option value=\"1000\">请选择</option>\n");
      out.write("                                    ");

                                        while (rs.next()) {
                                    
      out.write("\n");
      out.write("                                    <option value=\"");
      out.print(rs.getInt(1));
      out.write('"');
      out.write('>');
      out.print(rs.getString(2));
      out.write("</option>\n");
      out.write("                                    ");
    }
                                    
      out.write("\n");
      out.write("                                </select>\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"form-group\">\n");
      out.write("                                <label for=\"pic\">照片:</label>                                \n");
      out.write("                                <input type=\"button\" value=\"选择文件\" id=\"browse\">\n");
      out.write("                                <input type=\"button\" value=\"开始上传\" id=\"upload-btn\">\n");
      out.write("                                <ul id=\"file-list\"></ul>\n");
      out.write("                            </div>\n");
      out.write("                            <input type=\"hidden\" id=\"tupianpath\" value=\" \" />\n");
      out.write("                            <div class=\"row\">\n");
      out.write("                                <div class=\"col-xs-4\">\n");
      out.write("                                    <button type=\"button\" id=\"reg\" class=\"btn btn-primary btn-block btn-flat\" onclick=\"regkk();\">Register</button>\n");
      out.write("                                </div><!-- /.col -->\n");
      out.write("                            </div>\n");
      out.write("\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"col-md-4\"></div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("        <script src=\"js/jquery-1.12.2.min.js\"></script>\n");
      out.write("        <script src=\"js/bootstrap.min.js\"></script>\n");
      out.write("        <script src=\"dist/summernote.min.js\"></script>\n");
      out.write("        <script src=\"dist/lang/summernote-zh-CN.js\"></script>\n");
      out.write("        <script src=\"js/jmd5.js\"></script>\n");
      out.write("        <script src=\"js/plupload.full.min.js\"></script>\n");
      out.write("        <script src=\"js/upload/uploadimg.js\"></script>\n");
      out.write("        <script>\n");
      out.write("            function regkk(){\n");
      out.write("//                alert(\"123\");\n");
      out.write("                var loginname=document.getElementById(\"loginname\").value;\n");
      out.write("                var pwd=$.md5(document.getElementById(\"PWD\").value);\n");
      out.write("                var pwdconfirm=$.md5(document.getElementById(\"PWDconfirm\").value);\n");
      out.write("                var name=document.getElementById(\"name\").value;\n");
      out.write("                var qq=document.getElementById(\"qq\").value;\n");
      out.write("                var wechat=document.getElementById(\"wechat\").value;\n");
      out.write("                var phone=document.getElementById(\"phone\").value;\n");
      out.write("                var type=$(\"#usertype option:selected\").val();\n");
      out.write("                var tupian=document.getElementById(\"tupianpath\").value;\n");
      out.write("                if(loginname.length===0){\n");
      out.write("                    alert(\"Loging name don't empty!\");\n");
      out.write("                    $(\"#loginname\").focus();\n");
      out.write("                    return false;\n");
      out.write("                }\n");
      out.write("                if(name.length===0){\n");
      out.write("                    alert(\"Your name don't empty!\");\n");
      out.write("                    $(\"#name\").focus();\n");
      out.write("                    return false;\n");
      out.write("                }\n");
      out.write("                if(pwd.lenght===0){\n");
      out.write("                    alert(\"password don't empty!\");\n");
      out.write("                    $(\"#PWD\").focus();\n");
      out.write("                    return false;\n");
      out.write("                }\n");
      out.write("                if(pwd!==pwdconfirm){\n");
      out.write("                    alert(\"password and confirm password is not batch!\");\n");
      out.write("                    $(\"#PWD\").focus();\n");
      out.write("                    return false;\n");
      out.write("                }\n");
      out.write("                if(type===1000){\n");
      out.write("                    alert(\"请选择所属部门\");\n");
      out.write("                    $(\"#usertype\").focus();\n");
      out.write("                    return false;\n");
      out.write("                }\n");
      out.write("                $.ajax({\n");
      out.write("                    url:\"regist\",\n");
      out.write("                    data:{\"loginname\":loginname,\"pwd\":pwd,\"name\":name,\"qq\":qq,\"wechat\":wechat,\"phone\":phone,\"tu\":tupian,\"type\":type},\n");
      out.write("                    type:\"get\",\n");
      out.write("                    dataType:\"html\",\n");
      out.write("                    success:function(){\n");
      out.write("                        alert(\"regist is success!\");\n");
      out.write("                        location.href=\"login.jsp\";\n");
      out.write("                    }\n");
      out.write("                });\n");
      out.write("            }\n");
      out.write("        </script>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
      out.write("\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
