<%@page import="obj.Person"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
		<%
		Person p = (Person)request.getAttribute("obj");
	%>
		미성년자 여부 확인
		이름 : <%=p.getId() %><br>
		나이 : <%=p.getAge() %><br>
		미성년자입니다.
</body>
</html>