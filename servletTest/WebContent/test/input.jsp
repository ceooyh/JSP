<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 전송 버튼을 클릭했을때 routeTest서블릿에서 result폴더에 있는 route_result.jsp로 이동하여 입력한 내용을 전송 -->
	<form action="../RouteTest">
		<input type="text" name="txt"><button>전송</button>
	</form>
</body>
</html>