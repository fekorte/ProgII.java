package valueobjects;

public class Item {
    private String itemName;
    private float price;
    private int itemCode;
    private boolean stock;

    public Item(String itemName, float price, int itemCode, int stock) {
        this.itemName = itemName;
        this.price = price;
        this.itemCode = itemCode;
        this.stock = 0< stock;
    }

    public void setStock(int stockIncrease){
       this.stock = stock;
    }
}

    public String toString() {
        String availability  = stock ? "available" : "sold out"; //this is to know if we have this item in stock
        return ("Item Name " + itemName +  " / Item code: " + itemCode  " / Availability: " + availability );
    }

/** Do we need to cheack if the items are repeated???? in our case it could not be importan
 * public boolean equals(Object anderesBuch) {
 * 		if (anderesBuch instanceof Buch)
 * 			return ((this.nummer == ((Buch) anderesBuch).nummer)
 * 					&& (this.titel.equals(((Buch) anderesBuch).titel)));
 * 		else
 * 			return false;
 *        }
 */
    //methods to acces the information of the items
    public String getItemName(){return itemName;}
    public float getPrice(){return price;}

    public int getItemCode(){ return itemCode;}

    public int getStock() {return stock;}
}
