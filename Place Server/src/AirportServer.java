import java.rmi.registry.LocateRegistry;
import java.rmi.Naming;

public class AirportServer {
	public static void main(String[] args){		
		try{
			int port = Integer.parseInt(args[0]);
			String url = "//localhost:" + port + "/Airports";
            // LocateRegistry.createRegistry(port);
			Naming.rebind(url,  new Airports());
		}
		catch(Exception e){
			System.err.println("Unable to start AirportServer.");
			e.printStackTrace();
		}
	}
}
