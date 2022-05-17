package valueobjects;

public class Person {
    protected String name;
    protected int idNumber;
    public static int count = 1;

    public Person(String name) {
        this.name = name;
        this.idNumber = count++;
    }
}
    /*
    registerAsClient();

    logIn();
    */
