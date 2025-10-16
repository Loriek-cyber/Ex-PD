/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab3.p2;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.*;
import java.util.logging.Logger;

/**
 *
 * @author Arjel Buzi
 */
public class Server extends UnicastRemoteObject implements Prenotazione{
    public ArrayList<Boolean> stanze;
    public static Logger logger = Logger.getLogger("global");
    public Server (ArrayList<Boolean> stanze) throws RemoteException {
        this.stanze = stanze;
    }

    @Override
    public ArrayList<Boolean> getstanze() throws RemoteException {
        logger.info("Restituisco le stanze libere");
        return stanze;
    }

    @Override
    public synchronized  boolean prenota(int numeroStanza) throws RemoteException {
        logger.info("Vedo se la stanza è libera");
        if(stanze.get(numeroStanza)==true){
            logger.info("La stanza non è libera ");
            return false;

        }
        else{
            logger.info("La stanza è libera");
            stanze.set(numeroStanza,true);
            return true;
        }
    }

    public static void main(String[] args) throws RemoteException {
        ArrayList<Boolean> temp = new ArrayList<>();
        logger.info("Server starting");
        for(int i=0;i<10;i++){
            if(i%2==0){
                temp.add(true);
            }else {
                temp.add(false);
            }
        }

        Server serv = new Server(temp);
        try {
            java.rmi.registry.LocateRegistry.createRegistry(1099);
            logger.info("Registry created on port 1099");
        } catch (RemoteException e) {
            logger.info("Registry already running");
        }

        try{
            Naming.rebind("prenota",serv);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}
