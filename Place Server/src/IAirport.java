import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IAirport extends Remote {
	public String getCode() throws RemoteException;
	public String getName() throws RemoteException;
	public String getState() throws RemoteException;
	public double getDistance() throws RemoteException;
}