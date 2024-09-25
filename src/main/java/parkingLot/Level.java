package parkingLot;

import parkingLot.vehicles.Vehicle;
import parkingLot.vehicles.VehicleType;

import java.util.ArrayList;
import java.util.List;

public class Level {

    int levelNumber;
    int parkingSpotCount;
    List<ParkingSpot> parkingSpots;

    public Level(int levelNumber, int parkingSpotCount) {
        this.levelNumber = levelNumber;
        this.parkingSpotCount = parkingSpotCount;
        this.parkingSpots = new ArrayList<>();
        //creating parking spots in 50:40:10 ratio Bike:Car:Truck
        int numOfBikes = (int) (0.5 * parkingSpotCount);
        for (int i = 1; i <= numOfBikes; i++) {
            parkingSpots.add(new ParkingSpot(i, VehicleType.BIKE));
        }
        int numberOfCars = (int) (0.4 * parkingSpotCount);
        for (int i = numOfBikes + 1; i <= numberOfCars + numOfBikes; i++) {
            parkingSpots.add(new ParkingSpot(numOfBikes + i, VehicleType.CAR));
        }
        for (int i = numberOfCars + numOfBikes + 1; i <= parkingSpotCount; i++) {
            parkingSpots.add(new ParkingSpot(numOfBikes + numberOfCars + i, VehicleType.TRUCK));
        }
    }

    public boolean parkVehicle(Vehicle vehicle) {
        for (ParkingSpot parkingSpot : parkingSpots) {
            if (parkingSpot.isAvailable() && parkingSpot.getVehicleType().equals(vehicle.getVehicleType())) {
                parkingSpot.setVehicle(vehicle);
                return true;
            }
        }
        return false;
    }

    public boolean unparkVehicle(Vehicle vehicle) {
        for (ParkingSpot parkingSpot : parkingSpots) {
            if (!parkingSpot.isAvailable() && parkingSpot.getVehicleType().equals(vehicle.getVehicleType())) {
                parkingSpot.setVehicle(null);
                return true;
            }
        }
        return false;
    }

    public void displayAvailability() {
        System.out.println("level " + levelNumber + " Availability");
        parkingSpots.stream().map(ps -> ps.vehicleType + " parking spot number " + ps.parkingNumber + (!ps.isAvailable() ? " is occupied by " + ps.vehicle.getNumberPlate() : " is empty ")).forEach(System.out::println);
    }
}
