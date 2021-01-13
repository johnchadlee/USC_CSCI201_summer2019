import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;  

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

/**
 * Servlet implementation class login
 */
@WebServlet("/login")
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection conn = null;
		String name = request.getParameter("uname");
		String pass = request.getParameter("psw");
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/userdata?user=root&password=12345678&useSSL=false");
			Statement st = (Statement) conn.createStatement();
			ResultSet rs = null;
			rs = st.executeQuery("SELECT * FROM userdata WHERE uname='" + name + "' and psw='" + pass + "'");
			if(rs.next()) { //Valid account
				HttpSession session = request.getSession();
				session.setAttribute("name", name);
				RequestDispatcher rd;
				rd = request.getRequestDispatcher("/home.jsp");
				rd.forward(request, response);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("uname");
		String password = request.getParameter("psw");
		String responseString = "";
		if(username == null || username.trim().length() == 0){	
			responseString += "Username needs a value.<br />";
		}
		if(password == null || password.trim().length() == 0){	
			responseString += "Password needs a value.<br />";
		}
		if(responseString.length() > 0) {
			PrintWriter pw = response.getWriter();
			pw.println(responseString);
			pw.close();
		}
	}

}
