import java.rmi.*;
// import java.rmi.registry.LocateRegistry;
// import java.rmi.registry.Registry;

public class THClient {
    public static void main(String[] args) {
        //Ο client θα πρέπει να τρέχει στο command line ως εξής:
        //Ελέγχουμε αν δεν εχουν εισαχθεί ορίσματα τότε να εκτυπώνει τα ορίσματα που μπορούν να δωθούν java THClient
        /*
        *       java TΗClient: αν καμία άλλη παράμετρος δεν προσδιορίζεται, το πρόγραμμα θα πρέπει απλά να 
        *       τυπώνει στην οθόνη πως ακριβώς (με τι παραμέτρους) πρέπει να τρέξει ο χρήστης την εντολή
        */
        if(args.length == 0)
        {
            PrintCommands();
            return;
        }
        
        try {
            THInterface in = (THInterface)Naming.lookup("rmi://localhost:1099/TH"); 
            String check_command = args[0];
            //Έλεγχος παραπάνω ορισμάτων
            
            switch(check_command)
            {
                /*
                *       java TΗClient list <hostname>: να τυπώνεται ως αποτέλεσμα στην οθόνη μία λίστα με τις διαθέσιμες
                *       θέσεις (για κάθε τύπο και κόστος) στο θέατρο - π.χ. στην ακόλουθη μορφή:
                *       κ1 θέσεις Πλατεία - Ζώνη Α (κωδικός: ΠΑ) - τιμή: 45 Ευρώ 
                *       κ2 θέσεις Πλατεία - Ζώνη Β (κωδικός: ΠΒ) - τιμή: 35 Ευρώ 
                *       κ3 θέσεις Πλατεία - Ζώνη Γ (κωδικός: ΠΓ) - τιμή: 25 Ευρώ 
                *       κ4 θέσεις Κεντρικός Εξώστης (κωδικός: ΚΕ) - τιμή: 30 Ευρώ 
                *       κ5 θέσεις Πλαϊνά Θεωρεία (κωδικός: ΠΘ) - τιμή: 20 Ευρώ 
                *       όπου τα κ1,κ2,κ3,κ4,κ5 υποδεικνύουν τον τρέχοντα αριθμό διαθέσιμων θέσεων κάθε τύπου.
                */

                case "list": //αν επιλεξουμε το java THClient list localhost
                    if (args.length < 2) 
                    {
                        //Εκτύπωση Διαθέσιμων Θέσεων
                        System.out.println("Java THClient list <hostname>: Εμφάνιση των διαθέσιμων θέσεων και το κόστος\n");
                        
                    }
                    else{
                        //Εκτύπωση Διαθέσιμων Θέσεων
                        System.out.println(in.list().toString().replace("[","").replace("]","").replace(",",""));
                    }
                    break;

                   /*   java TΗClient book <hostname> <type> <number> <name>: να γίνεται κράτηση <number> θέσεων
                    *   τύπου/κωδικού <type> στο ονοματεπώνυμο <name>. Να τυπώνεται επίσης στην οθόνη σχετικό μήνυμα
                    *   επιτυχίας ή αποτυχίας (αν τελικά δεν βρέθηκαν διαθέσιμες οι αιτούμενες θέσεις - αυτό μπορεί να
                    *   συμβεί παρότι ο χρήστης τις είχε δει αρχικά διαθέσιμες γιατί στο ενδιάμεσο μπορεί να πρόλαβε και να
                    *   έκλεισε κάποιες από αυτές άλλος). Αν βρέθηκαν διαθέσιμες λιγότερες θέσεις να ερωτάται επίσης ο
                    *   χρήστης αν επιθυμεί να κάνει κράτηση μόνο για αυτές. Σε κάθε περίπτωση να επιστρέφεται επίσης το
                    *   συνολικό κόστος της κράτησης
                    */

                case "book": //αν επιλεξουμε το java THClient list localhost
                    if(args.length < 5) 
                    {
                        System.out.println("Java THClient book <hostname> <type> <number> <name>: Κράτηση θέσεων\n");
                        
                    }
                    else //if(args.length > 5) 
                    {
                        String type=args[2];
                        int number=Integer.parseInt(args[3]); //Μετατροπή string σε ακέραιο
                        String name=args[4];
                        System.out.println(in.book(type,number,name));
                    }

                    break;

                    /*  java TΗClient guests <hostname>: να τυπώνεται μία λίστα με το σύνολο των πελατών του θεάτρου
                    *   (όσων δηλαδή έχουν κράτηση) και των κρατήσεων που έχει κάνει ο καθένας από αυτούς (για πόσες και
                    *   τι τύπου/κωδικού θέσεις και συνολικό κόστος). 
                    */

                case "guests": //αν επιλεξουμε το java THClient guest localhost
                    if(args.length < 2) {
                        System.out.println("Java THClient guest <hostname>:  Εκτύπωση της συνολικής λίστας με τις κρατήσεις\n");
                    }
                    else{
                        System.out.println(in.guests());
                    }
                    break;

                    /* java TΗClient cancel <hostname> <type> <number> <name>: να γίνεται ακύρωση των αντίστοιχων
                    *    <number> θέσεων τύπου/κωδικού <type> για τις οποίες είχε κάνει κράτηση ο χρήστης <name>. Να
                    *    επιστρέφεται ως αποτέλεσμα μια λίστα με τις υπόλοιπες θέσεις (πλην αυτών δηλαδή που
                    *    ακυρώθηκαν) για τις οποίες έχει τυχόν ισχύουσα κράτηση ο ίδιος χρήστης, ή κατάλληλο μήνυμα
                    *    αποτυχίας σε περίπτωση που δεν βρέθηκαν οι προς ακύρωση θέσεις. 
                    */

                case "cancel": //αν επιλεξουμε το java THClient cancel localhost <type> <number> <name>
                if(args.length < 5) 
                {
                    System.out.println("Java THClient cancel <hostname> <type> <number> <name>: Ακύρωση κράτησης\n");
                    
                }
                else //if(args.length > 5) 
                {
                    String type=args[2];
                    int number=Integer.parseInt(args[3]);
                    String name=args[4];
                    System.out.println(in.cancel(type,number,name));

                }
                    
                    
            }
            
        } catch (Exception e) 
        {
            e.printStackTrace();
        }
    }

 
    /*εκτυπωση ορισματων οταν εκτελουμε την εντολη java THClient */

    private static void PrintCommands() 
    {
        System.out.println("Ορίσματα γραμμής εντολών:");
        System.out.println("Java THClient: Εκτύπωση του τρόπου εκτέλεσης των εντολών");
        System.out.println("Java THClient list <hostname>: Εκτύπωση όλων των διαθέσιμων θέσεων(για κάθε τύπο και κόστος) στο θέατρο");
        System.out.println("java TΗClient book <hostname> <type> <number> <name>: Εκτύπωση των κρατήσεων θέσεων με συγκεκριμένο κωδικό και όνομα πελάτη");
        System.out.println("java TΗClient guests <hostname>: Εκτύπωση της συνολικής λίστας με τις κρατήσεις");
        System.out.println("java TΗClient cancel <hostname> <type> <number> <name>: Εκτύπωση ακύρωσης κράτησης και εμφάνιση διαθέσιμων θέσεν");
    }

}
