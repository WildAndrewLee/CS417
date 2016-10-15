import java.util.List;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IAirports extends Remote {
	void lookup(double latitude, double longitude) throws RemoteException;
	IAirport get(int i) throws RemoteException;
}
