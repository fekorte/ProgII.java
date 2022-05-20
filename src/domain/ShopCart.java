package domain;

import valueobjects.Client;
import valueobjects.Employee;
import valueobjects.Item;

import java.lang.reflect.MalformedParameterizedTypeException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShopCart {
    private Client client;
    private int date;
    private Item item;

List<Item> cartItems= new ArrayList<Item>();


    public void putItemsInCart(Item item){
        cartItems.add(item);
    }

    public void changeNumberItemsInCart(Item item, int num){
        cartItems.set(num,item);
    }


    public void emptyCart(){
        cartItems.removeAll(cartItems);
    }

    public void removeItemsFromCart(Item item){
        cartItems.remove(item);
    }



    public ShopCart(Client client, int date, Item item){
        this.client = client;
        this.date = date;

    }




    // putItemsInCart();
    //
    // changeNumberItemsInCart();
    //
    // emptyCart();
    //
    // buy();
}
