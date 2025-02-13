# Computational-Thinking-with-Algorithms-Project

# Benchmarking Five Sorting Algorithms in Java

Overview

This project benchmarks the performance of five different sorting algorithms implemented in Java. The goal is to compare the execution times of each algorithm when sorting arrays of random integers. The algorithms included in this benchmark are:

- Bubble Sort
- Selection Sort
- Insertion Sort
- Merge Sort
- Quick Sort

Project Structure

. ├── src │ └── SortingBenchmark.java # Main class that runs the benchmarks ├── README.md # This file └── data # (Optional) Directory for any generated data or logs

How It Works

The `SortingBenchmark.java` class:
- Generates arrays filled with random integers.
- Runs each sorting algorithm on identical copies of the data.
- Measures the execution time using `System.nanoTime()`.
- Outputs the benchmark results to the console.

Requirements

- **Java 8** or higher

How to Run

1. Compile the project:

   Navigate to the project directory and run:
   ```bash
   javac -d bin src/SortingBenchmark.java
2.	Run the benchmark:
After compilation, execute the benchmark with:
java -cp bin SortingBenchmark
Customization
•	Input Size: You can modify the size of the arrays to benchmark larger or smaller datasets.
•	Number of Trials: Increase the number of trials for each algorithm to obtain more stable timing results.
•	Algorithms: Feel free to add additional sorting algorithms or modify the existing implementations.
Output
The program prints the execution time (in nanoseconds or milliseconds) for each sorting algorithm, allowing you to compare their performance under the same conditions.
License
This project is licensed under the MIT License.
________________________________________
This project is intended for educational purposes and performance comparison of sorting algorithms in Java.

