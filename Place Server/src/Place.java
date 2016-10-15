import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Place extends UnicastRemoteObject implements IPlace {
	protected Place() throws RemoteException {
		super();
	}

	public String fullName;
	public String state;
	public double latitude;
	public double longitude;

	@Override
	public String getFullName() throws RemoteException {
		return this.fullName;
	}

	@Override
	public String getState() throws RemoteException {
		return this.state;
	}

	@Override
	public double getLatitude() throws RemoteException {
		return this.latitude;
	}

	@Override
	public double getLongitude() throws RemoteException {
		return this.longitude;
	}
}