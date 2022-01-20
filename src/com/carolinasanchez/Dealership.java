package com.carolinasanchez;

import java.util.ArrayList;
import java.util.Scanner;

public class Dealership {
    private String dealershipName;
    private ArrayList<Car> currentCarsAvailable;
    private ArrayList<Car> currentCarsBooked;
    Scanner scanner = new Scanner(System.in);

    public Dealership(String dealershipName) {
        this.dealershipName = dealershipName;
        this.currentCarsAvailable = new ArrayList<>();
        this.currentCarsBooked = new ArrayList<>();
    }

    public String getDealershipName() {
        return dealershipName;
    }

    public void setDealershipName(String dealershipName) {
        this.dealershipName = dealershipName;
    }

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
        System.out.println(" ");
        String prompt = "Would you like to book a ";
        for (int i = 0; i < currentCarsAvailable.size(); i++) {
            if (i == currentCarsAvailable.size() - 1) {
                prompt += "or " + currentCarsAvailable.get(i).getMake() + "?";
            } else {
                prompt += currentCarsAvailable.get(i).getMake() + ", ";
            }
        }
        System.out.println(prompt);
        String carName = scanner.nextLine();
        for (int i = 0; i < currentCarsAvailable.size(); i++){
            if (currentCarsAvailable.get(i).getMake().equals(carName)) { // WOULD NOT WORK WITH ==, ONLY .EQUALS WOULD MOVE THE CAR FROM ONE ARRAY TO ANOTHER! == worked when the method had a parameter and that parameter was used to compare though. Best to use .equals when comparing strings in all cases, since sometimes == works, and sometimes it doesn't.
                currentCarsBooked.add(currentCarsAvailable.get(i));
                currentCarsAvailable.remove(i);
            }
        }
        System.out.println(" ");
        System.out.println("Available Cars: " + currentCarsAvailable.toString());
        System.out.println("Booked Cars: " + currentCarsBooked.toString());
    }

    public void returnACar() {
        System.out.println(" ");
        String prompt = "Would you like to return a ";
        for (int i = 0; i < currentCarsBooked.size(); i++) {
            if (i == currentCarsBooked.size() - 1 && 1 != currentCarsBooked.size()) {
                prompt += "or " + currentCarsBooked.get(i).getMake() + "?";
            } else if (i != currentCarsBooked.size() - 1) {
                prompt += currentCarsBooked.get(i).getMake() + ", ";
            } else {
                prompt += currentCarsBooked.get(i).getMake() + "?";
            }
        }
        System.out.println(prompt);
        String carReturn = scanner.nextLine();
        for (int i = 0; i < currentCarsBooked.size(); i++){
            if (currentCarsBooked.get(i).getMake().equals(carReturn)) {
                currentCarsAvailable.add(currentCarsBooked.get(i));
                currentCarsBooked.remove(i);
            }
        }
        System.out.println(" ");
        System.out.println("Available Cars: " + currentCarsAvailable.toString());
        System.out.println("Booked Cars: " + currentCarsBooked.toString());
    }
}