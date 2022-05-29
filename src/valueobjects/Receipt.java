package valueobjects;


import domain.ShopCart;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;

public class Receipt {
    private Person user;
    //private int date;
    private ShopCart cart;

    private String hour;
    private LocalDate date;


    public Receipt(Person user, ShopCart cart) {
        this.user = user;
        this.cart = cart;
        this.date = LocalDate.now();
        LocalTime time= LocalTime.now();//I looked for a YouTube tutorial...lets see if that works, I'm not sure how to check it haha Natha
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss", Locale.GERMAN);
        this.hour= formatter.format(time);//I looked for a YouTube tutorial...lets see if that works, I'm not sure how to check it haha Natha
    }

    public String toString() {
        return ("Client name: " + user.getName() + "\n" + "Client ID: " + user.getIdNumber() + "\n" + "Date and time: " + date.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG))+ " " + hour +  "\n" + "Bought Items: " + cart.getItemsInCart() + "\n" + "End price: " + cart.endPrice() + "\n" + "Thank you for shopping with us.");

    }
}

    //private ShopCart purchasedItems= cartItems;  --> totally unsure about it

    //this class will take into String all what is im  the ShopCart and the Client information
    //then it will print it in a file.txt--> this is for the persistence now is just in the conmand
    //then the ShopCart will be close

    //This par of Frankie comes from File Persistence manager--> if we are not working with database the interface doenst make sense
 //   private BufferedReader reader = null;
   // private PrintWriter writer = null;

   // public void openForReading(String datei) throws FileNotFoundException {
     //   reader = new BufferedReader(new FileReader(datei));
    //}

    //public void openForWriting(String datei) throws IOException {
      //  writer = new PrintWriter(new BufferedWriter(new FileWriter(datei)));







