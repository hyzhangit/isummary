import java.util.Arrays;

public class SortDemo {
    public static void main(String[] args) {
        int[] arr = {23, 45, 17, 11, 13, 89, 72, 26, 3, 17, 11, 13};
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    private static void quickSort(int[] arr, int l, int r) {
        // 1. terminator
        if (l >= r) {
            return;
        }

        // 2.process current
        int temp = arr[l];
        int i = l;
        int j = r;
        while (i < j) {
            while (j > i && arr[j] > temp) {
                j--;
            }
            arr[i] = arr[j];

            while (i < j && arr[i] <= temp) {
                i++;
            }
            arr[j] = arr[i];
        }
        arr[i] = temp;

        // 3. drill down
        quickSort(arr, l, i - 1);
        quickSort(arr, i + 1, r);

        // 4. revert status
    }
}
