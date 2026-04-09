class CargoSafetyException extends RuntimeException {
    public CargoSafetyException(String message) {
        super(message);
    }
}

class GoodsBogie {
    private String shape;
    private String cargo;

    public GoodsBogie(String shape) {
        this.shape = shape;
    }

    public void assignCargo(String cargo) {
        try {
            if (shape.equalsIgnoreCase("Rectangular") && cargo.equalsIgnoreCase("Petroleum")) {
                throw new CargoSafetyException("Unsafe Assignment: Petroleum cannot be assigned to a Rectangular bogie!");
            }
            this.cargo = cargo;
            System.out.println("Cargo '" + cargo + "' successfully assigned to " + shape + " bogie.");
        } catch (CargoSafetyException e) {
            System.err.println("Error: " + e.getMessage());
        } finally {
            System.out.println("Cargo assignment validation completed for " + shape + " bogie.");
        }
    }

    public String getCargo() {
        return cargo;
    }
}

public class TrainConsistManagementApp {
    public static void main(String[] args) {
        GoodsBogie cylindricalBogie = new GoodsBogie("Cylindrical");
        cylindricalBogie.assignCargo("Petroleum");

        GoodsBogie rectangularBogie = new GoodsBogie("Rectangular");
        rectangularBogie.assignCargo("Petroleum");

        rectangularBogie.assignCargo("Coal");
    }
}