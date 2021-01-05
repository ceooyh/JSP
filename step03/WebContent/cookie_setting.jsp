<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 쿠키에 쓸 수 있는 문자는 알파벳, 한글 문자, 숫자, : , _ 만 가능하다 -->
	<%
		Cookie cookie = new Cookie("test","쿠키테스트값");//띄어쓰기도 안된다.
		cookie.setMaxAge(120);//초단위이다.
		cookie.setPath("/");
		response.addCookie(cookie);
	%>
	<a href="cookie_result.jsp">쿠키 조회 페이지 이동</a>
</body>
</html>