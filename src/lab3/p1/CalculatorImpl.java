package lab3.p1;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.logging.Logger;

public class CalculatorImpl extends UnicastRemoteObject implements Calculator {

    public CalculatorImpl() throws RemoteException {}
    public static Logger logger = Logger.getLogger("global");

    @Override
    public double somma(double a, double b) throws RemoteException {return a+b;}

    @Override
    public double sottrazione(double a, double b) throws RemoteException {return a-b;}

    @Override
    public double multiplicazione(double a, double b) throws RemoteException {return a*b;}

    @Override
    public  double divisione(double a, double b) throws RemoteException {return a/b;}


    public static void main(String[] args) throws java.rmi.RemoteException {
        logger.info("Server starting");
        logger.info("Creating CalculatorImpl");
        CalculatorImpl c = new CalculatorImpl();
        logger.info("CalculatorImpl created");

        //creating Naming
        try {
            java.rmi.registry.LocateRegistry.createRegistry(1099);
            logger.info("Registry created on port 1099");
        } catch (RemoteException e) {
            logger.info("Registry already running");
        }


        logger.info("Binding");
        try{
            Naming.rebind("calc",c);
        } catch (MalformedURLException e) {
            logger.warning("Malformed URL");
            throw new RuntimeException(e);
        }
    }

}
