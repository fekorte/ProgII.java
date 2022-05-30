package valueobjects;

public abstract class Person {
    protected String name;
    protected String password;
    protected int idNumber;
    public static int count = 1; //why do we have this parameter?? to get a new id for each person that is created, never the same number

    public Person(String name, String password) {
        this.name = name;
        this.password = password;
        this.idNumber = count++;
    }
    public String getName(){
        return name;
    }
    public String getPassword(){ return password;}
    public int getIdNumber(){
        return idNumber;
    }

    public abstract boolean getBoolean();

    public abstract String toString();
}