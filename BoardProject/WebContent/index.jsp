<%@page import="service.BoardService"%>
<%@page import="dto.BoardDTO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인페이지</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script>
	$(function(){
		$(".board tr").click(function(){
			if($(this).index() == 0) return;
			var bno = $(this).find("td").first().html();
			location.href = "<%=request.getContextPath()%>/board/board_view.jsp?bno="+bno;
			console.log($(this).find("td").first().html());
		});
	});
</script>
<style type="text/css">
	#container{
		height: 600px;
		/* background-color: lime; */
	}
	#container .board{
		margin:20px auto;
		border-collapse: collapse;
	}
	#container  th, td{
		padding: 10px;
		text-align: center;
	}
	#container  th{
		border-top : 2px solid black;
		border-bottom : 2px solid black;
	}
	#container  td{
		border-top : 1px solid black;
		border-bottom : 1px solid black;
	}
	#container  tr:last-child > td {
		border-bottom : 2px solid black;
	}
	.title{
		width:500px;	
	}
	.writer{
		width:150px;	
	}
	.date{
		width:200px;
	}
</style>
</head>
<body>
	<%
		ArrayList<BoardDTO> list = BoardService.getInstance().selectBoardList();
	%>
	<!-- header.jsp를 현재 문서에 포함 -->
	<jsp:include page="/template/header.jsp" flush="false"></jsp:include>
		<!-- 게시판 글목록 나올 수 있도록 작업 -->
		<div id="container">
		<table class="board">
			<tr>
				<th>글번호</th>
				<th class="title">제목</th>
				<th class="writer">작성자</th>
				<th class="date">작성일</th>
				<th>조회수</th>
				<th>좋아요</th>
				<th>싫어요</th>
			</tr>
			<%
				for(int i=0;i<list.size();i++){
					%>
					<tr>
						<td><%=list.get(i).getBno() %></td>
						<td><%=list.get(i).getTitle() %></td>
						<td><%=list.get(i).getWriter() %></td>
						<td><%=list.get(i).getbDate() %></td>
						<td><%=list.get(i).getbCount() %></td>
						<td><%=list.get(i).getbLike() %></td>
						<td><%=list.get(i).getbHate() %></td>
					</tr>					
					<%
				}
			%>
		</table>
	</div>
		<a href="<%=request.getContextPath() %>/board/board_write_view.jsp">글쓰기</a>
	<jsp:include page="/template/footer.jsp" flush="false"></jsp:include>
	
</body>
</html>







