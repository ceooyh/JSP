<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	${requestScope.file0}<br>
	<a href="${requestScope.file0}">파일 다운로드</a><br>
	${requestScope.file1}<br>
	<a href="${requestScope.file1}">파일 다운로드</a><br>
</body>
</html>