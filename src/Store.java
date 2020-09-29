import entities.Client;
import service.Verification;

import java.util.Scanner;

public class Store {
    public static void main(String[] args) {

        Client client1 = new Client();
        client1.name = "Ion";
        client1.CNP = "1960321029990";

        Client client2 = new Client();
        client2.name = "Maria";
        client2.CNP = "6060314667742";

        allowedToBuyDrinks(client1);
        allowedToBuyDrinks(client2);
    }

    public static void allowedToBuyDrinks(Client client) {
        if (Verification.isValid(client)){
            boolean isMajor = Verification.isMajor(client.CNP);
            if (isMajor == true) {
                System.out.println(client.name + " is allowed to buy drinks.");
            } else {
                System.out.println(client.name + " is not allowed to buy drinks.");
            }
        }
        else{
            System.out.println("Not a valid CNP! Call the police!");
        }
    }
}
