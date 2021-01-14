package csci201;

import java.io.IOException;
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
import javax.servlet.http.HttpSession;


@WebServlet("/SigninServlet")
public class SigninServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String useremail=request.getParameter("email");
		String password=request.getParameter("password");
		
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		HttpSession session = request.getSession();
		String err = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/FinalProject?user=root&password=root&serverTimezone=UTC");
			st = conn.createStatement();
			
			// Insert or update, do executeUpdate
			rs = st.executeQuery("SELECT userEmail, userPW FROM Users;");
			while (rs.next()) {
				String email = rs.getString("userEmail");
				int pw = rs.getInt("userPW");
				if (email.equals(useremail)) {
					if (pw == password.hashCode()) {
						session.setAttribute("user",useremail);
						RequestDispatcher rd =  getServletContext().getRequestDispatcher("/profile.jsp");
						rd.forward(request, response);
						return;
					}
					else {
						err = "Incorrect password";
						session.setAttribute("loginerrormsg",err);
						RequestDispatcher rd =  getServletContext().getRequestDispatcher("/signin.jsp");
						rd.forward(request, response);
						return;
					}
				}
			}
			err = "This user does not exist";
			session.setAttribute("loginerrormsg", err);
			RequestDispatcher rd =  getServletContext().getRequestDispatcher("/signin.jsp");
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
