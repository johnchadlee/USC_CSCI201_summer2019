package csci201;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/ContactUs")
public class ContactUs extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name =request.getParameter("name");
		String email=request.getParameter("email");
		String phone=request.getParameter("phone");
		String message=request.getParameter("message");
		
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		
		try {
				Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/FinalProject?user=root&password=root&serverTimezone=UTC");
			st = conn.createStatement();

			PreparedStatement pst = conn.prepareStatement("INSERT INTO ContactUs (guestEmail, guestName, guestTel, guestMsg) VALUES (?, ?, ?, ?)");
			pst.setString(1, email); 
			pst.setString(2, name); 
			pst.setString(3, phone); 
			pst.setString(4, message); 
			pst.executeUpdate();
			pst.close(); 
            conn.close();
			
			RequestDispatcher rd =  getServletContext().getRequestDispatcher("/index.jsp");
			rd.forward(request, response);
			return;
		}
		
		catch (SQLException sqle) {
			System.out.println("sqle: " + sqle.getMessage());
		}
		catch (ClassNotFoundException cnfe) {
			System.out.println("cnfe: " + cnfe.getMessage());
		}
	}
}
