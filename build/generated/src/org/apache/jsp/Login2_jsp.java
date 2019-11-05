package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class Login2_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("<link href=\"//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css\" rel=\"stylesheet\" id=\"bootstrap-css\">\n");
      out.write("<script src=\"//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js\"></script>\n");
      out.write("<script src=\"//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js\"></script>\n");
      out.write("<!------ Include the above in your HEAD tag ---------->\n");
      out.write("\n");
      out.write("<!--author:starttemplate-->\n");
      out.write("<!--reference site : starttemplate.com-->\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"en\">\n");
      out.write("<head>\n");
      out.write("    <meta charset=\"utf-8\">\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">\n");
      out.write("    <meta name=\"keywords\"\n");
      out.write("          content=\"unique login form,leamug login form,boostrap login form,responsive login form,free css html login form,download login form\">\n");
      out.write("    <meta name=\"author\" content=\"leamug\">\n");
      out.write("    <title>Unique Login Form | Bootstrap Templates</title>\n");
      out.write("    <link href=\"css/style.css\" rel=\"stylesheet\" id=\"style\">\n");
      out.write("    <!-- Bootstrap core Library -->\n");
      out.write("    <link href=\"//netdna.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css\" rel=\"stylesheet\" id=\"bootstrap-css\">\n");
      out.write("    <script src=\"//netdna.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js\"></script>\n");
      out.write("    <script src=\"//code.jquery.com/jquery-1.11.1.min.js\"></script>\n");
      out.write("    <!-- Google font -->\n");
      out.write("    <link href=\"https://fonts.googleapis.com/css?family=Dancing+Script\" rel=\"stylesheet\">\n");
      out.write("    <!-- Font Awesome-->\n");
      out.write("    <link href=\"//maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css\" rel=\"stylesheet\">\n");
      out.write("    <style>\n");
      out.write("        body {\n");
      out.write("        background-image:url('http://getwallpapers.com/wallpaper/full/a/5/d/544750.jpg');\n");
      out.write("        background-position:center;\n");
      out.write("        background-size:cover;\n");
      out.write("  \n");
      out.write("        -webkit-font-smoothing: antialiased;\n");
      out.write("        font: normal 14px Roboto,arial,sans-serif;\n");
      out.write("        font-family: 'Dancing Script', cursive!important;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        .container {\n");
      out.write("            padding: 110px;\n");
      out.write("        }\n");
      out.write("        ::placeholder { /* Chrome, Firefox, Opera, Safari 10.1+ */\n");
      out.write("            color: #ffffff!important;\n");
      out.write("            opacity: 1; /* Firefox */\n");
      out.write("            font-size:18px!important;\n");
      out.write("        }\n");
      out.write("        .form-login {\n");
      out.write("            background-color: rgba(0,0,0,0.55);\n");
      out.write("            padding-top: 10px;\n");
      out.write("            padding-bottom: 20px;\n");
      out.write("            padding-left: 20px;\n");
      out.write("            padding-right: 20px;\n");
      out.write("            border-radius: 15px;\n");
      out.write("            border-color:#d2d2d2;\n");
      out.write("            border-width: 5px;\n");
      out.write("            color:white;\n");
      out.write("            box-shadow:0 1px 0 #cfcfcf;\n");
      out.write("        }\n");
      out.write("        .form-control{\n");
      out.write("            background:transparent!important;\n");
      out.write("            color:white!important;\n");
      out.write("            font-size: 18px!important;\n");
      out.write("        }\n");
      out.write("        h1{\n");
      out.write("            color:white!important;\n");
      out.write("        }\n");
      out.write("        h4 { \n");
      out.write("        border:0 solid #fff; \n");
      out.write("        border-bottom-width:1px;\n");
      out.write("        padding-bottom:10px;\n");
      out.write("        text-align: center;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        .form-control {\n");
      out.write("            border-radius: 10px;\n");
      out.write("        }\n");
      out.write("        .text-white{\n");
      out.write("            color: white!important;\n");
      out.write("        }\n");
      out.write("        .wrapper {\n");
      out.write("            text-align: center;\n");
      out.write("        }\n");
      out.write("        .footer p{\n");
      out.write("            font-size: 18px;\n");
      out.write("        }\n");
      out.write("    </style>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("\n");
      out.write("<!-- Page Content -->\n");
      out.write("<div class=\"container\">\n");
      out.write("    <div class=\"row\">\n");
      out.write("        <div class=\"col-md-offset-5 col-md-4 text-center\">\n");
      out.write("            <div class=\"form-login\"></br>\n");
      out.write("                <h4>Login</h4>\n");
      out.write("                </br>\n");
      out.write("                    <input type=\"text\" id=\"userName\" class=\"form-control input-sm chat-input\" placeholder=\"username\"/>\n");
      out.write("                    </br></br>\n");
      out.write("                    <input type=\"text\" id=\"userPassword\" class=\"form-control input-sm chat-input\" placeholder=\"password\"/>\n");
      out.write("                    </br></br>\n");
      out.write("                    <div class=\"wrapper\">\n");
      out.write("                        <span class=\"group-btn\">\n");
      out.write("                            <a href=\"Controleur1?action=LoginUser\" class=\"btn btn-primary btn-md\">login <i class=\"fa fa-sign-in\"></i></a>\n");
      out.write("                        </span>\n");
      out.write("                    </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("    </br></br></br>\n");
      out.write("\n");
      out.write("</div>\n");
      out.write("</body>\n");
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
