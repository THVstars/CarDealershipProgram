package com.carolinasanchez;

import java.util.ArrayList;
import java.util.Scanner;

public class Dealership { // CLASS DECLARATION
    private String dealershipName;
    private ArrayList<Car> currentCarsAvailable;
    private ArrayList<Car> currentCarsBooked;
    Scanner scanner = new Scanner(System.in);

    public Dealership(String dealershipName) { // CONSTRUCTOR
        this.dealershipName = dealershipName;
        this.currentCarsAvailable = new ArrayList<>();
        this.currentCarsBooked = new ArrayList<>();
    }

    public String getDealershipName() {
        return dealershipName;
    } // GETTER

    public void setDealershipName(String dealershipName) {
        this.dealershipName = dealershipName;
    } // SETTER

    public ArrayList<Car> getCurrentCarsAvailable() {
        return currentCarsAvailable;
    }

    public void setCurrentCarsAvailable(ArrayList<Car> currentCarsAvailable) {
        this.currentCarsAvailable = currentCarsAvailable;
    }

    public ArrayList<Car> getCurrentCarsBooked() {
        return currentCarsBooked;
    }

    public void setCurrentCarsBooked(ArrayList<Car> currentCarsBooked) {
        this.currentCarsBooked = currentCarsBooked;
    }

    public void displayInventory() {
        for (int i = 0; i < currentCarsAvailable.size(); i++) {
            System.out.println(currentCarsAvailable.get(i).toString());
        }
    }

    public void bookACar() { // Parameter would be String because the make is a String, and they need to be compared.
        System.out.println("");
        String prompt = currentCarsAvailable.size() > 0 ? "Would you like to book a " : "Sorry, there are no cars available to book. Please enter 0 to return to the main menu."; // If we had a ton of different cars available or booked, these prompts would create exceptionally long sentences for the customers to have to read through. Simple solution: Please enter the make of the car you'd like to book:
        for (int i = 0; i < currentCarsAvailable.size(); i++) {
            if (currentCarsAvailable.size() - 1 == i && currentCarsAvailable.size() != 1) {
                prompt += "or " + currentCarsAvailable.get(i).getMake() + "? Please enter the make of the vehicle.";
            } else if (currentCarsAvailable.size() > 2) {
                prompt += currentCarsAvailable.get(i).getMake() + ", ";
            } else if (currentCarsAvailable.size() != 1) {
                prompt += currentCarsAvailable.get(i).getMake() + " ";
            } else {
                prompt += currentCarsAvailable.get(i).getMake() + "? Please enter the make of the vehicle.";
            }
        }
        System.out.println(prompt);
        String carName = scanner.nextLine();
        for (int i = 0; i < currentCarsAvailable.size(); i++) {
            if (currentCarsAvailable.get(i).getMake().equals(carName)) { // WOULD NOT WORK WITH ==, ONLY .EQUALS WOULD MOVE THE CAR FROM ONE ARRAY TO ANOTHER! == worked when the method had a parameter and that parameter was used to compare though. Best to use .equals when comparing strings in all cases, since sometimes == works, and sometimes it doesn't.
                currentCarsBooked.add(currentCarsAvailable.get(i));
                currentCarsAvailable.remove(i);
                System.out.println("");
                System.out.println("You've booked a " + currentCarsBooked.get(currentCarsBooked.size() - 1).getMake() + ". Thank you for patronizing " + dealershipName + "!");
                System.out.println("");
                System.out.println("Available Cars: " + currentCarsAvailable.toString());
                System.out.println("Booked Cars: " + currentCarsBooked.toString());
                break; // BREAK NEEDED HERE SO THAT IT DOESN'T KEEP SEARCHING OTHER INDEXES FOR THE CAR AFTER IT'S BEEN FOUND!
            } else if (i == currentCarsAvailable.size() - 1){ // THIS ELSE IF STATEMENT MUST BE INCLUDED INSTEAD OF JUST AN ELSE STATEMENT SO THAT THE STRING IS PRINTED OUT ONLY ONCE!
                System.out.println("");
                System.out.println("Sorry, that car isn't available for booking.");
            }
        }
    }

    public void returnACar() {
        System.out.println("");
        String prompt = currentCarsBooked.size() > 0 ? "Would you like to return a " : "Sorry, there are no cars to return. Please enter 0 to return to the main menu."; // Simple solution: Please enter the make of the car you'd like to return:
        for (int i = 0; i < currentCarsBooked.size(); i++) {
            if (currentCarsBooked.size() - 1 == i && currentCarsBooked.size() != 1) {
                prompt += "or " + currentCarsBooked.get(i).getMake() + "? Please enter the make of the vehicle.";
            } else if (currentCarsBooked.size() > 2) {
                prompt += currentCarsBooked.get(i).getMake() + ", ";
            } else if (currentCarsBooked.size() != 1) {
                prompt += currentCarsBooked.get(i).getMake() + " ";
            } else {
                prompt += currentCarsBooked.get(i).getMake() + "? Please enter the make of the vehicle.";
            }
        }
        System.out.println(prompt);
        String carReturn = scanner.nextLine();
        for (int i = 0; i < currentCarsBooked.size(); i++) {
            if (currentCarsBooked.get(i).getMake().equals(carReturn)) {
                currentCarsAvailable.add(currentCarsBooked.get(i));
                currentCarsBooked.remove(i);
                System.out.println("");
                System.out.println("You've returned a " + currentCarsAvailable.get(currentCarsAvailable.size() - 1).getMake() + ". Thank you for patronizing " + dealershipName + "!");
                System.out.println("");
                System.out.println("Available Cars: " + currentCarsAvailable.toString());
                System.out.println("Booked Cars: " + currentCarsBooked.toString());
                break;
            } else if (i == currentCarsBooked.size() - 1) {
                System.out.println("");
                System.out.println("Sorry, that car hasn't been booked.");
            }
        }
    }
}