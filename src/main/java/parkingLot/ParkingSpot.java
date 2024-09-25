package parkingLot;

import lombok.Data;
import parkingLot.vehicles.Vehicle;
import parkingLot.vehicles.VehicleType;

@Data
public class ParkingSpot {

    int parkingNumber;
    VehicleType vehicleType;
    Vehicle vehicle;

    public ParkingSpot(int parkingNumber, VehicleType vehicleType) {
        this.parkingNumber = parkingNumber;
        this.vehicleType = vehicleType;
    }

    public boolean isAvailable(){
        return vehicle == null;
    }
}
