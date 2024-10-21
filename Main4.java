abstract class Shape {
    protected int dimension1; 
    protected int dimension2; 
    public Shape(int dimension1, int dimension2) {
        this.dimension1 = dimension1;
        this.dimension2 = dimension2;
    }
    public abstract void printArea();
}
class Rectangle extends Shape {
    public Rectangle(int width, int height) {
        super(width, height);
    }
    @Override
    public void printArea() {
        int area = dimension1 * dimension2;
        System.out.println("Area of Rectangle: " + area);
    }
}
class Triangle extends Shape {
    public Triangle(int base, int height) {
        super(base, height);
    }
    @Override
    public void printArea() {
        double area = 0.5 * dimension1 * dimension2;
        System.out.println("Area of Triangle: " + area);
    }
}
class Circle extends Shape {
    public Circle(int radius) {
        super(radius, 0); 
    }
    @Override
    public void printArea() {
        double area = Math.PI * dimension1 * dimension1; 
        System.out.println("Area of Circle: " + area);
    }
}
public class Main4 {
    public static void main(String[] args) {
        Shape rectangle = new Rectangle(5, 10);
        rectangle.printArea();

        Shape triangle = new Triangle(5, 10);
        triangle.printArea();

        Shape circle = new Circle(7);
        circle.printArea();
    }
}
