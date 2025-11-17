/* This is a stub for the Cafe class */

import java.util.ArrayList;

public class Cafe extends Building implements CafeRequirements {
    private int nCoffeeOunces;
    private int nSugarPackets;
    private int nCreams;
    private int nCups;

    /**
     * Default constructor 
     */
    public Cafe() {
        super("<Name Unknown>", "<Address Unknown>", 1);
        this.nCoffeeOunces = 20000;
        this.nSugarPackets = 1500;
        this.nCreams = 1500;
        this.nCups = 2000;
        System.out.println("You have built a cafe: ☕");
    }

    /**
     * Overloaded constructor with address only 
     * @param address string, the address of the building
     */
    public Cafe(String address) {
        super(address); 
        this.nCoffeeOunces = 20000;
        this.nSugarPackets = 1500;
        this.nCreams = 1500;
        this.nCups = 2000;
        System.out.println("You have built a cafe: ☕");
    }
    
    /** Overloaded constructor with name, address 
     * @param name string, the name of the building
     * @param address string, the address of the building
     */
    public Cafe(String name, String address) {
        super(name, address, 1); // Call full constructor with 1 floor
        this.nCoffeeOunces = 20000;
        this.nSugarPackets = 1500;
        this.nCreams = 1500;
        this.nCups = 2000;
        System.out.println("You have built a cafe: ☕");
    }

    /**
     * Full constructor
     * @param name string, the name of the building
     * @param address string, the address of the building
     */
    public Cafe(String name, String address, int nFloors) {
        super(name, address, nFloors);
        this.nCoffeeOunces = 20000;
        this.nSugarPackets = 1500;
        this.nCreams = 1500;
        this.nCups = 2000;
        System.out.println("You have built a cafe: ☕");
    }

    /**
     * turns order into an ArrayList of Integers
     * @param size int, number of ounces of coffee in order
     * @param nSugarPackets, int number of sugar packets in order
     * @param nCreams int, number of creams in order
     */
    private ArrayList<Integer> getOrder(int size, int nSugarPackets, int nCreams){
        ArrayList<Integer> order = new ArrayList<Integer>();
        order.add(size);
        order.add(nSugarPackets);
        order.add(nCreams);
        int cups = 1;
        order.add(cups);
        return order;
    }

    /**
     * turns stocked items into an ArrayList of Integers
     * @param size int, number of ounces of coffee in inventory
     * @param nSugarPackets, int number of sugar packets in inventory
     * @param nCreams int, number of creams in inventory
     */
    private ArrayList<Integer> getInventory(){
        ArrayList<Integer> inventory = new ArrayList<Integer>();
        inventory.add(this.nCoffeeOunces);
        inventory.add(this.nSugarPackets);
        inventory.add(this.nCreams);
        inventory.add(this.nCups);
        return inventory;
    }
    
    /**
     * Decreases inventory by amount specified for each paramter and by one cup. If there is not enough left in stock to complete order, stock will be replinished.
     * @param size int, number of ounces of coffee in order
     * @param nSugarPackets, int number of sugar packets in order
     * @param nCreams int, number of creams in order
     */
    public void sellCoffee(int size, int nSugarPackets, int nCreams){
        ArrayList<Integer> order = getOrder(size, nSugarPackets, nCreams);
        ArrayList<Integer> inventory = getInventory();
        for(int i = 0; i < inventory.size(); i++){
            int stock = inventory.get(i);
            int request = order.get(i);
            System.out.println(stock+" in relation to "+request);
            if (stock - request < 0){
                this.restock(20000, 1500, 1500, 2000);
            }
        }
        this.nCoffeeOunces = this.nCoffeeOunces - size;
        this.nSugarPackets = this.nSugarPackets - nSugarPackets;
        this.nCreams = this.nCreams - nCreams;
        this.nCups = this.nCups - 1;
    }

    /**
     * Return stock to the values given as paramters 
     * @param nCoffeeOunces int, number of coffee ounes to be in stock
     * @param nSugarPackets int, number of sugar packets to have in stock
     * @param nCreams int, number of creams to have in stock
     * @param nCups int, number of cups to have in stock
     */
    private void restock(int nCoffeeOunces, int nSugarPackets, int nCreams, int nCups){
        this.nCoffeeOunces = nCoffeeOunces;
        this.nSugarPackets = nSugarPackets;
        this.nCreams = nCreams;
        this.nCups = nCups;
    }

    // Overriding Navigation Methods

    /**
     * Prints availble methods for navigation within the building by overriding parent class since there is no elevator or more than one floor in cafe
     */
    public void showOptions(){
        System.out.println("Available options at " + this.name + ":\n + enter() \n + exit() \n + sellCoffee()");     
    }

    /**
     * Overrides parent method to throw exception since there is no elevator in CC
     * @param floor the floor requested to go to
     */
    public void goToFloor(int floor){
        throw new RuntimeException("There is only one floor in the cafe.");
    }

    public static void main(String[] args) {
        Cafe compass = new Cafe("Compass Cafe", "1 Chapin Way", 3);
        compass.showOptions();
        //  compass.goToFloor(2);
    }
    
}
