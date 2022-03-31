package Main;

/**
 * TrafficDemo demos and tests the TrafficMain singleton class.
 * This class is the entry point for starting the simulation.
 * 
 * @author Aidan Larock 6186076, Michael Wisniewski 6402176
 * 
 * @see TrafficMain
 */
public class TrafficDemo {

    public static void main(String[] args) {
        TrafficMain tm = TrafficMain.getInstance();
        tm.run();
    }
}