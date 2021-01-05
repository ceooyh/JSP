<%@page import="dto.BoardDTO"%>
<%@page import="dto.BoardDTO"%>
<%@page import="service.BoardService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	//서비스 클래스로 데이터 보냄
	String title = request.getParameter("title");
	String writer = request.getParameter("writer");
	String content = request.getParameter("content");
	
	BoardDTO dto = new BoardDTO(title,writer,content);
	
	BoardService.getInstance().insertBoardDTO(dto);
	//게시글 조회 페이지board_view.jsp
	//response.sendRedirect("../board_view.jsp");
%>