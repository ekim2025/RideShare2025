import java.util.*;
public class Road{
    private Station [] stations;
    private ArrayList<Car> fleet;
    
    private static final int NUMSTATIONS = 10;

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
    }

        //load all eligible people from stations to cars
        //going to be similar, but noe looping through stations and putting in cars


        // move all cars
        for(Car c : fleet){
            c.move();
        }

    }