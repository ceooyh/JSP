<%@page import="service.MemberService"%>
<%@page import="vo.MemberVO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자 메인 페이지</title>
<style>
.container{
	width:1200px;
	margin:0px auto;
	padding-top:30px;
	box-sizing: border-box;
}
#menu_bar{
	width:1200px;
	box-sizing: border-box;
	text-align: center;
}
#menu_bar > select{
	width:150px;
	padding:5px;
	margin-right:5px;
}
#menu_bar > input{
	width:200px;
	padding:5px;
	margin-right:5px;
}
#menu_bar > button{
	width:100px;
	padding:5px;
}
#title > li {
	width: 230px;
	font-size:16px;
	display: inline-block;
	text-align: center;
	font-weight: bold;
	padding:10px;
	box-sizing: border-box;
}
#title{
	font-size:0px;
	padding:0;
}
table{
	border-collapse: collapse;
}
td{
	width:230px;
	text-align: center;
	padding:10px;
	box-sizing: border-box;
}
</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script>
	$(function() {
		$("#btn_submit").click(function(e) {
			var data = $("#search").serialize();//kind=id&name=검색어
			$.ajax({
				url : "SearchProcess.jsp",
				data : data,
				method : 'get',
				success : function(d) {
					console.log(d);
					var arr = d.replaceAll("\n","").split(",");
					console.log(arr);
					var result = "<table>";
					for(i=0;i<arr.length-1;i++){
						//한건당 한줄씩 표현
						var txt = arr[i].split(" ");
						result += "<tr><td>"+txt[0]+"</td>"+"<td>"+txt[1]+"</td>"+"<td>"+txt[2]+"</td>"
						+"<td>"+txt[3]+"</td><td></td></tr>";
					}
					arr += "</table>";
					$("#content_area").html(result);
				}
			});
			e.preventDefault();	
		});
		
	});	
</script>
</head>
<body>
	<%
		if(session.getAttribute("login") == null || !session.getAttribute("grade").equals("master")){
			%>
				<script>
					location.href="main.jsp";
				</script>
			<%
		}
	
		//전체 회원 목록 읽어옴
		ArrayList<MemberVO> list = MemberService.getInstance().selectAllMemberVO();
	%>
	<jsp:include page="template/header.jsp"></jsp:include>
	
	<div class="container">
		<div id="menu_bar">
			<form id="search">
				<select name="kind">
					<option value="id">아이디</option>
					<option value="name">이름</option>
					<option value="grade">등급</option>
				</select>
				<input type="text" name="search">
				<button id="btn_submit">검색</button>
			</form>
		</div>
		<hr>
		<div id="content">
			<ul id="title">
				<li>아이디</li>
				<li>이름</li>
				<li>나이</li>
				<li>등급</li>
				<li>비고</li>
			</ul>
			<hr>
			<div id="content_area">
				<table>
				<%
					for(int i=0;i<list.size();i++){
						%>
						<tr> 
							<td><%=list.get(i).getId() %>
							<input type="hidden" value="<%=list.get(i).getId() %>"></td>
							<td><input type="text" value="<%=list.get(i).getName() %>"></td>
							<td><input type="text" value="<%=list.get(i).getAge() %>"></td>
							<td><input type="text" value="<%=list.get(i).getGrade() %>"></td>
							<td>
								<a href="#">수정</a> / <a href="#">삭제</a>  
							</td>
						</tr>
						<%
					}
				
				%>
				</table>
			</div>
		</div>
		
	</div>
			
	<jsp:include page="template/footer.jsp"></jsp:include>
</body>
</html>








