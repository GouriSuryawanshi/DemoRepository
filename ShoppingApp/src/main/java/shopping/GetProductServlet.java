package shopping;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/GetProducts")
public class GetProductServlet extends HttpServlet 
{
	Connection con;
	public void init(ServletConfig config) throws ServletException 
	{
		 con = (Connection)config.getServletContext().getAttribute("jdbccon");
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		PreparedStatement ps;
		ResultSet rs;
		PrintWriter out=response.getWriter();
		try
		{
			ps=con.prepareStatement("select * from product where cat_id=?");
			int cid1=Integer.parseInt(request.getParameter("cid"));
			ps.setInt(1, cid1);
			rs=ps.executeQuery();
			out.print("<form action='addtocart'>");
			out.print("select product : ");
			out.print("<select name='p'>");
			out.print("<option>Select Product</option>");
			while(rs.next())
			{
				out.print("<option value='"+ rs.getInt(1)+ "'>"+rs.getString(2)+"</option>");
				
			}
			out.print("</select>");
			out.print("<br/>");
			out.print("<br/>");
			out.print("<input type='submit' value='Add To Cart'/>");
			out.print("</form>");
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
		doGet(request, response);
	}

}
