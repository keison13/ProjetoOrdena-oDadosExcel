package algoritimos;
import java.util.Date;

public class InsertionSort {
    public static double sort(int[] arr) {
        long startTime = System.nanoTime();
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
        long endTime = System.nanoTime();
        return (endTime - startTime) / 1e9; // Convertendo para segundos
    }

    public static double sort(String[] arr) {
        long startTime = System.nanoTime();
        for (int i = 1; i < arr.length; i++) {
            String key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j].compareTo(key) > 0) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
        long endTime = System.nanoTime();
        return (endTime - startTime) / 1e9; // Convertendo para segundos
    }

    public static double sort(Date[] arr) {
        long startTime = System.nanoTime();
        for (int i = 1; i < arr.length; i++) {
            Date key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j].compareTo(key) > 0) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
        long endTime = System.nanoTime();
        return (endTime - startTime) / 1e9; // Convertendo para segundos
    }
}