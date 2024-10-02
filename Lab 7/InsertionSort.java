public class InsertionSort {
    public static void insertionSort(int[] array) {
        int n = array.length;
        int count = 0;
        for (int i = 1; i < n; ++i) {
            int j = i - 1;

            while (j >= 0 && array[j] > array[i]) {
                if (array[i] >= array[j]) {
                    break;
                }
                else{
                    count++;
                    j--;
                }

            }
        }
    }
}