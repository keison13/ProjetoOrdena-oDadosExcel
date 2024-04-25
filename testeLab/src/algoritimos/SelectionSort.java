package algoritimos;

import java.util.Date;

public class SelectionSort {
    public static double sort(int[] arr) {
        long startTime = System.nanoTime();
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
        long endTime = System.nanoTime();
        return (endTime - startTime) / 1e9; // Convertendo para segundos
    }

    public static double sort(String[] arr) {
        long startTime = System.nanoTime();
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j].compareTo(arr[minIndex]) < 0) {
                    minIndex = j;
                }
            }
            String temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
        long endTime = System.nanoTime();
        return (endTime - startTime) / 1e9; // Convertendo para segundos
    }

    public static double sort(Date[] arr) {
        long startTime = System.nanoTime();
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j].compareTo(arr[minIndex]) < 0) {
                    minIndex = j;
                }
            }
            Date temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
        long endTime = System.nanoTime();
        return (endTime - startTime) / 1e9; // Convertendo para segundos
    }
}

