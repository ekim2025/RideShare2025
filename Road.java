
import java.util.*;
public class Road{
    private Station [] stations;
    private ArrayList<Car> fleet;
    
    private static final int NUMSTATIONS = 32;

    public Road(){
        stations = new Station[NUMSTATIONS];
        for(int i = 0; i < stations.length; i++){
            stations[i] = new Station(i);
        }
        fleet = new ArrayList<Car>();
    }

    public void populateStations(int numPeople){
        for(int i = 0; i< numPeople; i++){
            int start = (int)(Math.random() * NUMSTATIONS);
            int stop = (int)(Math.random() * NUMSTATIONS);
            stations[start].addPerson(new Person(stop, start));
        }
    }

    public void populateCars(int numCars){
        for(int i = 0; i< numCars; i++){
            int start = (int)(Math.random() * NUMSTATIONS);
            int stop = (int)(Math.random() * NUMSTATIONS);
            fleet.add(new Car(stop, start));
        }
    }

    public void move(){
        //unload all eligible people from cars to stations
        for(Car c : fleet){
            Person p = c.unload();
            if(p != null){
                int location = c.getLocation();
                stations[location].addPerson(p);
            }
            // Remove the break statement that was here
        }
        
        // load all eligible people from stations to cars
        for (Station s : stations){
            ArrayList<Person> leftPeople = s.getLeftPeople();
            ArrayList<Person> rightPeople = s.getRightPeople();

            ArrayList<Person> toRemoveLeft = new ArrayList<>();
            ArrayList<Person> toRemoveRight = new ArrayList<>();

            //load leftbound ppl into leftbound cars
            for(int i = 0; i < leftPeople.size(); i++) {
                Person p = leftPeople.get(i);
                for(Car c : fleet) {
                    if(c.hasRoom() && !p.getDirection() && c.isGoingSameDirection(p)){
                        c.load(p);
                        toRemoveLeft.add(p);
                        break;
                    }
                }
            }
            
            //load rightbound ppl into rightbound cars
            for(int i = 0; i < rightPeople.size(); i++) {
                Person p = rightPeople.get(i);
                for (Car c : fleet) {
                    if(c.hasRoom() && p.getDirection() && c.isGoingSameDirection(p)) {
                        c.load(p);  // Add this line to actually load the person
                        toRemoveRight.add(p);
                        break;
                    }
                }
            }
            
            // Remove people who got into cars
            leftPeople.removeAll(toRemoveLeft); // looking back this sort of overcomplicated the whole thing but I thought it needed to have an option to get only the completed passengers and this was the only way I could think of.
            rightPeople.removeAll(toRemoveRight);// romove all was a method I looked up " The removeAll() method removes all items from a list which belong to a specified collection."
        }

        // move all cars
        for(Car c : fleet){
            c.move();
        }
    }
    
    public int getCompletedPassengers() {
        int completed = 0;
        
        // check all stations for passengers who have arrived at their destination
        for(int i = 0; i < stations.length; i++){
            Station station = stations[i];
            completed += station.completedCount();  // Using your existing method
        }
        
        // also check cars for passengers who have reached their destination but haven't exited yet
        for(Car c : fleet){
            completed += c.getCompletedPassengers();
        }
        
        return completed;
    }


    public String toString() {
        String result = "";
        
        // Loop through all stations
        for (int i = 0; i < stations.length; i++) {
            result += "Station " + i + ": " + stations[i].toString() + "\n";
        }
        
        result += "\nCARS:\n";
        // Loop through all cars
        for (int i = 0; i < fleet.size(); i++) {
            Car car = fleet.get(i);
            result += "Car " + i + 
                     " | Location: " + car.getLocation() + 
                     " | Destination: " + car.getDes() + 
                     " | Passengers: " + car.getPassengers() + "\n";
        }
        
        return result;
    }
}