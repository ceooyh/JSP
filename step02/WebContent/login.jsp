<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
		text-align: center;
	}
</style>
</head>
<body>
		<jsp:include page="template/header.jsp"></jsp:include>
		<section>
		<div>
		<form method="post" action="login_action.jsp"></form>
			<table>
				<tr>
					<td><label for="id">아이디 :</label></td>
					<td><input type="text" placeholder="아이디를 입력하세요" name ="id" id="id"></td>
				</tr>
				<tr>
					<td><label for="pass">암호 : </label></td>
					<td><input type="text" placeholder="암호를 입력하세요" name ="pass" id="pass"></td>
				 </tr>
				<tr>
					<td><button type="submit">로그인</button> </td>
					<td><button id="register" type="button">회원가입</button></td>
				 </tr>
			</table>
		</section>
		<jsp:include page="template/footer.jsp"></jsp:include>
</body>
</html>