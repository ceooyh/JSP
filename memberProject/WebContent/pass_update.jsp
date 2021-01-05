<%@page import="service.memberService"%>
<%@page import="dao.memberDao"%>
<%@page import="vo.memberVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page errorPage="error.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	section{
		width:1200px;
		margin:0 auto;
		height: 600px;
		box-sizing: border-box;
	}
	.container{
		padding-top:150px;
		width: 300px;
		margin: 0 auto;
	}
	td{
		height: 40px;
		box-sizing: border-box;
	}
	input{
		width: 250px;
		height: 30px;
	}
	button{
		width: 100px;
		height: 30px;
	}
</style>
</head>
<body>
		<%
			request.setCharacterEncoding("utf-8");
			String id = request.getParameter("id");
			String name = request.getParameter("name");
			
			memberService.getInstance().searchMemberVo(id, name);
		%>
	<section>
		<div class="container">
			<form method="post" action="pass_update_process.jsp">
				<table>
					<tr>
						<td><label for="id">아이디 :</label></td>
						<td><input type="text" placeholder="아이디를 입력하세요" name ="id" value="<%=id %>" readonly></td>
					</tr>
					<tr>
						<td><label for="pass">새 암호 : </label></td>
						<td><input type="text" placeholder="암호를 입력하세요" name ="pass" required></td>
					 </tr>
					<tr>
						<td><button type="submit">암호수정</button> </td>
					 </tr>
				</table>
				</form>
			</div>
		</section>
</body>
</html>

