<%@page import="service.memberService"%>
<%@page import="vo.memberVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page errorPage="error.jsp" %>
<%
	request.setCharacterEncoding("utf-8");
	String id = request.getParameter("id");
	String pass = request.getParameter("pass");
	String name = request.getParameter("name");
	int age = Integer.parseInt(request.getParameter("age"));
	
	memberVo vo = new memberVo(id,pass,name,age);
	//서비스 클래스로 vo를 전달
	memberService.getInstance().insertMemberVo(vo);
	
	RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
	dispatcher.forward(request, response);
%>