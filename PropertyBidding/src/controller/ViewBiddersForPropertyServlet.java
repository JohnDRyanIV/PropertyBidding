package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Bid;
import model.Bidder;
import model.Property;

/**
 * Servlet implementation class ViewBiddersForProperty
 */
@WebServlet("/viewBiddersForPropertyServlet")
public class ViewBiddersForPropertyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewBiddersForPropertyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		BidderHelper bho = new BidderHelper();
		
		PropertyHelper pho = new PropertyHelper();
		
		Integer propId = Integer.parseInt(request.getParameter("id"));
		
		Property prop = pho.searchForPropertyById(propId);
		
		List<Bidder> bidderList = bho.searchForBiddersByProperty(prop);
		
		request.setAttribute("allBidders", bidderList);
		
		if (bidderList.isEmpty()) {
			request.setAttribute("allBidders", " ");
		}
		
		getServletContext().getRequestDispatcher("/bidder-list-on-property.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
