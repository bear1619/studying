package com.google.classroom.chapter1.study.servlet.project;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.classroom.chapter1.study.util.SwagUtil;

public class RegisterServlet extends HttpServlet {

  @Override
  protected void service(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    // パラメーター受取
    request.setCharacterEncoding("UTF-8");
    String id = request.getParameter("id");
    String pwd = request.getParameter("pwd");
    String familyName = request.getParameter("familyName");
    String givenName = request.getParameter("givenName");
    String email = request.getParameter("email");

    addMember(id, pwd, familyName, givenName, email);

    // 結果を返す
    response.setContentType("text/html;charset=utf-8");
    PrintWriter pw = response.getWriter();
    SwagUtil.createCommonHeader(pw);
    pw.println("<body>");

    if (id.equals("errorUser")) {
      pw.println("IDに問題があります！！失敗<br/>");
      pw.println("<a href='javascript:history.go(-1)'>前へ</a>");
    } else {
      pw.println(familyName + " " + givenName + "様! 登録ありがとうございます。<br/>");
      pw.println("<a href='http://localhost:9080/study/main'>メインへ</a>");
    }
    pw.println("</body>");
    pw.println("</html>");
  }

  private void addMember(String id, String pwd, String familyName, String givenName, String email) {
    Connection connection;
    Statement statement;
    String sql;
    String jdbcUrl = "jdbc:mysql://localhost:3306/testdb";
    String databaseId = "test";
    String databasePw = "1234";
    try {
      Class.forName("com.mysql.jdbc.Driver");
    } catch (ClassNotFoundException e) {
      System.out.println("Class not found : " + e);
    }
    try {
      connection = DriverManager.getConnection(jdbcUrl, databaseId, databasePw);
      statement = connection.createStatement();
      sql = "INSERT INTO MEMBER (ID, PASSWORD, FAMILY_NAME, GIVEN_NAME, EMAIL) " + "VALUES ('" + id
          + "',password('" + pwd + "'),'" + familyName + "','" + givenName + "','" + email + "')";
      statement.executeUpdate(sql);
      statement.close();
      connection.close();
    } catch (SQLException e) {
      System.err.println("SQL Error : " + e);
    } catch (Exception e) {
      System.err.println("Error : " + e);
    }
  }
}
