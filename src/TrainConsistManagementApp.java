
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

        List<Bogie> bogies = Arrays.asList(
                new Bogie("Sleeper", 72),
                new Bogie("Sleeper", 70),
                new Bogie("AC Chair", 60),
                new Bogie("First Class", 40),
                new Bogie("Rectangular", 100),
                new Bogie("Cylindrical", 80),
                new Bogie("AC Chair", 55)
        );


        Map<String, List<Bogie>> groupedBogies = bogies.stream()
                .collect(Collectors.groupingBy(Bogie::getType));


        System.out.println("Grouped Bogies by Type:");
        groupedBogies.forEach((type, bogieList) -> {
            System.out.println(type + " -> " + bogieList);
        });


        System.out.println("\nOriginal List remains unchanged:");
        bogies.forEach(System.out::println);
    }
}
