import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IPlaces extends Remote {
	public IPlace lookup(String location, String state) throws RemoteException;
}