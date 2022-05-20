package ui.cui;

import domain.EShopManager;
import valueobjects.Item;
import valueobjects.Person;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

class UI {
    private BufferedReader in;
    private Person user;
    private EShopManager manager = new EShopManager();

    public UI() throws IOException {
        in = new BufferedReader(new InputStreamReader(System.in));
    }

    private void showMenu() {
        System.out.print("Commands: \n  Login:  'l'");
        System.out.print("         \n  Register:  'r'");
        System.out.print("         \n  ---------------------");
        System.out.println("         \n  Exit:        'q'");
        System.out.print("> ");
        System.out.flush();
    }

    private void showClientMenu() {
        System.out.print("Commands: \n  Show items (a-z): 'i' ");
        //System.out.print("         \n Show items (item number) : 'n' ");
        System.out.print("         \n Select items: 's' ");
        System.out.print("         \n Change shopping cart: 'c' ");
        System.out.print("         \n Empty shopping cart: 'e' ");
        System.out.print("         \n Buy selected items: 'b' ");
        System.out.print("         \n  ---------------------");
        System.out.println("         \n  Exit:        'q'");
        System.out.print("> ");
        System.out.flush();
    }

    private void showEmployeeMenu() {
        System.out.print("Commands: \n  Show items (a-z): 'i' ");
        System.out.print("         \n Show items (item number) : 'n' ");
        System.out.print("         \n Add new item: 'a' "); //this is made a new product to sell
        System.out.print("         \n Increase stock: 'k' "); // to put more of the same products--thi set the variable int stock in Item --somehow throug the
        System.out.print("         \n Register new employee: 'y' ");
        System.out.print("         \n Show stock list: 'x' ");
        System.out.print("         \n  ---------------------");
        System.out.println("         \n  Exit:        'q'");
        System.out.print("> ");
        System.out.flush();
    }

    private String readInput() throws IOException {
        return in.readLine();
    }

    private void processInput(String line) throws IOException {
        String userName;
        String password;
        String address;
        List<Item> list;

        switch (line) {
            case "l":
                System.out.print("Username > ");
                userName = readInput();
                System.out.print("Password > ");
                password = readInput();
                if (manager.login(userName, password)) {
                    System.out.println("Login successful");
                    manager.selectMenu(userName);
                    if(manager.selectMenu(userName)){
                        showClientMenu();
                    } else {
                        showEmployeeMenu();
                    }
                } else {
                    System.out.println("Login failed");
                }
                break;
            case "r":
                System.out.print("Username > ");
                userName = readInput();
                System.out.print("Password > ");
                password = readInput();
                System.out.print("Address > ");
                address = readInput();
                manager.registerClient(userName, password, address);
                break;
            case "i":
               List<Item> items = manager.getItems();
               for(Item element: items){
                   System.out.println(element);
               }
            break;
            case "n":
            break;
            case "s":
            break;
            case "c":
            break;
            case "e":
            break;
            case "b":
            break;
            case "a":
            break;
            case "k"://Increase stock



            break;
            case "y":
                System.out.print("Username > ");
                userName = readInput();
                System.out.print("Password > ");
                password = readInput();
                manager.registerEmployee(userName, password);
                break;
         case "x":
        break;
    }

}

    public void run() {
        String input = "";

        do {
            showMenu();
            try {
                input = readInput();
                processInput(input);
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        } while (!input.equals("q"));
    }

    public static void main(String[] args) throws IOException {
        UI cui = new UI();
        cui.run();


        }

}


