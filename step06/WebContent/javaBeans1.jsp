<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:useBean id="person" class="dto.PersonDTO" scope="page"></jsp:useBean>
	<jsp:setProperty property="name" name="person" value="홍길동"/>
	<jsp:setProperty property="age" name="person" value="20"/>
	<%=person.getName() %>
	<%=person.getAge() %>
	<hr>
	<jsp:useBean id="person1" class="dto.PersonDTO" scope="session"></jsp:useBean>
	<jsp:setProperty property="name" name="person1" value="홍길동1"/>
	<jsp:setProperty property="age" name="person1" value="202"/>
	<%=person1.getName() %>
	<%=person1.getAge() %>
	<hr>
	<a href="javaBeans2.jsp">페이지 이동</a>
</body>
</html>