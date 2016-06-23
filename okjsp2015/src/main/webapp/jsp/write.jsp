<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@ page pageEncoding="euc-kr"
    import="java.util.*,kr.pe.okjsp.*,kr.pe.okjsp.util.CommonUtil" errorPage="/jsp/error.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core"%>
<jsp:useBean id="member" class="kr.pe.okjsp.member.Member" scope="session"/>
<jsp:useBean id="article" class="kr.pe.okjsp.Article" scope="request"/>
<%
	boolean isMSIE = request.getHeader("user-agent").indexOf("MSIE") > -1; 
	
	boolean isLogin = CommonUtil.getCookieLong(request, "sid") > 0;
	if (!isLogin) {
		response.sendRedirect(Navigation.getPath("LOGFORM"));
		return;
	}
%>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=KSC5601">
	<script type="text/javascript" src="http://code.jquery.com/jquery-1.7.1.min.js"></script>
    <script src="/js/okjsp.js"></script>
    <script src='/js/okboard.js'></script>
    <script src='/js/ban.jsp'></script>
    <script src="/js/banner.js" charset="utf-8"></script>
    <link rel="stylesheet" href="/css/style.css" type="text/css">
    <link rel="stylesheet" href="/css/skin.css" type="text/css">
    <title>okjsp write</title>
</head>
<body class="body" leftmargin="0" topmargin="0" marginwidth="0" marginheight="0">
<jsp:include page="/top.jsp" />
<jsp:include page="/menu.jsp" />
<table class="tablestyle">
  <tr>
    <td valign='top'>
<form name="f1" method="post" ENCTYPE="multipart/form-data" onSubmit="return check()">
<table border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td colspan="3">
      <c:out value="${requestScope.header}" escapeXml="false" />
    </td>
  </tr>
  <tr>
    <td colspan="3">
        <b><c:out value="${bbsInfoMap[param.bbs].name}" /></b>
    </td>
  </tr>
</table>
<input type="hidden" name="bbs" value="<c:out value="${param.bbs}"/>">
<input type="hidden" name="pg" value="<c:out value="${param.pg}"/>">
<input type="hidden" name="act" value="<c:out value="${requestScope.pact}"/>">
<input type="hidden" name="seq" value="<c:out value="${article.seq}"/>">
<input type="hidden" name="ref" value="<c:out value="${article.ref}"/>">
<input type="hidden" name="lev" value="<c:out value="${article.lev}"/>">
<input type="hidden" name="step" value="<c:out value="${article.step}"/>">
<table border="0" cellspacing="0" cellpadding="0" id="writeForm">
  <tr>
    <td>�г���</td>
    <td>
      <input type="text" name="writer" 
      	value="<%= article.getWriter() %>" size="15"> ;�Ǹ���������!
<%
    if ("Y".equals(member.getProfile())) {
        %><img src="http://www.okjsp.pe.kr/profile/<%= member.getId() %>.jpg"
        	alt="<%= member.getId() %>"
        	style="width:16px"> <span class="tiny">logged in</span><%
    }
%>
    </td>
    <td>��й�ȣ</td>
    <td>
      <input type="password" name="password" 
		value="<%= CommonUtil.nchk(request.getParameter("password")) %>" maxlength="31" >
    </td>
  </tr>
  <tr>
    <td>Homepage</td>
    <td colspan="3">
      <input type="text" name="homepage"
        onChange="this.value=getRightURL(this.value)"
        value="<jsp:getProperty name="article"
          property="homepage"/>" size="50">
    </td>
  </tr>
  <tr>
    <td>����</td>
    <td colspan="3">
      <input type="text" name="subject" id="subject" value="<c:out value="${article.subject}" />">
      <input type="hidden" name="html" id="html" value="<%= article.getHtml() %>">
    </td>
  </tr>
  <tr>
    <td valign="top" height="163">����</td>
    <td colspan="3" valign="top" height="163">
<textarea name="content" id="content"><%= CommonUtil.rplc(article.getContent(), "&", "&amp;") %></textarea>
    </td>
  </tr>
  <tr>
    <td></td>
    <td colspan="3">
<%
	String bbs = request.getParameter("bbs");
	if ("bbs2".equals(bbs) ||
		"bbs4".equals(bbs) ||
		"TOOL".equals(bbs) ||
		"weblogic".equals(bbs) ||
		"xmltip".equals(bbs) ||
		"bbs7".equals(bbs) ||
		"bbs6".equals(bbs) ||
		"test".equals(bbs) ||
		"docs".equals(bbs)
		) {
%>
    <div>
<select name="ccl_id">
	<option value="0">Copyright-������(email������)���� ���۱�</option>
	<option value="1">CCL-������ǥ��</option>
	<option value="2">CCL-������ǥ��-�������Ǻ������</option>
	<option value="3">CCL-������ǥ��-�������</option>
	<option value="4">CCL-������ǥ��-�񿵸�</option>
	<option value="5">CCL-������ǥ��-�񿵸�-�������Ǻ������</option>
	<option value="6">CCL-������ǥ��-�񿵸�-�������</option>
</select>
	</div>
<%
	} else {
%><input type="hidden" name="ccl_id" value="0">
<%
	} //end ccl
%><script type="text/javascript">
	document.f1.ccl_id.value = "<%= CommonUtil.rplc(article.getCcl_id(), " ", "") %>";
</script>
<%
	ArrayList fileList = (ArrayList)request.getAttribute("arrdf");
	Iterator file = null;
	if (fileList != null) {
		file = fileList.iterator();
		while (file.hasNext()) {
			DownFile df = (DownFile)file.next();
			if (df.isImageFile()) {
%>&lt;img src="/upload/<%= df.getMaskName() %>"&gt;<br>
<%
			}
%><input type="checkbox" name="delFile" value="<%= df.getFseq() %>">����
<%= df.getFileName() %> <%= df.getFileSize() %> Bytes<br>
<%
		}
	}
%>
      <input type="file" name="filename4"><br>
      <input type="file" name="filename3"><br>
      <input type="file" name="filename2"><br>
      <input type="file" name="filename1"><br>
      <input type="file" name="filename0"><br>
    </td>
  </tr>
  <tr>
    <td colspan="6"></td>
  </tr>
</table>

<table border="0" cellspacing="0" cellpadding="0" height="21" width="600">
  <tr>
    <td colspan="3" height="5"></td>
  </tr>
  <tr>
    <td align="center">
    <input type="submit" value="������" name="send" style="width:50">
    &nbsp;
    <input type="button" value="���" onClick="history.back()" style="width:50">
  </td></tr>
</table>
</form>
    </td>
  </tr>
</table>
<jsp:include page="/footer.jsp" />
<script>
  init();
  document.f1.password.focus();
</script>
</body>
</html>
