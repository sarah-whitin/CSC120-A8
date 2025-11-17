/* This is a stub for the House class */

import java.util.ArrayList;

public class House extends Building implements HouseRequirements{
  private ArrayList<Student> residents;
  private boolean hasDiningRoom;
  private boolean hasElevator;

  /**
   * Default constructor, no dingin room & no elevator
   */
  public House() {
    super("<Name Unknown>", "<Address Unknown>", 1);
    this.residents = new ArrayList<Student>();
    this.hasDiningRoom = false;
    this.hasElevator = false;
    System.out.println("You have built a house: 🏠");
  }

  /**
   * Overloaded constructor with address only 
   * @param address string, the address of the building
   */
  public House(String address) {
      super(address); 
      this.hasDiningRoom = false;
      this.hasElevator = false;
      System.out.println("You have built a house: 🏠");
  }
  
  /** Overloaded constructor with name, address 
   * @param name string, the name of the building
   * @param address string, the address of the building
   */
  public House(String name, String address) {
      super(name, address, 1); // Call full constructor with 1 floor
      this.hasDiningRoom = false;
      this.hasElevator = false;
      System.out.println("You have built a house: 🏠");
    }

  /**
   * Overloaded constructor with name, address, nFloors
   * @param name string, the name of the building
   * @param address string, the address of the building
   * @param nFloors int, the number of floors of the building
   */
  public House(String name, String address, int nFloors) {
      super(name, address, nFloors);
      this.hasDiningRoom = false;
      this.hasElevator = false;
      System.out.println("You have built a house: 🏠");
  }

  /**
   * Overloaded constructor with name, address, nFloors, hasDiningRoom
   * @param name string, the name of the building
   * @param address string, the address of the building
   * @param nFloors int, the number of floors of the building
   * @param d boolean, if the house has a dining room or not
   */
  public House(String name, String address, int nFloors, boolean d) {
    super(name, address, nFloors);
    this.hasDiningRoom = d;
    this.hasElevator = false;
    System.out.println("You have built a house: 🏠");
}

  
  /**
   * Full Constructor
   * @param name string, the name of the building
   * @param address string, the address of the building
   * @param nFloors int, the number of floors of the building
   * @param d boolean, if the house has a dining room or not
   * @param e boolean, if the house has an elevator or not
   */
  public House(String name, String address, int nFloors, boolean d, boolean e) {
    super(name, address, nFloors);
    this.residents = new ArrayList<Student>();
    this.hasDiningRoom = d;
    this.hasElevator = e;
    System.out.println("You have built a house: 🏠");
  }
  
  /**
   * Find if house has dining room
   * @return boolean, if the house has a dining room or not
   */
  public boolean hasDiningRoom(){
    return this.hasDiningRoom;
  }
  
  /**
   * Get the number of residents in the house
   * @return number of residents 
   */
  public int nResidents(){
    return this.residents.size();
  }
  
  /**
   * Move in a student, or add them to the ArrayList of students
   * @param s the student moving in
   */
  public void moveIn(Student s){
    this.residents.add(s);
  }
  
  /**
   * Move out a student, or remove them from the ArrayList of students
   * @param s the student moving out
   * @return the student moving out
   */
  public Student moveOut(Student s){
    this.residents.remove(s);
    return s;
  }
  
  /**
   * see if student lives in house
   * @param s student to find resident status of
   * @return if student is a resident
   */
  public boolean isResident(Student s){
    boolean livesHere = this.residents.contains(s);
    return livesHere;
  }

  // Overriding Navigation Methods

  /**
  * Prints availble methods for navigation within the building
  */
  public void showOptions() {
    if (this.hasElevator == true){
      System.out.println("Available options at " + this.name + ":\n + enter() \n + exit() \n + goUp() \n + goDown()\n + goToFloor(n)\n + hasDiningRoom()\n + nResidents()\n + moveIn()\n + moveOut()\n + isResident()");
    }else{
      System.out.println("Available options at " + this.name + ":\n + enter() \n + exit() \n + hasDiningRoom()\n + nResidents()\n + moveIn()\n + moveOut()\n + isResident()");
    }
  }

  /**
   * Moves user to requested floor if there is an elevator, if not throws exceptin
   * @param floorNum floor for user to move to
   */
  public void goToFloor(int floorNum){
    if(this.hasElevator == true){
      super.goToFloor(floorNum);;
    }else{
      throw new RuntimeException("There is no elevator.");
    }
  }

  public static void main(String[] args) {
    House wilson = new House("Wilson", "1 Paradise", 5, true, false);
    System.out.println(wilson.hasDiningRoom());
    Student anna = new Student("anna", null, 2026);
    Student sox = new Student("sox", null, 2027);
    wilson.moveIn(anna);
    wilson.moveIn(sox);
    System.out.println(wilson.nResidents());
    System.out.println(wilson.isResident(sox));
    System.out.println(wilson.isResident(anna));
    wilson.moveOut(sox);
    System.out.println(wilson.isResident(sox));
    System.out.println(wilson.nResidents());
    wilson.showOptions();
  }

}