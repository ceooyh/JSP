<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- text box, submit button -->
	<!-- action : 전송을 할 서버 페이지를 지정하는 속성 -->
	<form action="jsp_search.jsp" method="get">
		<input type="text" name="search" placeholder="검색어를 입력하세요"><br>
		<button type="submit">검색</button>
	</form>
	<hr>
	
	<form action="gugu.jsp" method="get">
		<input type="text" name="dan" placeholder="출력할 구구단 단을 입력"><br>
		<button>전송</button>
	</form>
	
</body>
</html>