package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Bid;
import model.Bidder;

/**
 * Servlet implementation class EditBidServlet
 */
@WebServlet("/editBidServlet")
public class EditBidServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditBidServlet() {
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
		// TODO Auto-generated method stub
		BidHelper dao = new BidHelper();
		
		// Getting the edited bid amount
		String editedBidAmount = request.getParameter("editAmount");
		
		Double bidAmt;
		
		// get the id for the bid being edited
		Integer tempId = Integer.parseInt(request.getParameter("editBidId"));
	
		try {  // get the updated bid amount
			bidAmt = Double.parseDouble(editedBidAmount);
		} catch (NumberFormatException e) {
			bidAmt = null;
			System.out.println("Invalid bid amount entered");
		}
		
		// if user entered an invalid bid amount, then skip the update
		if (bidAmt != null) {
			// Finding bidder
			Bid bidToUpdate = dao.searchForBidById(tempId);
			
			bidToUpdate.setAmount(bidAmt);
			
			// Updating bidder
			dao.updateBid(bidToUpdate);
		}

		// redirect to view all bids servlet
		getServletContext().getRequestDispatcher("/viewAllBidsServlet").forward(request, response);
	}

}
