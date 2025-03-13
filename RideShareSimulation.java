public class RideShareSimulation {
    public static void main(String[] args) {
        System.out.println("=== RIDESHARE SIMULATION ===");
        
        runScenario(20, 50, 32);
        runScenario(40, 50, 32);
        
        System.out.println("\n=== CONCLUSION ===");
        System.out.println("More cars = better service.");
    }

    private static void runScenario(int numCars, int numPassengers, int numStations) {
        System.out.println("\n=== SCENARIO: " + numCars + " cars, " + numPassengers + " passengers ===");
        
        Road road = new Road();
        
        System.out.println("Creating passengers...");
        road.populateStations(numPassengers);
        
        System.out.println("Creating cars...");
        road.populateCars(numCars);
        
        System.out.println("Running simulation...");
        int maxSteps = 100;
        
        int previousCompleted = 0;
        int stepsWithoutChange = 0;