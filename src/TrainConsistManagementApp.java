import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TrainConsistManagementApp {

    public static void main(String[] args) {
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