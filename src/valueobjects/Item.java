package valueobjects;

public class Item {
    private String itemName;
    private float price;
    private int itemCode;
    private int numberInStock;

    public Item(String itemName, float price, int itemCode, int numberInStock) {
        this.itemName = itemName;
        this.price = price;
        this.itemCode = itemCode;
        this.numberInStock = numberInStock;
    }


    public void addItemInStock (int stockIncrease) {
        this.numberInStock = numberInStock + stockIncrease;
    }

    public void removeItem(int stockDecrease) {
        this.numberInStock = numberInStock - stockDecrease;//in case you want to sell an item we decrease it in the number of objects we bought=stockDecrease
    }

    public void addToStock(int numberNewItem) {
        this.numberInStock = numberInStock + numberNewItem;
    }

    ///dont we need a IOExeption to say that there ins nothing??
    public String toString() {
        String availability = (numberInStock > 0) ? "available" : "sold out"; //this is to know if we have this item in stock
        return ("Item Name " + itemName + " / Item code: " + itemCode + " / Availability: " + availability);
    }

    /**
     * Do we need to cheack if the items are repeated???? in our case it could not be importan
     * public boolean equals(Object anderesBuch) {
     * if (anderesBuch instanceof Buch)
     * return ((this.nummer == ((Buch) anderesBuch).nummer)
     * && (this.titel.equals(((Buch) anderesBuch).titel)));
     * else
     * return false;
     * }
     */
    //methods to acces the information of the items
    public String getItemName () {
        return itemName;
    }

    public float getPrice () {
        return price;
    }


    public int getItemCode () {
        return itemCode;
    }


    public int getNumberInStock () {
        return numberInStock;
    }

}



