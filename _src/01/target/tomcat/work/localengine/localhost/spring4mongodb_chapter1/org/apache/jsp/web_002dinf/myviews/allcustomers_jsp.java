package org.apache.jsp.WEB_002dINF.myviews;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class allcustomers_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.AnnotationProcessor _jsp_annotationprocessor;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) getServletConfig().getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
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

      out.write("<h1> E-shop Customers</h1>\r\n");
      out.write("\r\n");
      out.write("<table style=\"border: 1px solid; width: 500px; text-align:center\">\r\n");
      out.write("\t<thead style=\"background:#dccd\">\r\n");
      out.write("\t\t<tr>\r\n");
      out.write("\t\t\t<th>Name</th>\r\n");
      out.write("\t\t\t<th>Address</th>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t<th colspan=\"2\"></th>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t</thead>\r\n");
      out.write("\t<tbody>\r\n");
      out.write("\r\n");
      out.write("\t<c:forEach items=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${customerList}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\" var=\"customers\">\r\n");
      out.write("\t\t\t<c:url var=\"editUrl\" value=\"/customer/geteditcustomer?cust_id=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${customers.cust_id}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\" />\r\n");
      out.write("\t\t\t<c:url var=\"deleteUrl\" value=\"/customer/deletecustomer?cust_id=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${customers.cust_id}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\" />\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t<tr>\r\n");
      out.write("\t\t\t<td><c:out value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${customers.name}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\" /></td>\r\n");
      out.write("\t\t\t<td><c:out value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${customers.address}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\" /></td>\r\n");
      out.write("\t\t\t<td><a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${editUrl}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\">Edit</a></td>\r\n");
      out.write("\t\t\t<td><a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${deleteUrl}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\">Delete</a></td>\r\n");
      out.write("\t\t\t<td><a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${addUrl}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\">Add</a></td>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t</c:forEach>\r\n");
      out.write("\r\n");
      out.write("\t</tbody>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
