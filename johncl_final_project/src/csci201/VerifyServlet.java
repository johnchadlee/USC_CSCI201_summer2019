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
import javax.servlet.http.HttpSession;

@WebServlet("/VerifyServlet")
public class VerifyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String vin = request.getParameter("verify");
		String vstr = (String) request.getSession().getAttribute("vstr");
		String name = (String) request.getSession().getAttribute("name");
		String phone = (String) request.getSession().getAttribute("phone");
		String email = (String) request.getSession().getAttribute("email");
		String pw = (String) request.getSession().getAttribute("pw");
		HttpSession session = request.getSession();
		
		if (!vin.equals(vstr)) {
			
			session.setAttribute("emailerrormsg","Incorrect Verification Code");
			RequestDispatcher rd =  getServletContext().getRequestDispatcher("/verify.jsp");
			rd.forward(request, response);
			return;
		}
		else {
			try {
				Connection conn = null;
				Statement st = null;
				ResultSet rs = null;
				
				Class.forName("com.mysql.jdbc.Driver");
				conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/FinalProject?user=root&password=root&serverTimezone=UTC");
				st = conn.createStatement();

				PreparedStatement pst = conn.prepareStatement("INSERT INTO Users (userName, userPW, userEmail, userTel) VALUES (?, ?, ?, ?)");
				pst.setString(1, name); 
				pst.setString(2, pw); 
				pst.setString(3, email); 
				pst.setString(4, phone); 
				pst.executeUpdate();
				pst.close(); 
	            conn.close();
				session.setAttribute("user",email);
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
}
