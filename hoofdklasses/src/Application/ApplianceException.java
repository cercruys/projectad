package Application;

public class ApplianceException extends Exception{
    public ApplianceException(String message) {
        super(message);
        System.out.println(message);
    }
}
