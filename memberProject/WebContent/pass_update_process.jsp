<%@page import="service.memberService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page errorPage="error.jsp"%>
<% 

	String id = request.getParameter("id"); 
	String pass = request.getParameter("pass"); 
	
	memberService.getInstance().updatePass(id, pass);
	
	request.getRequestDispatcher("login.jsp").forward(request, response);
%>