package Vehicle;

/**
 * The Vehicle Factory class creates new object types based on
 * the paramters provided from a string.
 * 
 * @author Aidan Larock 6186076, Michael Wisniewski 6402176
 * 
 * @see TrafficMain
 * @see Vehicle
 */
public class VehicleFactory {

    /**
     * Creates and returns a vehicle object to the PlayerFactory
     * 
     * @param vehicle string of vehcile object to create
     * @return vehicle object
     */
    public Vehicle getVehicle(String vehicle) {
        if (vehicle.toLowerCase().equals("Sports")) {
            return new SportsCar();
        } else if (vehicle.toLowerCase().equals("Car")) {
            return new Car();
        } else if (vehicle.toLowerCase().equals("Truck")) {
            return new Truck();
        } else if (vehicle.toLowerCase().equals("Bus")) {
            return new Bus();
        } else {
            System.out.println("Provided type is not available.");
            return null;
        }
    }
}
