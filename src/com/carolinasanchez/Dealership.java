package com.carolinasanchez;

import java.util.ArrayList;

public class Dealership {
    public String dealershipName;
    public ArrayList<Car> currentCarsAvailable;
    public ArrayList<Car> currentCarsBooked;

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

    public void bookACar(String carName) { // String because the make is a String.
        for (int i = 0; i < this.getCurrentCarsAvailable().size(); i++){
            if (getCurrentCarsAvailable().get(i).getMake() == carName) {
                getCurrentCarsBooked().add(getCurrentCarsAvailable().get(i));
                getCurrentCarsAvailable().remove(i);
            }
        }
        System.out.println(" ");
        System.out.println("Available Cars: " + currentCarsAvailable.toString());
        System.out.println("Booked Cars: " + currentCarsBooked.toString());
    }
}