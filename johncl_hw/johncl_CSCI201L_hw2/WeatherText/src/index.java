
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.annotation.WebServlet;
import java.io.*;
import java.util.Enumeration;

/**
 * Servlet implementation class index
 */
@WebServlet("/index")
public class index extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public index() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
        response.setContentType("text/html");
        String filename = "weather.txt";
        ServletContext context = getServletContext();
        InputStream is = context.getResourceAsStream(filename);
        String conditions = "";
        if(is != null) {
          HttpSession session = request.getSession();
          InputStreamReader isr = new InputStreamReader(is);
          BufferedReader reader = new BufferedReader(isr);
          String line;
          while ((line = reader.readLine() ) != null) {
        	  String[] data = line.split("\\|");
    		  //Condition parser
        	  conditions = data[15];
    		  if(data.length > 16) {
    			for(int i = 15; i < data.length-1; i++) {
    				conditions = conditions + ", " + data[i];
    			}
    			conditions = conditions + " and " + data[data.length-1];
    		  }
    		  //Create weatherObj
    		  weatherObj city = new weatherObj(data[0], data[1], data[2] , Float.parseFloat(data[3]), Float.parseFloat(data[4]), data[5], data[6] , Integer.parseInt(data[7]), Integer.parseInt(data[8]), 
						Integer.parseInt(data[9]), Integer.parseInt(data[10]), Float.parseFloat(data[11]), 
						Float.parseFloat(data[12]), Float.parseFloat(data[13]), Integer.parseInt(data[14]), conditions);
    		  //Store in session
    		  session.setAttribute(data[0], city);
	          //writer.println(line + "</br>");
	      }
//          printer
//          PrintWriter writer = response.getWriter();
//          Enumeration<String> keys = session.getAttributeNames();
//          while (keys.hasMoreElements())
//          {
//            String key = (String)keys.nextElement();
//            writer.println(key + "<br>");
//          }
          String url = "jdbc:mysql://http://localhost:8080/johncl_CSCI201L_hw2/index.html";
          reader.close();
          isr.close();
        }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
