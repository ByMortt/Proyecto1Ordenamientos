public class Utilerias {
    // swap method implementation for int arrays
    public static void swap(int[] array, int i, int j) {
        int aux = array[i];
        array[i] = array[j];
        array[j] = aux;
    }

    // print method implementation for int arrays
    public static void print(int[] array) {
        for (int j : array) {
            System.out.printf("%d ", j);
        }
        System.out.println();
    }

    //Heap Sort Utilities Heapify and buildHeap
    //Heapify
    public static void heapify(int[] array, int n, int i) {
        int largest = i; // Initialize largest as root
        int l = 2 * i + 1; // left = 2*i + 1
        int r = 2 * i + 2; // right = 2*i + 2
        int comparisons = 0;
        int swaps = 0;
        int operations;
        // If left child is larger than root
        comparisons++;
        if (l < n && array[l] > array[largest]) {
            largest = l;
        }

        // If right child is larger than largest so far
        comparisons++;
        if (r < n && array[r] > array[largest]) {
            largest = r;
        }

        // If largest is not root
        comparisons++;
        if (largest != i) {
            swaps++;
            Utilerias.swap(array, i, largest);

            // Recursively heapify the affected sub-tree
            heapify(array, n, largest);
        }
        operations = comparisons + swaps;
        System.out.println("operaciones de heapyfy");
        System.out.printf("Comparaciones: %d\n", comparisons);
        System.out.printf("Intercambios: %d\n", swaps);
        System.out.printf("Operaciones: %d\n", operations);
    }

    //buildHeap
    public static void buildHeap(int[] array, int n) {
        // Index of last non-leaf node
        int startIdx = (n / 2) - 1;
        int operations=0;
        // Perform reverse level order traversal
        // from last non-leaf node and heapify
        // each node
        for (int i = startIdx; i >= 0; i--) {
            heapify(array, n, i);
            operations++;
        }
        System.out.println("operaciones de buildHeap");
        System.out.printf("Operaciones: %d\n", operations);
    }

    //Bucket Sort Utilities
    //maxValue
    public static int maxValue(int[] array) {
        int maxValue = 0;
        for (int j : array) {
            if (j > maxValue) {
                maxValue = j;
            }
        }
        return maxValue;
    }

    //minValue
    public static int minValue(int[] array) {
        int minValue = array[0];
        for (int j : array) {
            if (j < minValue) {
                minValue = j;
            }
        }
        return minValue;
    }

    //printBucket content
    public static void printBucket(int[] array) {
        for (int j : array) {
            System.out.printf("%d ", j);
        }
        System.out.println();
    }
}