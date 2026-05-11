import java.util.*;

public class select {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();
        int arr[] = new int[n];

        System.out.println("Enter elements:");
        for (int i = 0; i < n; i++) arr[i] = sc.nextInt();

        System.out.println("\n--- Starting Greedy Selection Sort ---");

        for (int i = 0; i < n - 1; i++) {
            int minIdx = i;

            // The Greedy Choice: Find the absolute smallest in the remaining list
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIdx]) {
                    minIdx = j;
                }
            }

            System.out.println("Step " + (i + 1) );

            // Swap
            int temp = arr[i];
            arr[i] = arr[minIdx];
            arr[minIdx] = temp;
            
            System.out.println(Arrays.toString(arr));
        }

        System.out.println("\nFinal Sorted Array: " + Arrays.toString(arr));
        sc.close();
    }
}