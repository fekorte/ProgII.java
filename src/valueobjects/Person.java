package valueobjects;

public class Person {
    protected String name;
    protected int idNumber;
    public static int count = 1; //why do we have this parameter??

    public Person(String name) {
        this.name = name;
        this.idNumber = count++;
    }
    public String getName(){
        return name;
    }
    public int getIdNumber(){
        return idNumber;
    }
}