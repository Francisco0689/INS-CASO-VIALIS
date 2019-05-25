package org.apache.jsp.WEB_002dINF.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("    <html>\n");
      out.write("        <head>\n");
      out.write("            <meta charset=\"UTF-8\">\n");
      out.write("            <title>formrun.js - Alert Dialog</title>\n");
      out.write("            <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.3/css/bootstrap.min.css\" integrity=\"sha384-MIwDKRSSImVFAZCVLtU0LMDdON6KVCrZHyVQQj6e8wIEJkW4tvwqXrbMIya1vriY\" crossorigin=\"anonymous\">\n");
      out.write("            <script src=\"https://cdnjs.cloudflare.com/ajax/libs/jquery/3.1.0/jquery.slim.min.js\" crossorigin=\"anonymous\"></script>\n");
      out.write("            <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.3/js/bootstrap.min.js\" integrity=\"sha384-ux8v3A6CPtOTqOzMKiuo3d/DomGaaClxFYdCu2HPMBEkf6x2xiDyJ7gkXU0MWwaD\" crossorigin=\"anonymous\"></script>\n");
      out.write("            <script src=\"https://sdk.form.run/js/v2/formrun.js\"></script>\n");
      out.write("        </head>\n");
      out.write("        <body>\n");
      out.write("\n");
      out.write("            <div class=\"container\">\n");
      out.write("                <h1>formrun.js <small> - Alert Dialog</small></h1>\n");
      out.write("\n");
      out.write("                <div class=\"card\">\n");
      out.write("                    <h3 class=\"card-header\">Test</h3>\n");
      out.write("\n");
      out.write("                    <div class=\"card-block\">\n");
      out.write("                        <form class=\"formrun\" action=\"#\" method=\"get\" data-formrun-alert-dialog>\n");
      out.write("                            <div class=\"form-group\"\n");
      out.write("                                 data-formrun-class-if-success=\"has-success\" data-formrun-class-if-error=\"has-danger\" data-formrun-target=\"\">\n");
      out.write("                                <label class=\"form-control-label\" for=\"name\">Test</label>\n");
      out.write("                                <input type=\"text\" class=\"form-control\" id=\"name\" name=\"\"\n");
      out.write("                                       data-formrun-required data-formrun-class-if-success=\"form-control-success\" data-formrun-class-if-error=\"form-control-danger\">\n");
      out.write("                                <div class=\"text-danger\" data-formrun-show-if-error=\"\"></div>\n");
      out.write("                            </div>\n");
      out.write("\n");
      out.write("                            <div class=\"form-group\"\n");
      out.write("                                 data-formrun-class-if-success=\"has-success\" data-formrun-class-if-error=\"has-danger\" data-formrun-target=\"\">\n");
      out.write("                                <label class=\"form-control-label\" for=\"email\"></label>\n");
      out.write("                                <input class=\"form-control\" id=\"email\" name=\"\"\n");
      out.write("                                       data-formrun-class-if-success=\"form-control-success\" data-formrun-class-if-error=\"form-control-danger\"\n");
      out.write("                                       data-formrun-required data-formrun-type=\"email\" data-formrun-class-if-success=\"form-control-success\" data-formrun-class-if-error=\"form-control-danger\">\n");
      out.write("\n");
      out.write("                                <div class=\"text-danger\" data-formrun-show-if-error=\"\"></div>\n");
      out.write("                            </div>\n");
      out.write("                            <br>\n");
      out.write("                            <div>\n");
      out.write("                                <button type=\"submit\" class=\"btn btn-primary pull-xs-right\" data-formrun-error-text=\"\" data-formrun-submitting-text=\"\"></button>\n");
      out.write("                            </div>\n");
      out.write("                        </form>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("            </div><!-- /.container -->\n");
      out.write("\n");
      out.write("        </body>\n");
      out.write("    </html>");
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
