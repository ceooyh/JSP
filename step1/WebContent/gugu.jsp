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
		//parameter값은 반드시 input의 name속성값으로 넣어줘야한다.
		int dan = Integer.parseInt(request.getParameter("dan"));
		response.getWriter().println("<h2>"+ dan +"단</h2>");
		
		for(int i =1;i<10;i++){
	%>
		<p><%=dan %> * <%=i %> = <%=dan * i %></p>
	<%
		}
	%>
</body>
</html>