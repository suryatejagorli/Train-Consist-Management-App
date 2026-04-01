import java.util.ArrayList;
import java.util.List;

public class Main{

    public static void main(String[] args) {
        System.out.println("=== Train Consist Management App ===");
        List<String> passengerBogies = new ArrayList<>();
        passengerBogies.add("Sleeper");
        passengerBogies.add("AC Chair");
        passengerBogies.add("First Class");

        System.out.println("Passenger bogies added: " + passengerBogies);
        passengerBogies.remove("AC Chair");
        System.out.println("After removing AC Chair: " + passengerBogies);
        boolean hasSleeper = passengerBogies.contains("Sleeper");
        System.out.println("Does Sleeper bogie exist? " + hasSleeper);
        System.out.println("Final passenger bogie list: " + passengerBogies);
        System.out.println("Application is ready for further operations.");
    }
}