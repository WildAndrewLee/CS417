all: places airports client

.PHONY: places
places:
	mkdir -p bin
	javac -d bin -cp protobuf.jar src/IPlace.java src/PlaceServer.java src/IPlaces.java src/Places.java src/Place.java src/PlaceDataProto.java

.PHONY: airports
airports:
	mkdir -p bin
	javac -d bin -cp protobuf.jar src/IAirports.java src/IAirport.java src/Airport.java src/AirportComparator.java src/AirportDataProto.java src/Airports.java src/AirportServer.java

client:
	mkdir -p bin
	javac -d bin src/IAirport.java src/IAirports.java src/IPlace.java src/IPlaces.java src/Airport.java src/Place.java src/Client.java

.PHONY: clean
clean:
	rm -rf bin
