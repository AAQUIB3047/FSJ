/*
class is a blue or a template
it is based upon real world entity
it has fields and methods
fields(variables) - datamembers are the properties of the class
methods are the actions of the class (functions)
*/

import java.util.Scanner;

class Person {

    private String name;
    private int age;
    private double weight;
    Scanner sc = new Scanner(System.in);

    public void accept() {
        System.out.println("Enter name age and weight of the person ");
        name = sc.next();
        age = sc.nextInt();
        weight = sc.nextDouble();
    }

    public void display() {
        System.out.println("Name is " + name);
        System.out.println("Age is " + age);
        System.out.println("Weight is " + weight);

    }
}

public class ClassNObject {
    public static void main(String[] args) {
        Person p1 = new Person();
        Person p2 = new Person();
        p1.accept();
        p1.display();

        p2.accept();
        p2.display();
    }
}