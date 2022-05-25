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
    }//
    //in longin the user will create object item-->  new Item("cup", 2.5f, 5 , 7 ));

    public void changeNumberItemsInCart(Item item, int num){
        cartItems.set(num,item);
    }
    //this creates an int wishStock
    //when someone buy this then: numberInStock- wishStock



    public void emptyCart(){
        cartItems.removeAll(cartItems);
    }

    public void removeItemsFromCart(Item item){
        cartItems.remove(item);
    }
   //this delates all the objects with the same name

    public void buy(){
        //when someone buy this then: numberInStock- wishStock


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
