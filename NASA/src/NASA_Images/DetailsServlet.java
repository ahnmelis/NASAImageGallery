package NASA_Images;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 * Servlet implementation class DetailsServlet
 */
@WebServlet("/DetailsServlet")
public class DetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DetailsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//get all necessary variables
		//open the existing session
		HttpSession session = request.getSession();
		@SuppressWarnings("unchecked")
		ArrayList<CompressedResponse> finalresults = (ArrayList<CompressedResponse>)session.getAttribute("finalresults");
		//take in picture input
		String detailsselection = request.getParameter("detailsselection");
		
		//find them within the finalresults arraylist
		//picture is a CompressedResponse that is going to be forwarded to DetailsServlet
		CompressedResponse picture = null;
    	for(int i = 0; i < finalresults.size(); i++) {
    		if (detailsselection.equals(finalresults.get(i).getHref())) {
    	        //set equal
    			picture = finalresults.get(i);
    		}
    	}
		//forward to DetailsServlet
    	request.setAttribute("picture", picture);
		request.getRequestDispatcher("details.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
