package controller;

import java.io.IOException;
import java.time.LocalTime;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Property;

//README
// This might not be used at all, unless we want to change various fields of houses.
// It's just put here in case we need to use it in the future.



/**
 * Servlet implementation class EditPropertyServlet
 */
@WebServlet("/editPropertyServlet")
public class EditPropertyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditPropertyServlet() {
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
		
		// Getting info on property
		String address = request.getParameter("address");
		String city = request.getParameter("city");
		String state = request.getParameter("state");
		String zip = request.getParameter("zip");
		Integer tempId = Integer.parseInt(request.getParameter("id"));
		
		// Finding property
		Property propertyToUpdate = dao.searchForPropertyById(tempId);
		propertyToUpdate.setAddress(address);
		propertyToUpdate.setCity(city);
		propertyToUpdate.setState(state);
		propertyToUpdate.setZip(zip);
		
		// Updating property
		dao.updateProperty(propertyToUpdate);
		
		getServletContext().getRequestDispatcher("/viewAllPropertiesServlet").forward(request, response);

	}

}
