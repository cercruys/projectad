package Application;

public class IngelogdePerson {

    private static Person persoon;

    public static Person getPerson() {
        return persoon;
    }

    public static void setPerson(Person persoon) {
        IngelogdePerson.persoon = persoon;
    }
}