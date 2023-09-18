/**
 * Clase Utilerias
 * Contiene los métodos de swap y print para arreglos de enteros
 * Contiene los métodos de heapify y buildHeap para el algoritmo Heap Sort
 * Contiene los métodos de maxValue, minValue y printBucket para el algoritmo Bucket Sort
 * @version 3.0, 17/09/2023
 * @author Oscar Cruz, Suzzette, Melissa
 */
public class Utilerias {
    // swap method implementation for int arrays
    /**
     * Intercambia dos elementos de un arreglo de enteros.
     *
     * @param array El arreglo en el que se desea intercambiar los elementos.
     * @param i     El índice del primer elemento a intercambiar.
     * @param j     El índice del segundo elemento a intercambiar.
     */
    public static void swap(int[] array, int i, int j) {
        int aux = array[i];
        array[i] = array[j];
        array[j] = aux;
    }

    // print method implementation for int arrays
    /**
     * Imprime un arreglo de enteros.
     *
     * @param array El arreglo que se desea imprimir.
     */
    public static void print(int[] array) {
        for (int j : array) {
            System.out.printf("%d ", j);
        }
        System.out.println();
    }

    //Heap Sort Utilities Heapify and buildHeap
    //Heapify
    /**
     * Convierte un subárbol en un montículo.
     *
     * @param array El arreglo que contiene el subárbol.
     * @param n     El tamaño del subárbol.
     * @param i     El índice de la raíz del subárbol.
     */
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
    /**
     * Convierte un arreglo en un montículo.
     *
     * @param array El arreglo que se desea convertir en un montículo.
     * @param n     El tamaño del arreglo.
     */
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
    /**
     * Obtiene el valor máximo de un arreglo de enteros.
     *
     * @param array El arreglo del que se desea obtener el valor máximo.
     * @return El valor máximo del arreglo.
     */
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
    /**
     * Obtiene el valor mínimo de un arreglo de enteros.
     *
     * @param array El arreglo del que se desea obtener el valor mínimo.
     * @return El valor mínimo del arreglo.
     */
    public static int minValue(int[] array) {
        int minValue = array[0];
        for (int j : array) {
            if (j < minValue) {
                minValue = j;
            }
        }
        return minValue;
    }

    //quickSort Utilities
    //partition
    /**
     * Particiona un arreglo de enteros.
     *
     * @param array El arreglo que se desea particionar.
     * @param low   El índice más bajo del arreglo.
     * @param high  El índice más alto del arreglo.
     * @return El índice de la partición.
     */
    public static int partition(int[] array, int low, int high) {
        int pivot = array[high];
        int i = low - 1; // index of smaller element
        int comparisons = 0;
        int swaps = 0;
        int operations;
        for (int j = low; j < high; j++) {
            // If current element is smaller than or
            // equal to pivot
            comparisons++;
            if (array[j] <= pivot) {
                i++;
                swaps++;
                Utilerias.swap(array, i, j);
            }
        }
        swaps++;
        Utilerias.swap(array, i + 1, high);
        operations = comparisons + swaps;
        System.out.println("Lista ordenada");
        Utilerias.print(array);
        System.out.println("Operaciones de quick sort");
        System.out.printf("Comparaciones: %d\n", comparisons);
        System.out.printf("Intercambios: %d\n", swaps);
        System.out.printf("Operaciones: %d\n", operations);
        return i + 1;
    }

    //mergeSort Utilities
    //merge
    /**
     * Combina dos subarreglos de un arreglo.
     *
     * @param array El arreglo que contiene los subarreglos.
     * @param l     El índice más bajo del arreglo.
     * @param m     El índice medio del arreglo.
     * @param r     El índice más alto del arreglo.
     */
    public static void merge(int[] array, int l, int m, int r) {
        // Find sizes of two subarrays to be merged
        int comparisons = 0;
        int swaps = 0;
        int operations;
        int n1 = m - l + 1;
        int n2 = r - m;
        /* Create temp arrays */
        int[] L = new int[n1];
        int[] R = new int[n2];
        /*Copy data to temp arrays*/
        for (int i = 0; i < n1; ++i) {
            L[i] = array[l + i];
            System.out.println("Lista por izquierda");
            Utilerias.print(L);
        }
        for (int j = 0; j < n2; ++j) {
            R[j] = array[m + 1 + j];
            System.out.println("Lista por derecha");
            Utilerias.print(R);
        }
        /* Merge the temp arrays */
        // Initial indexes of first and second subarrays
        int i = 0, j = 0;
        // Initial index of merged subarry array
        int k = l;
        while (i < n1 && j < n2) {
            comparisons++;
            if (L[i] <= R[j]) {
                array[k] = L[i];
                swaps++;
                i++;
            } else {
                array[k] = R[j];
                swaps++;
                j++;
            }
            k++;
        }
        /* Copy remaining elements of L[] if any */
        while (i < n1) {
            array[k] = L[i];
            swaps++;
            i++;
            k++;
        }
        /* Copy remaining elements of R[] if any */
        while (j < n2) {
            array[k] = R[j];
            swaps++;
            j++;
            k++;
        }
        operations = comparisons + swaps;
        System.out.println("Operaciones de merge sort");
        System.out.printf("Comparaciones: %d\n", comparisons);
        System.out.printf("Intercambios: %d\n", swaps);
        System.out.printf("Operaciones: %d\n", operations);
    }
}