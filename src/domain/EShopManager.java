package domain;



import valueobjects.Client;
import valueobjects.Employee;

import java.util.HashMap;
import java.util.Map;


public class EShopManager {
    private Map<String, String> personList = new HashMap<>();
    private Map<String, Client> clientList = new HashMap<>();

    private Map<String, Employee> employeeList = new HashMap<>();

    public boolean login(String userName, String password) {
        if (personList.containsKey(password) && personList.containsValue(userName)) {
            return true;
        } else {
            return false;
        }
    }

    public void registerClient(String userName, String password, String address) {
        Client client = new Client(userName, address);
        personList.putIfAbsent(password, userName);
        clientList.putIfAbsent(userName, client);
    }

    public void registerEmployee(String userName, String password) {
        Employee employee = new Employee(userName);
        personList.putIfAbsent(password, userName);
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