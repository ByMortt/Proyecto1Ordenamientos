/**
 * Clase que contiene los métodos de ordenamiento.
 * @see Utilerias
 * @see Main
 * @version 3.0, 17/09/2023
 * @author Oscar Cruz, Suzzette, Melissa
 */
public class Ordenamientos {
    // Selection sort
    /**
     * Ordena un arreglo de enteros utilizando el algoritmo de selección (Selection Sort).
     *
     * @param array El arreglo que se desea ordenar.
     */
    public static void selectionSort(int[] array) {
        int comparisons = 0;
        int swaps = 0;
        int operations;
        for (int i = 0; i < array.length - 1; i++) {
            int indexMinor = i;
            for (int j = i + 1; j < array.length; j++) {
                comparisons++;
                if (array[j] < array[indexMinor]) {
                    indexMinor = j;
                }
            }
            if (i != indexMinor) {
                swaps++;
                Utilerias.swap(array, i, indexMinor);
            }
            System.out.printf("\nIteracion numero %d \n", i + 1);
            Utilerias.print(array);
        }
        operations = comparisons + swaps;
        System.out.printf("Comparaciones: %d\n", comparisons);
        System.out.printf("Intercambios: %d\n", swaps);
        System.out.printf("Operaciones: %d\n", operations);
    }

    // Insertion sort
    /**
     * Ordena un arreglo de enteros utilizando el algoritmo de inserción (Insertion Sort).
     *
     * @param array El arreglo que se desea ordenar.
     */
    public static void insertionSort(int[] array) {
        int operations = 0;
        for (int i = 1; i < array.length; i++) {
            int j = i;
            int aux = array[i];
            while (j > 0 && aux < array[j - 1]) {
                array[j] = array[j - 1];
                j--;
            }
            array[j] = aux;
            operations++;
            System.out.printf("\nIteracion numero %d \n", i);
            Utilerias.print(array);
        }
        System.out.printf("Operaciones: %d\n", operations);
    }

    // Bubble sort
    /**
     * Ordena un arreglo de enteros utilizando el algoritmo de burbuja (Bubble Sort).
     *
     * @param array El arreglo que se desea ordenar.
     */
    public static void bubbleSort(int[] array) {
        int comparisons = 0;
        int swaps = 0;
        int operations;
        int n = array.length;
        for (int i = n - 1; i > 0; i--) {
            boolean swapped = false;
            for (int j = 0; j < i; j++) {
                comparisons++;
                if (array[j] > array[j + 1]) {
                    Utilerias.swap(array, j, j + 1);
                    swapped = true;
                    swaps++;
                }
            }
            if (!swapped) {
                break;
            }
            System.out.println("Iteracion numero " + (n - i));
            Utilerias.print(array);
        }
        operations = comparisons + swaps;
        System.out.println("Lista ordenada");
        Utilerias.print(array);
        System.out.printf("Comparaciones: %d\n", comparisons);
        System.out.printf("Intercambios: %d\n", swaps);
        System.out.printf("Operaciones: %d\n", operations);
    }

    //Heap sort
    /**
     * Ordena un arreglo de enteros utilizando el algoritmo de ordenamiento por montón (Heap Sort).
     *
     * @param array El arreglo que se desea ordenar.
     */
    public static void heapSort(int[] array) {
        int comparisons = 0;
        int swaps = 0;
        int operations;
        int n = array.length;
        Utilerias.buildHeap(array, n);
        for (int i = n - 1; i > 0; i--) {
            Utilerias.swap(array, 0, i);
            swaps++;
            Utilerias.heapify(array, i, 0);
            comparisons++;
            System.out.println("Iteracion numero " + (n - i));
            Utilerias.print(array);
        }
        operations = comparisons + swaps;
        System.out.println("Lista ordenada");
        Utilerias.print(array);
        System.out.println("Operaciones de heap sort");
        System.out.printf("Comparaciones: %d\n", comparisons);
        System.out.printf("Intercambios: %d\n", swaps);
        System.out.printf("Operaciones: %d\n", operations);
    }

