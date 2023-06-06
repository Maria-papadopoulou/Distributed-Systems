import java.rmi.*;
import java.rmi.registry.LocateRegistry;

public class THServer
{
    public THServer() 
    {
        try 
        {
            //Δημιουργηθηκε νεο αντικείμενο τυπου THImpl
            THImpl th = new THImpl();

            Naming.rebind("rmi://localhost:1099/TH", th);
            System.out.println("Server Started");

        } catch (Exception e) 
        {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) throws Exception
    {
        new THServer(); // φτιαχνει στιγμιοτυπο της κλασης THServer()
        System.out.println("RMI server started");
        try{
            LocateRegistry.createRegistry(1099);
            System.out.println("java RMI registry created!");

        }
        catch(Exception e)
        {
        }
        
    }
}