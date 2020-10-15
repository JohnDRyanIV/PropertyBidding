package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Bid;
import model.Property;

/**
 * Servlet implementation class ViewBidsOnPropertyServlet
 */
@WebServlet("/viewBidsOnPropertyServlet")
public class ViewBidsOnPropertyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewBidsOnPropertyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		BidHelper bho = new BidHelper();
		
		PropertyHelper pho = new PropertyHelper();
		
		Integer propId = Integer.parseInt(request.getParameter("id"));
		
		Property prop = pho.searchForPropertyById();
		
		List<Bid> bidList = bho.searchForBidByProperty(prop);
		
		request.setAttribute("allBids", bidList);
		
		if (bidList.isEmpty()) {
			request.setAttribute("allBids", " ");
		}
		
		getServletContext().getRequestDispatcher("/bid-list-on-property.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
