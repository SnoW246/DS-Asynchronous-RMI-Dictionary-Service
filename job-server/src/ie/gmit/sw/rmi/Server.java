package ie.gmit.sw.rmi;

//Library imports
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

// Declaration of a server class
public class Server{
	// Main runnable function
	public static void main(String[] args) throws RemoteException, MalformedURLException {
		// Declaration and creation of new Dictionary Service Implementation object
		DictionaryService lookup = new DictionaryServiceImpl();
		
		// Declaration of local registry at port 1099
		LocateRegistry.createRegistry(1099);
		// Deployment of lookup service and JSP website
		Naming.rebind("lookup", lookup);
		// System output message to inform that server is deployed
		System.out.println("Dictionary service is ready.");
	}// End of main function
}// End of Server class