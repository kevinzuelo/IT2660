import java.util.Random;

public class MergeSort {
    public  void mergeSort(int arr[]) {
        int numbers = arr.length;


        if(numbers < 2)
            return;
        int mid = numbers / 2;
        int left[] = new int[mid];
        int right[] = new int[numbers - mid];

        for(int i = 0; i < mid; i++) {
            left[i] = arr[i];
        }
        for(int i = mid; i < numbers; i++) {
            right[i - mid] = arr[i];
        }
        
        mergeSort(left);
        mergeSort(right);
        merge(arr, left, right);
    }

    public static void merge(int arr[], int left[], int right[]) {
        int i = 0;
        int j = 0;
        int k = 0;

        while(i < left.length && j < right.length) {
            if(left[i] <= right[j]) {
                arr[k] = left[i];
                i++;
            }
            else {
                arr[k] = right[j];
                j++;
            }
            k++;
        }

        while(i < left.length) {
            arr[k] = left[i];
            i++;
            k++;
        }
        while(j < right.length) {
            arr[k] = right[j];
            j++;
            k++;
        }
    }

    public static void main(String[] args) {
        MergeSort newMerge = new MergeSort();
        int[] randomNumbers = new int[100];

        for(int i = 0; i < randomNumbers.length; i++) {
            randomNumbers[i] = (int) (Math.random()*100);
        }
        
        System.out.print("Unsorted array: ");
        for(int i = 0; i < randomNumbers.length; i++) {
            System.out.print(randomNumbers[i] + " ");
        }
        
        System.out.print("\nSorted array: " );
        newMerge.mergeSort(randomNumbers);
        for(int i = 0; i < randomNumbers.length; i++) {
            System.out.print(randomNumbers[i] + " ");
        }
    }
}
