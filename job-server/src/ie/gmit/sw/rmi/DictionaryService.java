package ie.gmit.sw.rmi;

// Library imports
import java.rmi.Remote;
import java.rmi.RemoteException;

// Declaration of Dictionary Service class
public interface DictionaryService extends Remote{
	// Declaration of lookup function
	public String lookup(String s) throws RemoteException;
}// End of Dictionary Service Class