import java.util.Scanner;

public class TrainConsistManagementApp {

    public static boolean linearSearch(String[] bogieIDs, String searchKey) {
        for (String id : bogieIDs) {
            if (id.equals(searchKey)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter number of bogies:");
        int n = sc.nextInt();
        sc.nextLine(); // consume newline

        String[] bogieIDs = new String[n];
        System.out.println("Enter bogie IDs:");
        for (int i = 0; i < n; i++) {
            bogieIDs[i] = sc.nextLine();
        }

        System.out.println("Enter bogie ID to search:");
        String searchKey = sc.nextLine();

        boolean found = linearSearch(bogieIDs, searchKey);

        if (found) {
            System.out.println("Bogie ID " + searchKey + " found in the consist.");
        } else {
            System.out.println("Bogie ID " + searchKey + " not found in the consist.");
        }

        sc.close();
    }
}