<%@page import="vo.memberVo"%>
<%@page import="service.memberService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page errorPage="error.jsp" %>
<%
	request.setCharacterEncoding("utf-8");
	String id = request.getParameter("id");
	String pass = request.getParameter("pass");
	String name = request.getParameter("name");
	int age = Integer.parseInt(request.getParameter("age"));

	memberService.getInstance().updateMemberVo(id, pass, name, age);
	
	session.setAttribute("name", name);
	session.setAttribute("age", name);
	
	response.sendRedirect("main.jsp");
%>