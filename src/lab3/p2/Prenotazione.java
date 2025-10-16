package lab3.p2;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface Prenotazione extends Remote {
    public ArrayList<Boolean> getstanze() throws RemoteException;
    public boolean prenota(int numeroStanza) throws RemoteException;
}
