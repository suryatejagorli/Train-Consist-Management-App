import java.util.LinkedHashSet;

public class TrainConsistManagementApp {
    public static void main(String[] args) {
        LinkedHashSet<String> trainFormation = new LinkedHashSet<>();
        trainFormation.add("Engine");
        trainFormation.add("Sleeper");
        trainFormation.add("Cargo");
        trainFormation.add("Guard");

        trainFormation.add("Sleeper");
        System.out.println("Final Train Formation: " + trainFormation);
    }
}