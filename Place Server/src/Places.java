import java.io.FileInputStream;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Places extends UnicastRemoteObject implements IPlaces {
	private PlaceDataProto.PlaceList placeList;
	
	public Places() throws RemoteException {
		try{
			placeList = PlaceDataProto.PlaceList.parseFrom(new FileInputStream("places/places-proto.bin"));
		}
		catch(Exception e){
			throw new RemoteException("Unable to load places/places-proto.bin");
		}
	}

	public IPlace lookup(String location, String state) throws RemoteException {
		for(PlaceDataProto.Place place : placeList.getPlaceList()){
			if(place.getState().equalsIgnoreCase(state) && place.getName().startsWith(location)){
				return new Place(){{
					fullName = place.getName();
					state = place.getState();
					latitude = place.getLat();
					longitude = place.getLon();
				}};
			}
		}
		
		return null;
	}
}