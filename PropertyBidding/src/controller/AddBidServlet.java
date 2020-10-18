package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Bid;
import model.Bidder;
import model.Property;

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
		
		BidHelper dao = new BidHelper();
		
		BidderHelper bho = new BidderHelper();
		
		PropertyHelper pho = new PropertyHelper();
		
		Bidder bidr = null;
		
		Property prop = null;
		
		Integer bidderId;
		
		Integer propertyId;
		
		Double bidAmount = null;
		
		try {  // get the bidder ID of the selected bidder
			bidderId = Integer.parseInt(request.getParameter("bidderId"));
			bidr = bho.searchForBidderById(bidderId);
		} catch (NumberFormatException e) {
			bidderId = null;
			System.out.println("Forgot to select a bidder");
		}
		try {  // get the property ID of the selected property
			propertyId = Integer.parseInt(request.getParameter("propertyId"));
			prop = pho.searchForPropertyById(propertyId);
		} catch (NumberFormatException e) {
			propertyId = null;
			System.out.println("Forgot to select a property");
		}
		try {  // get the bid amount that was entered
			bidAmount = Double.parseDouble(request.getParameter("bidAmount"));
		} catch (NumberFormatException e) {
			bidAmount = null;
			System.out.println("Invalid bid amount entered");
		}
		
		// check to see if we are missing any input from the user.  if all three
		// pointers are not null, then we are okay to add the bid to the database.
		if ((bidderId != null) && (propertyId != null) && (bidAmount != null)) { 
			Bid newBid = new Bid(bidAmount, prop, bidr);                       
			dao.insertBid(newBid);
		}
		
		getServletContext().getRequestDispatcher("/index.html").forward(request, response);
	}

}
