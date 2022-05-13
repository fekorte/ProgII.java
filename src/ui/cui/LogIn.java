package ui.cui;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

public class LogIn {
    private BufferedReader in;

    public static void main(String[] args) {
        private void showMenue() {
            System.out.print("Commands: \n  Login:  'l'");
            System.out.print("         \n  Register:  'r'");
            System.out.print("         \n  ---------------------");
            System.out.println("         \n  Beenden:        'q'");
            System.out.print("> "); // Prompt
            System.out.flush(); // ohne NL ausgeben
        }
    }

    private String readInput() throws IOException {
        // einlesen von Konsole
        return in.readLine();
    }

    private void processInput(String line) throws IOException {
        String userName;
        String password;
        List<> liste;


        switch (line) {
            case "l":
                System.out.print("Username > ");
                userName = readInput();
                System.out.print("Password > ");
                password = readInput();
                break;
            case "r":

                break;
        }
    }
}
