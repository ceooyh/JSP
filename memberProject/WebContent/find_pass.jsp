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
		box-sizing: border-box;
	}
	.container{
		padding-top:150px;
		width: 300px;
		margin: 0 auto;
	}
	label{
		width: 100px;
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
	<jsp:include page="template/header.jsp"></jsp:include>
		<section>
				<div class="container">
					<form method="post" action="pass_update.jsp">
						<table>
							<tr>
								<td><label for="id">아이디 :</label></td>
								<td><input type="text" placeholder="아이디를 입력하세요" name ="id" id="id"></td>
							</tr>
							<tr>
								<td><label for="name">이름 : </label></td>
								<td><input type="text" placeholder="암호를 입력하세요" name ="name" id="name"></td>
							 </tr>
							 <tr>
								<td><button type="submit">비밀번호 찾기</button></td>
							 </tr>
						</table>
						</form>
					</div>
		</section>
	<jsp:include page="template/footer.jsp"></jsp:include>
</body>
</html>