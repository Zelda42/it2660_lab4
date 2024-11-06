import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
      System.out.println("Unsorted Array ---------------------------------------------------");
      ArrayList<Integer> integerList = Lab4.getList();
      Lab4.outputList(integerList);

      // part 3

      System.out.println("\n\nBubble sort results ----------------------------------------------");
      ArrayList<Integer> bubbleSortedList = new ArrayList<>(integerList); // Copy original list
      long bubbleStartTime = System.nanoTime(); 
      bubbleSortedList = Lab4.bubbleSort(bubbleSortedList);
      long bubbleEndTime = System.nanoTime(); 
      System.out.println("\nBubble sort time (nanoseconds): " + (bubbleEndTime - bubbleStartTime));
      Lab4.outputList(bubbleSortedList);

      System.out.println("\n\nInsertion sort results -------------------------------------------");
      ArrayList<Integer> insertionSortedList = new ArrayList<>(integerList); // Copy original list
      long insertionStartTime = System.nanoTime(); 
      insertionSortedList = Lab4.insertionSort(insertionSortedList);
      long insertionEndTime = System.nanoTime(); 
      System.out.println("\nInsertion sort time (nanoseconds): " + (insertionEndTime - insertionStartTime));
      Lab4.outputList(insertionSortedList);
    }
}

class Lab4 {
  public static ArrayList<Integer> insertionSort(ArrayList<Integer> integerList) {
    // Step 1 - Implement insertion sort algorithm here
    for (int i = 1; i < integerList.size(); i++) {
    int key = integerList.get(i);
    int j = i - 1;
    while (j >= 0 && integerList.get(j) > key) {
        integerList.set(j + 1, integerList.get(j));
        j = j - 1;
    }
    integerList.set(j + 1, key);
}

    return integerList;
  }

  public static ArrayList<Integer> bubbleSort(ArrayList<Integer> integerList) {
    // Step 2 - Implement the bubble sort algorithm here
    int n = integerList.size();
for (int i = 0; i < n - 1; i++) {
    for (int j = 0; j < n - i - 1; j++) {
        if (integerList.get(j) > integerList.get(j + 1)) {
            // Swap elements
            int temp = integerList.get(j);
            integerList.set(j, integerList.get(j + 1));
            integerList.set(j + 1, temp);
        }
    }
}

    return integerList;
  }

  public static ArrayList<Integer> getList() {
    ArrayList<Integer> integerList = new ArrayList<>();
    String line;
    try (BufferedReader br = new BufferedReader(new FileReader("integers.txt"))) {
        while ((line = br.readLine()) != null) {
            integerList.add(Integer.parseInt(line));
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
    return integerList;
  }

  public static void outputList(ArrayList<Integer> integerList) {
    for (int i = 0; i < integerList.size(); i++) {
        System.out.print(integerList.get(i) + " ");
    }
  }
}

// question 1 I would choose merge sort or quick sort. They have time complexity O(n log n) which is better for large data than O(n^2)
// 2. my bubble sort was 18934000 ns and insertion sort 7969000 ns. Insertion was quicker. it has fewer comparisons. 
// it should be quicker given the time complexities between the two.
// 3. bubble sort seems to be the easiest for me. It just repeats comparing and swapping. But insertion sort is fun 
// building a sorted portion of the array one element at a time