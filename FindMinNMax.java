public class FindMinNMax {
    public static void main(String[] args) {
        int arr[] = {5,10,7,9,2,3,4,1,6,8};
        int min = arr[0];
        int max = arr[0];
        int posmin = 0;
        int posmax = 0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]<min){
                min = arr[i];
                posmin = i +1;
            }
            if(arr[i]>max){
                max = arr[i];
                posmax = i + 1;
            }
        }
        System.out.println("The entered numbers are:");
        System.out.println("Minimum value: " + min + " at position: " + posmin);
        System.out.println("Maximum value: " + max + " at position: " + posmax);
    }
    
}
