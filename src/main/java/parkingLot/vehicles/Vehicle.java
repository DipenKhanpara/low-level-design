package parkingLot.vehicles;

import lombok.Data;

@Data
public class Vehicle {

    String numberPlate;
    VehicleType vehicleType;

    public Vehicle(String numberPlate, VehicleType vehicleType) {
        this.numberPlate = numberPlate;
        this.vehicleType = vehicleType;
    }
}
