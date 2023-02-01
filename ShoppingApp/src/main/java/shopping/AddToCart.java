package shopping;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/addtocart")
public class AddToCart extends HttpServlet
{
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		
		
		PrintWriter out=response.getWriter();
		
		int selectpid=Integer.parseInt(request.getParameter("p"));
		
		HttpSession session=request.getSession();
		
		List<Integer> plist=null;
		plist = (List<Integer>)session.getAttribute("cart");
		
		if(plist==null)
			plist=new ArrayList<>();
		plist.add(selectpid);
		
		session.setAttribute("cart", plist);
		
		out.print("Select product id : "+selectpid+" is added in the cart <br/>");
		out.print("No of selected products : "+plist.size());
		out.print("<br/><a href='viewcart'> View Cart </a>");
		out.print("<br/><a href='home'>Add More</a>");
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
		doGet(request, response);
	}

}
