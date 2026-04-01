
import java.util.*;

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
    }
}
