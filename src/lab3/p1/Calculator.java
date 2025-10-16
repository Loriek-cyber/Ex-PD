package lab3.p1;
import java.rmi.Remote;

public interface Calculator extends Remote {
    public double somma(double a, double b) throws java.rmi.RemoteException;
    public double sottrazione(double a, double b) throws java.rmi.RemoteException;
    public double multiplicazione(double a, double b) throws java.rmi.RemoteException;
    public double divisione(double a, double b) throws java.rmi.RemoteException;
}
