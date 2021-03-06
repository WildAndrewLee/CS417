import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class PlaceServer {
	public static void main(String[] args){		
		try{
			int port = Integer.parseInt(args[0]);
			String url = "//localhost:" + port + "/Places";
            // LocateRegistry.createRegistry(port);
			Naming.rebind(url,  new Places());
		}
		catch(Exception e){
			System.err.println("Unable to start PlaceServer.");
			e.printStackTrace();
		}
	}
}
