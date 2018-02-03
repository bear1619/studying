package com.google.classroom.chapter1.study.servlet.project;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.classroom.chapter1.study.util.SwagUtil;

public class DeleteServlet extends HttpServlet {

  @Override
  protected void service(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    int n = 0;

    String id = request.getParameter("id");
    PrintWriter pw = response.getWriter();
    Connection connection = null;
    String jdbcUrl = "jdbc:mysql://localhost:3306/testdb"
        + "?verifyServerCertificate=false&amp;useSSL=true";
    String databaseId = "test";
    String databasePw = "1234";

    PreparedStatement pstmt = null;
    try {
      Class.forName("com.mysql.jdbc.Driver");
    } catch (ClassNotFoundException e) {
      System.out.println("Class not found : " + e);
    }
    try {
      connection = DriverManager.getConnection(jdbcUrl, databaseId, databasePw);

      String sql = "delete from member where id=?";
      pstmt = connection.prepareStatement(sql);
      pstmt.setString(1, id);
      n = pstmt.executeUpdate();
    } catch (SQLException se) {
      System.out.println(se.getMessage());
    } finally {
      try {
        if (pstmt != null) {
          pstmt.close();
        }
        if (connection != null) {
          connection.close();
        }
      } catch (SQLException se) {
        System.out.println(se.getMessage());
      }
    }
    if (n > 0) {
      response.sendRedirect("list.do");
    } else {
      SwagUtil.createCommonHeader(pw);
      pw.println("<body>");
      pw.println("削除に失敗しました");
      pw.println("<a href='javascript:history.go(-1)'>前のページ戻る</a>");
      pw.println("</body>");
      pw.println("</html>");
      pw.close();
    }
  }
}
