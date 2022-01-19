package com.carolinasanchez;

public class Main {

    public static void main(String[] args) {
        Car Hyundai = new Car("Genesis", "GV80", 1000, 100);
        Car Buick = new Car("Lacrosse", "GV90", 700, 75);
        Car Lincoln = new Car("Continental", "GV100", 900, 95);

        Dealership dealership = new Dealership("Taehyung's Cars");

        dealership.getCurrentCarsAvailable().add(Hyundai);
        dealership.getCurrentCarsAvailable().add(Buick);
        dealership.getCurrentCarsAvailable().add(Lincoln); // .get to add to an empty arraylist .set to reassign existing arraylist

        dealership.displayInventory();

        dealership.bookACar();

        dealership.returnACar();
    }
}
