package domain;

import valueobjects.Item;
import valueobjects.Person;
import valueobjects.Receipt;

import java.util.ArrayList;
import java.util.List;

public class ShopCart{
    List<Item> cartItems=new ArrayList<>();

    public void putItemsInCart(Item item){
        cartItems.add(item);
    }
    //in longin the user will create object item-->  new Item("cup", 2.5f, 5 , 7 ));
    //this creates an int wishStock
    //when someone buy this then: numberInStock- wishStock

    public void emptyCart(){
        cartItems.removeAll(cartItems);
    }

    public void removeItemsFromCart(Item item){
        cartItems.remove(item);
    }

    public void increaseItemStock(String itemName, int stockIncrease){
        for(Item element: cartItems){
            if(element.getItemName().equals(itemName)){
                element.addItemInStock(stockIncrease);
            }
        }
    }

    public void decreaseItemStock(String itemName, int stockDecrease){
        for(Item element: cartItems){
            if(element.getItemName().equals(itemName)){
                element.removeItem(stockDecrease);
            }
        }
    }

    //deletes a certain quantity of objects
    public List<Item> getItemsInCart(){
        return cartItems;
    }

    public float endPrice(){ //the proble with the price is that sum object but not the repetition--> if i have 2 cups it only shows me the prices of one
        float price=0;
        for(Item element: cartItems){
            price+=(element.getPrice()*element.getNumberInStock());
        }
        return price;
    }

    public String getItemName(){
        String itemName = "";
        for(Item element: cartItems){
            element.getItemName();
        }
        return itemName;
    }

    public Receipt buy(Person user, ShopCart cart){ //buy(user)
        //when someone buy this then: numberInStock- wishStock
        //eigtl Receipt nicht void
        Receipt receipt=new Receipt(user, cart);
        return receipt;
    }

}
