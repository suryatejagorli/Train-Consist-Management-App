import java.util.ArrayList;
import java.util.List;

class Train {
    private List<String> bogies = new ArrayList<>();

    public void addBogie(String bogieId) {
        bogies.add(bogieId);
    }

    public boolean searchBogie(String bogieId) {
        if (bogies.isEmpty()) {
            throw new IllegalStateException("Search failed: No bogies available in the train.");
        }
        return bogies.contains(bogieId);
    }
}

public class TrainConsistManagementApp {
    public static void main(String[] args) {
        Train train = new Train();

        try {
            System.out.println("Searching BG101...");
            boolean found = train.searchBogie("BG101");
            System.out.println("Result: " + found);
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
        }

        train.addBogie("BG101");
        train.addBogie("BG205");
        train.addBogie("BG309");

        try {
            System.out.println("Searching BG205...");
            boolean found = train.searchBogie("BG205");
            System.out.println("Result: " + found);

            System.out.println("Searching BG999...");
            boolean notFound = train.searchBogie("BG999");
            System.out.println("Result: " + notFound);
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
        }
    }
}