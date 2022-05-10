package domain;

public class ShopCart {
    private Client client;
    private int date;
    private Item item;

    public ShopCart(Client client, int date, Item item){
        this.client = client;
        this.date = date;
        this.item = item;
    }
    putItemsInCart();

    changeNumberItemsInCart();

    emptyCart();

    buy();
}
