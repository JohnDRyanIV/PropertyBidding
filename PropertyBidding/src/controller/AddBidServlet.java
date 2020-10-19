package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class AddBidServlet
 */
@WebServlet("/addBidServlet")
public class AddBidServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddBidServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		BidderHelper bho = new BidderHelper();
		
		PropertyHelper pho = new PropertyHelper();
		
		// get list of all bidders and send to new-list.jsp
		if (bho.showAllBidders().isEmpty()) {  
			System.out.println("List of bidders is empty.");
			request.setAttribute("allBidders", " ");
		} else {
			System.out.println("Getting list of bidders");
			request.setAttribute("allBidders", bho.showAllBidders());
		}
		
		// get list of all properties and send to new-list.jsp
		if (pho.showAllProperties().isEmpty()) {
			System.out.println("List of properties is empty.");
			request.setAttribute("allProperties", " ");
		} else {
			System.out.println("Getting list of properties");
			request.setAttribute("allProperties", pho.showAllProperties());
		}
		
		getServletContext().getRequestDispatcher("/new-bid.jsp").forward(request, response);
	}

}
