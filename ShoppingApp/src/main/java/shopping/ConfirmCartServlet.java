package shopping;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/confirmcart")
public class ConfirmCartServlet extends HttpServlet 
{
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		PrintWriter out =response.getWriter();
		HttpSession session =request.getSession();
		out.print("<br/><h4 style='color:blue'>Your order is confirmed</h4>");
		out.print("<br/><p>Thanks for shopping with us</p><hr/>");
		User user = (User)session.getAttribute("loginuser");
		out.print("<br/>Your e-bill will be mailed at : "+user.getEmail() );
		out.print("<br/>You will receive msg before delivery on "+user.getContact());
		//summary of shopping into shopping table
		
		String uid=user.getUid();
		java.sql.Timestamp today = new java.sql.Timestamp( new java.util.Date().getTime());
		Float price=(Float) session.getAttribute("tprice");
		out.print("<hr/><br/><a href='logout'> LOGOUT </a>");
		//insert userid date and price in shopping table
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
		doGet(request, response);
	}

}
