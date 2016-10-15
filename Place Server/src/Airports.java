import java.io.FileInputStream;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;

public class Airports implements IAirport
{
private AirportDataProto.AirportList airportList;
	
	public Airports() throws RemoteException {
		try{
			airportList = AirportDataProto.AirportList.parseFrom(new FileInputStream("places/airports-proto.bin"));
		}
		catch(Exception e){
			throw new RemoteException("Unable to load places/airports-proto.bin");
		}
	}

	public List<Airport> lookup(double latitude, double longitude) throws RemoteException
	{
		List<Airport> airports = new ArrayList<Airport>();
		PriorityQueue<Airport> top5Airports = new PriorityQueue<>(airportList.getAirportCount(), new AirportComparator());
		for(AirportDataProto.Airport airport : airportList.getAirportList()){
			Airport tempAirport = new Airport(){{
				code = airport.getCode();
				name = airport.getName();
				state = airport.getState();
				distance = getDistance(airport.getLat(), airport.getLon(), latitude, longitude);
			}};
			top5Airports.add(tempAirport);
		}
		Iterator<Airport> iter = top5Airports.iterator();
		int i = 0;
		while(i < 4)
		{
			airports.add(iter.next());
			i++;
		}
		return airports;
	}

	private double getDistance(double airportLat, double airportLon, double latitude, double longitude) throws RemoteException
	{
		double lat1Cos = Math.cos(Math.toRadians(latitude));
		double lat2Cos = Math.cos(Math.toRadians(airportLat));
		double lat1Sin = Math.sin(Math.toRadians(latitude));
		double lat2Sin = Math.sin(Math.toRadians(airportLat));
		double lonCos = Math.cos(Math.toRadians(airportLon) - Math.toRadians(longitude));
		
		double aCos = Math.acos((lat1Sin * lat2Sin) + (lat1Cos * lat2Cos * lonCos));
		return (60 * Math.toDegrees(aCos) * 1.1507794);
	}
}
