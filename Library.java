/* This is a stub for the Library class */

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Set;

public class Library extends Building implements LibraryRequirements {
    
  private Hashtable<String, Boolean> collection;
  
  /**
  * Default constructor, no dingin room & no elevator, creates empty collection
  */
  public Library() {
    super("<Name Unknown>", "<Address Unknown>", 2);
    this.collection = new Hashtable<String, Boolean>();
    System.out.println("You have built a library: 📖");
  }

  /**
   * Overloaded constructor with address only, creates empty collection
   * @param address string, the address of the building
   */
  public Library(String address) {
      super(address); 
      this.nFloors = 2;
      this.collection = new Hashtable<String, Boolean>();
      System.out.println("You have built a library: 📖");
  }
  
  /** Overloaded constructor with name, address, creates empty collection
   * @param name string, the name of the building
   * @param address string, the address of the building
   */
  public Library(String name, String address) {
      super(name, address, 2);
      this.collection = new Hashtable<String, Boolean>();
      System.out.println("You have built a library: 📖");
    }

  /**
   * Full constructor, creates empty collection
   * @param name string, the name of the building
   * @param address string, the address of the building
   * @param nFloors int, the number of floors of the building
   */
  public Library(String name, String address, int nFloors) {
    super(name, address, nFloors);
    this.collection = new Hashtable<String, Boolean>();
    System.out.println("You have built a library: 📖");
  }

  /**
   * Add a book to collections, defaults as available for check out
   * @param title string, title of the book to be added to collection
   */
  public void addTitle(String title){
    boolean availablity = true;
    this.collection.put(title, availablity);
    System.out.println(this.collection);
  }

  /**
   * Remove a book from collections
   * @param title string, title of book to be removed from collections
   */
  public String removeTitle(String title){
    this.collection.remove(title);
    return title;
  }
    
  /**
   * Updates title to map to boolean false if book is available, otherwise prints a message that the book is already checked out.
   * @param title string, title of book to be checked out
   */
  public void checkOut(String title){
    boolean status = this.isAvailable(title);
    if(status == true){
      this.collection.replace(title, false);
    }
    if(status == false){
      System.out.println(title+" is already checked out.");
    }
  }

  /**
   * Updates title to map to boolean true if book is checked out, otherwise prints a message that the book is not checked out.
   * @param title string, title of book to be returned out
   */
  public void returnBook(String title){
    boolean status = this.isAvailable(title);
    if(status == false){
      this.collection.replace(title, true);
    }else{
      System.out.println(title+" is not checked out.");
    }
  } 

  /**
   * See if book is in collection or not
   * @param title string, title of book to evaluate if is in collection or not
   * @return boolean, true if book is in collectioni, false if not
   */
  public boolean containsTitle(String title){
    return this.collection.containsKey(title);
  }

  /**
   * See if book is available or not
   * @param title string, title of book to evaluate availability of
   * @return boolean, true if book is available for checkout, false if not
   */
  public boolean isAvailable(String title){
    if (this.containsTitle(title) == true){
      boolean status = this.collection.get(title);
      return status;
    }else{
      return false;
    }
  }

  /**
   * Prints all titles and if they are available or checked out.
   */
  public void printCollection(){
    // for key in keys
    Set<String> keys = this.collection.keySet();
      for(String key: keys){
      boolean value = collection.get(key);
      if(value == true){
        System.out.println(key+" is available.");
      }else{
        System.out.println(key+" is checked out.");
      }
    }
  }

  // Overriding Methods - Library has to have elevator

  /**
  * Prints availble methods for navigation within the building
  */
  public void showOptions() {
    System.out.println("Available options at " + this.name + ":\n + enter() \n + exit() \n + goUp() \n + goDown()\n + addTitle()\n + removeTitle()\n + checkOut()\n + returnBook()\n + containsTitle()\n + isAvailable()\n + printCollection()");
  }

  /**
  * Moves user to requested floor if there is an elevator, if not throws exceptin
  * @param floorNum floor for user to move to
  */
  public void goToFloor(int floorNum){
    super.goToFloor(floorNum);
  }


  public static void main(String[] args) {
    Library neilson = new Library("Neilson", "1 Neilson Drive", 5);
    neilson.showOptions();
    neilson.enter();
    neilson.goToFloor(3);

    Library king = new Library("King", "1 Paradise Drive", 5);
    king.showOptions();
    king.enter();
    king.goToFloor(3);
  }
}