package csci201;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class validateForm
 */
@WebServlet("/validateForm")
public class validateForm extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		String responseString = "";
		if(fname == null || fname.trim().length() == 0){	
			responseString += "First Name needs a value.<br />";
		}
		if(fname == null || lname.trim().length() == 0){	
			responseString += "Last Name needs a value.<br />";
		}
		if(responseString.length() > 0) {
			PrintWriter pw = response.getWriter();
			pw.println(responseString);
			pw.close();
		}
	}

}
