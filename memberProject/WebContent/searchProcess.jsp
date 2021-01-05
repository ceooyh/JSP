<%@page import="vo.memberVo"%>
<%@page import="java.util.ArrayList"%>
<%@page import="service.memberService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// 검색할 종류
	String kind = request.getParameter("kind");
	//검색어
	String search = request.getParameter("search");
	
	ArrayList<memberVo> list = memberService.getInstance().searchKindMemberVO(kind, search);
	
	String result = "";
	
	//검색 결과를 받아서 클라이언트에 출력
	if(kind.equals("grade"))
		kind = "gname";
	search = search.toUpperCase();
	for(int i=0;i<list.size();i++){
		result += list.get(i).getId() + " " + list.get(i).getName() + " "+ list.get(i).getAge() +" " + list.get(i).getGrade() + ",";
	}
	out.write(result);

	
%>