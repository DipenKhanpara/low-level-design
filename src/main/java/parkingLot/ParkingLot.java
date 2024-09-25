package parkingLot;

import parkingLot.vehicles.Vehicle;

import java.util.ArrayList;
import java.util.List;

public class ParkingLot {

    static ParkingLot parkingLot;
    List<Level> levels = new ArrayList<>();

    private ParkingLot(){

    }

    public static synchronized ParkingLot getInstance(){
        if(parkingLot == null){
            parkingLot = new ParkingLot();
        }
        return parkingLot;
    }

    public void addLevel(Level level){
        levels.add(level);
    }

    public boolean parkVehicle(Vehicle vehicle){
        for(Level level : levels){
            if(level.parkVehicle(vehicle)){
                return true;
            }
        }
        return false;
    }

    public boolean unparkVehicle(Vehicle vehicle){
        for(Level level : levels){
            if(level.unparkVehicle(vehicle)){
                return true;
            }
        }
        return false;
    }

    public void displayAvailability(){
        for(Level level : levels) {
            level.displayAvailability();
        }
    }
}
