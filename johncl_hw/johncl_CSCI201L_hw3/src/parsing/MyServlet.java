package parsing;

import java.io.FileNotFoundException;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MyServlet
 */
@WebServlet("/MyServlet")
public class MyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    @SuppressWarnings("unused")
	private static JSONParser fio;
    /**
     * @throws IOException 
     * @throws FileNotFoundException 
     * @throws FormatException 
     * @see HttpServlet#HttpServlet()
     */
	
    public MyServlet() throws FormatException, FileNotFoundException, IOException {
        super();
        
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Error: City Not Found");
//		
		// search for a city using name
		if(request.getParameter("citySearch") != null && request.getParameter("citySearch").trim().length() != 0) {
			String city = request.getParameter("citySearch");
			System.out.println("Searching for: " + city);
			boolean found = false;
			JSONParser j = new JSONParser(city);
			for (City i : j.getCities()) {
				if (city.trim().equalsIgnoreCase(i.getName())) {
					request.setAttribute("searchedCity", i);
					found = true;
				}
			}
			if (!found) {
				RequestDispatcher rd = request.getRequestDispatcher("failure.html");
				rd.forward(request, response);
				return;
			}
			
			RequestDispatcher rd = request.getRequestDispatcher("results.jsp");
			rd.forward(request, response);
			return;
		}
		
		// search for a city using latitude and longitude
		else if (request.getParameter("latSearch") != null && request.getParameter("longSearch") != null ) {
			String lat = request.getParameter("latSearch");
			String lon = request.getParameter("longSearch");
			if (lat.isEmpty() || lon.isEmpty()) {
				RequestDispatcher rd = request.getRequestDispatcher("failure.html");
				rd.forward(request, response);
				return;
			}
			try {
				Double latDouble = Double.parseDouble(lat);
				Double lonDouble = Double.parseDouble(lon);
				boolean found = false;
				for (City i : JSONParser.getCities()) {
					if (latDouble == i.getLatitude() && lonDouble == i.getLongitude()) {
						request.setAttribute("searchedCity", i);
						found = true;
					}
				}
				if (!found) {
					RequestDispatcher rd = request.getRequestDispatcher("failure.html");
					rd.forward(request, response);
					return;
				}
				RequestDispatcher rd = request.getRequestDispatcher("results.jsp");
				rd.forward(request, response);
				return;
			}
			catch (NumberFormatException nfe) {
				RequestDispatcher rd = request.getRequestDispatcher("failure.html");
				rd.forward(request, response);
				return;
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
