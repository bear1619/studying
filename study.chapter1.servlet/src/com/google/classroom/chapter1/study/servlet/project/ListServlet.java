package com.google.classroom.chapter1.study.servlet.project;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ListServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 結果を返す
		response.setContentType("text/html;charset=utf-8");
		PrintWriter pw = response.getWriter();
		pw.println("<html>");
		pw.println("<head></head>");
		pw.println("<body>");
		pw.println("<table border='1' cellspacing='0'>");
		pw.println("<tr>");
		pw.println("<th>ID</th>");
		pw.println("<th>姓</th>");
		pw.println("<th>名</th>");
		pw.println("<th>eメール</th>");
		pw.println("</tr>");
		pw = selectMember(pw);
		pw.println("</body>");
		pw.println("</html>");
	}

	private PrintWriter selectMember(PrintWriter pw) {
		Connection connection;
		Statement statement;
		ResultSet rs = null;
		String sql;
		String jdbcUrl = "jdbc:mysql://localhost:3306/testdb";
		String databaseID = "test";
		String databasePW = "1234";
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("Class not found : " + e);
		}
		try {
			connection = DriverManager.getConnection(jdbcUrl, databaseID, databasePW);
			statement = connection.createStatement();
			sql = "SELECT * FROM MEMBER";
			rs = statement.executeQuery(sql);
			if (rs.next()) {
				do {
				    String id = rs.getString("ID");
				    String family_name = rs.getString("family_name");
				    String given_name = rs.getString("given_name");
				    String email = rs.getString("email");
				    pw.println("<tr>");
				    pw.println("<td>" + id + "</td>");
				    pw.println("<td>" + family_name + "</td>");
				    pw.println("<td>" + given_name + "</td>");
				    pw.println("<td>" + email + "</td>");
				    pw.println("</tr>");
				} while (rs.next());
			} else {
			    pw.println("<tr>");
			    pw.println("<td colspan='4'>登録情報が存在しません。</td>");
			    pw.println("</tr>");
			}
			statement.close();
			connection.close();
		} catch (SQLException e) {
			System.err.println("SQL Error : " + e);
		} catch (Exception e) {
			System.err.println("Error : " + e);
		}
		return pw;
	}
}
