package com.google.classroom.chapter1.study.util;

import java.io.PrintWriter;

public class SwagUtil {

	public static void createCommonHeader(PrintWriter pw) {
		// HTML5宣言
		pw.println("<!DOCTYPE html>");
		pw.println("<html>");

		pw.println("<head>");

		pw.println("<style type=\'text/css\'>");
		pw.println("td {");
		pw.println("border: 1px solid #CCCCCC");
		pw.println("padding: 5px 15px;");
		pw.println("}");

		pw.println("</style>");

		pw.println("</head>");
	}

}
