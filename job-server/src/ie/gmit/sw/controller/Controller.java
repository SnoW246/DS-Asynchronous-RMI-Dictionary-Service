package ie.gmit.sw.controller;

// Library imports
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
// JSP Library imports
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
// Internal package library import
import ie.gmit.sw.model.Model;

// Declaration of Controller Class
public class Controller extends HttpServlet{
	// Declaration of serialazable object ID
	private static final long serialVersionUID = 1L;
	// Declaration of variables
	private String word;
	
	// Override doPost function for HTTP request and HTTP response
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Declaration of hash map for dictionary entries
		Map<String, String> messages = new HashMap<String, String>();
        request.setAttribute("messages", messages);
		
        // Declaration of word request
		word = request.getParameter("word");
		
		// Lookup dictionary service control statement, when word is not empty
		if ((word != null && !word.isEmpty())){
			// Construction of new model
			Model service = new Model();
			// Declaration of word request to a string result
			String result = service.lookup(word);
			
			// Declaration of result message
			messages.put("description", result);
			
			// Declaration of statement control for result not null & not empty
			if(result != null && !result.isEmpty()){
				// Declaration of dispatcher to request a lookup JSP website
				RequestDispatcher dispatcher = request.getRequestDispatcher("lookup.jsp");
				// Declaration of forwarding the new request and response
				dispatcher.forward(request, response);
			}// End of if
			// Otherwise...
			else{
				// Dispatcher request to lookup JSP website
				RequestDispatcher dispatcher = request.getRequestDispatcher("lookup.jsp");
				// Forwarding the request and response
				dispatcher.forward(request, response);
			}// End of else
		}// End of if
		
		// Otherwise, if word is empty
		else{
			// Declaration of message result
			messages.put("description", "Error");
			// Dispatcher request to lookup JSP website
			RequestDispatcher dispatcher = request.getRequestDispatcher("lookup.jsp");
			// Forwarding the request and response
			dispatcher.forward(request, response);
		}// End of else
	}// End of doPost function
}// End of Controller class