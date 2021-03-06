import java.rmi.Naming;
import java.util.List;

public class Client {
    public static void main(String[] args){
        try{
            String host1 = "localhost";
            String host2 = "localhost";
            int port1 = 1099;
            int port2 = 1099;
            
            String city = null;
            String state = null;
            
            for(int n = 0; n < args.length; n++){
            	String arg = args[n];
            	
                if(arg.startsWith("-h1")){
                    host1 = args[n + 1];
                    n++;
                }
                else if(arg.startsWith("-h2")){
                    host2 = args[n + 1];
                    n++;
                }
                else if(arg.startsWith("-p1")){
                    port1 = Integer.parseInt(args[n + 1]);
                    n++;
                }
                else if(arg.startsWith("-p2")){
                    port2 = Integer.parseInt(args[n + 1]);
                    n++;
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
            
            String placesURL = "//" + host1 + ":" + port1 + "/Places";
            String airportsURL = "//" + host2 + ":" + port2 + "/Airports";
            
            IPlaces places = (IPlaces) Naming.lookup(placesURL);
            IAirports airports = (IAirports) Naming.lookup(airportsURL);
            
            IPlace place = (IPlace) (places.lookup(city, state));
            
            System.out.println(place.getFullName() + ", " + place.getState() + ": " + place.getLatitude() + ", " + place.getLongitude());
            
            airports.lookup(place.getLatitude(), place.getLongitude());
            
            for(int n = 0; n < 5; n++){
            	IAirport airport = airports.get(n);
                System.out.println("code=" + airport.getCode() + ", name=" + airport.getName() + ", state=" + airport.getState() + " distance: " + airport.getDistance() + " miles");
            }
        }
        catch(Exception e){
            System.err.println("Unable to start client.");
            e.printStackTrace();
        }
    }
}
