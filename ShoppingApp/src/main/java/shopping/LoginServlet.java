package shopping;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/Login")
public class LoginServlet extends HttpServlet 
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
		PreparedStatement ps;
		ResultSet rs;
		PrintWriter  out=response.getWriter();
		
		String user=request.getParameter("uid");
		String password=request.getParameter("pwd");
		
		try
		{
			
			ps=con.prepareStatement("select * from users where u_id = ? and password = ?");
			ps.setString(1,user);
			ps.setString(2, password);
			
			rs=ps.executeQuery();
			
			if(rs.next())
			{
				
				Cookie [] all = request.getCookies();
				if(all != null)
				{
					for(Cookie c : all)
					{
						if(c.getName().equals("loginerror"))
						{
							c.setMaxAge(0);
							//modified cookie should be send back
							response.addCookie(c);
						}
					}
				}	
				HttpSession session= request.getSession();
				User u= new User(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7));
				session.setAttribute("loginuser",u);
				//out.print("successful");
				//create dispatcher object and call forward method
				RequestDispatcher rd= request.getRequestDispatcher("home");
				rd.forward(request, response);
			}
			else
			{
				Cookie c = new Cookie("loginerror","Invalid_username/Password");
				response.addCookie(c);
				response.sendRedirect("/ShoppingApp/login.jsp");
				
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}

}
