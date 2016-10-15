import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IPlace extends Remote {
	public String getFullName() throws RemoteException;
	public String getState() throws RemoteException;
	public double getLatitude() throws RemoteException;
	public double getLongitude() throws RemoteException;
}