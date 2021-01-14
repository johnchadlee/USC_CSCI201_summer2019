package csci201;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/ValidateForm")
public class ValidateForm extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		String upw = request.getParameter("pw");
		String cpw = request.getParameter("cpw");
		String responseString = "";

		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/FinalProject?user=root&password=root&serverTimezone=UTC");
			st = conn.createStatement();
			
			rs = st.executeQuery("SELECT userEmail FROM Users;");
			while (rs.next()) {
				String eml = rs.getString("userEmail");
				if (email.equals(eml)) {
					responseString += "This email has been registered.\n";
				}
			}
		}
		catch (SQLException sqle) {
			System.out.println("sqle: " + sqle.getMessage());
		}
		catch (ClassNotFoundException cnfe) {
			System.out.println("cnfe: " + cnfe.getMessage());
		}
		
		
		if (name == null || name.trim().length() == 0) {
			responseString += "Please enter name.\n";
		}
		if (phone == null || phone.trim().length() == 0) {
			responseString += "Please enter phone number.\n";
		}
		if (phone == null || email.trim().length() == 0) {
			responseString += "Please enter email.\n";
		}
		if (upw == null || upw.trim().length() == 0) {
			responseString += "Please enter password.\n";
		}
		if (!upw.equals(cpw)) {
			responseString += "Passwords need to match.\n";
		}
		if (responseString.length() > 0) {
			PrintWriter pw = response.getWriter();
			pw.println (responseString);
			pw.close();
		}
		
	}
}
