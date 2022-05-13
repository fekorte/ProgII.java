package valueobjects;

public class Item {
    private String itemName;
    private float price;
    private int itemCode;
    private int stock;

    public Item(String itemName, float price, int itemCode, int stock) {
        this.itemName = itemName;
        this.price = price;
        this.itemCode = itemCode;
        this.stock = stock;
    }
    public void setStock(int stockIncrease){
       this.stock = stock;
    }
}
