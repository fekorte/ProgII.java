package valueobjects;


import domain.ShopCart;

public class Receipt {
    private Person user;
    private int date;
    private ShopCart cart;


    public Receipt(Person user, ShopCart cart) {
        this.user = user;
        this.date = 2022;
        this.cart = cart;
    }

    public String toString() {
        return ("Client name: " + user.getName() + "\n" + "Client ID: " + user.getIdNumber() + "\n" + "Date: " + date + "\n" + "Bought Items: " + cart.getItemsInCart() + "\n" + "End price: " + cart.endPrice() + "\n" + "Thank you for shopping with us.");
    }
}
    //DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
   // LocalDateTime now = LocalDateTime.now();
   //System.out.println(dtf.format(now));


        //  public Receipt {

//   }

    //private ShopCart purchasedItems= cartItems;  --> totally unsure about it

    //this class will take into String all what is im  the ShopCart and the Client information
    //then it will print it in a file.txt
    //then the ShopCart will be close

    //This par of Frankie comes from File Persistence manager--> if we are not working with database the interface doenst make sense
 //   private BufferedReader reader = null;
   // private PrintWriter writer = null;

   // public void openForReading(String datei) throws FileNotFoundException {
     //   reader = new BufferedReader(new FileReader(datei));
    //}

    //public void openForWriting(String datei) throws IOException {
      //  writer = new PrintWriter(new BufferedWriter(new FileWriter(datei)));







