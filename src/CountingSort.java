
import java.util.Arrays;

public class CountingSort {
	public static int[] countingSort(int[] inputArray) {
		// 
		int N = inputArray.length;    //Array input
		int M = 0;
		for (int i = 0; i < N; i++) {  //Finding the maxixmum element of the array
			M = Math.max(M, inputArray[i]);
		}

		int[] countArray = new int[M + 1];   // Initializing the count array
		for (int i = 0; i < N; i++) {
			countArray[inputArray[i]]++;
		}
		for (int i = 1; i <= M; i++) {    //Changing the count array for positions
			countArray[i] += countArray[i - 1];
		}
		int[] outputArray = new int[N];
		for (int i = N - 1; i >= 0; i--) {
			outputArray[countArray[inputArray[i]] - 1] = inputArray[i];
			countArray[inputArray[i]]--; //Decrement the count of the current element in the count array.
		}
		return outputArray; // sorted output array returned
	}


	public static void main(String[] args) {  // Main method
		int[] inputArray = {4, 3, 8, 8, 0, 3};
		int[] outputArray = countSort(intputArray);

		for (int i = 0; i < inputArray.length; i++) {
			System.out.print(outputArray[i] + " ");
		}
	}
}
