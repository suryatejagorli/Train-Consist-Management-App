import java.util.*;
import java.util.regex.*;
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

class GoodsBogie {
    private String type;
    private String cargo;

    public GoodsBogie(String type, String cargo) {
        this.type = type;
        this.cargo = cargo;
    }

    public String getType() {
        return type;
    }

    public String getCargo() {
        return cargo;
    }

    @Override
    public String toString() {
        return "GoodsBogie{" +
                "type='" + type + '\'' +
                ", cargo='" + cargo + '\'' +
                '}';
    }
}

public class TrainConsistManagementApp {
    public static void main(String[] args) {

        List<Bogie> bogies = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            bogies.add(new Bogie("Sleeper", 50 + (i % 30)));
        }

        long startLoop = System.nanoTime();
        List<Bogie> loopFiltered = new ArrayList<>();
        for (Bogie b : bogies) {
            if (b.getCapacity() > 60) {
                loopFiltered.add(b);
            }
        }
        long endLoop = System.nanoTime();
        long loopTime = endLoop - startLoop;

        long startStream = System.nanoTime();
        List<Bogie> streamFiltered = bogies.stream()
                .filter(b -> b.getCapacity() > 60)
                .collect(Collectors.toList());
        long endStream = System.nanoTime();
        long streamTime = endStream - startStream;

        System.out.println("Loop-based filtering result size: " + loopFiltered.size());
        System.out.println("Stream-based filtering result size: " + streamFiltered.size());
        System.out.println("Loop execution time (ns): " + loopTime);
        System.out.println("Stream execution time (ns): " + streamTime);

        List<GoodsBogie> goodsBogies = Arrays.asList(
                new GoodsBogie("Rectangular", "Coal"),
                new GoodsBogie("Cylindrical", "Petroleum"),
                new GoodsBogie("Cylindrical", "Petroleum"),
                new GoodsBogie("Rectangular", "Grain")
        );

        boolean isSafe = goodsBogies.stream()
                .allMatch(b -> {
                    if (b.getType().equals("Cylindrical")) {
                        return b.getCargo().equals("Petroleum");
                    }
                    return true;
                });

        if (isSafe) {
            System.out.println("Train is safety compliant ✅");
        } else {
            System.out.println("Train is NOT safety compliant ❌");
        }

        System.out.println("\nGoods Bogies in Train:");
        goodsBogies.forEach(System.out::println);

        List<Bogie> bogieList = Arrays.asList(
                new Bogie("Sleeper", 72),
                new Bogie("Sleeper", 70),
                new Bogie("AC Chair", 60),
                new Bogie("First Class", 40),
                new Bogie("Rectangular", 100),
                new Bogie("Cylindrical", 80),
                new Bogie("AC Chair", 55)
        );

        int totalSeats = bogieList.stream()
                .filter(b -> b.getType().equals("Sleeper") ||
                        b.getType().equals("AC Chair") ||
                        b.getType().equals("First Class"))
                .map(Bogie::getCapacity)
                .reduce(0, Integer::sum);

        System.out.println("Total Seating Capacity of Train: " + totalSeats);

        Map<String, List<Bogie>> groupedBogies = bogieList.stream()
                .collect(Collectors.groupingBy(Bogie::getType));

        System.out.println("\nGrouped Bogies by Type:");
        groupedBogies.forEach((type, list) ->
                System.out.println(type + " -> " + list)
        );

        System.out.println("\nOriginal List remains unchanged:");
        bogieList.forEach(System.out::println);

        System.out.println("\nAfter Sorting by Capacity:");
        List<Bogie> sortedBogies = bogieList.stream()
                .sorted(Comparator.comparingInt(Bogie::getCapacity))
                .collect(Collectors.toList());

        sortedBogies.forEach(System.out::println);

        LinkedHashSet<String> trainFormation = new LinkedHashSet<>();
        trainFormation.add("Engine");
        trainFormation.add("Sleeper");
        trainFormation.add("Cargo");
        trainFormation.add("Guard");
        trainFormation.add("Sleeper");

        System.out.println("\nFinal Train Formation: " + trainFormation);

        Scanner scanner = new Scanner(System.in);

        String trainIdRegex = "TRN-\\d{4}";
        String cargoCodeRegex = "PET-[A-Z]{2}";

        Pattern trainIdPattern = Pattern.compile(trainIdRegex);
        Pattern cargoCodePattern = Pattern.compile(cargoCodeRegex);

        System.out.print("Enter Train ID: ");
        String trainId = scanner.nextLine();

        System.out.print("Enter Cargo Code: ");
        String cargoCode = scanner.nextLine();

        Matcher trainIdMatcher = trainIdPattern.matcher(trainId);
        if (trainIdMatcher.matches()) {
            System.out.println("Train ID is valid: " + trainId);
        } else {
            System.out.println("Invalid Train ID format! Expected format: TRN-1234");
        }

        Matcher cargoCodeMatcher = cargoCodePattern.matcher(cargoCode);
        if (cargoCodeMatcher.matches()) {
            System.out.println("Cargo Code is valid: " + cargoCode);
        } else {
            System.out.println("Invalid Cargo Code format! Expected format: PET-AB");
        }

        System.out.println("Validation complete. Proceeding with train operations...");
    }
}