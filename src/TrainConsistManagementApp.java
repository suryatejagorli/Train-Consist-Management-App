

class InvalidCapacityException extends Exception {
    public InvalidCapacityException(String message) {
        super(message);
    }
}


class PassengerBogie {
    private String type;
    private int capacity;

    public PassengerBogie(String type, int capacity) throws InvalidCapacityException {
        if (capacity <= 0) {
            throw new InvalidCapacityException("Capacity must be greater than zero");
        }
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
        return "PassengerBogie{" +
                "type='" + type + '\'' +
                ", capacity=" + capacity +
                '}';
    }
}

public class TrainConsistManagementApp {
    public static void main(String[] args) {
        try {

            PassengerBogie sleeper = new PassengerBogie("Sleeper", 72);
            System.out.println("Created: " + sleeper);


            PassengerBogie invalid = new PassengerBogie("AC Chair", -10);
            System.out.println("Created: " + invalid);

        } catch (InvalidCapacityException e) {
            System.out.println("Error creating bogie: " + e.getMessage());
        }

        try {

            PassengerBogie zeroCapacity = new PassengerBogie("First Class", 0);
            System.out.println("Created: " + zeroCapacity);

        } catch (InvalidCapacityException e) {
            System.out.println("Error creating bogie: " + e.getMessage());
        }
    }
}
