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
        if (vehicle.toLowerCase().equals("sports")) {
            return new SportsCar();
        } else if (vehicle.toLowerCase().equals("car")) {
            return new Car();
        } else if (vehicle.toLowerCase().equals("truck")) {
            return new Truck();
        } else if (vehicle.toLowerCase().equals("bus")) {
            return new Bus();
        } else {
            System.out.println("Vehicle Provided type is not available.");
            return null;
        }
    }
}
