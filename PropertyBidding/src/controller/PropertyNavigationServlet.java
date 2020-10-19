package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Property;

/**
 * Servlet implementation class PropertyNavigationServlet
 */
@WebServlet("/propertyNavigationServlet")
public class PropertyNavigationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PropertyNavigationServlet() {
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
		PropertyHelper dao = new PropertyHelper();
		
		String act = request.getParameter("doThisToProperty");
		String path = "/viewAllPropertiesServlet";
		boolean isSold = false;
		
		// determines if house has been sold. If so, can't sell again or place bids on it.
		try {
			Integer tempId = Integer.parseInt(request.getParameter("id"));
			Property checkIfSold = dao.searchForPropertyById(tempId);
			isSold = checkIfSold.isSold();
		} catch(NumberFormatException e) {
			System.out.println("Didn't select property");
		}
		// can still delete if house has been sold
		if(act.equals("delete")) {
			try {
				Integer tempId = Integer.parseInt(request.getParameter("id"));
				Property propertyToDelete = dao.searchForPropertyById(tempId);
				dao.deleteProperty(propertyToDelete);
			} catch(NumberFormatException e) {
				System.out.println("Didn't select property");
			}
		}
		else if (act.equals("add")) {
			path = "/new-property.jsp";
			
		}
		else if(act.equalsIgnoreCase("edit")) {
			try {
				Integer tempId = Integer.parseInt(request.getParameter("id"));
				Property propertyToEdit = dao.searchForPropertyById(tempId);
				request.setAttribute("propertyToEdit", propertyToEdit);
				path = "/edit-property.jsp";
			} catch (NumberFormatException e) {
				System.out.println("Didn't select property");
			} 
		}
		else if(act.equals("View bids")) { // views bids on the house & who placed them
			try {
				Integer tempId = Integer.parseInt(request.getParameter("id"));
				Property propertyToEdit = dao.searchForPropertyById(tempId);
				path = "/viewBidsOnPropertyServlet";
			} catch (NumberFormatException e) {
				System.out.println("Didn't select property");
			}
		}
		else if(isSold == false) { // If house isn't sold, following actions can be performed
			if (act.equals("sell")) {
				try {
					Integer tempId = Integer.parseInt(request.getParameter("id"));
					Property propertyToSell = dao.searchForPropertyById(tempId);
					dao.sellProperty(propertyToSell);
				} catch(NumberFormatException e) {
					System.out.println("Didn't select property");
				}
			}
		}

		
		// redirect to proper jsp
		getServletContext().getRequestDispatcher(path).forward(request, response);
	}

}
