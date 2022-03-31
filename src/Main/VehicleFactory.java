package Main;

import Vehicle.Bus;
import Vehicle.Car;
import Vehicle.SportsCar;
import Vehicle.Truck;
import Vehicle.Vehicle;

public class VehicleFactory {
    public Vehicle getVehicle(String vehicle) {
        if (vehicle.equalsIgnoreCase("Sports")) {
            return new SportsCar();

        } else if (vehicle.equalsIgnoreCase("Car")) {
            return new Car();
        } else if (vehicle.equalsIgnoreCase("Truck")) {
            return new Truck();
        } else if (vehicle.equalsIgnoreCase("Bus")) {
            return new Bus();
        } else {
            return null;
        }
    }
}
