import java.util.Arrays;
public class BubbleSort {
    public static void main(String[] args) {
        int array[] = {4, 3, 8, 8, 0, 3};
        System.out.println ("Array before sorting:"+ Arrays.toString(a));
        int n = array. Length;
        for (int i = 0; i < n-1; i++) {  // Outer loop to access each array element
            for (int j = 0;  j < n-1;  j++) {  //Inner loop to compare array elements
                if (array [j]  > array [j+1]) {
                    int temp = array [j];         // swapping occurs if elements are not in the 
 						intended order
                    array [j] = array [j+1];
                    array [j+1] = temp;
                }
            }
        }
        System.out.println("Array After sorting:"+ Arrays.toString(a));
    }
}



