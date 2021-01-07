<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> Application - 1 </title>
</head>
<body>
	<%
		application.setAttribute("app_num", 777);
	%>
	
	<%=application.getServerInfo() %><br>
	<%=application.getRealPath("application_1.jsp") %><Br>
	<a href="application_2.jsp">다음페이지</a>
</body>
</html>