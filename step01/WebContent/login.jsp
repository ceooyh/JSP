<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	테스트
	<%
		String id = request.getParameter("id");
		String pass = request.getParameter("pass");
	%>
	사용자로부터 입력받은 아이디 : <%=id %>,<br> 
	사용자로부터 입력받은 비밀번호 : <%=pass %><br>
</body>
</html>