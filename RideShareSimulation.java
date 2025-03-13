/**
 * RideShare Simulation main class
 * Works with the existing Car, Person, Station, and Road classes
 */
public class RideShareSimulation {
    public static void main(String[] args) {
        System.out.println("=== RIDESHARE SIMULATION ===");
        
        // run first simulation with 20 cars
        runScenario(20, 50, 32);
        
        // run second simulation with 40 cars
        runScenario(40, 50, 32);
        
        // compare results
        System.out.println("\n=== CONCLUSION ===");
        System.out.println("Check the results above to compare which scenario provided better service.");
        System.out.println("The scenario with more cars generally allows more passengers to reach their destinations.");
    }
    
   