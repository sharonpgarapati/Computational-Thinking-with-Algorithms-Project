import java.util.Arrays;
public class InsertionSort {
    void insertionSort(int arr[]) {
        int n = arr.length;
        for (int i = 1; i < n; ++i) {   //Outer loop over the array starting at index 1
            int key = arr[i];   //
            int j = i - 1;
	// Comparing key with each element on the left-hand side of it 
	// until an element smaller than it is found
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1; // Move the index to be compared to the left by one position
            }
            arr[j + 1] = key;  // Complete the process again, this time one position to the right
        }
    }
    static void printArray(int arr[]) {    // Print array
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }
    // Main method
    public static void main(String args[]) {
        int arr[] = { 4, 3, 8, 8, 0, 3 };
        InsertionSort ob = new InsertionSort();
        ob.insertionSort(arr);
        printArray(arr);
    }
}
