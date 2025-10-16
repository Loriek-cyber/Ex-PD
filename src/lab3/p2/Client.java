package lab3.p2;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

public class Client {
    public static void main(String[] args) throws RemoteException, MalformedURLException, NotBoundException {
        Prenotazione pren = (Prenotazione) Naming.lookup("rmi://127.0.0.1/prenota");

        ArrayList<Boolean> stanze = pren.getstanze();
        for(int i = 0; i < stanze.size(); i++){
            System.out.println("Stanza "+ i + ": " + (stanze.get(i) ?"Libera":"Occupata"));
        }

        for(int i = 0; i < stanze.size(); i++){
            System.out.println(pren.prenota(4));
        }

    }
}
