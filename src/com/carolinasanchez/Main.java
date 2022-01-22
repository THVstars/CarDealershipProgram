package com.carolinasanchez;

import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Car Hyundai = new Car("Genesis", "GV80", 1000, 100);
        Car Buick = new Car("Lacrosse", "GV90", 700, 75);
        Car Lincoln = new Car("Continental", "GV100", 900, 95);

        Dealership dealership = new Dealership("Taehyung's Cars");

        dealership.getCurrentCarsAvailable().add(Hyundai);
        dealership.getCurrentCarsAvailable().add(Buick);
        dealership.getCurrentCarsAvailable().add(Lincoln); // .get to add to an empty arraylist .set to reassign existing arraylist

        dealership.displayInventory();

        System.out.println(" ");
        System.out.println("Would you like to: \n1. Book a car \n2. Return a car \n3. Exit the dealership? \nPlease enter a number.");
        System.out.println(" ");
        int response = scanner.nextInt();

        while (response == 1) {
            dealership.bookACar();
            System.out.println(" ");
            System.out.println("Would you like to: \n1. Book a car \n2. Return a car \n3. Exit the dealership? \nPlease enter a number.");
            System.out.println(" ");
            response = scanner.nextInt();
        } while (response == 2) {
            dealership.returnACar();
            System.out.println(" ");
            System.out.println("Would you like to: \n1. Book a car \n2. Return a car \n3. Exit the dealership? \nPlease enter a number.");
            System.out.println(" ");
            response = scanner.nextInt();
        }
    }
}
