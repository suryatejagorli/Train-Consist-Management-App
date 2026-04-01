import java.util.LinkedList;

public class TrainConsistManagementApp {
    public static void main(String[] args) {
        LinkedList<String> trainConsist = new LinkedList<>();
        trainConsist.add("Engine");
        trainConsist.add("Sleeper");
        trainConsist.add("AC Chair");
        trainConsist.add("Cargo");
        trainConsist.add("Guard");
        System.out.println("Initial Train Consist: " + trainConsist);
        trainConsist.add(2, "Pantry Car");
        System.out.println("After inserting Pantry Car at position 2: " + trainConsist);
        trainConsist.removeFirst();
        trainConsist.removeLast();
        System.out.println("After removing first and last bogie: " + trainConsist);
        System.out.println("Final Ordered Train Consist: " + trainConsist);
    }
}