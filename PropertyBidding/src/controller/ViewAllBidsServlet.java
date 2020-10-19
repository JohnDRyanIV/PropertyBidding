package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//README
// This might not even need to be implemented, because we could set up the project such
// that you must choose a property before you can see bids on it.
/**
 * Servlet implementation class ViewAllBidsServlet
 */
@WebServlet("/viewAllBidsServlet")
public class ViewAllBidsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewAllBidsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		BidHelper dao = new BidHelper();
		
		// use the BidHelper object's showAllBids method to
		// obtain a list of all the bids and get it ready for
		// the bid-list.jsp
		request.setAttribute("allBids",  dao.showAllBids());
		
		String path = "/bid-list.jsp";
		
		// if there are no bids to display, then set the
		// path to redirect to index.html
		if (dao.showAllBids().isEmpty()) {
			path = "/index.jsp";
		}
		
		// redirect the user to the next path
		getServletContext().getRequestDispatcher(path).forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
