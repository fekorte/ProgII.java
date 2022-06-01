package domain;



import valueobjects.Client;
import valueobjects.Employee;
import valueobjects.Item;
import valueobjects.Person;

import java.util.ArrayList;
import java.util.List;


public class EShopManager {
    List<Person> users = new ArrayList<>();
    List<Person> loggedInUsers;//this is to implement in the future but not now
    private Stock stock = new Stock();


    public List<Item> getItems(){
        return stock.getStock();
    }


    public EShopManager(){
        registerClient("Peter", "234","pappel");
        registerEmployee("Hans", "abc");
        registerClient("Natha", "123", "ZMT" );
        registerEmployee("Felina", "123");
        registerClient("Sedefnur", "0426", "gröp");
    }

    public Person login(String userName, String password) {
        for (Person user : users) {
            if (user.getName().equals(userName) && user.getPassword().equals(password)) {
                return user;
            }
        }
        return null;
    }

    public void registerClient(String userName, String password, String address) {
        Client client = new Client(userName,password, address);
        users.add(client);
    }

    public void registerEmployee(String userName, String password) {
        Employee employee = new Employee(userName,password);
        users.add(employee);
    }

    public boolean selectMenu(Person user) {
        if (user.getBoolean()) {
            return true;
        } else {
            return false;
        }
    }
}