import java.util.Vector;
public class UnderstandVector {
    public static void main(String[]args){
        Vector<Integer> v = new Vector<>();
        v.add(10);
        v.add(21);
        v.add(30);
        v.add(51);
        
        for(int e :v){
            if (e%2==1){
                System.out.println(e + " is odd");
            }
        }
        System.out.println("The elements in the vector are:" + v);
        System.out.println("The size of the vector is:" + v.size());
        System.out.println("The capacity of the vector is:" + v.capacity());
        System.out.println("The first element in the vector is:" + v.firstElement());
        System.out.println("The last element in the vector is:" + v.lastElement());
        v.clear();
        System.out.println("The elements in the vector after clear() are:" + v);
        System.out.println("Is the vector empty? " + v.isEmpty());
        
    }
    
}
