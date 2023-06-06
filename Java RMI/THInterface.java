import java.rmi.*;
import java.util.*;

//Remote Interface
//Αφορούν μόνο τον client
public interface THInterface extends Remote
{
    //Κράτηση Θέσεων
    String book(String type, int number, String name) throws RemoteException;
    //Λίστα Πελατών
    String guests() throws RemoteException;
    //Λίστα με υπόλοιπες θέσεις
    String cancel(String type, int number, String name) throws RemoteException;
    //Λιστα διαθεσιμων θεσεων
    ArrayList<String> list() throws RemoteException;

}
