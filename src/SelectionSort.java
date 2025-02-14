import java.io.*;
public class SelectionSort {
    void selectionSort(int array[]) {
        int n = array.length;
        for (int i = 0; i < n-1; i++) {    // Outer loop
            int min_idx = i;
            for (int j = i+1; j < n; j++)    // Inner loop of unsorted array
                if (array[j] < array[min_idx]) // Locate the index of the min element in the 
                                                                            unsorted subarray  
                min_idx =  j;
            int temp = array[min_idx]; // Swapping elements
            array[min_idx] = array[i];
            array [i] = temp;
        }
    }
    void printArray(int array[]) { // Prints the array
        int n = array.length;
        for (int i=0; i<n; ++i)
            System.out.print(array[i]+" ");
        System.out.println();
    }

    
    public static void main(String args[]) {   // Main method
        SelectionSort ob = new SelectionSort();
        int array[] = {4,3,8,8,0,3};
        ob. selectionSort(array);
        System.out.println("Sorted array");
        ob.printArray(array);
    }
}
