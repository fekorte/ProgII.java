package domain;

import valueobjects.Item;

import java.util.ArrayList;
import java.util.List;

public class ShopCart {
    List<Item> cartItems = new ArrayList<>();

    public void putItemsInCart(Item item) {
        cartItems.add(item);
    }
    //in longin the user will create object item-->  new Item("cup", 2.5f, 5 , 7 ));
    //this creates an int wishStock
    //when someone buy this then: numberInStock- wishStock

    public void emptyCart() {
        cartItems.removeAll(cartItems);
    }

    public void removeItemsFromCart(Item item) {
        cartItems.remove(item);
    }
    //deletes a certain quantity of objects
    public List<Item> getItemsInCart(){ return cartItems;}
    public void buy() {
        //when someone buy this then: numberInStock- wishStock
    }
}
