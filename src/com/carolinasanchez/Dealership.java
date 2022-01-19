package com.carolinasanchez;

import java.util.ArrayList;
import java.util.Scanner;

public class Dealership {
    public String dealershipName;
    public ArrayList<Car> currentCarsAvailable;
    public ArrayList<Car> currentCarsBooked;
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

    public void bookACar() { // String because the make is a String.
        System.out.println(" ");
        System.out.println("Would you like to book a Genesis, Lacrosse or Continental?");
        String carName = scanner.nextLine();
        for (int i = 0; i < this.getCurrentCarsAvailable().size(); i++){
            if (getCurrentCarsAvailable().get(i).getMake().equals(carName)) { // WOULD NOT WORK WITH ==, ONLY .EQUALS WOULD MOVE THE CAR FROM ONE ARRAY TO ANOTHER! == worked when the method had a parameter and that parameter was used to compare though. Best to use .equals when comparing strings in all cases, since sometimes == works, and sometimes it doesn't.
                getCurrentCarsBooked().add(getCurrentCarsAvailable().get(i));
                getCurrentCarsAvailable().remove(i);
            }
        }
        System.out.println(" ");
        System.out.println("Available Cars: " + currentCarsAvailable.toString());
        System.out.println("Booked Cars: " + currentCarsBooked.toString());
    }

    public void returnACar() { // String because the make is a String.
        System.out.println(" ");
        System.out.println("Would you like to return a Genesis, Lacrosse or Continental?");
        String carReturn = scanner.nextLine();
        for (int i = 0; i < this.getCurrentCarsBooked().size(); i++){
            if (getCurrentCarsBooked().get(i).getMake().equals(carReturn)) {
                getCurrentCarsAvailable().add(getCurrentCarsBooked().get(i));
                getCurrentCarsBooked().remove(i);
            }
        }
        System.out.println(" ");
        System.out.println("Available Cars: " + currentCarsAvailable.toString());
        System.out.println("Booked Cars: " + currentCarsBooked.toString());
    }
}