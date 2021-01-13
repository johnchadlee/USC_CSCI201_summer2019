package csci201;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class lab5_database
 */
@WebServlet("/lab5_database")
public class lab5_database extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private int hitCount;
	public void init() {
		hitCount = 0;
	}

	
	protected void getData(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		out.println("<html><body>");
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null; 
		try {
			//With jdbc driver version 8, com.mysql.cj.jdbc.Driver
			//With jdbc driver version 5 - com.mysql.jdbc.Driver
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/lab5?user=root&password=root");
			st = conn.createStatement();
			rs = st.executeQuery("SELECT * FROM Page1;");
			int pageID = rs.getInt("pageID");
			while(rs.next()) {
				String IP = ((ServletRequest) rs).getRemoteAddr();
				int PORT = ((ServletRequest) rs).getServerPort();
				String page;
				out.println();
				out.println("<br />");
			}
		}
	}
	protected void increment(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		out.println("<html><body>");
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null; 
		try {
			//With jdbc driver version 8, com.mysql.cj.jdbc.Driver
			//With jdbc driver version 5 - com.mysql.jdbc.Driver
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/lab5?user=root&password=root");
			st = conn.createStatement();
			rs = st.executeQuery("SELECT * FROM Page1;");
			int pageID = rs.getInt("pageID");
			
		} catch(SQLException sqle) {
			System.out.println("sqle: " + sqle.getMessage());
		} catch(ClassNotFoundException cnfe) {
			System.out.println("cnfe: " + cnfe.getMessage());
		}
		out.println("</body></html>");
	}
}
