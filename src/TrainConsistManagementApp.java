
import java.util.*;
import java.util.stream.Collectors;

class Bogie {
    private String type;
    private int capacity;

    public Bogie(String type, int capacity) {
        this.type = type;
        this.capacity = capacity;
    }

    public String getType() {
        return type;
    }

    public int getCapacity() {
        return capacity;
    }

    @Override
    public String toString() {
        return "Bogie{" +
                "type='" + type + '\'' +
                ", capacity=" + capacity +
                '}';
    }
}

public class TrainConsistManagementApp {
    public static void main(String[] args) {
        // Step 1: Create a list of bogies
        List<Bogie> bogies = Arrays.asList(
                new Bogie("Sleeper", 72),
                new Bogie("Sleeper", 70),
                new Bogie("AC Chair", 60),
                new Bogie("First Class", 40),
                new Bogie("Rectangular", 100),   // goods bogie, not counted in seats
                new Bogie("Cylindrical", 80),    // goods bogie, not counted in seats
                new Bogie("AC Chair", 55)
        );

        // Step 2: Extract capacities of passenger bogies only
        int totalSeats = bogies.stream()
                .filter(b -> b.getType().equals("Sleeper") ||
                        b.getType().equals("AC Chair") ||
                        b.getType().equals("First Class"))
                .map(Bogie::getCapacity)
                .reduce(0, Integer::sum);

        // Step 3: Display result
        System.out.println("Total Seating Capacity of Train: " + totalSeats);

        // Program continues...
        System.out.println("\nOriginal List remains unchanged:");
        bogies.forEach(System.out::println);
    }
}
