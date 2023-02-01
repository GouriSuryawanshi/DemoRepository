package shopping;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/header")
public class HeaderServlet extends HttpServlet 
{
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		PrintWriter out= response.getWriter();
		HttpSession session=request.getSession();
		User u=(User)session.getAttribute("loginuser");
		String name=u.getFname()+" "+u.getMname()+" "+u.getLname();
		out.print("<h2>"+"WELCOME "+name+"</h2></br>");
		out.print("<a href='Update.jsp'>Update details </a>");
		out.print("<br/> <hr/>");
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
		doGet(request, response);
	}

}
