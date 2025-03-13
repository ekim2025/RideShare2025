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
            } else {
                break;
            }
            
        }
        // load all eligible people from stations to cars

        for (Station s : stations){
            ArrayList<Person> leftPeople = s.getLeftPeople();
            ArrayList<Person> rightPeople = s.getRightPeople();

            ArrayList<Person> toRemoveLeft = new ArrayList<>();  // for the people who get into a car but aren't at their destination ?? Not sure aboutt his but also not sure where else to store them
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
            //load rightbounf ppl into rightbound cars
            for(int i = 0; i < rightPeople.size(); i++) {
                Person p = rightPeople.get(i);
                for (Car c : fleet) {
                    if(c.hasRoom() && p.getDirection() && c.isGoingSameDirection(p)) {
                        toRemoveRight.add(p);
                        break; // moves onto the next person!
                    }
                }
            }

        // going to be similar, but noe looping through stations and putting in cars 
        // think about car having room and the direction of the car vs. person


        // move all cars
        for(Car c : fleet){
            c.move();
        }

    }
}
}