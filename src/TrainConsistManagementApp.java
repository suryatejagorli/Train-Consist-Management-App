import java.util.Scanner;

public class TrainConsistManagementApp {

    public static void bubbleSort(int[] capacities) {
        int n = capacities.length;
        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (capacities[j] > capacities[j + 1]) {
                    int temp = capacities[j];
                    capacities[j] = capacities[j + 1];
                    capacities[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) break;
        }
    }

    public static void displayArray(int[] capacities) {
        for (int cap : capacities) {
            System.out.print(cap + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter number of passenger bogies:");
        int n = sc.nextInt();

        int[] capacities = new int[n];
        System.out.println("Enter capacities of passenger bogies:");
        for (int i = 0; i < n; i++) {
            capacities[i] = sc.nextInt();
        }

        System.out.println("Original Capacities:");
        displayArray(capacities);

        bubbleSort(capacities);

        System.out.println("Sorted Capacities (Ascending):");
        displayArray(capacities);

        sc.close();
    }
}