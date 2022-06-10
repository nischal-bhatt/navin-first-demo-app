package com.telusko;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/sq")
public class SqServlet extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {

		int k = 0;
		Cookie cookies[]=req.getCookies();
		for (Cookie c : cookies)
		{
			if (c.getName().equals("k"))
			{
				k = Integer.parseInt(c.getValue());
			}
		}
		
		
		//HttpSession session = req.getSession();
		
		//int k = Integer.parseInt(req.getParameter("k"));
		//int k = (Integer)session.getAttribute("k");
		
		k = k*k;
		
		PrintWriter out = res.getWriter();
		//out.println("square root is " + k + " hi<br> ");
		
		//ServletContext context =  getServletContext();
		//String str = context.getInitParameter("name");
		
		ServletConfig ctx = getServletConfig();
		String str = ctx.getInitParameter("name");
		out.println("<html><body bgcolor='orange'>");
		out.println(str);
		out.println("</body></html>");
	
		//we will give u a feature jsp --> we will write java code in html
		//if you dont use jsp, you will keep needing to do the above
		System.out.println("sq called via send redirect");
	}
}
