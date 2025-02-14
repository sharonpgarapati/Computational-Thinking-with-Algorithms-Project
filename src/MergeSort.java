import java.io.*;
class MergeSort {

    // Function to merge the subarrays of array[]
    void merge(int arr[], int l, int m, int r){
        // Find sizes of two sub-arrays to be merged
        int n1 = m - l + 1;
        int n2 = r - m;

        // Temporary arrays
        int L[] = new int[n1];
        int R[] = new int[n2];

        // Copy data to temporary arrays
        for (int i = 0; i < n1; ++i)
            L[i] = arr[l + i];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[m + 1 + j];


        
        int i = 0;      // Initial index of first sub-array 
        int  j = 0;      // Initial index of second sub-array
        int k  = l;        // Initial index of merged sub-array 

        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            }
            else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        // Copy the remaining elements of Left[] if there are any
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        // Copy the remaining elements of Right[] if there are any
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    // Main function that sorts arr[l..r] using
    // merge()
    void sort(int arr[],  int l,  int r)
    {
        if (l < r) {

            // Find the middle point
            int m = l + (r - l) / 2;

            // Sort first and second halves
            sort(arr, l, m);
            sort(arr, m + 1, r);

            // Merge the sorted halves
            merge(arr, l, m, r);
        }
    }

    //  function to print an array 
    static void printArray(int arr[])
    {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    // Main method
    public static void main(String args[])
    {
        int arr[] = { 4, 3, 8, 8, 0, 3};

        System.out.println("Given array is");
        printArray(arr);

        MergeSort ob = new MergeSort();
        ob.sort(arr, 0, arr.length - 1);

        System.out.println("\nSorted array is");
        printArray(arr);
    }
}
