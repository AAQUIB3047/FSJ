public class PrintArrayReverse {
    public static void main(String[] args) {
        int arr[] = { 5, 1, 20, 13, 24, 15 };
        System.out.println("Array in reverse order:");
        for (int i = arr.length - 1; i >= 0; i--) {
            System.out.print(arr[i] + " ");
        }
    }
}