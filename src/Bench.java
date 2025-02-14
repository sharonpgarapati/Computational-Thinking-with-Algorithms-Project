import java.util.Arrays;
class Bench {
    public int[] copyArr(int[] src) {
        int[] dest = new int[src.length];
        System.arraycopy(src, 0, dest, 0, src.length);
        return dest;
    }
    public int[] randomArray(int n) {
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = (int)(Math.random() * 100);
        }
        return array;
    }
    //Benchmark Bubble Sort
    public String benchmarkBubbleSort(int arraySize) {
        double total = 0;
        int reps = 10; //Number of times to run the algorithm
        int[] arr = randomArray(arraySize);
        for (int i = 0; i < reps; i++) {
            int[] cloned = copyArr(arr);
            long startTime = System.nanoTime();
            bubbleSort(cloned); //Call bubbleSort
            selectionSort(cloned); //Call selectionSort
            long endTime = System.nanoTime();
            long timeElapsed = endTime - startTime;
            double elapsedMillis = timeElapsed / 1000000.0;
            total += elapsedMillis;
        }
        return String.format("%.3f", total/reps);
    }
    //Benchmark Selection Sort
    public String benchmarkSelectionSort(int arraySize) {
        double total = 0;
        int reps = 10; //Number of times to run the algorithm
        int[] arr = randomArray(arraySize);
        for (int i = 0; i < reps; i++) {
            int[] cloned = copyArr(arr);
            long startTime = System.nanoTime();
            selectionSort(cloned); //Call selectionSort
            long endTime = System.nanoTime();
            long timeElapsed = endTime - startTime;
            double elapsedMillis = timeElapsed / 1000000.0;
            total += elapsedMillis;
        }
        return String.format("%.3f", total/reps);
    }
   
    //Benchmark Insertion Sort
    public String benchmarkInsertionSort(int arraySize) {
        double total = 0;
        int reps = 10; //Number of times to run the algorithm
        int[] arr = randomArray(arraySize);
        for (int i = 0; i < reps; i++) {
            int[] cloned = copyArr(arr);
            long startTime = System.nanoTime();
            insertionSort(cloned); //Call insertionSort
            long endTime = System.nanoTime();
            long timeElapsed = endTime - startTime;
            double elapsedMillis = timeElapsed / 1000000.0;
            total += elapsedMillis;
        }
        return String.format("%.3f", total/reps);
    }
	
	
	//Benchmark Merge Sort
    /**
     * @param arraySize
     * @return
     */
    public String benchmarkMergeSort(int arraySize) {
        double total = 0;
        double average = 0;
        int reps = 10; //Number of times to run the algorithm
        int[] arr = randomArray(arraySize);
        for (int i = 0; i < reps; i++) {
            int[] cloned = copyArr(arr);
            long startTime = System.nanoTime();
            mergeSort(cloned, 0, cloned.length - 1); //Call mergeSort;
            //Ensure mergeSort is implemented correctly
            long endTime = System.nanoTime();
            long timeElapsed = endTime - startTime;
            double elapsedMillis = timeElapsed / 1000000.0;
            total += elapsedMillis;
        }
        return String.format("%.3f", total/reps);
        
        
    }
    //Benchmark Counting Sort
    public String benchmarkCountingSort(int arraySize) {
        double total   = 0;
        double average = 0;
        int reps = 10; //Number of times to run the algorithm
        int[] arr = randomArray(arraySize);
        for (int i = 0; i < reps; i++) {
            int[] cloned = copyArr(arr);
            long startTime = System.nanoTime();
            countingSort(cloned); //Call countingSort
            long endTime = System.nanoTime();
            long timeElapsed = endTime - startTime;
            double elapsedMillis = timeElapsed / 1000000.0;
            total += elapsedMillis;
            //System.out.println(Arrays.toString(cloned));
        }
        return String.format("%.3f", total/reps);		
    }
    
	
    
    //Bubble Sort method  - Start
    /**
     * @param arr
     */
    public void bubbleSort(int arr[]) 
        { 
            int n = arr.length; 
            for (int i = 0; i < n - 1; i++) 
                for (int j = 0; j < n - i - 1; j++) 
                    if (arr[j] > arr[j + 1]) { 
                        // swap temp and arr[i] 
                        int temp = arr[j]; 
                        arr[j] = arr[j + 1]; 
                        arr[j + 1] = temp; 
                    } 
        } //Bubble Sort - End
    
    //Selection Sort method - Start
    public void selectionSort(int arr[]) 
    { 
        int n = arr.length; 
  
        // One by one move boundary of unsorted subarray 
        for (int i = 0; i < n - 1; i++) { 
            // Find the minimum element in unsorted array 
            int min_idx = i; 
            for (int j = i + 1; j < n; j++) { 
                if (arr[j] < arr[min_idx]) 
                    min_idx = j; 
            } 
  
            // Swap the found minimum element with the first 
            // element 
            int temp = arr[min_idx]; 
            arr[min_idx] = arr[i]; 
            arr[i] = temp; 
        } 
    } //Selection sort - End
    
    //Insertion Sort method - Start
    public void insertionSort(int arr[]) 
    { 
        int n = arr.length; 
        for (int i = 1; i < n; ++i) { 
            int key = arr[i]; 
            int j = i - 1; 
  
            // Move elements of arr[0..i-1], that are 
            // greater than key, to one position ahead 
            // of their current position 
            while (j >= 0 && arr[j] > key) { 
                arr[j + 1] = arr[j]; 
                j = j - 1; 
            } 
            arr[j + 1] = key; 
        } 
    } //Insertion Sort method - End
 
    // Merge Sort method - Start
      // Main function that sorts arr[l..r] using
    // merge()
    public void mergeSort(int arr[], int l, int r){
        if (l < r) {

            // Find the middle point
            int m = l + (r - l) / 2;

            // Sort first and second halves
            mergeSort(arr, l, m);
            mergeSort(arr, m + 1, r);

            // Merge the sorted halves
            merge(arr, l, m, r);
        }
    } 
    // Merges two subarrays of arr[].
    // First subarray is arr[l..m]
    // Second subarray is arr[m+1..r]
   private void merge(int arr[], int l, int m, int r){
        // Find sizes of two subarrays to be merged
        int n1 = m - l + 1;
        int n2 = r - m;

        // Create temp arrays
        int L[] = new int[n1];
        int R[] = new int[n2];

        // Copy data to temp arrays
        for (int i = 0; i < n1; ++i)
            L[i] = arr[l + i];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[m + 1 + j];

        // Merge the temp arrays

        // Initial indices of first and second subarrays
        int i = 0, j = 0;

        // Initial index of merged subarray array
        int k = l;
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

        // Copy remaining elements of L[] if any
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        // Copy remaining elements of R[] if any
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

   
     //Merge Sort method - End
     
     // Counting Sort method - Start
     
     
    public void countingSort(int[] inputArray) {
        int N = inputArray.length; //Array input
        int M = 0;
 
        for (int i = 0; i < N; i++) {   //Finding the maximum element of the array
            M = Math.max(M, inputArray[i]);
        }
 
        int[] countArray = new int[M + 1];  // Initializing the count array
 
        for (int i = 0; i < N; i++) {
            countArray[inputArray[i]]++;
        }
 
        for (int i = 1; i <= M; i++) {    // Changing the count array for positions
            countArray[i] += countArray[i - 1];
        }
 
        int[] outputArray = new int[N];
 
        for (int i = N - 1; i >= 0; i--) {
            outputArray[countArray[inputArray[i]] - 1] = inputArray[i];
            countArray[inputArray[i]]--;
        }
 
        return;     //sorted output array returned
    }
     // Counting Sort method - End
 
 
 
	//main method
    public static void main(String[] args) {
        Bench w = new Bench();
        
        //2d Array to store run times
        String[][] runtimes = new String[5][11];


        //Delcare arraySize
        int[] arraySizes = new int[]{100, 250, 500, 1000, 2000, 2500, 3000, 3500, 5000, 10000, 10001};
        runtimes[0][0]="BubbleSort"; //First array bubble sort
        runtimes[1][0]="SelectionSort";
        runtimes[2][0]="InsertionSort";
        runtimes[3][0]="MergeSort";
        runtimes[4][0]="CountingSort";
        
        //Loop throuh the array and get bench mark time for each algorithm
        for (int i=0; i<arraySizes.length; i++) {
             for (int j=1; j<runtimes[0].length; j++) {
				//Call benchmark Bubble sort with different arrays
				runtimes[0][j]= w.benchmarkBubbleSort(arraySizes[j]);
				
				//Call benchmark Selection sort with different arrays
				runtimes[1][j]= w.benchmarkSelectionSort(arraySizes[j]); 
				
				//Call benchmark Insertion sort with different arrays
				runtimes[2][j] =w.benchmarkInsertionSort(arraySizes[j]);
				
				//Call benchmark Insertion sort with different arrays
				runtimes[3][j] =w.benchmarkMergeSort(arraySizes[j]);
				
				//Call benchmark Insertion sort with different arrays
				runtimes[4][j] =w.benchmarkCountingSort(arraySizes[j]);
             }
         }          
 
    // print array in rectangular form
    System.out.printf(" %-15s  %-10s  %-10s  %-10s  %-10s  %-10s %-10s  %-10s  %-10s  %-10s  %-10s %n", "Size", "100", "250", "500", "1000","2000","2500", "3000","3500","5000", "10000","10001");
        for (int r=0; r<runtimes.length; r++) {
            System.out.printf(" %-15s", runtimes[r][0]);
             for (int c=1; c<runtimes[r].length; c++) {
                 System.out.printf(" %-10s " ,runtimes[r][c] );
             }
             System.out.println();
         }  
    }
   

}