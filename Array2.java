import java.util.Scanner;

public class Array2 {
    public static void main(String[] args) {
        int arr[] = new int[10];
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter 10 numbers:");

       
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }

        
        System.out.println("The entered numbers are:");
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }

        
    }
}