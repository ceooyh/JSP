<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	${requestScope.file0 }<br>
	<!-- <a href="${requestScope.file0 }" download>파일 다운로드</a><br> -->
	<c:choose>
		<c:when test="${requestScope.dto0.type == 'image' }">
			<img src="${requestScope.dto0.path }">
		</c:when>
		<c:otherwise>
			<a href="filedownload.jsp?file=${requestScope.dto0.fileName }">파일 다운로드</a><br>		
		</c:otherwise>
	</c:choose>
	${requestScope.file1 }<br>
	<a href="${requestScope.file1 }" download>파일 다운로드</a>
</body>
</html>





