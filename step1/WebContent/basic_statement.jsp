<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>기초문법</title>
</head>
<body>
	<!-- 선언문 작성 -->
	<%!
		//필드와 메서드를 작성하는장소(jsp를 클래스라고 생각하면 된다.)
		String message = "선언문 메세지";
		//필드 선언하고 getMessage란 메서드 한개 만든거라고 보면된다.
		public String getMessage(){
			return message;
		}
	%>
	
	
	<!-- 표현식 작성 -->
	선언문 필드 테스트 : <%=message %><br>
	선언문 메서드 테스트 : <%=getMessage() %><br>
	
	<!-- 스크립트릿, 사용자가 서버에 데이터를 전달하는 수단 -->
	<%
		//request는 사용자의 요구사항 및 사용자 정보를 담고 있는 객체
		int num = Integer.parseInt(request.getParameter("num"));
		String msg = request.getParameter("msg");
	
	%>
	스크립트 테스트 : <%=num%>
	<br>
	스크립트 테스트 : <%=msg%>
	
	<!-- 실제 jsp가 일처리 하는 코드 -->
	<%
		//웹에 출력부분
		response.getWriter().println(message+1);
		response.getWriter().println("<br>");
		response.getWriter().println(message+2);
		response.getWriter().println("<br>");
	%>
</body>
</html>