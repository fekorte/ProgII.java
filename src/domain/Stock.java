package domain;

import valueobjects.Item;

import java.util.ArrayList;
import java.util.List;

public class Stock {

    private List<Item> stock = new ArrayList<>();

    public Stock(){
        addNewItem(new Item("cup", 2.5f, 5 , 7 ));
        addNewItem(new Item("Vaso", .5f, 5 , 3 ));
        addNewItem(new Item("T-Shirt", 1.5f, 234, 0));

    }

    public List<Item> getStock(){
        return stock;
    }


    public void setStock(List<Item> stock) {
        this.stock = stock;
    }



    /*
        private int date;
        private int numberItems;
        private Item item;
        private Person person;



        public Stock(int date; int numberItems; Item item; Person person){
            this.date = date;
            this.numberItems = numberItems;
            this.item  = item;
            this.person = person;
        }
        */
    public void addNewItem(Item item) {
        stock.add(item);
        }


    //Incorrect method, needs to include arrayList
   public void addItemToStock(int numberOfItems){
    //    Item.setStock(numberOfItems);
   }
   public void removeItemFromStock(Item item){
        stock.remove(item);
   }

   public List<Item> getStockContent() {
       return new ArrayList<Item>(stock);
   }
}
