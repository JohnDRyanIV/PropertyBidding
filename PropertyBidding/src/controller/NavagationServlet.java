package controller;

import java.io.IOException;
import java.util.ArrayList;   // this is for debugging purposes...delete
import java.util.List;   // this is for debugging purposes...delete

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Bid;
import model.Bidder;
import model.Property;

/**
 * Servlet implementation class NavagationServlet
 */
@WebServlet("/navigationServlet")
public class NavagationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NavagationServlet() {
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
		
		BidHelper dao = new BidHelper();
		
		BidderHelper bho = new BidderHelper();
		
		PropertyHelper pho = new PropertyHelper();
		
		String act = request.getParameter("doThisToBid");
		
		System.out.println("Action: " + act);  // this is for debugging purposes...delete
			
		String path = "/viewAllBidsServlet";
		
		List<Property> propList = new ArrayList<Property>();   // this is for debugging purposes....delete
		
		List<Bidder> bidderList = new ArrayList<Bidder>();    // this is for debugging purposes....delete
		
		if (act.equalsIgnoreCase("edit")) {
			try {
				Integer tempId = Integer.parseInt(request.getParameter("id"));
				Bid bidToEdit = dao.searchForBidById(tempId);
				request.setAttribute("bidToEdit", bidToEdit);
				path = "/edit-bid.jsp";
			} catch (NumberFormatException e) {
					System.out.println("Forgot to select a bid");
			}
		} else if (act.equals("add")) {
			if (bho.showAllBidders().isEmpty()) {  
				request.setAttribute("allBidders", " ");
			} else {
				request.setAttribute("allBidders", bho.showAllBidders());
				bidderList = new ArrayList<Bidder>();     // this is for debugging purposes....delete
			}
			if (pho.showAllProperties().isEmpty()) {
				request.setAttribute("allProperties", " ");
			} else {
				request.setAttribute("allProperties", pho.showAllProperties());
				propList = new ArrayList<Property>();     // this is for debugging purposes...delete
			}
				
			for (Bidder bidr : bidderList) {   // this is for debugging purposes...delete
				System.out.println(bidr.toString());
			}
			
			for (Property prop1 : propList) {   // this is for debugging purposes...delete
				System.out.println(prop1.toString());
			} 
			
			path = "/new-bid.jsp";   // redirect to the home page
		}
		
		// redirect to whichever jsp is in the
		// path variable
		getServletContext().getRequestDispatcher(path).forward(request, response);	
		
	}

}
