package lab3.p3;

import java.rmi.RemoteException;
import java.util.ArrayList;

public interface Vota {
    public ArrayList<Candidato> getCandidati() throws RemoteException;
    public void vota(Candidato c) throws RemoteException;
    public
}
