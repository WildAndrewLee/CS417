all: places airports client

.PHONY: places
places:
	javac -cp protobuf.jar src/PlaceServer.java src/IPlaces.java src/Places.java src/Place.java src/PlaceDataProto.java

.PHONY: airports
airports:
	javac -cp protobuf.jar src/Airport.java src/AirportComparator.java src/AirportDataProto.java src/Airports.java src/AirportServer.java

client:
	javac src/IAirport.java src/IPlaces.java src/Airport.java src/Place.java src/Client.java

.PHONY: clean
clean:
	rm -f src/*.class