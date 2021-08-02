package kr.or.pets.common;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class FileDownloadController
 */

public class FileDownloadController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static String ARTICLE_IMAGE = "C:\\workspace-sts\\article_image";

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAction(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAction(request, response);
	}

	private void doAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
	 	String imageFileName = request.getParameter("imageFileName");
	 	String pro_boardNum = request.getParameter("pro_boardNum");
	 	System.out.println("imageFileName : " + imageFileName);
	 	
	 	response.setHeader("Cache-Control", "no-chache");
	 	response.addHeader("content-disposition", "attachment;filename=" + imageFileName);
	 	
	 	String path = ARTICLE_IMAGE +"\\"+ pro_boardNum +"\\"+ imageFileName;
	 	File imageFile = new File(path);
	 	OutputStream out = response.getOutputStream();
	 	FileInputStream in = new FileInputStream(imageFile);
	 	
	 	byte[] buffer = new byte[1024 * 8];
	 	while(true) {
	 		int count = in.read(buffer);
	 		if(count == -1) break;
	 		out.write(buffer, 0, count);
	 	}
	 	
	 	in.close();
	 	out.close();
		
	}

}

























