import java.util.*;
public class Station{
    private ArrayList<Person> waitingLeft;
    private ArrayList<Person> waitingRight;
    private ArrayList<Person> completed;
    private int number;

    public Station(int myNumber){
        number = myNumber;
        waitingLeft = new ArrayList<Person>();
        waitingRight = new ArrayList<Person>();
        completed = new ArrayList<Person>();
    }

    public void addPerson(Person p){
        if (p.getDestination() == number){
            completed.add(p);
        } else if(p.getDirection()){
            waitingRight.add(p);
        } else {
            waitingLeft.add(p);
        }
    }

    /**
     * Method for giving back an individual that is going leftbound.
     * @return A single person traveling to the left -- returns null if nobody is available
     */

    public Person nextRight(){
        if(waitingLeft.size() > 0){
            return waitingLeft.remove(0);
        } else {
            return null;
        }
    }

    public int completedCount(){
        return completed.size();
    }

    public ArrayList<Person> getLeftPeople() {
        return waitingLeft;
    }

    public ArrayList<Person> getRightPeople() {
        return waitingRight;
    }


    public String toString(){
        String s = "station: " + number + "\n";
        s+= "Leftbound: " + waitingLeft.toString() + "\n";
        s+= "Rightbound: " + waitingRight.toString() + "\n";
        s+= "Completed: " + completed.toString();
        return s;
    }
}
