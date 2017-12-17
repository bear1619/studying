package com.google.classroom.chapter1.study.servlet.project;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegisterServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// パラメーター受取
		request.setCharacterEncoding("UTF-8");
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		String email = request.getParameter("email");

		// 結果を返す
		response.setContentType("text/html;charset=euc-kr");
		PrintWriter pw = response.getWriter();
		pw.println("<html>");
		pw.println("<head></head>");
		pw.println("<body>");

		if (id.equals("errorUser")) {
			pw.println("IDに問題があります！！失敗<br/>");
			pw.println("<a href='javascript:history.go(-1)'>前へ</a>");
		} else {
			pw.println(id + "様! 登録ありがとうございます。<br/>");
		}
		pw.println("</body>");
		pw.println("</html>");
	}
}
