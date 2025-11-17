import java.util.ArrayList;
// import java.util.Scanner;

public class CampusMap {

    ArrayList<Building> buildings;

    /* Default constructor, initializes empty ArrayList */
    public CampusMap() {
        buildings = new ArrayList<Building>();
    }

    /**
     * Adds a Building to the map
     * @param b the Building to add
     */
    public void addBuilding(Building b) {
        System.out.println("Adding building...");
        buildings.add(b);
        System.out.println("-->Successfully added " + b.getName() + " to the map.");
    }

    /**
     * Removes a Building from the map
     * @param b the Building to remove
     * @return the removed Building
     */
    public Building removeBuilding(Building b) {
        System.out.println("Removing building...");
        buildings.remove(b);
        System.out.println("-->Successfully removed " + b.getName() + " to the map.");
        return b;
    }

    public String toString() {
        String mapString = "DIRECTORY of BUILDINGS";

        for (int i = 0; i < this.buildings.size(); i ++) {
            mapString += "\n  " + (i+1) + ". "+ this.buildings.get(i).getName() + " (" + this.buildings.get(i).getAddress() + ")";
        }
        return mapString;
    }

    public static void main(String[] args) {
        CampusMap myMap = new CampusMap();
        myMap.addBuilding(new Building("Ford Hall", "100 Green Street Northampton, MA 01063", 4));
        myMap.addBuilding(new Building("Bass Hall", "4 Tyler Court Northampton, MA 01063", 4));
        myMap.addBuilding(new House("Wilson", "1 Paradise Road", 5, false, false));
        myMap.addBuilding(new House("King", "King Circle", 5, true, true));
        myMap.addBuilding(new House("Scales", "Scales Circle", 4, true, true));
        myMap.addBuilding(new House("Emerson", "The Arch", 5, false, false));
        myMap.addBuilding(new House("Tyler", "GeoThermal Pit", 3, true, false));
        myMap.addBuilding(new Library("Neilson", "1 Neilson Drive", 5));
        myMap.addBuilding(new Library("Hillyer", "Elm Street", 6));
        myMap.addBuilding(new Library("Mendenhall", "122 Green Street", 3));
        myMap.addBuilding(new Cafe("Campus Center", "1 Chapin Circle"));
        myMap.addBuilding(new Cafe("Compass Cafe", "1 Neilson Drive"));

        System.out.println(myMap);

        // while(true){
        //     Scanner input = new Scanner(System.in);  // Create a Scanner object
        //     System.out.println("Which building would you like to enter?");
        //     String userBuilding = input.nextLine();
        //     // see if building exist
        //     boolean found = false;
        //     for(int i = 1; i < myMap.buildings.size(); i++){
        //         Building building = myMap.buildings.get(i);
        //         System.out.println(building);
        //         String name = building.getName();
        //         System.out.println(name);
        //         if (name.equals(userBuilding)){
        //             building.enter();
        //             found = true;
        //             while(found == true){
        //                 building.showOptions();
        //                 System.out.println("What would you like to do?");
        //                 String task = input.nextLine();
        //             }
        //         }
        //     }
        //     if(found == false){
        //         System.out.println("This builing does not exist");
        //     }
        // }   
    }
}
