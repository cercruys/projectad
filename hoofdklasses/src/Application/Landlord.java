package Application;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

public class Landlord extends Person{
    private HashMap<Integer, Student> students;
    private ArrayList<Location> locations;

    public Landlord(Person person) {
        super(person);
        students= new HashMap<>();
        locations = new ArrayList<>();
    }

    public HashMap<Integer, Student> getStudents() {
        return students;
    }

    public ArrayList<Location> getLocations() {
        return locations;
    }
    private void studentExists(Student student) throws LandLordException {
        if (student == null) {
            throw new LandLordException("This student does not exist!");
        }
    }

    public void addStudent(int roomID, Student student) throws LandLordException {
        studentExists(student);
        if(!students.containsValue(student)) {
            students.put(roomID, student);
        }
        else
            throw new LandLordException("This student is already in the list!");
    }

    public void removeStudent(Student student) throws LandLordException, SQLException {
        studentExists(student);
        if(students.containsValue(student))
            students.remove(student.getRoomID(),student);
        else
            throw new LandLordException("List does not contain student!");
    }
    public void locationExists(Location location) throws LandLordException {
        if(location==null)
            throw new LandLordException("This location does not exist!");
    }

    public void addLocation(Location location) throws LandLordException {
        locationExists(location);
        if(!locations.contains(location))
            locations.add(location);
        else
            throw new LandLordException("Location is already in the list!");
    }

    public void removeLocation(Location location) throws LandLordException {
        locationExists(location);
        if(locations.contains(location))
            locations.remove(location);
        else
            throw new LandLordException("List does not contain location!");
    }
}