package valueobjects;

public class Client extends Person {
    private String address;
    private boolean client;

    public Client(String name, String password, String address) {
        super(name,password);
        this.address=address;
        client = true;

    }

    public boolean getBoolean(){
        return client;
    }
    public String getAddress(){return address; }
}