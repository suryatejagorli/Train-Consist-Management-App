import java.util.Arrays;
import java.util.Scanner;

public class TrainConsistManagementApp {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter number of bogies:");
        int n = sc.nextInt();
        sc.nextLine();

        String[] bogieNames = new String[n];
        System.out.println("Enter bogie type names:");
        for (int i = 0; i < n; i++) {
            bogieNames[i] = sc.nextLine();
        }

        System.out.println("Original Bogie Names:");
        System.out.println(Arrays.toString(bogieNames));

        Arrays.sort(bogieNames);

        System.out.println("Sorted Bogie Names (Alphabetical):");
        System.out.println(Arrays.toString(bogieNames));

        sc.close();
    }
}