    // bucket sort algorithm
    /**
     * Ordena un arreglo de enteros utilizando el algoritmo de ordenamiento por cubetas (Bucket Sort).
     *
     * @param array El arreglo que se desea ordenar.
     */
    public static void bucketSort(int[] array) {
        int comparisons = 0;
        int swaps = 0;
        int operations;
        int max = Utilerias.maxValue(array); //maxValue(array);
        int min = Utilerias.minValue(array); //minValue(array);
        int range = max - min + 1;
        int[] bucket = new int[range];
        // Fill buckets
        for (int k : array) {
            bucket[k - min]++;
            comparisons++;
            // Imprimir el contenido de la cubeta en cada iteración
            System.out.println("Contenido de la cubeta:");
            for (int i = 0; i < bucket.length; i++) {
                System.out.printf("%d: %d\n", i + min, bucket[i]);
            }
        }
        int outPos = 0;
        // Move buckets to original array
        for (int i = 0; i < range; i++) {
            for (int j = 0; j < bucket[i]; j++) {
                // Imprimir el arreglo después de cada paso
                System.out.println("Arreglo ordenado parcialmente:");
                Utilerias.print(array);
                array[outPos++] = i + min;
                swaps++;
            }
        }
        operations = comparisons + swaps;
        System.out.println("Lista ordenada");
        Utilerias.print(array);
        System.out.println("Operaciones de bucket sort");
        System.out.printf("Comparaciones: %d\n", comparisons);
        System.out.printf("Intercambios: %d\n", swaps);
        System.out.printf("Operaciones: %d\n", operations);
    }

    //quick sort algorithm
    /**
     * Ordena un arreglo de enteros utilizando el algoritmo de ordenamiento rápido (Quick Sort).
     *
     * @param array El arreglo que se desea ordenar.
     * @param low   El índice más bajo del arreglo.
     * @param high  El índice más alto del arreglo.
     */
    public static void quickSort(int[] array, int low, int high) {
        int comparisons = 0;
        int swaps = 0;
        int operations;
        if (low < high) {
            int pi = Utilerias.partition(array, low, high);
            quickSort(array, low, pi - 1);
            quickSort(array, pi + 1, high);
            Utilerias.print(array);
            comparisons++;
        }
        operations = comparisons + swaps;
        System.out.println("Lista ordenada");
        Utilerias.print(array);
        System.out.println("Operaciones de quick sort");
        System.out.printf("Comparaciones: %d\n", comparisons);
        System.out.printf("Intercambios: %d\n", swaps);
        System.out.printf("Operaciones: %d\n", operations);
    }

    //merge sort algorithm (recursive) (top-down), like the past algorithms, count the number of operations and print the array after each iteration
    /**
     * Ordena un arreglo de enteros utilizando el algoritmo de ordenamiento por mezcla (Merge Sort).
     *
     * @param array El arreglo que se desea ordenar.
     * @param l     El índice más bajo del arreglo.
     * @param r     El índice más alto del arreglo.
     */
    public static void sort(int[] array, int l, int r) {
        int comparisons = 0;
        int swaps = 0;
        int operations;
        if (l < r) {
            // Find the middle point
            int m = (l + r) / 2;
            // Sort first and second halves
            sort(array, l, m);
            sort(array, m + 1, r);
            // Merge the sorted halves
            Utilerias.merge(array, l, m, r);
            System.out.println("Lista ordenada");
            Utilerias.print(array);
            comparisons++;
        }
        operations = comparisons + swaps;
        System.out.println("Operaciones de merge sort");
        System.out.printf("Comparaciones: %d\n", comparisons);
        System.out.printf("Intercambios: %d\n", swaps);
        System.out.printf("Operaciones: %d\n", operations);
    }
}