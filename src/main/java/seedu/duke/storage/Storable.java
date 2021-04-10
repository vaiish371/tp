package seedu.duke.storage;

public interface Storable {

    /**
    * Interface method that mandates a class to be storable when implemented.
    * @return a String containing information about the attributes of an object to be stored in the database
    */
    String toStorage();

}
