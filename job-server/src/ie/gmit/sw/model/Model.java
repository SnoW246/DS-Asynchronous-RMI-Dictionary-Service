package ie.gmit.sw.model;

// Library imports
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

//Internal package library import
import ie.gmit.sw.rmi.DictionaryService;

// Declaration of model class
public class Model{
	// Declaration of URL String Variable to localhost:1099
	private final String SERVICE_URL = "rmi://localhost:1099/lookup";
	
	// Declaration of lookup service function
	public String lookup(String phrase){
		// Try...
		try {
			// Looking up the received string from the lookup JSP website
			DictionaryService lookup = (DictionaryService) Naming.lookup(SERVICE_URL);
			// Returning result
			return lookup.lookup(phrase);
		}// End of try
		// Catch exceptions while trying
		catch (MalformedURLException | RemoteException | NotBoundException e){
			// Output message type when exception occurs
			System.out.println(e.getMessage());
			// Print the stack for detailed information
			e.printStackTrace();
		}// End of stack
		
		// Return of empty string
		return " ";
	}// End of lookup function
}// End of Model class