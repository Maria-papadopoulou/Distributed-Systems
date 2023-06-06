import java.rmi.*;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.*;

// Server-side implementation
public class THImpl extends UnicastRemoteObject implements THInterface 
{
    //global μεταβλητες. χρησιμοποιουνται σε ολο το προγραμμα αρκει να τις καλεσουμε
    public static int k1_A_size = 100;
    public static int k2_B_size = 200;
    public static int k3_C_size = 400;
    public static int k4_Centr_size = 225;
    public static int k5_Side_size = 75;
    
    //global πινακες. χρησιμοποιουνται σε ολο το προγραμμα αρκει να τις καλεσουμε
    public static ArrayList<String> k1_zone_A = new ArrayList<>();
    public static ArrayList<String> k2_zone_B = new ArrayList<>();
    public static ArrayList<String> k3_zone_C = new ArrayList<>();
    public static ArrayList<String> k4_zone_Centr = new ArrayList<>();
    public static ArrayList<String> k5_zone_Side = new ArrayList<>();
    
    public THImpl() throws RemoteException 
    {
        super(); //καλει την κλαση "μπαμπας": public class THImpl extends UnicastRemoteObject implements THInterface
        initializeZones();
    }

    //αρχικοποιηση το καθε ArrayList καθε ζωνης με κενο χαρακτηρα ως θεση
    private void initializeZones() 
    {
        for (int i = 0; i < k1_A_size; i++) 
        {
            k1_zone_A.add("");
        }
        for (int i = 0; i < k2_B_size; i++) 
        {
            k2_zone_B.add("");
        }
        for (int i = 0; i < k3_C_size; i++) 
        {
            k3_zone_C.add("");
        }
        for (int i = 0; i < k4_Centr_size; i++) 
        {
            k4_zone_Centr.add("");
        }
        for (int i = 0; i < k5_Side_size; i++) 
        {
            k5_zone_Side.add("");
        }
    }

  /* υλοποιηση του δευτερου ζητουμενου της ασκησης. 
  *
  * java TΗClient list <hostname>: να τυπώνεται ως αποτέλεσμα στην οθόνη μία λίστα με τις διαθέσιμες
  * θέσεις (για κάθε τύπο και κόστος) στο θέατρο - π.χ. στην ακόλουθη μορφή:
  * κ1 θέσεις Πλατεία - Ζώνη Α (κωδικός: ΠΑ) - τιμή: 45 Ευρώ
  * κ2 θέσεις Πλατεία - Ζώνη Β (κωδικός: ΠΒ) - τιμή: 35 Ευρώ
  * κ3 θέσεις Πλατεία - Ζώνη Γ (κωδικός: ΠΓ) - τιμή: 25 Ευρώ
  * κ4 θέσεις Κεντρικός Εξώστης (κωδικός: ΚΕ) - τιμή: 30 Ευρώ
  * κ5 θέσεις Πλαϊνά Θεωρεία (κωδικός: ΠΘ) - τιμή: 20 Ευρώ
  * όπου τα κ1,κ2,κ3,κ4,κ5 υποδεικνύουν τον τρέχοντα αριθμό διαθέσιμων θέσεων κάθε τύπου.
  */  

    public ArrayList<String> list() throws RemoteException 
    {
        ArrayList<String> seatList = new ArrayList<>();
        int[] empty_Seats = countEmptySeats();
        String[] category_seats = {"ΠΑ", "ΠΒ", "ΠΓ", "ΚΕ", "ΠΘ"};
        int[] cost = {45, 35, 25, 30, 20};
        
        for (int i = 0; i < category_seats.length; i++) 
        {
            String seatInfo = empty_Seats[i] + " θέσεις Πλατεία - Ζώνη " + category_seats[i] + " (κωδικός: " + category_seats[i] + ") - τιμή: " + cost[i] + "€\n";
            seatList.add(seatInfo);
        }

        return seatList;
    }

