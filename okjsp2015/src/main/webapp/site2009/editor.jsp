<%@page import="kr.pe.okjsp.util.CommonUtil"%><%
	response.sendRedirect("http://www.okjsp.net/site2009/editor_jquery.jsp?bbs="+
			CommonUtil.nchk(request.getParameter("bbs"),"bbs6"));
%>