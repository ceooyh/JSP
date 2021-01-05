<%@page import="service.memberService"%>
<%@page import="vo.memberVo"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script type="text/javascript">
	$(function(){
		$("#btn_submit").click(function() {
			var data = $("#search").serialize();
				$.ajax({
					url: "searchProcess.jsp",
					data : data,
					method : 'get',
					success:function(d){
						console.log(d);
						var arr = d.replaceAll("\n","").split(",");
						cosole.log(arr);
						var result = ""
						for(i=0;i<arr.length-1;i++){
							//한건당 한줄씩 표현
							var txt = arr[i].split(" ");
							result += "<tr><td>" + txt[0]+"</td>"+"<td>" + txt[1]+"</td>"+"<td>" + txt[2]+"</td>"
							+"<td>" + txt[3]+"</td><td></td></tr>";
						}
						arr += "</table>";
						$("#content_area").html(result);
					}
				});
			e.preventDefault();	
		});
	});
</script>
<style type="text/css">
	.container{
		width: 1200px;
		margin: 0px auto;
		padding-top: 30px;
		box-sizing: border-box;
	}
	#menu_bar{
		width: 1200px;
		box-sizing: border-box;
		text-align: center;
	}
	#menu_bar > select{
		width: 150px;
		padding:5px;
		margin-right: 5px;
	}
	#menu_bar > button{
		width: 100px;
		padding:5px;
	}
	#title{
		font-size: 0px;
	}
	#title ul{
		padding : 0;
	}
	#title > li{
		font-size:16px;
		width : 220px;
		display: inline-block;
		text-align: center;
		font-weight: bold;
		padding: 10px;
		box-sizing: border-box;
	}
	table{
		border-collapse: collapse;
		width: 1200px;
	}
	td{
		width: 230px;
		text-align: center;
		padding: 10px;
		box-sizing: border-box;
	}
</style>
</head>
<body>
	<%
			if(session.getAttribute("login") == null || !session.getAttribute("grade").equals("master")){
				%>
				<script>
					location.href("main.jsp");
				</script>
				
	<%
			}
			//전체 회원 목록을 읽어옴
			ArrayList<memberVo> list= memberService.getInstance().selectAllMemberVO();
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
				<%
					for(int i=0;i<list.size();i++){
					%>
						<p>
							<span><%=list.get(i).getId() %></span>
							<span><%=list.get(i).getName() %></span>
							<span><%=list.get(i).getAge() %></span>
							<span><%=list.get(i).getGrade() %></span>
							<span>
								<a href="#">수정</a> / <a href="#">삭제</a>
							</span>
						</p>
				<%
					}
				%>			
			</div>
		</div>
	</div>
	<jsp:include page="template/footer.jsp"></jsp:include>
</body>
</html>