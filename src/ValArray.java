import java.util.Arrays;
public class ValArray {
    public static void main(String[] args) {
        int[] array1 = {1, 2, 3, 4,};
        int sum = sumArray(array1);
        int[] array2 = createArrayWithSum(array1, sum);

        System.out.println("Sum = " + sum);
        System.out.println("Array 2: " + Arrays.toString(array2));
    }
    public static int sumArray(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        return sum;
    }
    public static int[] createArrayWithSum(int[] arr, int sum) {
        int[] result = new int[arr.length];
        result[0] = sum;
        for(int i = 1; i < result.length; i++) {
            result[i] = result[i-1] + 1;
        }
        return result;
    }
}