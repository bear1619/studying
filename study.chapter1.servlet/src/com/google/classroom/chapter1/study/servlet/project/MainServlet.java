package com.google.classroom.chapter1.study.servlet.project;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MainServlet extends HttpServlet{
	@Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html; charset=UTF-8");

        PrintWriter out = resp.getWriter();
        out.println("<html><headD><title>Main</title></head>");
        out.println("<body>");
        out.println("<ul>");
        out.println("<li><a href='register.html'>会員登録</a></li>");
        out.println("<li><a href='register.html'>会員登録</a></li>");
        out.println("</ul>");
        out.println("</body></html>");
    }

}
