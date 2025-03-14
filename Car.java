import java.util.*;
public class Car {
    //fields
    private int destination;
    private int currentLocation;
    private boolean direction;
    ArrayList <Person> passengers = new ArrayList <Person>(); 
    public static final int MAX = 3;

    public Car(int myDestination, int start){
        destination = myDestination;
        currentLocation = start;
        direction = destination > currentLocation;
        passengers = new ArrayList<Person>();

    }

    public String toString(){
        return super.toString() + " Destination: " + destination + " Current Location: " + currentLocation + " Going right? " + direction+ " Passengers: " + passengers;
    }

    public void addPassenger(Person p){
        if (passengers.size() >= 3){
            System.out.println("ERROR: No room!");
        } else if(p.getDirection() != direction) {
            System.out.println("ERROR: Trying to add person in wrong direction");
        }else {
            passengers.add(p);
        }
    }

    public void move(){
        if (currentLocation == destination){
            return; // kick out early before trying to move :)
        }

        if(direction){
            currentLocation++;
        } else{
            currentLocation--;
        }
    }
    /**
     * Method for handing back a person that is eligible to be dropped off
     * This removes the person from the car as well\
     * There may be multiple people eligible for dropoff but this only returns one
     * @return one Person eligible to be dropped off, null if nobody is available
     */
    public Person unload(){
        for(int i = 0; i < passengers.size(); i++){
            Person a = passengers.get(i);
            if(a.getDestination() == currentLocation || destination == currentLocation){
                return passengers.remove(i);
            }
        }
        return null;
    }
    
    public void load(Person p) {
        if (hasRoom()) {
            passengers.add(p); // Add the person to the list of passengers
        } else {
            System.out.println("ERROR: Car is full!");
        }
    }


    public boolean hasRoom(){
        return passengers.size() < 3;
    }

    public int getDes()
    {
        return destination;
    }

    public int getPassengers()
    {
        return passengers.size(); 
    }

    public int getLocation(){
        return currentLocation;
    }

public boolean isGoingSameDirection(Person p) {
    return direction == p.getDirection();
}

public boolean isGoingRight() {
    return direction; 
}
public int getCompletedPassengers() {
    int completedCount = 0;
    
    // check all passengers in this car
    for (int i = 0; i < passengers.size(); i++) {
        Person passenger = passengers.get(i);
        // if passenger's destination matches car's current location
        if (passenger.getDestination() == currentLocation) {
            completedCount++;
        }
    }
    
    return completedCount;
}

}
    