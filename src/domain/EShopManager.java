package domain;



import valueobjects.Client;
import valueobjects.Employee;
import valueobjects.Item;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class EShopManager {
    private Map<String, String> personMap = new HashMap<>();//maps are better for people-- for maps we need a key and a value
    private Map<String, Client> clientList = new HashMap<>();

    private Map<String, Employee> employeeList = new HashMap<>();

    private Stock stock = new Stock();

    public List<Item> getItems(){
        return stock.getStock();
    }


    public EShopManager(){
        registerClient("Peter", "234","pappel");
        registerEmployee("Hans", "abc");
        registerClient("Natha", "123", "ZMT" );
        registerEmployee("Felina", "123");
    }


    public boolean login(String userName, String password) {
        if (personMap.containsKey(password) && personMap.containsValue(userName)) {
            return true;
        } else {
            return false;
        }
    }

    public void registerClient(String userName, String password, String address) {
        Client client = new Client(userName, address);
        personMap.putIfAbsent(password, userName);
        clientList.putIfAbsent(userName, client);
    }

    public void registerEmployee(String userName, String password) {
        Employee employee = new Employee(userName);
        personMap.putIfAbsent(password, userName);//if the person is there it wont works
        employeeList.putIfAbsent(userName, employee);
    }

    public boolean selectMenu(String userName) {
        if (clientList.containsKey(userName)) {
            return true;
        } else {
            return false;
        }
    }
}