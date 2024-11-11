package com.example.distance;

import java.util.Scanner;

public class Distance {
    public int feet;
    public int inches;

        public void setValues(int feet, int inches) {
        this.feet = feet;
        this.inches = inches;
    }

        public void displayValues() {
        System.out.println("Feet: " + feet + ", Inches: " + inches);
    }

        public Distance add(Distance d) {
        Distance result = new Distance();
        int totalInches = this.inches + d.inches;
        int extraFeet = totalInches / 12;
        result.inches = totalInches % 12;
        result.feet = this.feet + d.feet + extraFeet;
        return result;
    }

    
    public Distance compare(Distance d) {
        int thisTotalInches = this.feet * 12 + this.inches;
        int otherTotalInches = d.feet * 12 + d.inches;
        if (thisTotalInches > otherTotalInches) {
            return this;
        } else if (thisTotalInches < otherTotalInches) {
            return d;
        } else {
            return this;         }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Distance d1 = new Distance();
        Distance d2 = new Distance();

        System.out.println("Enter feet and inches for the first distance:");
        d1.setValues(scanner.nextInt(), scanner.nextInt());

        System.out.println("Enter feet and inches for the second distance:");
        d2.setValues(scanner.nextInt(), scanner.nextInt());

        d1.displayValues();
        d2.displayValues();

        Distance sum = d1.add(d2);
        System.out.print("Sum of distances: ");
        sum.displayValues();

        Distance greater = d1.compare(d2);
        System.out.print("Greater distance: ");
        greater.displayValues();

        scanner.close();
    }
}
