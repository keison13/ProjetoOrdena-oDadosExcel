package algoritimos;
import java.util.Date;

public class CountingSort {
    public static double sort(int[] arr) {
        long startTime = System.nanoTime();
        int max = findMax(arr);
        countingSort(arr, max);
        long endTime = System.nanoTime();
        double executionTime = (endTime - startTime) / 1e9; // Convertendo para segundos
        return executionTime;
    }

    public static double sort(String[] arr) {
        long startTime = System.nanoTime();
        // Assume que os elementos são letras minúsculas de 'a' a 'z'
        int max = 26;
        countingSort(arr, max);
        long endTime = System.nanoTime();
        double executionTime = (endTime - startTime) / 1e9; // Convertendo para segundos
        return executionTime;
    }

    public static double sort(Date[] arr) {
        long startTime = System.nanoTime();
        // Não implementado para Date[], pois requer uma abordagem específica de comparação e contagem
        long endTime = System.nanoTime();
        double executionTime = (endTime - startTime) / 1e9; // Convertendo para segundos
        return executionTime;
    }

    private static int findMax(int[] arr) {
        int max = Integer.MIN_VALUE;
        for (int num : arr) {
            if (num > max) {
                max = num;
            }
        }
        return max;
    }

    private static void countingSort(int[] arr, int max) {
        int n = arr.length;
        int[] count = new int[max + 1];
        int[] output = new int[n];

        for (int num : arr) {
            count[num]++;
        }

        for (int i = 1; i <= max; i++) {
            count[i] += count[i - 1];
        }

        for (int i = n - 1; i >= 0; i--) {
            output[count[arr[i]] - 1] = arr[i];
            count[arr[i]]--;
        }

        for (int i = 0; i < n; i++) {
            arr[i] = output[i];
        }
    }

    private static void countingSort(String[] arr, int max) {
        int n = arr.length;
        int[] count = new int[max + 1];
        String[] output = new String[n];

        for (String str : arr) {
            int index = str.charAt(0) - 'a'; // Assume que os elementos são letras minúsculas de 'a' a 'z'
            count[index]++;
        }

        for (int i = 1; i <= max; i++) {
            count[i] += count[i - 1];
        }

        for (int i = n - 1; i >= 0; i--) {
            int index = arr[i].charAt(0) - 'a'; // Assume que os elementos são letras minúsculas de 'a' a 'z'
            output[count[index] - 1] = arr[i];
            count[index]--;
        }

        System.arraycopy(output, 0, arr, 0, n);
    }
}

