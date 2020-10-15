package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


// README
// This class might not even be used because we're setting up the project such that you can
// Only see bidders for an individual property. It's just here in case we need it later.
/**
 * Servlet implementation class ViewAllBidders
 */
@WebServlet("/viewAllBiddersServlet")
public class ViewAllBiddersServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewAllBiddersServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		BidderHelper dao = new BidderHelper();
		
		request.setAttribute("allBidders", dao.showAllBidders());
		
		String path = "/bidder-list.jsp";
		
		// if there are no bidders to display, then set the
		// path to redirect to index.html
		if (dao.showAllBidders().isEmpty()) {
			path = "/index.html";
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
