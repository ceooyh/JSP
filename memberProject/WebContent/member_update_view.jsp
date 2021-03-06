<%@page import="vo.memberVo"%>
<%@page import="service.memberService"%>
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
		System.out.println(session.getAttribute("login")); 
		System.out.println(session.getAttribute("login")==null); 
		//세션 유효 처리
		if(session.getAttribute("login") == null || !((boolean)session.getAttribute("login")) ){
			//sendRedirect 해도 바로 페이지 이동 X
			response.sendRedirect("login.jsp"); 
			return;			
		}
		//회원 정보
		memberVo vo = memberService.getInstance().selectMemberVO((String)session.getAttribute("id"));
				
	%>
	<jsp:include page="template/header.jsp"></jsp:include>
		<section>
			<div class="container">
				<form method="post" action="update_process.jsp">
					<table>
						<tr>
							<td><label for="id">아이디 :</label></td>
							<td><input type="text" placeholder="수정할 이름을 입력하세요" name="id" value="<%=vo.getId()%>" readonly></td>
						</tr>
						<tr>
							<td><label for="pass">암호 :</label></td>
							<td><input type="text" placeholder="수정할 암호를 입력하세요" name ="pass" id="pass"></td>
						</tr>
						<tr>
							<td><label for="name">이름 :</label></td>
							<td><input type="text" placeholder="수정할 이름을 입력하세요" name ="name" value="<%=vo.getName()%>"></td>
						</tr>
						<tr>
							<td><label for="pass">나이 : </label></td>
							<td><input type="text" placeholder="수정할 나이를 입력하세요" name="age" value="<%=vo.getAge()%>"></td>
						 </tr>
						<tr>
							<td><button type="submit">수정</button> </td>
						 </tr>
					</table>
				</form>
			</div>
		</section>
	<jsp:include page="template/footer.jsp"></jsp:include>
</body>
</html>