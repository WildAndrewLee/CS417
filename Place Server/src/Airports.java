import java.io.FileInputStream;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;
import java.rmi.server.UnicastRemoteObject;

public class Airports extends UnicastRemoteObject implements IAirports {
	private AirportDataProto.AirportList airportList;
	private List<IAirport> airports = new ArrayList<IAirport>();

	public Airports() throws RemoteException {
		try {
			airportList = AirportDataProto.AirportList.parseFrom(new FileInputStream("places/airports-proto.bin"));
		} catch (Exception e) {
			throw new RemoteException("Unable to load places/airports-proto.bin");
		}
	}

	public void lookup(double latitude, double longitude) throws RemoteException {
		PriorityQueue<Airport> top5Airports = new PriorityQueue<>(airportList.getAirportCount(),
				new AirportComparator());
		for (AirportDataProto.Airport airport : airportList.getAirportList()) {
			Airport tempAirport = new Airport() {
				{
					code = airport.getCode();
					name = airport.getName();
					state = airport.getState();
					distance = calcDistance(airport.getLat(), airport.getLon(), latitude, longitude);
				}
			};
			top5Airports.add(tempAirport);
		}
		Iterator<Airport> iter = top5Airports.iterator();
		int i = 0;
		while (i < 5) {
			airports.add(iter.next());
			i++;
		}
	}

	private double calcDistance(double airportLat, double airportLon, double latitude, double longitude)
			throws RemoteException {
		double lat1Cos = Math.cos(Math.toRadians(latitude));
		double lat2Cos = Math.cos(Math.toRadians(airportLat));
		double lat1Sin = Math.sin(Math.toRadians(latitude));
		double lat2Sin = Math.sin(Math.toRadians(airportLat));
		double lonCos = Math.cos(Math.toRadians(airportLon) - Math.toRadians(longitude));

		double aCos = Math.acos((lat1Sin * lat2Sin) + (lat1Cos * lat2Cos * lonCos));
		return (60 * Math.toDegrees(aCos) * 1.1507794);
	}

	public IAirport get(int i) throws RemoteException {
		return airports.get(i);
	}
}
