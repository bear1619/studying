package com.google.classroom.chapter1.study.servlet.project;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MainServlet extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
    resp.setContentType("text/html; charset=UTF-8");

    // レスポンスのオブジェクトをPrintWriterを使用し、クライアントへHTMLを出力する。
    PrintWriter out;

    out = resp.getWriter();

    out.println("<HTML><HEAD><meta charset='UTF-8'><title>Main</title></HEAD>");
    out.println("<BODY>");
    out.println("<ul>");
    out.println("<li><a href='register.html'>会員登録</a></li>");
    out.println("<li><a href='/study/list'>会員照会</a></li>");
    out.println("</ul>");
    out.println("</BODY></HTML>");

  }

}
