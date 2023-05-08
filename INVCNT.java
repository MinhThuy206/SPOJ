import java.util.*;
import java.lang.*;

class INVCNT {
    static long inversionCount(long arr[]) {
        long inversions = mergeSort(arr, 0, arr.length - 1);
        return inversions;
    }

    public static long mergeSort(long[] arr, int low, int high) {
        long inversions = 0;
        if (high > low) {
            int mid = (low + high) / 2;

            inversions += mergeSort(arr, low, mid);
            inversions += mergeSort(arr, mid + 1, high);
            inversions += merge(arr, low, high);
        }

        return inversions;
    }

    public static long merge(long[] arr, int low, int high) {
        int mid = (low + high) / 2;
        int i = low, j = mid + 1, index = 0;
        long inversions = 0;
        long[] newArr = new long[high - low + 1];

        while (i <= mid && j <= high) {
            if (arr[j] < arr[i]) {
                inversions += (mid - i + 1);
                newArr[index++] = arr[j++];
            } else {
                newArr[index++] = arr[i++];
            }
        }

        while (i <= mid) {
            newArr[index++] = arr[i++];
        }
        while (j <= high) {
            newArr[index++] = arr[j++];
        }

        index = 0;
        for (int k = low; k <= high; k++) {
            arr[k] = newArr[index++];
        }
        return inversions;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long t = sc.nextLong();

        while (t-- > 0) {
            long n = sc.nextLong();
            long arr[] = new long[(int) n];

            for (long i = 0; i < n; i++)
                arr[(int) i] = sc.nextLong();

            System.out.println(inversionCount(arr));
        }
    }
}
