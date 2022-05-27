package valueobjects;

public class  Employee extends Person {
    private boolean client;
    public Employee(String name, String password) {
        super(name, password);
        client = false;
    }
    public boolean getBoolean(){
        return client;
    }
}

