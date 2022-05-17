package domain;


import valueobjects.Client;


public class EShopManager {

    public boolean login(String userName,String password) {
        // todo : implement logic
    }
    public void registerClient(String userName, String password, String address){
        Client client = new Client(userName, address);
    }

}
