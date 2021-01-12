<%@page import="dao.BoardDAO"%>
<%@page import="vo.PaggingVO"%>
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
<style type="text/css">
#container {
	/* height: 600px; */
	/* background-color: lime; */
}
</style>
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
<style>
	.board{
		margin:20px auto;
		border-collapse: collapse;
	}
	.board th, .board td{
		padding: 10px;
		text-align: center;
	}
	.board th{
		border-top : 2px solid black;
		border-bottom : 2px solid black;
	}
	.board td{
		border-top : 1px solid black;
		border-bottom : 1px solid black;
	}
	.board tr:last-child > td {
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
	.page_bar{
		position:relative;
		text-align: center;
	}
	.page_bar a:link,.page_bar a:visited {
		color:black;
		text-decoration: none;
		font-size : 18px;
		margin-left: 10px;
		margin-right: 10px;
	}
	.page_bar a:hover{
		font-weight: bold;
		color:red;
	}
	.btn_writer{
		position:absolute;
		right:0px;
	}
</style>
</head>
<body>
	<!-- header.jsp를 현재 문서에 포함 -->
	<jsp:include page="/template/header.jsp" flush="false"></jsp:include>
	<div id="container">
		<!-- 게시판 글목록 -->
		<%
			int pageNo = 1;//맨처음 접속을 했을때 페이지 번호가 없으니 첫페이지로 고정시켜준다
			if(request.getParameter("pageNo") != null)//페이지 번호가 없으면 해당 페이지로 이동시켜주기 위해서 페이지 번호를 지정
				pageNo = Integer.parseInt(request.getParameter("pageNo"));
			//ArrayList<BoardDTO> list = BoardService.getInstance().selectBoardList(pageNo);
		%>
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
						<td><%=list.get(i).getTitle() %>
						 <%=list.get(i).getcCount() == 0 ? "" : "["+list.get(i).getcCount()+"]"  %></td>
						<td><%=list.get(i).getWriter() %></td>
						<td><%=list.get(i).getbDate() %></td>
						<td><%=list.get(i).getbCount() %></td>
						<td><%=list.get(i).getbLike() %></td>
						<td><%=list.get(i).getbHate() %></td>
					</tr>					
					<%
				}
			//페이징 정보를 읽어옴
			int count = BoardDAO.getInstance().getCount();
			PaggingVO pageVO = new PaggingVO(count, pageNo);
			%>
			<tr>
				<td colspan="7">
					<div class="page_bar">
					<!-- 페이징 처리 시작 -->
					<%
						if(pageVO.isPreviousPageGroup()){
					%>
						<!-- 현재 페이지 그룹의 첫번째 페이지 - 1 == 이전페이지그룹의 마지막 페이지 -->
						<a href="index.jsp?pageNo=<%=pageVO.getStartPageOfPageGroup()-1%>">◀</a>
					<%
						}
						int start = pageVO.getStartPageOfPageGroup();
						int end = pageVO.getEndPageOfPageGroup();
						for(int i=start;i<=end;i++){
					%>
						<!-- loop start -->
						<a href="index.jsp?pageNo=<%=i%>"><%=i %></a>
						<!-- loop end -->
						<%
						}
						if(pageVO.isNextPageGroup()){
						%>
						<a href="index.jsp?pageNo=<%=pageVO.getEndPageOfPageGroup()+1%>">▶</a>
						<%
						}
						%>
					<!-- 페이징 처리 종료 -->
						<a href="<%=request.getContextPath()%>/board/board_write_view.jsp" class="btn_writer">글쓰기</a>
					</div>
				</td>
			</tr>
		</table>

	</div>
	<jsp:include page="/template/footer.jsp" flush="false"></jsp:include>
	<script>
		console.log("Context : <%= request.getContextPath() %>");
		console.log("URI : <%= request.getRequestURI() %>");
		console.log("URL : <%= request.getRequestURL() %>");
		console.log("Path : <%= request.getServletPath() %>");
		console.log("QueryString : <%= request.getQueryString() %>");
		console.log("Path : " + location.href);
		
	</script>
</body>
</html>







