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
 * Servlet implementation class InsertBidderServlet
 */
@WebServlet("/insertBidServlet")
public class InsertBidderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertBidderServlet() {
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
		PropertyHelper pho = new PropertyHelper();
		BidderHelper bho = new BidderHelper();
		
		String bidrPlace = request.getParameter("bidderId");
		System.out.println(bidrPlace);
		Bidder bidder = bho.searchForBidderById(Integer.parseInt(bidrPlace));
		
		String propPlace = request.getParameter("propertyId");
		Property property = pho.searchForPropertyById(Integer.parseInt(propPlace));
		
		String amtPlace = request.getParameter("bidAmount");
		Double bidAmount = Double.valueOf(amtPlace);
		
		Bid toBid = new Bid(bidAmount, property, bidder);
		dao.insertBid(toBid);
		
		getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
	}

}
