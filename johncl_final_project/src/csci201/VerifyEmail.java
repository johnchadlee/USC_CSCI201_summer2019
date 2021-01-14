package csci201;

import java.io.IOException;
import java.math.BigInteger;
import java.security.SecureRandom;
import java.io.UnsupportedEncodingException;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/VerifyEmail")
public class VerifyEmail extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String vstr = new BigInteger(130, new SecureRandom()).toString(32);
		String email = request.getParameter("email");
		
		final String username = "gbx98512@gmail.com";
        final String password = "Gan11223344";

        Properties props = new Properties();
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session ssession = Session.getInstance(props,
          new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
          });

        try {

            Message message = new MimeMessage(ssession);
            message.setFrom(new InternetAddress("gbx98512@gmail.com"));
            message.setRecipients(Message.RecipientType.TO,
                InternetAddress.parse(email));
            message.setSubject("Your Verification Code");
            message.setText(vstr);

            Transport.send(message);

            System.out.println("Done");

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
        
	      HttpSession session = request.getSession();
	      session.setAttribute("email",email); 
	      session.setAttribute("name", request.getParameter("name")); 
	      session.setAttribute("phone", request.getParameter("phone")); 
	      session.setAttribute("pw", request.getParameter("pw")); 
	      session.setAttribute("vstr", vstr); 
	    
	      
	    RequestDispatcher dispatch = getServletContext().getRequestDispatcher("/verify.jsp");
		dispatch.forward(request,response);
		return;
	}
}
