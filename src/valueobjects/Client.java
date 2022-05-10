package valueobjects;

public class Client extends Person{
    private Address address;

    public Client(String name, int idNumber, Address address){
        super(name, idNumber);
        this.address = address;
    }
    /*
    putItemsInCart();

    changeNumberItemsInCart();

    emptyCart();

    buy();
     /*
}
