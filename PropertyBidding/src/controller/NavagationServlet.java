package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Bid;

/**
 * Servlet implementation class NavagationServlet
 */
@WebServlet("/navagationServlet")
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
		
		String act = request.getParameter("doThisToBid");
		
		String path = "/viewAllBidsServlet";
		
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
			path = "/index.html";
		}
		
		// redirect to whichever jsp is in the
		// path variable
		getServletContext().getRequestDispatcher(path).forward(request, response);	
		
	}

}
