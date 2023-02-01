package shopping;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/home")
public class HomeServlet extends HttpServlet 
{
Connection con;
	
	
	public void init(ServletConfig config) throws ServletException 
	{
		 con = (Connection)config.getServletContext().getAttribute("jdbccon");
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		RequestDispatcher rd = request.getRequestDispatcher("/header");
		rd.include(request, response);
		
	    Statement s;
		ResultSet rs;
		PrintWriter out=response.getWriter();
		
		try
		{
			s=con.createStatement();
			rs=s.executeQuery("select * from category");
			while(rs.next())
			{
				out.print("<a href='GetProducts?cid="+ rs.getInt(1) +"'>"+rs.getString(2)+"</a></br>");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	
	}

}
