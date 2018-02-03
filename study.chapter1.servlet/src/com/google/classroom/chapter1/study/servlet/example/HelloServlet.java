package com.google.classroom.chapter1.study.servlet.example;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet テスト・クラス
 *
 * @author : choi.ki.duc
 *
 */
public class HelloServlet extends HttpServlet {

  /**
   * 原則サーブレットクラスは doGetまたは、doPostのみ作成とする.
   * コンテナーが生成下Request、Responseオブジェクトを受け取ることを担う。
   */
  @Override
  public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
    resp.setContentType("text/html; charset=UTF-8");

    // レスポンスのオブジェクトをPrintWriterを使用し、クライアントへHTMLを出力する。
    PrintWriter out = resp.getWriter();
    out.println("<HTML><HEAD><TITLE>HelloServlet</TITLE></HEAD>");
    out.println("<BODY>");
    out.println("<H2> Clinet IP: " + req.getRemoteAddr() + "</H2>");
    out.println("<H2> Client Host : " + req.getRemoteHost() + "</H2>");
    out.println("<H2> Request URI : " + req.getRequestURI() + "</H2>");
    out.println("</BODY></HTML>");
  }
}