package csci201;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Lab4_Servlet
 */
@WebServlet("/Lab4_Servlet")
public class Lab4_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String pname = request.getParameter("pname");
		String oname = request.getParameter("oname");
		String emessage = request.getParameter("emessage");
		
		//response.setContentType("text/html");
		
		String responseString = "";
		if(pname == null || pname.trim().length() == 0){	
			responseString += "Pet's Name needs a value.<br />";
		}
		if(oname == null || oname.trim().length() == 0){	
			responseString += "Owner's Name needs a value.<br />";
		}
		if(emessage == null || emessage.trim().length() == 0) {
			responseString += "Email needs a value.<br />"; 
		}
		if(responseString.length() > 0) {
			PrintWriter pw = response.getWriter();
			pw.println(responseString);
			pw.close();
		}
//		else {
//			final PrintWriter write = response.getWriter();
//			write.println(pname);
//			write.println(oname);
//			write.println(emessage);
//		}
		
	}

}
