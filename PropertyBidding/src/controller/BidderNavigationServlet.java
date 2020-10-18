package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Bidder;

/**
 * Servlet implementation class BidderNavigationServlet
 */
@WebServlet("/bidderNavigationServlet")
public class BidderNavigationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BidderNavigationServlet() {
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
		BidderHelper dao = new BidderHelper();
		
		String act = request.getParameter("doThisToBidder");
		String path = "/viewAllBiddersServlet";
		if(act.equalsIgnoreCase("edit")) {
			try {
				Integer tempId = Integer.parseInt(request.getParameter("id"));
				Bidder bidderToEdit = dao.searchForBidderById(tempId);
				request.setAttribute("bidderToEdit", bidderToEdit);
				path = "/edit-bidder.jsp";
			} catch (NumberFormatException e) {
				System.out.println("Didn't select bidder");
			}
		} else if (act.equals("add")) {
			path = "/new-bidder.jsp";
		}
		
		// redirect to proper jsp
		getServletContext().getRequestDispatcher(path).forward(request, response);
	}

}
