import java.util.Arrays;
import java.util.Scanner;

public class TrainConsistManagementApp {

    public static boolean binarySearch(String[] bogies, String key) {
        if (bogies == null || bogies.length == 0) {
            return false;
        }

        Arrays.sort(bogies);

        int low = 0;
        int high = bogies.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            int comparison = key.compareTo(bogies[mid]);

            if (comparison == 0) {
                return true;
            } else if (comparison < 0) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] bogieIDs = {"BG101","BG205","BG309","BG412","BG550"};

        System.out.println("Enter Bogie ID to search:");
        String searchKey = sc.nextLine();

        boolean result = binarySearch(bogieIDs, searchKey);

        if (result) {
            System.out.println("Bogie ID " + searchKey + " found!");
        } else {
            System.out.println("Bogie ID " + searchKey + " not found.");
        }

        sc.close();
    }
}