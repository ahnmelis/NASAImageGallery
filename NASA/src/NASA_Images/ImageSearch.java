package NASA_Images;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.URL;
import java.util.ArrayList;
import java.util.StringTokenizer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

/**
 * Servlet implementation class ImageSearch
 */
@WebServlet("/ImageSearch")
public class ImageSearch extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ImageSearch() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//open the existing session
		HttpSession session = request.getSession();
		//create new history arraylist
		ArrayList<String> history = new ArrayList<String>();
		if (session.getAttribute("history") != null) {
			history = (ArrayList<String>) session.getAttribute("history");
		}
		
		//take in user input
		String term = request.getParameter("term");
		String year_start = request.getParameter("year_start");
		String year_end = request.getParameter("year_end");
		String location = request.getParameter("location");
		
		//put for reference in history arraylist
		String full_search = term + ", " + year_start + ", " + year_end + ", " + location;
		history.add(full_search);
		session.setAttribute("history", history);
		
		//get api url ready
		String APIcall = "https://images-api.nasa.gov/search?";
		
		if (term != "") {
			APIcall += "description=";
			//create StringTokenizer (line, token) for formatting of search query
		    StringTokenizer st = new StringTokenizer(term);
	    	APIcall += st.nextToken();
	    	
		    while(st.hasMoreTokens()) {
	  	    	APIcall += "%" + st.nextToken();
	  	    }
		}
		
    	APIcall += "&media_type=image";
    	
    	//if the user specifies a time frame
    	if (year_start != "") {
    		APIcall += "&year_start=" + year_start;
    	}
    	
    	if (year_end != "") {
    		APIcall += "&year_end=" + year_end;
    	}
    	
    	if (location != "") {
    		APIcall += "&location=";
    		StringTokenizer st2 = new StringTokenizer(location);
        	APIcall += st2.nextToken();
        	
    	    while(st2.hasMoreTokens()) {
      	    	APIcall += "%" + st2.nextToken();
      	    }
    	}
		
		//parse the json using gson
    	Gson gson = new Gson();
		BufferedReader br = null;
		//variable of Response class to store response from api
		Response returnedresults = new Response();
		
		URL url = new URL(APIcall);
		br = new BufferedReader(new InputStreamReader(url.openStream()));
		
		//https://stackoverflow.com/questions/8371274/how-to-parse-json-array-with-gson/8371455
		Type temp = new TypeToken<Response>(){}.getType();
		returnedresults = gson.fromJson(br, temp);
				
		//reorganize the resulting class into a filtered class
		ArrayList<CompressedResponse> finalresults = new ArrayList<CompressedResponse>();
		
		for (int i = 0; i < returnedresults.getCollection().getItems().size(); i++) {
			//create temporary CompressedResponse
			CompressedResponse boo = new CompressedResponse();
			//image-url
			boo.setHref(returnedresults.getCollection().getItems().get(i).getLinks().get(0).getHref());
			//title
			boo.setTitle(returnedresults.getCollection().getItems().get(i).getData().get(0).getTitle());
			//date created
			boo.setDateCreated(returnedresults.getCollection().getItems().get(i).getData().get(0).getDateCreated());
			//center
			boo.setCenter(returnedresults.getCollection().getItems().get(i).getData().get(0).getCenter());
			//description
			boo.setDescription(returnedresults.getCollection().getItems().get(i).getData().get(0).getDescription());
			//secondary creator
			boo.setSecondaryCreator(returnedresults.getCollection().getItems().get(i).getData().get(0).getSecondaryCreator());
			
			//add boo to arraylist
			finalresults.add(boo);
		}
		
		if (finalresults.isEmpty()) {
			request.setAttribute("searchError", "Cannot find photos with search term '" + term + "' and with the specified time frame or location.");
		}
		
		else {
			//set finalresults as session variable
			session.setAttribute("finalresults", finalresults);
			request.setAttribute("finalresults", finalresults);
			//also pass along search terms
			request.setAttribute("searchterm", term);
			request.setAttribute("year_start", year_start);
			request.setAttribute("year_end", year_end);
			request.setAttribute("location", location);
		}
		//redirect the page with the results
		request.getRequestDispatcher("SearchResults.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
