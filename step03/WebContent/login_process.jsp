<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	/*
		<세션(Session)>
		-웹브라우저 : 서버에 저장되어 있는 데이터
		-웹브라우저가 닫히면 데이터는 전부 날아감
		(사용자 데이터가 서버에 저장)
		
		<쿠키(cookie)>
		-사용자 데이터 -> 사용자 디바이스에 저장
		민감한 개인정보를 저장하지 않습니다.
		털려도 되는 데이터를 저장해둡니다.
	*/
	String id = request.getParameter("id");
	String pass = request.getParameter("pass");
	
	//session.setMaxInactiveInterval(60*30); // 30분동안 기다린다.(초단위로 들어감)
	if(id.equals("admin") && pass.equals("1234")){
		//로그인 성공 처리
		session.setAttribute("login", true);
		session.setAttribute("name", "관리자");
		session.removeAttribute("msg");
	}else{
		//로그인 실패 처리
		session.setAttribute("login", false);
		session.setAttribute("msg", "로그인에 실패 하셨습니다. 아이디 비밀번호 확인 하세요");
	}

	response.sendRedirect("login.jsp");

%>

