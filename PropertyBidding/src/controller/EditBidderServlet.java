package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Bidder;

// README
// This might not be used at all, unless we want to allows bidders to change their name.
// Just included it in case we need it later.



/**
 * Servlet implementation class EditBidderServlet
 */
@WebServlet("/editBidderServlet")
public class EditBidderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditBidderServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		BidderHelper dao = new BidderHelper();
		
		// Getting info on bidder
		String name = request.getParameter("name");
		Integer tempId = Integer.parseInt(request.getParameter("id"));
		
		// Finding bidder
		Bidder bidderToUpdate = dao.searchForBidderById(tempId);
		bidderToUpdate.setName(name);
		
		// Updating bidder
		dao.updateBidder(bidderToUpdate);
		
		getServletContext().getRequestDispatcher("viewAllBiddersServlet").forward(request, response);
	}

}
