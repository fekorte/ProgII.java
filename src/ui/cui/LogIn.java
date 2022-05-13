package ui.cui;

import domain.EShopManager;
import valueobjects.Person;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

class UI {
    private BufferedReader in;
    private Person user;
    private EShopManager manager = new EShopManager();

    public UI() throws IOException {
        in = new BufferedReader(new InputStreamReader(System.in));
    }

        private void showMenue() {
            System.out.print("Commands: \n  Login:  'l'");
            System.out.print("         \n  Register:  'r'");
            System.out.print("         \n  ---------------------");
            System.out.println("         \n  Beenden:        'q'");
            System.out.print("> ");
            System.out.flush();
        }


    private String readInput() throws IOException {
        return in.readLine();
    }

    private void processInput(String line) throws IOException {
        String userName;
        String password;


        switch (line) {
            case "l":
                System.out.print("Username > ");
                userName = readInput();
                System.out.print("Password > ");
                password = readInput();
                manager.login(userName, password)
                break;
            case "r":

                break;
        }
    }
    public void run() {
        String input = "";

        do {
            showMenue();
            try {
                input = readInput();
                processInput(input);
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        } while (!input.equals("q"));
    }

    public static void main(String[] args) throws IOException {
        UI cui = new UI();
        cui.run();
    }
}
