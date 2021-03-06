package com.carolinasanchez;

import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) { // INSTANCES OF THE CAR CLASS
        Car Hyundai = new Car("Genesis", "GV80", 1000, 100);
        Car Buick = new Car("Lacrosse", "GV90", 700, 75);
        Car Lincoln = new Car("Continental", "GV100", 900, 95);

        Dealership dealership = new Dealership("Taehyung's Cars"); // INSTANCE OF THE DEALERSHIP CLASS

        dealership.getCurrentCarsAvailable().add(Hyundai);
        dealership.getCurrentCarsAvailable().add(Buick);
        dealership.getCurrentCarsAvailable().add(Lincoln); // .get to add to an empty arraylist .set to reassign existing arraylist

        // dealership.displayInventory();

        System.out.println("");
        System.out.println("Welcome to " + dealership.getDealershipName() + "!");
        System.out.println("");
        System.out.println("Would you like to: \n\n1. Book a car \n2. Return a car \n3. Exit the dealership? \n\nPlease enter a number.");
        int response = scanner.nextInt(); // USER INPUT

        while (response <= 0 || response > 3) {
            System.out.println("");
            System.out.println("Sorry, that is not an option. Please try again.");
            System.out.println("");
            System.out.println("Would you like to: \n\n1. Book a car \n2. Return a car \n3. Exit the dealership? \n\nPlease enter a number.");
            response = scanner.nextInt();
        }

        while (response == 1) { // HAS TO BE TWO NESTED WHILE LOOPS USING 1 AND 2 AND THEN 2 AND 1 AS THE VALUES FOR RESPONSE OR THE PROGRAM WON'T LET YOU SWITCH BACK AND FORTH BETWEEN RESPONSE = 1 AND RESPONSE = 2. ALSO HAS TO INCLUDE THE SECOND NESTED WHILE LOOP OR THE PROGRAM WON'T LET YOU START LOOPING WITH RESPONSE = 2.
            System.out.println("");
            System.out.println("These are the cars available for booking:");
            System.out.println("");
            dealership.displayInventory();
            dealership.bookACar();
            System.out.println("");
            System.out.println("Would you like to: \n\n1. Book a car \n2. Return a car \n3. Exit the dealership? \n\nPlease enter a number.");
            response = scanner.nextInt();

            while (response <= 0 || response > 3) {
                System.out.println("");
                System.out.println("Sorry, that is not an option. Please try again.");
                System.out.println("");
                System.out.println("Would you like to: \n\n1. Book a car \n2. Return a car \n3. Exit the dealership? \n\nPlease enter a number.");
                response = scanner.nextInt();
            }

            while (response == 2) {
                dealership.returnACar();
                System.out.println("");
                System.out.println("Would you like to: \n\n1. Book a car \n2. Return a car \n3. Exit the dealership? \n\nPlease enter a number.");
                response = scanner.nextInt();

                while (response <= 0 || response > 3) {
                    System.out.println("");
                    System.out.println("Sorry, that is not an option. Please try again.");
                    System.out.println("");
                    System.out.println("Would you like to: \n\n1. Book a car \n2. Return a car \n3. Exit the dealership? \n\nPlease enter a number.");
                    response = scanner.nextInt();
                }
            }
        }

        while (response == 2) {
            dealership.returnACar();
            System.out.println("");
            System.out.println("Would you like to: \n\n1. Book a car \n2. Return a car \n3. Exit the dealership? \n\nPlease enter a number.");
            response = scanner.nextInt();

            while (response <= 0 || response > 3) {
                System.out.println("");
                System.out.println("Sorry, that is not an option. Please try again.");
                System.out.println("");
                System.out.println("Would you like to: \n\n1. Book a car \n2. Return a car \n3. Exit the dealership? \n\nPlease enter a number.");
                response = scanner.nextInt();
            }

            while (response == 1) {
                System.out.println("");
                System.out.println("These are the cars available for booking:");
                System.out.println("");
                dealership.displayInventory();
                dealership.bookACar();
                System.out.println("");
                System.out.println("Would you like to: \n\n1. Book a car \n2. Return a car \n3. Exit the dealership? \n\nPlease enter a number.");
                response = scanner.nextInt();

                while (response <= 0 || response > 3) {
                    System.out.println("");
                    System.out.println("Sorry, that is not an option. Please try again.");
                    System.out.println("");
                    System.out.println("Would you like to: \n\n1. Book a car \n2. Return a car \n3. Exit the dealership? \n\nPlease enter a number.");
                    response = scanner.nextInt();
                }
            }
        }
    }
}
