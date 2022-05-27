package ui.cui;

import domain.EShopManager;
import domain.ShopCart;
import valueobjects.Item;
import valueobjects.Person;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class UI {
    private BufferedReader in;
    private Person user;
    boolean loggedIn;
    boolean itsAClient;
    private EShopManager manager = new EShopManager();
    private ShopCart cart = new ShopCart();

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
        System.out.print("Commands:\n ---------------------");
        System.out.print("         \n Show items (a-z): 'i' ");
        System.out.print("         \n Show items (item number) : 'n' ");
        System.out.print("         \n Show cart content: 'm' ");
        System.out.print("         \n Select items: 's' ");
        System.out.print("         \n Remove items: 'v' ");
        System.out.print("         \n Empty shopping cart: 'e' ");
        System.out.print("         \n Buy selected items: 'b' ");
        System.out.print("         \n ---------------------");
        System.out.println("         \n  Exit:        'q'");
        System.out.print("> ");
        System.out.flush();
    }

    private void showEmployeeMenu() {
        System.out.print("Commands:\n ---------------------");
        System.out.print("         \n Show items (a-z item name): 'i' ");
        System.out.print("         \n Show items (item code) : 'n' ");
        System.out.print("         \n Add new item: 'a' "); //this is made a new product to sell
        System.out.print("         \n Increase stock: 'k' "); // to put more of the same products--thi set the variable int stock in Item --somehow throug the
        System.out.print("         \n Register new employee: 'y' "); //working
        System.out.print("         \n Show Stock logBook: 'x' "); //Logbook--> all the movements done in stock-->creates a txt file
        System.out.print("         \n ---------------------");
        System.out.println("       \n  Exit:        'q'");
        System.out.print("> ");
        System.out.flush();
    }

    private String readInput() throws IOException {
        return in.readLine();
    }

    private void processInput (String line) throws IOException {
        String userName;
        String password;
        String address;
        List<Item> list;
        String item;
        int quantity;

        switch (line) {
            case "l":
                System.out.print("Username > ");
                userName = readInput();
                System.out.print("Password > ");
                password = readInput();
                if (manager.login(userName, password)) {
                    System.out.println("Login successful");
                    loggedIn = true;
                    if (manager.selectMenu(userName)) {
                        itsAClient = true;
                    } else {
                        itsAClient = false;
                    }
                } else {
                    System.out.println("Login failed");
                    loggedIn = false;
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
            case "i": {
                List<Item> itemsI = manager.getItems();
                System.out.println(itemsI.get(0).getItemName());

                Collections.sort(itemsI, Comparator.comparing(Item::getItemName, String.CASE_INSENSITIVE_ORDER));
                for (Item element : itemsI) {
                    System.out.println(element);
                }
            }
            break;
            case "m":
                System.out.println(cart.getItemsInCart());
                break;
            case "n": //Show items (item number) : 'n' "
            {
                List<Item> items = manager.getItems();
                Collections.sort(items, Comparator.comparingInt(Item::getItemCode));
                for (Item element : items) {
                    System.out.println(element);
                }
            }
            break;

            case "s":
                System.out.print("Item name > ");
                item = readInput();
                System.out.print("Quantity >");
                quantity = Integer.parseInt(readInput());
                List<Item> itemsS = manager.getItems();
                for (Item element : itemsS) { //iterates through list and checks if item is in stock
                    if (element.getItemName().equals(item)) {
                        Item copyItem = element; //copy of item, to change quantity in cart but not in stock
                        if (element.getNumberInStock() >= quantity) { //checks if user didnt select more items than available in stock
                            copyItem.setNumberInStock(1);
                            while(quantity != 0){
                                cart.putItemsInCart(copyItem);
                                quantity--;
                            }
                            System.out.println("Added to cart.");
                            break;
                        } else {
                            System.out.println("Too many items selected.");
                        }
                    } else {
                        System.out.println("Selected item not available.");
                    }
                }
                break;
            case "v":
                System.out.print("Item name > ");
                item = readInput();
                System.out.print("Quantity >");
                quantity = Integer.parseInt(readInput());
                List<Item> itemsV = cart.getItemsInCart();
                for(Item element : itemsV){
                    if(element.getItemName().equals(item)){
                        Item copyItem = element;
                        copyItem.setNumberInStock(1);
                            while(quantity != 0) {
                                cart.removeItemsFromCart(copyItem); //removes items from cart
                                quantity--;
                            System.out.println("Removed from cart.");
                            break;
                        }
                    } else {
                        System.out.println("Item not available. Please select a different item.");
                    }
                }
                break;

            case "e":
                cart.emptyCart();
                System.out.print("Cart has been emptied.");
                break;
            case "b":
                break;
            case "a":
                break;
            case "k"://Increase stock
            {
                List<Item> items=manager.getItems();
                //imput the ItemName
                //select the "object"--> a method which select the object from the array
                //imput --> the user will put an int, which will be the variable "int stockIncrease"
                //call the method addItemInStock
                //then System.out.println (the object to show the user that the item number was changed )


            }

            break;
            case "y":
                System.out.print ("Username > ");
                userName = readInput ();
                System.out.print ("Password > ");
                password = readInput ();
                manager.registerEmployee (userName, password);
                break;
            case "x":
                break;
            default:
                break;
        }

    }

    public void run() {
        String input = "";
        do {
            if(loggedIn){
                if(itsAClient){
                    showClientMenu();
                } else {
                    showEmployeeMenu();
                }
            } else {
                showMenu();
            }
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