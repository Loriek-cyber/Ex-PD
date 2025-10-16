package lab3.p1;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.logging.Logger;

public class CalculatorClient {
    Logger logger = Logger.getLogger("global");
    public static void main(String[] args) throws MalformedURLException, NotBoundException, RemoteException {
        Calculator cal = (Calculator) Naming.lookup("rmi://127.0.0.1/calc");
        System.out.println(cal.somma(1.0, 2.0));
        System.out.println(cal.sottrazione(1.0, 2.0));
        System.out.println(cal.multiplicazione(1.0, 2.0));
        System.out.println(cal.divisione(1.0, 2.0));
    }
}
