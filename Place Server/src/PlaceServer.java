import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class PlaceServer {
	public static void main(String[] args){		
		try{
			int port = Integer.parseInt(args[0]);
			
		}
		catch(Exception e){
			System.err.println("No valid port specified for arg0.");
		}
	}
}