import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.Connection;

@WebServlet("/SignupServlet")
public class SignupServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SignupServlet() {
        super();
    }

    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String fieldToValidate = request.getParameter("field");
    	PrintWriter out = response.getWriter();
    	if(fieldToValidate != null && fieldToValidate.equals("username")) {
    		String username = request.getParameter("username");
    	if(username != null && username.length() > 0) {
    		out.println("Valid Username");
    	}
    	else {
    		out.println("Invalid Username");
    	}
    	}
    	if(fieldToValidate != null && fieldToValidate.equals("password")) {
    		String password = request.getParameter("password");
    		if(password != null && password.length() > 0) {
    			out.println("Valid Password");
    		}
    		else {
    			out.println("Invalid Password");
    		}
    	}
    }
    
    
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("uname");
		String password = request.getParameter("psw");
		String confirm = request.getParameter("cpsw");
		String responseString = "";
		if(username == null || username.trim().length() == 0){	
			responseString += "Username needs a value.<br />";
		}
		if(password == null || password.trim().length() == 0){	
			responseString += "Password needs a value.<br />";
		}
		if(confirm == null || confirm.trim().length() == 0){	
			responseString += "Confirm Password needs a value.<br />";
		}
		if(responseString.length() > 0) {
			PrintWriter pw = response.getWriter();
			pw.println(responseString);
			pw.close();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			Connection conn = null;
			PreparedStatement stmt = null;
			String name = request.getParameter("uname");
			String pass = request.getParameter("psw");
			String confirm = request.getParameter("cpsw");

			try {
				if(pass.contentEquals(confirm) != true) {
					throw new UnMatchException("Password does not match");
				}
				if(request.getAttribute(name) != null) {
					throw new duplicateNameException("duplicateNameException");
				}
				Class.forName("com.mysql.jdbc.Driver");
				conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/userdata?user=root&password=12345678&useSSL=false");
				stmt = conn.prepareStatement("INSERT INTO userdata(uname, psw) VALUES(?, ?);");
				stmt.setString(1,name);
				stmt.setString(2,pass);
				int i = stmt.executeUpdate();
				if(i>0) { //New Valid account
					RequestDispatcher rd;
					rd = request.getRequestDispatcher("/home.jsp");
					rd.forward(request, response);
				}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (UnMatchException e) {
			e.printStackTrace();
		} catch (duplicateNameException e) {
			e.printStackTrace();
		}
	}
}
