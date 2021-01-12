package com.login;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=utf-8");//화면 출력시 문자코드 변경하는 부분
		response.getWriter().append("Served at: ").append(request.getContextPath());
		response.getWriter().append(request.getParameter("id"));
		//세션
		HttpSession session = request.getSession();
		session.setAttribute("text", "session message");
		
		//페이지 이동
		//response.sendRedirect("login_result.jsp");//사용자의 요청사항이 전부 소실
		System.out.println(request.getRequestURI());
		request.setAttribute("id", request.getParameter("id"));
		request.getRequestDispatcher("result/login_result.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");//한글 깨짐 방지 데이터 받았을때 문자코드 변경
		doGet(request, response);
	}

}
