package parkingLot;

import parkingLot.vehicles.Bike;
import parkingLot.vehicles.Car;
import parkingLot.vehicles.Truck;
import parkingLot.vehicles.Vehicle;

public class ParkingLotDemo {

    public static void main(String[] args) {
        ParkingLot parkingLot = ParkingLot.getInstance();
        parkingLot.addLevel(new Level(1, 10));
        //parkingLot.addLevel(new Level(2, 20));

        Vehicle bike = new Bike("EE1234");
        Vehicle car = new Car("DP1234");
        Vehicle truck = new Truck("AB1234");

        System.out.println(parkingLot.parkVehicle(bike));
        System.out.println(parkingLot.parkVehicle(car));
        System.out.println(parkingLot.parkVehicle(truck));

        parkingLot.displayAvailability();

        System.out.println(parkingLot.unparkVehicle(bike));
        System.out.println(parkingLot.unparkVehicle(car));
        System.out.println(parkingLot.unparkVehicle(truck));

        parkingLot.displayAvailability();
    }
}