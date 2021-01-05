<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="template/header.jsp" flush="false"></jsp:include>
	<div class="container">
		페이지 처리 중 에러가 났습니다.
		Exception Class : <%=exception.getClass().getName() %><br>
		Exception Message : <%=exception.getMessage() %><br>
		<a href="javascript:history.back();">뒤로가기</a>
	</div>
	<jsp:include page="template/footer.jsp" flush="false"></jsp:include>
</body>
</html>