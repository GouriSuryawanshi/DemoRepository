package shopping;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/remove")
public class RemoveFromCartServlet extends HttpServlet 
{

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		int sr_no=Integer.parseInt(request.getParameter("sr_no"));
		HttpSession session =request.getSession();
		List<Integer> ls=(List<Integer>)session.getAttribute("cart");
		ls.remove(sr_no-1);
		RequestDispatcher rd= request.getRequestDispatcher("/viewcart");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
		doGet(request, response);
	}

}