    //μετραμε τις κενες θεσεις της καθε ζωνης
    private int[] countEmptySeats() 
    {
        int[] emptySeats = new int[5];
        int k1_empty_A = 0; //μετρητης που μετραει τις κενες θεσεις για τη ζωνη Α
        int k2_empty_B = 0; //μετρητης που μετραει τις κενες θεσεις για τη ζωνη Β
        int k3_empty_C = 0; //μετρητης που μετραει τις κενες θεσεις για τη ζωνη C
        int k4_empty_Centr = 0; //μετρητης που μετραει τις κενες θεσεις για τη Κεντρικη ζωνη 
        int k5_empty_Side = 0; //μετρητης που μετραει τις κενες θεσεις για τη πλαινη ζωνη


        for(int i=0; i<k1_zone_A.size(); i++) 
        {
            if (k1_zone_A.get(i).equals(""))
            {
                k1_empty_A++; //αυξανουμε τον μετρητη κενων θεσεων
            }
        }
        for(int i=0; i<k2_zone_B.size(); i++)
        {
            if (k2_zone_B.get(i).equals("")) 
            {
                k2_empty_B++; //αυξανουμε τον μετρητη κενων θεσεων
            }
        }
        for(int i=0; i<k3_zone_C.size(); i++) 
        {
            if (k3_zone_C.get(i).equals(""))
            {
                k3_empty_C++; //αυξανουμε τον μετρητη κενων θεσεων
            }
        }
        for(int i=0; i<k4_zone_Centr.size(); i++) 
        {
            if (k4_zone_Centr.get(i).equals("")) 
            {
                k4_empty_Centr++; //αυξανουμε τον μετρητη κενων θεσεων
            }
        }
        for(int i=0; i<k5_zone_Side.size(); i++) 
        {
            if (k5_zone_Side.get(i).equals("")) 
            {
                k5_empty_Side++; //αυξανουμε τον μετρητη κενων θεσεων
            }
        }


        /*  1η θεση πινακα = k1_empty_A -> κενες θεσεις ζωνης 
         *  2η θεση πινακα = k2_empty_B -> κενες θεσεις ζωνης
         *  3η θεση πινακα = k3_empty_C -> κενες θεσεις ζωνης
         *  4η θεση πινακα = k4_empty_Centr -> κενες θεσεις ζωνης
         *  5η θεση πινακα = k5_empty_Side -> κενες θεσεις ζωνης
         */
        emptySeats[0] = k1_empty_A; 
        emptySeats[1] = k2_empty_B;
        emptySeats[2] = k3_empty_C;
        emptySeats[3] = k4_empty_Centr;
        emptySeats[4] = k5_empty_Side;
        
        return emptySeats;
}

/*  java TΗClient book <hostname> <type> <number> <name>: να γίνεται κράτηση <number> θέσεων
*   τύπου/κωδικού <type> στο ονοματεπώνυμο <name>. Να τυπώνεται επίσης στην οθόνη σχετικό μήνυμα
*   επιτυχίας ή αποτυχίας (αν τελικά δεν βρέθηκαν διαθέσιμες οι αιτούμενες θέσεις - αυτό μπορεί να
*   συμβεί παρότι ο χρήστης τις είχε δει αρχικά διαθέσιμες γιατί στο ενδιάμεσο μπορεί να πρόλαβε και να
*   έκλεισε κάποιες από αυτές άλλος). Αν βρέθηκαν διαθέσιμες λιγότερες θέσεις να ερωτάται επίσης ο
*   χρήστης αν επιθυμεί να κάνει κράτηση μόνο για αυτές. Σε κάθε περίπτωση να επιστρέφεται επίσης το
*   συνολικό κόστος της κράτησης.
*/

public synchronized String book(String zone, int numSeatsToBook,String name) throws RemoteException 
{
    ArrayList<String> selectedZone; //επιλεγμενες ζωνες 
    int maxSeats; //μεγιστος αριθμος θεσεων
    String n=name; //θετουμε στη μεταβλητη n τη παραμετρο name, ωστε να τη χρησιμοποιησουμε στο προγραμμα
    double total_cost=0; //συνολικο κοστος κρατησης

    switch (zone) // επιλεγουμε μια ζωνη
    {
        case "ΠΑ": //αν η ζωνη ειναι η ΠΑ
            selectedZone = k1_zone_A; //οριζω ως επιλεγμενη ζωνη την Α
            maxSeats = k1_A_size; //οριζω ως μεγιστο μεγεθος το k1_A_size που εχω στις global μεταβλητες
            break;
        case "ΠΒ": //αν η ζωνη ειναι η ΠΒ
            selectedZone = k2_zone_B; //οριζω ως επιλεγμενη ζωνη την Β
            maxSeats = k2_B_size; //οριζω ως μεγιστο μεγεθος το k2_B_size που εχω στις global μεταβλητες
            break;
        case "ΠΓ": //αν η ζωνη ειναι η ΠΓ
            selectedZone = k3_zone_C; //οριζω ως επιλεγμενη ζωνη την Β
            maxSeats = k3_C_size; //οριζω ως μεγιστο μεγεθος το k3_C_size που εχω στις global μεταβλητες
            break;
        case "ΚΕ": //αν η ζωνη ειναι η ΚΕ
            selectedZone = k4_zone_Centr; //οριζω ως επιλεγμενη ζωνη τον Κεντρικο Εξωστη
            maxSeats = k4_Centr_size; //οριζω ως μεγιστο μεγεθος το k4_Centr_size που εχω στις global μεταβλητες
            break;
        case "ΠΘ": //αν η ζωνη ειναι η ΠΘ
            selectedZone = k5_zone_Side; //οριζω ως επιλεγμενη ζωνη τη Πλαινη Θεωρεία
            maxSeats = k5_Side_size; //οριζω ως μεγιστο μεγεθος το k5_Side_size που εχω στις global μεταβλητες
            break;
        default: //εαν δωσω ο,τιδηποτε αλλο περα απο τις παραπανω επιλογες
            return "Δεν βρέθηκε η ζώνη που ζητήθηκε"; //επιστροφη μηνυματος λαθους
    }

    //ελεγχω εαν οι  θεσεις που επιθυμω να κρατησω(numSeatsToBook) ειναι <=0 ή μεγαλυτες απο το μεγιστο αριθμο θεσεων
    if (numSeatsToBook <= 0 || numSeatsToBook > maxSeats) 
    {
        return "Δεν υπάρχουν διαθέσιμες θέσεις"; //επιστροφη μηνυματος λαθους
    }

    // Βρισκουμς τις συνεχομενες θεσεις που ειναι διαθεσιμες
    int startSeat = -1; //πρωτη θεση θετω τη -1
    int consecutiveSeats = 0; //οι συνεχομενες θεσεις αρχικα ειναι 0 (μετρητης συνεχομενων θεσεων_)

    for (int i = 0; i < maxSeats; i++) //για ολες τις θεσεις μεχρι τη μεγιστη
    {
        if (selectedZone.get(i).equals("")) //αν η επιλεγμενη ζωνη ειναι ιση με το κενο
        {
            //ελεγχω αν η πρωτη θεση παραμενει -1
            if (startSeat == -1) 
            {
                startSeat = i; //και της βαζω την τιμη i
            }
            consecutiveSeats++; //αυξανω τις συνεχομενες θεσεις

            //ελεγχω εαν οι συνεχομενες θεσεις ειναι ισες με τις θεσεις που κρατησα (αρα εφτασα στο "τελος του πινακα")
            if (consecutiveSeats == numSeatsToBook) 
            {
                break;
            }
        } else //(!selectedZone.get(i).equals("")) //αν η επιλεγμενη ζωνη δεν ειναι ιση με το κενο
        {
            startSeat = -1; //η αρχικη θεση παραμενει -1
            consecutiveSeats = 0; //οι συνεχομενες θεσεις ειναι 0
        }
    }

    // Κλεισιμο θεσεων
    for (int i = startSeat; i < startSeat+numSeatsToBook; i++) 
    {
        selectedZone.set(i, n);//θετω στην επιλεγμενη ζωνη τη θεση και το ονομα του πελατη που θα κανει τη κρατηση
        if (selectedZone==k1_zone_A) //αν η επιλεγμενη ζωνη ειναι η Α
        {
            total_cost+=45; //υπολογισμος συνολικου κοστους
        }
        else if(selectedZone==k2_zone_B) //αν η επιλεγμενη ζωνη ειναι η Β
        {
            total_cost+=35; //υπολογισμος συνολικου κοστους

        }
        else if(selectedZone==k3_zone_C) //αν η επιλεγμενη ζωνη ειναι η Γ
        {
            total_cost+=25; //υπολογισμος συνολικου κοστους

        }
        else if(selectedZone==k4_zone_Centr) //αν η επιλεγμενη ζωνη ειναι η Κεντρικη
        {
            total_cost+=30; //υπολογισμος συνολικου κοστους

        }
        else if(selectedZone==k5_zone_Side) //αν η επιλεγμενη ζωνη ειναι η πλαινη
        {
            total_cost+=20; //υπολογισμος συνολικου κοστους

        }
    }

    //μειωση διαθεσιμων θεσεων
    switch (zone) 
    {
        case "ΠΑ":
            k1_A_size -= numSeatsToBook; //μειωνονται οι διαθεσιμες θεσεις 
            break;
        case "ΠΒ":
            k2_B_size -= numSeatsToBook; //μειωνονται οι διαθεσιμες θεσεις 
            break;
        case "ΠΓ":
            k3_C_size -= numSeatsToBook; //μειωνονται οι διαθεσιμες θεσεις 
            break;
        case "ΚΕ": 
            k4_Centr_size -= numSeatsToBook; //μειωνονται οι διαθεσιμες θεσεις 
            break;
        case "ΠΘ":
            k5_Side_size -= numSeatsToBook; //μειωνονται οι διαθεσιμες θεσεις 
            break;
    }

    return "Πραγματοποιήθηκε κράτηση στο όνομα: "+n+" με συνολικό κόστος: "+total_cost+"€\n";
}

/*java TΗClient guests <hostname>: να τυπώνεται μία λίστα με το σύνολο των πελατών του θεάτρου
(όσων δηλαδή έχουν κράτηση) και των κρατήσεων που έχει κάνει ο καθένας από αυτούς (για πόσες και
τι τύπου/κωδικού θέσεις και συνολικό κόστος)*/

public synchronized String guests() 
{
    double total_cost_guest = 0;//τελικο κοστος πελατων
    StringBuilder Info = new StringBuilder();
    Info.append("Λίστα με κλεισμένες θέσεις Πελατών:\n");
    Info.append("----------------------------------------\n");

    String[] allZones = {"ΠΑ", "ΠΒ", "ΠΓ", "ΚΕ", "ΠΘ"};

    //χρησιμοποιουμε HashMap ώστε να εχουμε μια λιστα με δυο τυπους δεδομενων για τις κρατησεις. 
    //μια μεταβλητη ειναι το ονομα του πελατη και το double το κοστος της ζωνης
    HashMap<String, Double> reservations = new HashMap<>();

   
    for (String zone:allZones) 
    {
        ArrayList<String> selected_Zone;
        int max_Seats;
        int zonecost;

       
        switch (zone) 
        {
            case "ΠΑ":
                selected_Zone = k1_zone_A;
                max_Seats = 100;
                zonecost = 45;
                break;
            case "ΠΒ":
                selected_Zone = k2_zone_B;
                max_Seats = 200;
                zonecost = 35;
                break;
            case "ΠΓ":
                selected_Zone = k3_zone_C;
                max_Seats = 400;
                zonecost = 25;
                break;
            case "ΚΕ":
                selected_Zone = k4_zone_Centr;
                max_Seats = 225;
                zonecost = 30;
                break;
            case "ΠΘ":
                selected_Zone = k5_zone_Side;
                max_Seats = 75;
                zonecost = 20;
                break;
            default:
                continue; 
        }

        // για ολες τις θεσεις των ζωνων
        for (int i = 0; i < max_Seats; i++) 
        {
            String seatStatus = selected_Zone.get(i);
           
             //ελέγχει αν η θέση δεν είναι κενή
            if (!seatStatus.equals(""))
             {
                Info.append("Ζώνη: ").append(zone).append(" -Θέση").append(i).append(" -Όνομα Πελάτη: ").append(seatStatus).append("\n");

               //υπολογισμός κόστους για κάθε όνομα και για την αντίστοιχη ζώνη 
                if (reservations.containsKey(seatStatus)) 
                {
                    double current_Cost = reservations.get(seatStatus);
                    reservations.put(seatStatus, current_Cost + zonecost);
                } else 
                {
                    reservations.put(seatStatus, (double)zonecost);
                }
            }
        }
    }
//εκτυπωση κοστους για υπολοιπους πελατες
    for (Map.Entry<String, Double> entry : reservations.entrySet())
     {
        String customer = entry.getKey();
        double cost = entry.getValue();
        Info.append("Κόστος για τον πελάτη").append(customer).append(": ").append(cost).append("€\n");
        total_cost_guest += cost;
    }

    return Info.toString();
}


/*▪ java TΗClient cancel <hostname> <type> <number> <name>: να γίνεται ακύρωση των αντίστοιχων
<number> θέσεων τύπου/κωδικού <type> για τις οποίες είχε κάνει κράτηση ο χρήστης <name>. Να
επιστρέφεται ως αποτέλεσμα μια λίστα με τις υπόλοιπες θέσεις (πλην αυτών δηλαδή που
ακυρώθηκαν) για τις οποίες έχει τυχόν ισχύουσα κράτηση ο ίδιος χρήστης, ή κατάλληλο μήνυμα
αποτυχίας σε περίπτωση που δεν βρέθηκαν οι προς ακύρωση θέσεις */


public synchronized String cancel(String zone, int seatNumber, String name) throws RemoteException
 {
    ArrayList<String> selectedZone= new ArrayList<>();
    int maxSeats=0;
     // Κλήση Συνάρτησης για τις δεσμεμεύνες θέσεις ανά όνομα
     int[] reserve=countReserveSeats(name);


    switch (zone) 
    {
        case "ΠΑ":
            selectedZone = k1_zone_A;
            maxSeats = reserve[0];
            break;
        case "ΠΒ":
            selectedZone = k2_zone_B;
            maxSeats = reserve[1];
            break;
        case "ΠΓ":
            selectedZone = k3_zone_C;
            maxSeats =reserve[2];
            break;
        case "ΚΕ":
            selectedZone = k4_zone_Centr;
            maxSeats = reserve[3];
            break;
        case "ΠΘ":
            selectedZone = k5_zone_Side;
            maxSeats = reserve[4];
            break;
        default:
            break;
    }

    int canceledSeats = 0;//ακυρωση θεσεων

    // Υλοποίηση ακυρωσης θέσεων σύμφωνα με το όνομα και αν έχουμε φτάσει στις θέσεις που πρέπει να ακυρωθουν τότε να σταματά η επανάληψη
    for (int i = 0; i < maxSeats; i++) 
    {
        String seatStatus = selectedZone.get(i);
        if (seatStatus.equals(name)) 
        {
            selectedZone.set(i, "");
            canceledSeats++;
            if (canceledSeats == seatNumber) 
            {
                break;
            }
        }
    }

      // Τις δεσμευμένες θέσεις που ακυρώσαμε τις κάνουμε πάλι ελέυθερες 
      switch (zone) 
      {
        case "ΠΑ":
            k1_A_size += seatNumber;
            break;
        case "ΠΒ":
            k2_B_size += seatNumber;
            break;
        case "ΠΓ":
            k3_C_size += seatNumber;
            break;
        case "ΚΕ":
            k4_Centr_size += seatNumber;
            break;
        case "ΠΘ":
            k5_Side_size += seatNumber;
            break;
    }
    String list2=guest2(name); //συναρτηση που υπολογιζει τις θεσεις που εχουν απομεινει συμφωνα με το ονομα του πελατη
    return list2;//εμφανιση θεσεων που εχουν απομεινει
}

private String guest2(String name) 
{
    String guestsInfo = new String();
    guestsInfo="Ακύρωση κρατήσεων\n";
    guestsInfo="----------------------------------\n";

    String[] allZones = {"ΠΑ", "ΠΒ", "ΠΓ", "ΚΕ", "ΠΘ"};

    // Iterate through all zones
    for (String zone : allZones) 
    {
        ArrayList<String> selectedZone;
        int maxSeats; //μεγιστε θεσεις
        int zonecost;//κοστος ζωνης

        switch (zone) 
        {
            case "ΠΑ":
                selectedZone = k1_zone_A; //επιλεγμενη ζωνη η Α
                maxSeats = 100; //μεγιστος αριθμος θεσεων 100
                zonecost = 45; //κοστος 45€
                break;
            case "ΠΒ":
                selectedZone = k2_zone_B; //επιλεγμενη ζωνη η Β
                maxSeats = 200; //μεγιστος αριθμος θεσεων 200
                zonecost = 35; //κοστος 35€
                break;
            case "ΠΓ":
                selectedZone = k3_zone_C;  //επιλεγμενη ζωνη η Β
                maxSeats = 400; //μεγιστος αριθμος θεσεων 200
                zonecost = 25; //κοστος 45€
                break;
            case "ΚΕ":
                selectedZone = k4_zone_Centr; //επιλεγμενη ζωνη η Β
                maxSeats = 225; //μεγιστος αριθμος θεσεων 200
                zonecost = 30; //κοστος 45€
                break;
            case "ΠΘ":
                selectedZone = k5_zone_Side; //επιλεγμενη ζωνη η Β
                maxSeats = 75; //μεγιστος αριθμος θεσεων 200
                zonecost = 20; //κοστος 45€
                break;
            default: //αν δεν ειναι ζωνη απο τις παραπανω 
                continue;  //συνεχιζουμε
        }

       //για ολες τις θεσεις
        for (int i = 0; i < maxSeats; i++) 
        {
            String seatStatus = selectedZone.get(i);//παιρνει τα ονοματα των πελατων
            if(name.equals(seatStatus))
            {
                if (!seatStatus.equals("")) 
                {
                    return "Ζώνη: "+zone+(" - Θέση: ")+i+" - Όνομα Πελάτη: "+seatStatus+"\n";
    
                    
                }
            }
            
        }
    }

    return guestsInfo.toString(); //επιστρεφονται οι πληφοροφιες πελατων
}


//κρατημενες θεσεις
private int[] countReserveSeats(String name)
    {
        int[] emptySeats = new int[5];
        int k1_reserve_A = 0; //μετρητης που μετραει τις κρατημενες θεσεις για τη ζωνη Α
        int k2_reserve_B = 0; //μετρητης που μετραει τις κρατημενες θεσεις για τη ζωνη Β
        int k3_reserve_C = 0; //μετρητης που μετραει τις κρατημενες θεσεις για τη ζωνη C
        int k4_reserve_Centr = 0; //μετρητης που μετραει τις κρατημενες θεσεις για τη Κεντρικη ζωνη 
        int k5_reserve_Side = 0; //μετρητης που μετραει τις κρατημενες θεσεις για τη πλαινη ζωνη


        for(int i=0; i<k1_zone_A.size(); i++) 
        {
            if (k1_zone_A.get(i).equals(name)) 
            {
                k1_reserve_A++; //αυξανουμε τον μετρητη κρατημενων θεσεων
            }
        }
        for(int i=0; i<k2_zone_B.size(); i++) 
        {
            if (k2_zone_B.get(i).equals(name)) 
            {
                k2_reserve_B++; //αυξανουμε τον μετρητη κρατημενων θεσεων
            }
        }
         for(int i=0; i<k3_zone_C.size(); i++) 
        {
            if (k3_zone_C.get(i).equals(name)) 
            {
                k3_reserve_C++; //αυξανουμε τον μετρητη κρατημενων θεσεων
            }
        }
        for(int i=0; i<k4_zone_Centr.size(); i++) 
        {
            if (k4_zone_Centr.get(i).equals(name)) 
            {
                k4_reserve_Centr++; //αυξανουμε τον μετρητη κρατημενων θεσεων
            }
        }
        for(int i=0; i<k5_zone_Side.size(); i++)
        {
            if (k5_zone_Side.get(i).equals(name)) 
            {
                k5_reserve_Side++; //αυξανουμε τον μετρητη κρατημενων θεσεων
            }
        }


        /*  1η θεση πινακα = k1_reserve_A -> κρατημενες θεσεις ζωνης Α
         *  2η θεση πινακα = k2_reserve_B -> κρατημενες θεσεις ζωνης Β
         *  3η θεση πινακα = k3_reserve_C -> κρατημενες θεσεις ζωνης Γ
         *  4η θεση πινακα = k4_reserve_Centr -> κρατημενες θεσεις ζωνης Κεντρικης
         *  5η θεση πινακα = k5_reserve_Side -> κρατημενες θεσεις ζωνης Πλαινης
         */

        emptySeats[0] = k1_reserve_A; 
        emptySeats[1] = k2_reserve_B;
        emptySeats[2] = k3_reserve_C;
        emptySeats[3] = k4_reserve_Centr;
        emptySeats[4] = k5_reserve_Side;
        
        return emptySeats;
}
}
