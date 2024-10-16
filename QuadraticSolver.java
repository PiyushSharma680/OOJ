/*Develop a Java program that prints all real solutions to the quadratic equation ax2+bx+c = 0.
Read in a, b, c and use the quadratic formula. If the discriminate b2-4ac is negative, 
display a message stating that there are no real solutions.*/
import java.util.Scanner;
public class QuadraticSolver {
    public static void main(String[] args) {
        
        try (Scanner scanner = new Scanner(System.in)) {
            
            System.out.print("Enter coefficient a: ");
            double a = scanner.nextDouble();
            System.out.print("Enter coefficient b: ");
            double b = scanner.nextDouble();
            System.out.print("Enter coefficient c: ");
            double c = scanner.nextDouble();
            
            if (a == 0) {
                System.out.println("Coefficient a cannot be zero for a quadratic equation.");
                return;
            }   
            double discriminant = b * b - 4 * a * c;
            
            if (discriminant > 0) {
                
                double sqrtDiscriminant = Math.sqrt(discriminant);
                double root1 = (-b + sqrtDiscriminant) / (2 * a);
                double root2 = (-b - sqrtDiscriminant) / (2 * a);
                System.out.println("The roots are real and different.");
                System.out.println("Root 1: " + root1);
                System.out.println("Root 2: " + root2);
            } else if (discriminant == 0) {
                
                double root = -b / (2 * a);
                System.out.println("The root is real and repeated.");
                System.out.println("Root: " + root);
            } else {
                
                System.out.println("There are no real solutions.");
            }
            
        }
    }
}

