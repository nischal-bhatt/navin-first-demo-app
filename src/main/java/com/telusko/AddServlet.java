package com.telusko;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/add") //this will replace the stuff in web.xml
public class AddServlet extends HttpServlet{

	
	
	
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException
	{
		System.out.println("using post");
		int i = Integer.parseInt(req.getParameter("num1"));
		int j = Integer.parseInt(req.getParameter("num2"));
		
		int k = i + j;
		
		System.out.println("result is " + k);
		
		PrintWriter out = res.getWriter();
		
		out.println(k + " is the result");
		
	}
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException
	{
		System.out.println("using get");
		int i = Integer.parseInt(req.getParameter("num1"));
		int j = Integer.parseInt(req.getParameter("num2"));
		
		int k = i + j;
		
		System.out.println("result is " + k);
		
		//now lets maintain the data in the session
		//whenever u go to a webapp.. it will maintain a session for u
		// session is there throughout your visit 
		
		//put ur data into sessions
		// once you put ur k in a session
		// you can use k in your next servlet
		
		//HttpSession session = req.getSession();
		//session.setAttribute("k",k);
		
		Cookie cookie = new Cookie("k",k + "");
		res.addCookie(cookie);
		
		res.sendRedirect("sq");
		
		
		
		
		//res.sendRedirect("sq?k="+k); 
		//this technique comes under URL Rewriting
		//another way is session management
				
		
		//PrintWriter out = res.getWriter();
		
		//out.println(k + " is the result");
		
		//req.setAttribute("k", k);
		
		
		//RequestDispatcher rd = req.getRequestDispatcher("sq");
		//rd.forward(req, res);
		
		
		
	}
}
