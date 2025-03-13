/**
 * @ help from Lisa
 * by Evelyn Kim 
 * 3/13/25
 */
public class RideShareTesterV2 {
    public static void main(String [] args){
        Road r = new Road();
        r.populateCars(40);
        r.populateStations(50);
        System.out.println("======BEGINNING THE SIMULATION======");
        System.out.println("-----Before moving-----" + "\n" + r.toString());
        for (int i = 0; i <= 32; i++){
            r.move();
        }
        System.out.println("======AFTER RUNNING SIMULATION======");
        System.out.println(r);

        System.out.println("\n" + "Number of completed passengers: " + r.getCompletedPassengers() + "/50");
        System.out.println("Percentage: " + ((double)r.getCompletedPassengers() / 50 * 100.0) + "%");
        


        Road s = new Road();
        s.populateCars(20);
        s.populateStations(50);
        System.out.println("======BEGINNING THE SECOND SIMULATION======");
        System.out.println("-----Before moving-----" + "\n" + s.toString());
        for (int i = 0; i <= 32; i++){
            s.move();
        }
        System.out.println("======AFTER RUNNING SIMULATION======");
        System.out.println(r);

        System.out.println("\n" + "Number of completed passengers: " + s.getCompletedPassengers() + "/50");
        System.out.println("Percentage: " + ((double)s.getCompletedPassengers() / 50 * 100.0) + "%");

    }
}

