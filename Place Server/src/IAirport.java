import java.util.List;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IAirport extends Remote {

	List<Airport> lookup(double latitude, double longitude) throws RemoteException;

}