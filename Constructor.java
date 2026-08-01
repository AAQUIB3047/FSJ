import java.util.Scanner;

/*
constructor  is a special function
it has same name as the class name
access specifier is public 
it may or may not have parameters
it is invoked(called) automatically when an object is created
*/
class Person {

    private String name;
    private int age;
    private double weight;

    // Default constructor
    public Person() {
        System.out.println("Constructor is invoked");
        name = "unknown";
        age = 0;
        weight = 0;
    }

    // Parameterized constructor
    public Person(String n, int a, double w) {
        name = n;
        age = a;
        weight = w;
    }

    // if you have two or more constructor
    // in the same class with different parameters
    // then it is called constructor overloading

    public void display() {
        System.out.println("Name is " + name);
        System.out.println("Age is " + age);
        System.out.println("Weight is " + weight);

    }
}

public class Constructor {
    public static void main(String[] args) {
        Person p1 = new Person("AAquib", 15, 54.32);
        p1.display();
    }
}

