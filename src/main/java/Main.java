/**
 * Clase principal que contiene el método main
 * @see Ordenamientos
 * @see Utilerias
 * @version 3.0, 17/09/2023
 * @author Oscar Cruz, Suzzette, Melissa
 */
public class Main {

    /**
     *
     */
    public static void main(String[] args) {
        // creation and initialization of the array
        // por medio de n se puede cambiar el tamaño del arreglo
        int n = 10;
        int[] array = new int[n];
        for (int i = 0; i < array.length; i++) {
            array[i] = (int)(Math.random() * 101);
        }

        //create 6 copies of the array to sort
        int[] array1 = array.clone();
        int[] array2 = array.clone();
        int[] array3 = array.clone();
        int[] array4 = array.clone();
        int[] array5 = array.clone();
        int[] array6 = array.clone();
        //print the array
        System.out.println("Array original");
        Utilerias.print(array);
        //Selection sort
        System.out.println("|||||||||||||||||||||||||||||||||||||||||");
        System.out.println("Selection sort");
        Ordenamientos.selectionSort(array);
        //Insertion sort
        System.out.println("|||||||||||||||||||||||||||||||||||||||||");
        System.out.println("array1");
        Utilerias.print(array1);
        System.out.println("Insertion sort");
        Ordenamientos.insertionSort(array1);
        //Bubble sort
        System.out.println("|||||||||||||||||||||||||||||||||||||||||");
        System.out.println("array2");
        Utilerias.print(array2);
        System.out.println("Bubble sort");
        Ordenamientos.bubbleSort(array2);
        //heap sort
        System.out.println("|||||||||||||||||||||||||||||||||||||||||");
        System.out.println("array3");
        Utilerias.print(array3);
        System.out.println("Heap sort");
        Ordenamientos.heapSort(array3);
        //quick sort
        System.out.println("|||||||||||||||||||||||||||||||||||||||||");
        System.out.println("array4");
        Utilerias.print(array4);
        System.out.println("Quick sort");
        Ordenamientos.quickSort(array4, 0, array4.length - 1);
        //merge sort
        System.out.println("|||||||||||||||||||||||||||||||||||||||||");
        System.out.println("array5");
        Utilerias.print(array5);
        System.out.println("Merge sort");
        Ordenamientos.sort(array5, 0, array5.length - 1);
        System.out.println("array5 ordenado");
        Utilerias.print(array5);
        //bucket sort
        System.out.println("|||||||||||||||||||||||||||||||||||||||||");
        System.out.println("array6");
        Utilerias.print(array6);
        System.out.println("Bucket sort");
        Ordenamientos.bucketSort(array4);
    }
}