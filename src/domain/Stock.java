package domain;

import valueobjects.Item;

import java.util.ArrayList;
import java.util.List;

public class Stock {

    private List<Item> stock = new ArrayList<>();

    public Stock(){
        addNewItem(new Item("Cup", 2.5f, 5009 , 7 ));
        addNewItem(new Item("Vaso", .5f, 5887 , 3 ));
        addNewItem(new Item("T-Shirt", 8.75f, 002, 10));
        addNewItem(new Item("Hoodie", 15.99f, 0017, 1));
        addNewItem(new Item("Schoes", 10.5f, 6689, 9));
    }

    public List<Item> getStock(){
        return stock;
    }

    public void setStock(List<Item> stock) {
        this.stock = stock;
    } //now I'm not sure if we need this or if we better increase the variable "numberInStock"

    public void addNewItem(Item item) {
        stock.add(item);
        }
        //in longin the user will create object item-->  new Item("cup", 2.5f, 5 , 7 ));

   public void removeItemFromStock(Item item){
        stock.remove(item);
   }

   public List<Item> getStockContent() {
       return new ArrayList<Item>(stock);
   }
}
