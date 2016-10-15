import java.util.Comparator;

public class AirportComparator implements Comparator<Airport>{

	@Override
	public int compare(Airport o1, Airport o2) {
		if(o1.distance < o2.distance)
			return -1;
		else if(o1.distance > o2.distance)
			return 1;
		return 0;
	}

}
