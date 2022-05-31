package ui.cui;

import domain.EShopManager;
import domain.ShopCart;
import valueobjects.Item;
import valueobjects.Person;
import valueobjects.Receipt;

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
    List<String> stockChanges = new ArrayList<>();

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
        System.out.println("         \n  Exit:        'w'");
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
        System.out.print("         \n Show stock logbook: 'x' "); //Logbook--> all the movements done in stock-->creates a txt file
        System.out.print("         \n ---------------------");
        System.out.println("       \n  Exit:        'w'");
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
        String item;
        int quantity;
        boolean inCart = false;

        switch (line) {
            case "a":{ //Add new item
                List<Item> items=manager.getItems();
                //input the ItemName
                //input the Variable
                System.out.print("Item Name > ");
                String itemName=readInput();
                System.out.print("Price > ");
                float price=Float.parseFloat(readInput());
                System.out.print("Item code > ");
                int itemCode=Integer.parseInt(readInput());
                System.out.print("Number of items > ");
                int numberInStock=Integer.parseInt(readInput());
                //create de Item object
                Item itemNew=new Item(itemName, price, itemCode, numberInStock);
                //add new item in the list
                items.add(itemNew);
                //Organizing and printing the new list
                Collections.sort(items, Comparator.comparing(Item::getItemName, String.CASE_INSENSITIVE_ORDER));
                for(Item element: items){
                    System.out.println(element);
                }
                String stockNumber = String.valueOf(itemNew.getNumberInStock());//from here on it is for the point 'x' in menu to make the logbook entry
                String employee = user.toString();
                stockChanges.add("\n" + "New item added" + "\n" + "Added item: " + itemName + "\n" + "Quantity: " + stockNumber + "\n" + "Name of employee: " + employee + "\n");
            }
            break;
            case "b": //Buy selected items
                List<Item> itemsB = manager.getItems();//all the item in stock
                List<Item> itemsC = cart.getItemsInCart();//items in the cart
                for(Item element : itemsB){
                    for(Item toBuy : itemsC){
                        if(element.getItemName().equals(toBuy.getItemName())){ //checks if two items in stock and cart match
                            int num = toBuy.getNumberInStock();
                            element.removeItem(num); //items that are bought are getting removed from stock
                            String itemName = element.getItemName(); //from here on it is for the point 'x' in menu to make the logbook entry
                            String stockNumber = String.valueOf(num);
                            String client = user.toString();
                            stockChanges.add("\n" + "Items bought" + "\n" + "Bought item: " + itemName + "\n" + "Quantity: " + stockNumber + "\n" + "Name of client: " + client + "\n"); //write information about changes in List
                        }
                    }
                }
                Receipt receipt = cart.buy(user, cart);
                System.out.println(receipt);
                cart.emptyCart();
                break;
            case "e":
                cart.emptyCart();
                System.out.print("Cart has been emptied.");
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
            case "k"://Increase stock
            {
                System.out.print("Item name > ");
                String itemName = readInput();
                System.out.print("Quantity > ");
                quantity = Integer.parseInt(readInput());
                List<Item> itemsK=manager.getItems();
                for(Item element : itemsK){
                    if (element.getItemName().equals(itemName)){
                        element.addItemInStock(quantity);
                        String addedToStock = String.valueOf(quantity); //from here on it is for the point 'x' in menu to make the logbook entry
                        String stockNumber = String.valueOf(element.getNumberInStock());
                        String employee = user.toString();
                        stockChanges.add("\n" + "Stock increased" + "\n" + "Item: " + itemName + "\n" + "Quantity added: " + addedToStock + "\n" + "Total quantity: " + stockNumber + "\n" + "Name of employee: " + employee + "\n");
                    }
                }

            }
            break;
            case "l":
                System.out.print("Username > ");
                userName = readInput();
                System.out.print("Password > ");
                password = readInput();
                user = manager.login(userName, password);
                if (user != null) {
                    System.out.println("Login successful");
                    loggedIn = true;
                    if (manager.selectMenu(user)) {
                        itsAClient = true;
                    } else {
                        itsAClient = false;
                    }
                } else {
                    System.out.println("Login failed");
                    loggedIn = false;
                }
                break;
            case "m":
                List<Item> itemsM = cart.getItemsInCart();
                for(Item element : itemsM){
                    System.out.println(element);
                }
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
            case "r":
                System.out.print("Username > ");
                userName = readInput();
                System.out.print("Password > ");
                password = readInput();
                System.out.print("Address > ");
                address = readInput();
                manager.registerClient(userName, password, address);
                break;
            case "s":
                System.out.print("Item name > ");
                item = readInput();
                System.out.print("Quantity >");
                quantity = Integer.parseInt(readInput());
                List<Item> itemsS = manager.getItems();
                List<Item> itemsL = cart.getItemsInCart();
                for(Item element : itemsS){
                    if(element.getItemName().equals(item)){//checks if element is in stock
                        if (element.getNumberInStock() >= quantity) {//checks if user didnt select more items than available in stock
                            for(Item article : itemsL){
                                if(article.getItemName().equals(item)){//checks if item is already in cart
                                    if(element.getNumberInStock() >= article.getNumberInStock()) { //number of items in cart cant be higher than in stock
                                        cart.increaseItemStock(item, quantity);
                                        System.out.println("Added to cart");
                                        inCart = true;//to save the fact that the item is already in cart
                                    }
                                }
                            }
                            if(!inCart){ //if item was not already in cart
                                float price = element.getPrice();
                                int itemCode = element.getItemCode();
                                Item cartItem = new Item(item, price, itemCode, quantity);//creates new item
                                cart.putItemsInCart(cartItem);
                                System.out.println("Added to cart");
                            } else {
                                inCart = false;
                            }
                        }
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
                    if(element.getItemName().equals(item)){ //checks if item is in cart
                        if(element.getNumberInStock() >= quantity) { //checks if user doesnt want to remove too many items
                            cart.decreaseItemStock(item, quantity);
                        }
                    }
                    System.out.println("Removed from cart.");
                }
                break;
            case "w":
                loggedIn = false;
                break;
            case "x":
                for(String stockEntry : stockChanges){
                    System.out.println(stockEntry);
                }
                break;
            case "y":
                System.out.print ("Username > ");
                userName = readInput ();
                System.out.print ("Password > ");
                password = readInput ();
                manager.registerEmployee (userName, password);
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