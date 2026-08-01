
class Shape {
    private double area;

    public void Calculate(double side) {
        area = side * side;
        System.out.println("Area of square is " + area);
    }

    public void Calculate(double length, double breadth) {
        area = length * breadth;
        System.out.println("Area of rectangle is " + area);
    }

    public void Calculate(double radius, float pi) {
        area = pi * radius * radius;
        System.out.println("Area of circle is " + area);
    }
}

public class FunctionOverloading {
    public static void main(String[] args) {
        Shape sq = new Shape();
        sq.Calculate(5.0); // Calls the method for square

        Shape rect = new Shape();
        rect.Calculate(4.0, 6.0); // Calls the method for rectangle

        Shape circle = new Shape();
        circle.Calculate(3.0, 3.14f); // Calls the method for circle
    }
}