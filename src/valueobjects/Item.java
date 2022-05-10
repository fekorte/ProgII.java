package valueobjects;

public class Item {
    private String name;
    private float price;
    private int itemCode;
    private int stock;

    public Item(String name, float price, int itemCode, int stock) {
        this.name = name;
        this.price = price;
        this.itemCode = itemCode;
        this.stock = stock;
    }
    public static void setStock(int stockIncrease){
       this.stock = stock;
    }
}
