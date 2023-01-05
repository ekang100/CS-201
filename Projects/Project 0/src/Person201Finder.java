import java.io.IOException;
import java.util.List;

public class Person201Finder {
    public static void main(String[] args) throws IOException {
        Person201 ellie = new Person201("Ellie", "WU", 1);
        Person201[] peopleData = Person201Utilities.readURL("https://courses.cs.duke.edu/compsci201/fall22/people.txt");

        System.out.println("People on the same floor: ");
        List<Person201> sameFloor = Person201Utilities.sameFloor(peopleData, ellie);
        Person201Utilities.printPeople(sameFloor);

        System.out.println("People in the same building: ");
        List<Person201> sameBuilding = Person201Utilities.sameBuilding(peopleData, ellie);
        Person201Utilities.printPeople(sameBuilding);

        
    }
    
}
