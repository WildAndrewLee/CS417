import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Airport extends UnicastRemoteObject implements IAirport {
	protected Airport() throws RemoteException {
		super();
	}

	public String code;
	public String name;
	public String state;
	public double distance;
	
	public String getCode(){
		return this.code;
	}
	
	public String getName() throws RemoteException {
		return this.name;
	}

	@Override
	public String getState() throws RemoteException {
		return this.state;
	}

	@Override
	public double getDistance() throws RemoteException {
		return this.distance;
	}
}