/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.37
 * Generated at: 2020-09-29 08:34:55 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views.board;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class detail_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(4);
    _jspx_dependants.put("jar:file:/Users/jangsang-og/Downloads/programming/eclipse/spring-workspace/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/sp03_board_mysql/WEB-INF/lib/jstl-1.2.jar!/META-INF/fmt.tld", Long.valueOf(1153352682000L));
    _jspx_dependants.put("/WEB-INF/views/board/../include/includeFile.jsp", Long.valueOf(1601362847000L));
    _jspx_dependants.put("/WEB-INF/lib/jstl-1.2.jar", Long.valueOf(1599713879510L));
    _jspx_dependants.put("jar:file:/Users/jangsang-og/Downloads/programming/eclipse/spring-workspace/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/sp03_board_mysql/WEB-INF/lib/jstl-1.2.jar!/META-INF/c.tld", Long.valueOf(1153352682000L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005ffmt_005fformatDate_0026_005fvalue_005fpattern_005fnobody;

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005ffmt_005fformatDate_0026_005fvalue_005fpattern_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.release();
    _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.release();
    _005fjspx_005ftagPool_005ffmt_005fformatDate_0026_005fvalue_005fpattern_005fnobody.release();
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    if (!javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSP들은 오직 GET, POST 또는 HEAD 메소드만을 허용합니다. Jasper는 OPTIONS 메소드 또한 허용합니다.");
        return;
      }
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write('\n');
      out.write("   \r\n");
      out.write("<!-- jstl -->\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!-- context path -->\r\n");
      if (_jspx_meth_c_005fset_005f0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("<!-- jquery -->\r\n");
      out.write("<script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${path}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/resources/js/jquery-3.5.1.js\"></script>\r\n");
      out.write("<!-- <script src=\"https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.1/jquery.js\"></script> -->\r\n");
      out.write("<!-- css -->\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${path}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/resources/css/style.css\">");
      out.write("  \n");
      out.write("  \n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("<meta charset=\"UTF-8\">\n");
      out.write("<title>상세조회</title>\n");
      out.write("<!-- 핸들바 라이브러리 추가 -->\n");
      out.write("<script src=\"https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/4.7.6/handlebars.js\"></script>\n");
      out.write("<!-- 핸들바 탬플릿 작성 -->\n");
      out.write("<script id=\"replyTemplate\" type=\"text/x-handlebars-template\">\n");
      out.write("\t{{#each .}}\n");
      out.write("\t\t<li>\n");
      out.write("\t\t\t<div>\n");
      out.write("\t\t\t\t번호 : {{rnum}} <br>\n");
      out.write("\t\t\t\t작성자 : {{writer}} <br>\n");
      out.write("\t\t\t\t내용 : <span id='rnum{{rnum}}' > {{content}} </span> <br>\n");
      out.write("\t\t\t\t등록일자 : {{regdate}} <br>\n");
      out.write("\t\t\t\t<button class ='btnReplyModify' value='{{rnum}}'>수정</button>\n");
      out.write("\t\t\t\t<button class ='btnReplySave' value='{{rnum}}' hidden>저장</button>\n");
      out.write("\t\t\t\t<button class ='btnReplyCancel' value='{{rnum}}' hidden>취소</button>\n");
      out.write("\t\t\t\t<button class ='btnReplyDelete' value='{{rnum}}'>삭제</button>\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t</li>\n");
      out.write("\t{{/each}}\n");
      out.write("</script>\n");
      out.write("\n");
      out.write("<script type=\"text/javascript\">\n");
      out.write(" \t$(function() {\n");
      out.write(" \t\t\n");
      out.write(" \t\treplyList();\n");
      out.write(" \t\t\n");
      out.write(" \t\t//수정버튼을 클릭했을때 수정폼으로 이동\n");
      out.write(" \t\t$('#btnModify').on('click', function(e){\n");
      out.write(" \t\t\te.preventDefault(); //객체의 기본기능 소멸\n");
      out.write(" \t\t\tvar bnum = $('#bnum').val();\n");
      out.write("\t\t\t$(location).attr('href', '");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${path}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/board/modify?bnum='+ bnum);\n");
      out.write(" \t\t} );\n");
      out.write("\n");
      out.write(" \t\t//목록버튼을 클릭했을때\n");
      out.write(" \t\t$('#btnList').on('click', function(e) {\n");
      out.write(" \t\t\te.preventDefault(); //객체의 기본기능 소멸\n");
      out.write("\t\t\t$(location).attr('href', '");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${path}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/board/list');\n");
      out.write("\t\t});\n");
      out.write(" \t\t\n");
      out.write(" \t\t//삭제버튼을 눌렀을때\n");
      out.write(" \t\t$('#btnDelete').on('click', function(e) {\n");
      out.write(" \t\t\te.preventDefault(); //객체의 기본기능 소멸\n");
      out.write(" \t\t\tvar result = confirm('삭제하시겠습니까?');\n");
      out.write(" \t\t\tif (result){\n");
      out.write(" \t \t\t\tvar bnum = $('#bnum').val();\n");
      out.write(" \t\t\t\t$(location).attr('href', '");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${path}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/board/delete?bnum=' + bnum);\t\t\t\n");
      out.write(" \t\t\t}\n");
      out.write(" \t\t\t\n");
      out.write("\t\t});\n");
      out.write("\t\t\n");
      out.write("\t\t//다운로드 버튼을 클릭했을때\n");
      out.write("\t\t$('.fileDownload').on('click', function(e) {\n");
      out.write(" \t\t\te.preventDefault(); //객체의 기본기능 소멸\n");
      out.write("\t\t\tvar filename = $(this).val();\n");
      out.write("\t\t\t$(location).attr('href', '");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${path}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/board/filedownload?filename=' +filename);\n");
      out.write("\t\t\t\n");
      out.write("\t\t});\n");
      out.write("\t\t\n");
      out.write("\t\t//댓글추가저장버튼\n");
      out.write("\t\t$('#btnReplyAdd').on('click',function(){\n");
      out.write("\t\t\tvar bnum = $('#bnum').val(); //게시물번호\n");
      out.write("\t\t\tvar replyWriter = $('#replyWriter').val(); //댓글 작성자\n");
      out.write("\t\t\tvar replyContent = $('#replyContent').val(); //댓글 내용\n");
      out.write("\t\t\t//alert(replyContent);\n");
      out.write("\t\t\t//공백 체크\n");
      out.write("\t\t\tif (replyWriter == ''){\n");
      out.write("\t\t\t\talert('작성자를 입력해 주세요');\n");
      out.write("\t\t\t\t$('#replyWriter').focus();\n");
      out.write("\t\t\t\treturn  //함수 실행 즉각 종료\n");
      out.write("\t\t\t}else if (replyContent == ''){\n");
      out.write("\t\t\t\talert('내용을 입력해 주세요');\n");
      out.write("\t\t\t\t$('#replyContent').focus();\n");
      out.write("\t\t\t\treturn\n");
      out.write("\t\t\t}\n");
      out.write("\t\t\t\n");
      out.write("\t\t\t$.ajax({\n");
      out.write("\t\t\t\ttype:'post',\n");
      out.write("\t\t\t\tcontentType:'application/json',\n");
      out.write("\t\t\t\turl : '");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${path}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/reply/',\n");
      out.write("\t\t\t\tdata : JSON.stringify({bnum:bnum,writer:replyWriter,content:replyContent}), //json문자열 표기법으로 변환\n");
      out.write("\t\t\t\tdataType : 'text',  //결과값의 타입\n");
      out.write("\t\t\t\tsuccess : function(result){\n");
      out.write("\t\t\t\t\talert(result);\n");
      out.write("\t\t\t\t\treplyList();\n");
      out.write("\t\t\t\t\t//추가데이터 클리어\n");
      out.write("\t\t\t\t\t$('#replyWriter').val('');\n");
      out.write("\t\t\t\t\t$('#replyContent').val('');\n");
      out.write("\t\t\t\t\t\n");
      out.write("\t\t\t\t},\n");
      out.write("\t\t\t\terror:function(result){\n");
      out.write("\t\t\t\t\talert(\"error\");\n");
      out.write("\t\t\t\t\tconsole.log(result);\n");
      out.write("\t\t\t\t}\n");
      out.write("\t\t\t});\n");
      out.write("\t\t});\n");
      out.write("\t\t\n");
      out.write("\t\t//댓글 조회\n");
      out.write("\t\t$('#btnReplyList').on('click', function() {\n");
      out.write("\t\t\treplyList();\n");
      out.write("\t\t});\n");
      out.write("\t\t\n");
      out.write("\t\tfunction replyList(){\n");
      out.write("\t\t\tvar bnum = $('#bnum').val(); //게시물번호\n");
      out.write("\t\t\t//alert(bnum);\n");
      out.write("\t\t\t$.ajax({\n");
      out.write("\t\t\t\ttype:\"get\",\n");
      out.write("\t\t\t\turl:'");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${path}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/reply/' + bnum, //restfull하게 설계\n");
      out.write("\t\t\t\tdataType : 'json', //결과값의 형태\n");
      out.write("\t\t\t\tsuccess:function(result){\n");
      out.write("\t\t\t\t\t//alert('성공');\n");
      out.write("\t\t\t\t\tconsole.log(result);\n");
      out.write("\t\t\t\t\treplyDisplay(result);\n");
      out.write("\t\t\t\t},\n");
      out.write("\t\t\t\terror:function(result){\n");
      out.write("\t\t\t\t\talert('error');\n");
      out.write("\t\t\t\t}\n");
      out.write("\t\t\t});\n");
      out.write("\t\t\t\n");
      out.write("\t\t\t\n");
      out.write("\t\t}\n");
      out.write("\t\t//댓글리스트 만들고 출력\n");
      out.write("\t\tfunction replyDisplay(data) {\n");
      out.write("\t\t\t//핸들바 탬플릿을 이용한 리스트 만들기 \n");
      out.write("\t\t\tvar source = $('#replyTemplate').html();\n");
      out.write("\t\t\tvar template = Handlebars.compile(source);\n");
      out.write("\t\t\t$('#replies').html(template(data));\n");
      out.write("\t\t}\n");
      out.write("\t\t\n");
      out.write("\t\t//댓글 수정\n");
      out.write("\t\t$('#replies').on('click', '.btnReplyModify',function(){\n");
      out.write("\t\t\tvar rnum = $(this).val();\n");
      out.write("\t\t\t//alert(rnum);\n");
      out.write("\t\t\tvar html = '<textarea id=\"rnum'+ rnum + '\">'+ $('#rnum'+rnum).html() +'</textarea>'; //수정할수 있게 변경\n");
      out.write("\t\t\t$('#rnum'+rnum).replaceWith(html); //기존의 html을 바꾼다\n");
      out.write("\t\t\t//버튼 컨트롤\n");
      out.write("\t\t\t$('.btnReplySave[value=' + rnum + ']').show(); //저장버튼 보이기\n");
      out.write("\t\t\t$('.btnReplyCancel[value=' + rnum + ']').show(); //취소버튼 보이기\n");
      out.write("\t\t\t$('.btnReplyModify[value=' + rnum + ']').hide(); //수정버튼 감추기\n");
      out.write("\t\t\t\n");
      out.write("\t\t});\n");
      out.write("\t\t\n");
      out.write("\t\t//댓글 취소\n");
      out.write("\t\t$('#replies').on('click', '.btnReplyCancel',function(){\n");
      out.write("\t\t\tvar rnum = $(this).val();\n");
      out.write("\t\t\t//원래상태대로 변경\n");
      out.write("\t\t\tvar html = '<span id=\"rnum'+ rnum + '\">'+ $('#rnum'+rnum).html() +'</span>'; \n");
      out.write("\t\t\t$('#rnum'+rnum).replaceWith(html); //기존의 html을 바꾼다\n");
      out.write("\t\t\t//버튼 컨트롤\n");
      out.write("\t\t\t$('.btnReplySave[value=' + rnum + ']').hide(); //저장버튼 감추기\n");
      out.write("\t\t\t$('.btnReplyCancel[value=' + rnum + ']').hide(); //취소버튼 감추기\n");
      out.write("\t\t\t$('.btnReplyModify[value=' + rnum + ']').show(); //수정버튼 보이기\n");
      out.write("\t\t\t\n");
      out.write("\t\t});\n");
      out.write("\t\t\n");
      out.write("\t\t//댓글수정저장버튼\n");
      out.write("\t\t$('#replies').on('click', '.btnReplySave',function(){\n");
      out.write("\t\t\tvar rnum = $(this).val(); //댓글번호\n");
      out.write("\t\t\tvar replyContent = $('#rnum'+rnum).val(); //댓글 내용\n");
      out.write("\t\t\t//alert(replyContent);\n");
      out.write("\t\t\t$.ajax({\n");
      out.write("\t\t\t\ttype:'put', //수정\n");
      out.write("\t\t\t\tcontentType:'application/json', //json형태로 데이터 서버에 보냄\n");
      out.write("\t\t\t\turl : '");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${path}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/reply/'+rnum, \n");
      out.write("\t\t\t\tdata : JSON.stringify({content:replyContent}), //json문자열 표기법으로 변환\n");
      out.write("\t\t\t\tdataType : 'text',  //결과값의 타입\n");
      out.write("\t\t\t\tsuccess : function(result){\n");
      out.write("\t\t\t\t\talert(result);\n");
      out.write("\t\t\t\t\tafterSave(rnum);\n");
      out.write("\t\t\t\t},\n");
      out.write("\t\t\t\terror:function(result){\n");
      out.write("\t\t\t\t\talert(\"error\");\n");
      out.write("\t\t\t\t\tconsole.log(result);\n");
      out.write("\t\t\t\t}\n");
      out.write("\t\t\t});\n");
      out.write("\t\t});\n");
      out.write("\n");
      out.write("\t\t//수정저장후 버튼 상태 변경\n");
      out.write("\t\tfunction afterSave(rnum){\n");
      out.write("\t\t\tvar html = '<span id=\"rnum'+ rnum + '\">'+ $('#rnum'+rnum).val() +'</span>';\n");
      out.write("\t\t\t$('#rnum'+rnum).replaceWith(html); //기존의 html을 바꾼다\n");
      out.write("\t\t\t//버튼 컨트롤\n");
      out.write("\t\t\t$('.btnReplySave[value=' + rnum + ']').hide(); //저장버튼 감추기\n");
      out.write("\t\t\t$('.btnReplyCancel[value=' + rnum + ']').hide(); //취소버튼 감추기\n");
      out.write("\t\t\t$('.btnReplyModify[value=' + rnum + ']').show(); //수정버튼 보이기\n");
      out.write("\t\t}\n");
      out.write("\t\t\n");
      out.write("\t\t//댓글 삭제\n");
      out.write("\t\t$('#replies').on('click', '.btnReplyDelete',function(){\n");
      out.write("\t\t\tvar rnum = $(this).val(); //댓글번호\n");
      out.write("\t\t\tvar bnum = $('#bnum').val(); //게시물번호\n");
      out.write("\t\t\t// alert(bnum);\n");
      out.write("\t\t\t$.ajax({\n");
      out.write("\t\t\t\ttype:\"delete\",\n");
      out.write("\t\t\t\turl:'");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${path}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/reply/' + rnum +\"?bnum=\" + bnum, //restfull하게 설계\n");
      out.write("\t\t\t\tdataType : 'text', //결과값의 형태\n");
      out.write("\t\t\t\t// data : \"bnum=\" + bnum, //바디\n");
      out.write("\t\t\t\tsuccess:function(result){\n");
      out.write("\t\t\t\t\talert(result);\n");
      out.write("\t\t\t\t\treplyList();\n");
      out.write("\t\t\t\t},\n");
      out.write("\t\t\t\terror:function(result){\n");
      out.write("\t\t\t\t\talert('error');\n");
      out.write("\t\t\t\t}\n");
      out.write("\t\t\t});\n");
      out.write("\t\t\t\n");
      out.write("\t\t});\t\t\n");
      out.write("\t\t\n");
      out.write("\t});\n");
      out.write(" </script>\n");
      out.write("\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("<div class=\"container\">\n");
      out.write("\t<h2>상세조회</h2>\n");
      out.write("\t<table border = \"1\">\n");
      out.write("\t\t<tr>\n");
      out.write("\t\t\t<td>번호</td>\n");
      out.write("\t\t\t<td><input id=\"bnum\" type=\"text\" name=\"bnum\" size='5' value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${board.bnum}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\"></td>\n");
      out.write("\t\t\t<td>조회수</td>\n");
      out.write("\t\t\t<td>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${board.readcnt}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\n");
      out.write("\t\t</tr>\n");
      out.write("\t\t<tr>\n");
      out.write("\t\t\t<td>작성자</td>\n");
      out.write("\t\t\t<td colspan=\"3\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${board.writer}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("</td>\n");
      out.write("\t\t</tr>\n");
      out.write("\t\t<tr>\n");
      out.write("\t\t\t<td>이메일</td>\n");
      out.write("\t\t\t<td colspan=\"3\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${board.email}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("</td>\n");
      out.write("\t\t</tr>\n");
      out.write("\t\t<tr>\n");
      out.write("\t\t\t<td>제목</td>\n");
      out.write("\t\t\t<td colspan=\"3\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${board.subject}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("</td>\n");
      out.write("\t\t</tr>\n");
      out.write("\t\t<tr>\n");
      out.write("\t\t\t<td>내용</td>\n");
      out.write("\t\t\t<td colspan=\"3\"><pre>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${board.content}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("</pre></td>\n");
      out.write("\t\t</tr>\n");
      out.write("\t\t<tr>\n");
      out.write("\t\t\t<td>파일</td>\n");
      out.write("\t\t\t<td colspan=\"3\">\n");
      out.write("\t\t\t\t");
      if (_jspx_meth_c_005fforEach_005f0(_jspx_page_context))
        return;
      out.write("\n");
      out.write("\t\t\t</td>\t\n");
      out.write("\t\t</tr>\n");
      out.write("\t\t<tr>\n");
      out.write("\t\t\t<td>등록일자</td>\n");
      out.write("\t\t\t<td colspan=\"3\">");
      if (_jspx_meth_fmt_005fformatDate_005f0(_jspx_page_context))
        return;
      out.write(" </td>\n");
      out.write("\t\t</tr>\n");
      out.write("\t\t<tr>\n");
      out.write("\t\t\t<td>수정일자</td>\n");
      out.write("\t\t\t<td colspan=\"3\">");
      if (_jspx_meth_fmt_005fformatDate_005f1(_jspx_page_context))
        return;
      out.write("</td>\n");
      out.write("\t\t</tr>\n");
      out.write("\t\t\n");
      out.write("\t\t<tr>\n");
      out.write("\t\t\t<td colspan=\"4\">\n");
      out.write("\t\t\t\t<button class=\"btn btn-warning\" id=\"btnModify\">수정</button>\n");
      out.write("\t\t\t\t<button class=\"btn btn-danger\" id=\"btnDelete\">삭제</button>\n");
      out.write("\t\t\t\t<button class=\"btn btn-secondary\" id=\"btnList\">목록</button>\n");
      out.write("\t\t\t</td>\n");
      out.write("\t\t\t\n");
      out.write("\t\t</tr>\n");
      out.write("\t</table>\n");
      out.write("</div>\n");
      out.write("<div class=\"container\">\n");
      out.write("\t\n");
      out.write("\t<!-- 댓글달기 -->\n");
      out.write("\t<h2>댓글</h2>\n");
      out.write("\t<div>\n");
      out.write("\t\t<label>작성자</label>\n");
      out.write("\t\t<input type=\"text\" id=\"replyWriter\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${sessionScope.userid}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\" readonly><br>\n");
      out.write("\t\t <div class=\"form-group\">\n");
      out.write("\t\t\t<label>내용</label>\n");
      out.write("\t\t\t<textarea class=\"form-control\" id = \"replyContent\" rows=\"2\" cols=\"20\"></textarea>\n");
      out.write("\t\t</div>\n");
      out.write("\t\t<button class=\"btn btn-success\" id=\"btnReplyAdd\">댓글추가</button>\t\n");
      out.write("\t</div>\n");
      out.write("\t<!-- 댓글목록 -->\n");
      out.write("\t<!-- <button id=\"btnReplyList\">댓글조회</button> -->\n");
      out.write("\t<div id=\"replies\">\n");
      out.write("\t\n");
      out.write("\t</div>\n");
      out.write("\t\n");
      out.write("</div>\n");
      out.write("</body>\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }

  private boolean _jspx_meth_c_005fset_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:set
    org.apache.taglibs.standard.tag.rt.core.SetTag _jspx_th_c_005fset_005f0 = (org.apache.taglibs.standard.tag.rt.core.SetTag) _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.SetTag.class);
    boolean _jspx_th_c_005fset_005f0_reused = false;
    try {
      _jspx_th_c_005fset_005f0.setPageContext(_jspx_page_context);
      _jspx_th_c_005fset_005f0.setParent(null);
      // /WEB-INF/views/board/../include/includeFile.jsp(7,0) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_c_005fset_005f0.setVar("path");
      // /WEB-INF/views/board/../include/includeFile.jsp(7,0) name = value type = javax.el.ValueExpression reqTime = true required = false fragment = false deferredValue = true expectedTypeName = java.lang.Object deferredMethod = false methodSignature = null
      _jspx_th_c_005fset_005f0.setValue(new org.apache.jasper.el.JspValueExpression("/WEB-INF/views/board/../include/includeFile.jsp(7,0) '${pageContext.request.contextPath}'",_jsp_getExpressionFactory().createValueExpression(_jspx_page_context.getELContext(),"${pageContext.request.contextPath}",java.lang.Object.class)).getValue(_jspx_page_context.getELContext()));
      int _jspx_eval_c_005fset_005f0 = _jspx_th_c_005fset_005f0.doStartTag();
      if (_jspx_th_c_005fset_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
      _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005fset_005f0);
      _jspx_th_c_005fset_005f0_reused = true;
    } finally {
      org.apache.jasper.runtime.JspRuntimeLibrary.releaseTag(_jspx_th_c_005fset_005f0, _jsp_getInstanceManager(), _jspx_th_c_005fset_005f0_reused);
    }
    return false;
  }

  private boolean _jspx_meth_c_005fforEach_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_005fforEach_005f0 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    boolean _jspx_th_c_005fforEach_005f0_reused = false;
    try {
      _jspx_th_c_005fforEach_005f0.setPageContext(_jspx_page_context);
      _jspx_th_c_005fforEach_005f0.setParent(null);
      // /WEB-INF/views/board/detail.jsp(249,4) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_c_005fforEach_005f0.setVar("file");
      // /WEB-INF/views/board/detail.jsp(249,4) name = items type = javax.el.ValueExpression reqTime = true required = false fragment = false deferredValue = true expectedTypeName = java.lang.Object deferredMethod = false methodSignature = null
      _jspx_th_c_005fforEach_005f0.setItems(new org.apache.jasper.el.JspValueExpression("/WEB-INF/views/board/detail.jsp(249,4) '${flist}'",_jsp_getExpressionFactory().createValueExpression(_jspx_page_context.getELContext(),"${flist}",java.lang.Object.class)).getValue(_jspx_page_context.getELContext()));
      int[] _jspx_push_body_count_c_005fforEach_005f0 = new int[] { 0 };
      try {
        int _jspx_eval_c_005fforEach_005f0 = _jspx_th_c_005fforEach_005f0.doStartTag();
        if (_jspx_eval_c_005fforEach_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
          do {
            out.write("\n");
            out.write("\t\t\t\t\t");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${file.filename}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
            out.write(" \n");
            out.write("\t\t\t\t\t<button class=\"fileDownload\" value=\"");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${file.filename}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
            out.write("\">다운로드</button> <br>\n");
            out.write("\t\t\t\t");
            int evalDoAfterBody = _jspx_th_c_005fforEach_005f0.doAfterBody();
            if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
              break;
          } while (true);
        }
        if (_jspx_th_c_005fforEach_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
          return true;
        }
      } catch (java.lang.Throwable _jspx_exception) {
        while (_jspx_push_body_count_c_005fforEach_005f0[0]-- > 0)
          out = _jspx_page_context.popBody();
        _jspx_th_c_005fforEach_005f0.doCatch(_jspx_exception);
      } finally {
        _jspx_th_c_005fforEach_005f0.doFinally();
      }
      _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.reuse(_jspx_th_c_005fforEach_005f0);
      _jspx_th_c_005fforEach_005f0_reused = true;
    } finally {
      org.apache.jasper.runtime.JspRuntimeLibrary.releaseTag(_jspx_th_c_005fforEach_005f0, _jsp_getInstanceManager(), _jspx_th_c_005fforEach_005f0_reused);
    }
    return false;
  }

  private boolean _jspx_meth_fmt_005fformatDate_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  fmt:formatDate
    org.apache.taglibs.standard.tag.rt.fmt.FormatDateTag _jspx_th_fmt_005fformatDate_005f0 = (org.apache.taglibs.standard.tag.rt.fmt.FormatDateTag) _005fjspx_005ftagPool_005ffmt_005fformatDate_0026_005fvalue_005fpattern_005fnobody.get(org.apache.taglibs.standard.tag.rt.fmt.FormatDateTag.class);
    boolean _jspx_th_fmt_005fformatDate_005f0_reused = false;
    try {
      _jspx_th_fmt_005fformatDate_005f0.setPageContext(_jspx_page_context);
      _jspx_th_fmt_005fformatDate_005f0.setParent(null);
      // /WEB-INF/views/board/detail.jsp(257,19) name = pattern type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_fmt_005fformatDate_005f0.setPattern("yyyy-MM-dd HH:mm:ss");
      // /WEB-INF/views/board/detail.jsp(257,19) name = value type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_fmt_005fformatDate_005f0.setValue((java.util.Date) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${board.regdate}", java.util.Date.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      int _jspx_eval_fmt_005fformatDate_005f0 = _jspx_th_fmt_005fformatDate_005f0.doStartTag();
      if (_jspx_th_fmt_005fformatDate_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
      _005fjspx_005ftagPool_005ffmt_005fformatDate_0026_005fvalue_005fpattern_005fnobody.reuse(_jspx_th_fmt_005fformatDate_005f0);
      _jspx_th_fmt_005fformatDate_005f0_reused = true;
    } finally {
      org.apache.jasper.runtime.JspRuntimeLibrary.releaseTag(_jspx_th_fmt_005fformatDate_005f0, _jsp_getInstanceManager(), _jspx_th_fmt_005fformatDate_005f0_reused);
    }
    return false;
  }

  private boolean _jspx_meth_fmt_005fformatDate_005f1(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  fmt:formatDate
    org.apache.taglibs.standard.tag.rt.fmt.FormatDateTag _jspx_th_fmt_005fformatDate_005f1 = (org.apache.taglibs.standard.tag.rt.fmt.FormatDateTag) _005fjspx_005ftagPool_005ffmt_005fformatDate_0026_005fvalue_005fpattern_005fnobody.get(org.apache.taglibs.standard.tag.rt.fmt.FormatDateTag.class);
    boolean _jspx_th_fmt_005fformatDate_005f1_reused = false;
    try {
      _jspx_th_fmt_005fformatDate_005f1.setPageContext(_jspx_page_context);
      _jspx_th_fmt_005fformatDate_005f1.setParent(null);
      // /WEB-INF/views/board/detail.jsp(261,19) name = pattern type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_fmt_005fformatDate_005f1.setPattern("yyyy-MM-dd HH:mm:ss");
      // /WEB-INF/views/board/detail.jsp(261,19) name = value type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_fmt_005fformatDate_005f1.setValue((java.util.Date) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${board.updatedate}", java.util.Date.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      int _jspx_eval_fmt_005fformatDate_005f1 = _jspx_th_fmt_005fformatDate_005f1.doStartTag();
      if (_jspx_th_fmt_005fformatDate_005f1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
      _005fjspx_005ftagPool_005ffmt_005fformatDate_0026_005fvalue_005fpattern_005fnobody.reuse(_jspx_th_fmt_005fformatDate_005f1);
      _jspx_th_fmt_005fformatDate_005f1_reused = true;
    } finally {
      org.apache.jasper.runtime.JspRuntimeLibrary.releaseTag(_jspx_th_fmt_005fformatDate_005f1, _jsp_getInstanceManager(), _jspx_th_fmt_005fformatDate_005f1_reused);
    }
    return false;
  }
}
