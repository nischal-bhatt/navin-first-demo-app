package com.telusko;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		
		//PrintWriter out = res.getWriter();
		
		//out.println(k + " is the result");
		
		req.setAttribute("k", k);
		
		
		RequestDispatcher rd = req.getRequestDispatcher("sq");
		rd.forward(req, res);
		
		
	}
}
