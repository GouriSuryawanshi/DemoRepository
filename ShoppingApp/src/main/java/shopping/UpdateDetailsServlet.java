package shopping;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/update")
public class UpdateDetailsServlet extends HttpServlet 
{
	Connection con;
	public void init(ServletConfig config) throws ServletException 
	{
		 con = (Connection)config.getServletContext().getAttribute("jdbccon");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		PreparedStatement ps;
		try 
		{
			ps=con.prepareStatement("update users set email=?,contact=? where u_id=?");
			HttpSession session=request.getSession();
			User user=(User)session.getAttribute("loginuser");
			String email=request.getParameter("email");
			String contact=request.getParameter("contact");
			String uid=user.getUid();
			ps.setString(1, email);
			ps.setString(2, contact);
			ps.setString(3, uid);
			int n=ps.executeUpdate();
			System.out.println(n+" Profile updated");
			user.setEmail(email);
			user.setContact(contact);
			
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		RequestDispatcher rd= request.getRequestDispatcher("/home");
		rd.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
		doGet(request, response);
	}

}
