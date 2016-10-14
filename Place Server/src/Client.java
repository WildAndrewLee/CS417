import java.rmi.Naming;

public class Client {
	public static void main(String[] args){
		try{
			String host = "localhost";
			int port = 1099;
			
			String city = null;
			String state = null;
			
			for(String arg : args){
				if(arg.startsWith("-h")){
					host = arg.substring(3);
				}
				else if(arg.startsWith("-p")){
					port = Integer.parseInt(arg.substring(3));
				}
				else if(city == null){
					city = arg;
				}
				else if(state == null){
					state = arg;
				}
				else{
					System.err.println("Too many arguments provided. Ignoring argument: " + arg);
				}
			}
			
			String placesURL = "//" + host + ":" + port + "/Places";
			String airportsURL = "//" + host + ":" + port + "/Airport";
			
			IPlaces places = (IPlaces) Naming.lookup(placesURL);
			// TODO: Airport binding.
			
			Place place = places.lookup(city, state);
			Airport[] nearestAirports = airports.lookup(place.latitude, place.longitude);
		}
		catch(Exception e){
			System.err.println("Unable to start client.");
			e.printStackTrace();
		}
	}
}