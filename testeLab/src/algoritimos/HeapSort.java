package algoritimos;

import java.util.Date;

public class HeapSort {
    public static double sort(int[] arr) {
        long startTime = System.nanoTime();
        int n = arr.length;
        buildHeap(arr, n);
        for (int i = n - 1; i > 0; i--) {
            swap(arr, 0, i);
            maxHeapify(arr, 0, i);
        }
        long endTime = System.nanoTime();
        double executionTime = (endTime - startTime) / 1e9; // Convertendo para segundos
        return executionTime;
    }

    public static double sort(String[] arr) {
        long startTime = System.nanoTime();
        int n = arr.length;
        buildHeap(arr, n);
        for (int i = n - 1; i > 0; i--) {
            swap(arr, 0, i);
            maxHeapify(arr, 0, i);
        }
        long endTime = System.nanoTime();
        double executionTime = (endTime - startTime) / 1e9; // Convertendo para segundos
        return executionTime;
    }

    public static double sort(Date[] arr) {
        long startTime = System.nanoTime();
        int n = arr.length;
        buildHeap(arr, n);
        for (int i = n - 1; i > 0; i--) {
            swap(arr, 0, i);
            maxHeapify(arr, 0, i);
        }
        long endTime = System.nanoTime();
        double executionTime = (endTime - startTime) / 1e9; // Convertendo para segundos
        return executionTime;
    }

    private static void buildHeap(int[] arr, int n) {
        for (int i = n / 2 - 1; i >= 0; i--) {
            maxHeapify(arr, i, n);
        }
    }

    private static void buildHeap(String[] arr, int n) {
        for (int i = n / 2 - 1; i >= 0; i--) {
            maxHeapify(arr, i, n);
        }
    }

    private static void buildHeap(Date[] arr, int n) {
        for (int i = n / 2 - 1; i >= 0; i--) {
            maxHeapify(arr, i, n);
        }
    }

    private static void maxHeapify(int[] arr, int i, int n) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n && arr[left] > arr[largest]) {
            largest = left;
        }

        if (right < n && arr[right] > arr[largest]) {
            largest = right;
        }

        if (largest != i) {
            swap(arr, i, largest);
            maxHeapify(arr, largest, n);
        }
    }

    private static void maxHeapify(String[] arr, int i, int n) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n && arr[left].compareTo(arr[largest]) > 0) {
            largest = left;
        }

        if (right < n && arr[right].compareTo(arr[largest]) > 0) {
            largest = right;
        }

        if (largest != i) {
            swap(arr, i, largest);
            maxHeapify(arr, largest, n);
        }
    }

    private static void maxHeapify(Date[] arr, int i, int n) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n && arr[left].compareTo(arr[largest]) > 0) {
            largest = left;
        }

        if (right < n && arr[right].compareTo(arr[largest]) > 0) {
            largest = right;
        }

        if (largest != i) {
            swap(arr, i, largest);
            maxHeapify(arr, largest, n);
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static void swap(String[] arr, int i, int j) {
        String temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static void swap(Date[] arr, int i, int j) {
        Date temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}

