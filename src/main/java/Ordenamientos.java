public class Ordenamientos {
    // Selection sort
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

    // bucket sort algorithm, like the past algorithms, count the number of operations and print the array after each iteration
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
}