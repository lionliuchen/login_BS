package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE HTML>\n");
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
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <div class=\"jumbotron\" style=\" background: linear-gradient(45deg,#020031 0,#6d3353 100%);\">\n");
      out.write("            <div class=\"row\">\n");
      out.write("                <div class=\"col-md-2\"></div>\n");
      out.write("                <div class=\"col-md-8\">\n");
      out.write("                    <div class=\"titlecontent\">千年之狐</div>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"col-md-2\"></div>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"row\" style=\"margin-top: 15%;\">\n");
      out.write("                <div class=\"col-md-4\"></div>\n");
      out.write("                <div class=\"col-md-4\">\n");
      out.write("                    <div class=\"panel panel-primary\">\n");
      out.write("                        <div class=\"panel-heading\"></div>\n");
      out.write("                        <div class=\"panel-body\">\n");
      out.write("                            <div class=\"form-group has-feedback\">\n");
      out.write("                                <input type=\"text\" id=\"userid\" class=\"form-control\" placeholder=\"用户名\">\n");
      out.write("                                <span class=\"glyphicon glyphicon-user form-control-feedback\"></span>\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"form-group has-feedback\">\n");
      out.write("                                <input type=\"password\" id=\"userPWD\" class=\"form-control\" placeholder=\"密码\">\n");
      out.write("                                <span class=\"glyphicon glyphicon-lock form-control-feedback\"></span>\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"row\">\n");
      out.write("                                <div class=\"col-xs-4\">\n");
      out.write("                                    <button type=\"button\" class=\"btn btn-primary btn-block btn-flat\" onclick=\"login();\">登  录</button>\n");
      out.write("                                </div><!-- /.col -->\n");
      out.write("                            </div>\n");
      out.write("                            <!--</form>-->\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"panel-footer\">\n");
      out.write("                            <a href=\"register.jsp\" class=\"text-center\">新用户注册</a>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"col-md-4\"></div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("        <script src=\"js/jquery-1.12.2.min.js\"></script>\n");
      out.write("        <script src=\"js/jmd5.js\"></script>\n");
      out.write("        <script src=\"js/bootstrap.min.js\"></script>\n");
      out.write("        <script>\n");
      out.write("            function login() {\n");
      out.write("                var name = document.getElementById(\"userid\").value;\n");
      out.write("                var pwd = document.getElementById(\"userPWD\").value;\n");
      out.write("                var userpwd;\n");
      out.write("                if($.trim(pwd)!==\"123\"){\n");
      out.write("                    userpwd = $.md5(pwd);\n");
      out.write("                }\n");
      out.write("                else{\n");
      out.write("                    userpwd=\"123\";\n");
      out.write("                }\n");
      out.write("                window.location.href=\"login?para1=\"+name+\"&para2=\"+userpwd;\n");
      out.write("            }\n");
      out.write("        </script>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
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
