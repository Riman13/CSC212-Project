
import java.util.Scanner;
public class PhoneBook {

    static LinkedList<Contact> contacts;
    static LinkedList<Event> events;

    //Constructor
    public PhoneBook() {
        this.contacts = new LinkedList<Contact>();
        this.events = new LinkedList<Event>();
    }


//method add for event and contact
    public static boolean addContact(Contact c) {
        if (!SearchsearchByNameOrPhone(c) ) {
            contacts.insertSort(c);
            return true ;
        }
        else 
            return false ;
    }
    
    public static boolean addEvent(Event e) {
        if (events.search(e) == false) {
            events.insertSort(e);
            return true ;
        }
        else 
            return false ;
    }
    
    public static boolean removeContact(Contact c) {

        Contact tmp = contacts.remove(c);
        if (tmp != null) {
            return true;
        } else {
            return false;
        }

    }
    
    public static boolean removeEvent(Event e) {

        Event tmp = events.remove(e);
        if (tmp != null) {
            return true;
        } else {
            return false;
        }

    }

    public static void deleteContactwithEvents(String con) {

        if (contacts.isEmpty() == false) {
            Contact d;
            contacts.findFirst();

            for (int j = 0; j < contacts.size; j++) {

                if (contacts.retrieve().getContact_name().equalsIgnoreCase(con)) {

                    d = contacts.retrieve();

                    if (!d.events.isEmpty() && d.events.size > 1) {
                        d.events.findFirst();
                        for (int i = 0; i < d.events.size; i++) {
                            if (d.events.retrieve().contcts_Name.size <= 1) {
                                events.remove(d.events.retrieve());
                            }//end if check for there is another contact shared same event if not we will remove event 
                        }
                    } else {
                        events.remove(d.events.retrieve());
                    }

                    contacts.remove(d);
                    System.out.println("contact" + con + " has been deleted successfully");
                    return;
                }
                contacts.findNext();
            }//end for 
        }// end outer if 
        else {
            System.out.println("The list is empty you can't delete it");
        }//end else 
    }

    //advanced search functionality that allows users to search for contacts based on multiple criteria (e.g., name, phone number, email address).
   
       public static boolean SearchsearchByNameOrPhone (Contact c) {
       if (!contacts.isEmpty()) {
           contacts.findFirst();
           while (!contacts.last()) {
           if ((contacts.retrieve().getContact_name().equalsIgnoreCase(c.getContact_name()))||
           (contacts.retrieve().getPhoneNumber().equals(c.getPhoneNumber())))
                return true;
            contacts.findNext(); 
           }//end while
           if ((contacts.retrieve().getContact_name().equalsIgnoreCase(c.getContact_name()))||
             (contacts.retrieve().getPhoneNumber().equals(c.getPhoneNumber())))
              return true;
      }
     return false;
     
 }//search


    public static LinkedList<Contact> searchByEmail0rAdressOrBirthday(String o) {
        LinkedList<Contact> contactShared = new LinkedList<Contact>();
        if (!contacts.isEmpty()) {
            contacts.findFirst();
            while (!contacts.last()) {
                if ((contacts.retrieve().getEmailAddress().equalsIgnoreCase(o)) ||
                (contacts.retrieve().getAddress().equalsIgnoreCase(o)) ||
                (contacts.retrieve().getBirthday().equals(o))){
                    contactShared.insertSort(contacts.retrieve());
                    contacts.findNext();
                } //if
            }//while
            if ((contacts.retrieve().getEmailAddress().equalsIgnoreCase(o)) ||
                (contacts.retrieve().getAddress().equalsIgnoreCase(o)) ||
                (contacts.retrieve().getBirthday().equals(o))) {
                contactShared.insertSort(contacts.retrieve());
            }
        }//if 
        return contactShared;
    }

    public static Event searchByEventTiltleOrByContact(String con) {

        if (!events.isEmpty()) {
            events.findFirst();
            while (!events.last()) {
                if ((events.retrieve().getTitle().equalsIgnoreCase(con)) ||
                   (contacts.retrieve().getContact_name().equalsIgnoreCase(con))) {
                    return events.retrieve();
                }
                events.findNext();
            }
            if ((events.retrieve().getTitle().equalsIgnoreCase(con)) ||
               (contacts.retrieve().getContact_name().equalsIgnoreCase(con))) {
                return events.retrieve();
            }
        }
        return null;
    }

    public static void schedule(Contact ev, Event r) {
        if (contacts.search(ev) == true && ev.addEventInContact(r) == true) {
            System.out.println("schedulling contact" + ev.getContact_name() + "" + r.getTitle());
        } else {
            if (contacts.search(ev) == false) {
                System.out.println("contact does't exit");
            }
            if (ev.addEventInContact(r) == false) {
                System.out.println("there's conflict");
            }
        }
    }

    public static void printContactsSharingFirstName(String firstName) {

        if (contacts.isEmpty()) {
            System.out.println("No Contacts found !");
            return;
        }

        String name;
        int j;

        if (!contacts.isEmpty()) {

            contacts.findFirst();

            for (int i = 1; i <= contacts.size; i++) {

                name = contacts.retrieve().getContact_name();

                j = name.indexOf(" ");
                name = name.substring(j);

                if (name.equalsIgnoreCase(firstName)) {

                    System.out.println("Contact found!");
                    System.out.println(contacts.retrieve().toString() + "\n");
                }//End inner if 

                contacts.findNext();
            }//end for

        }//end if

    }//End method 

    public static void printContactsSharingEvent(Event e) {

        if (events.isEmpty()) {
            System.out.println("No events found !");
            return;
        }//end if

        events.findFirst();

        for (int i = 1; i <= events.size; i++) {

            if (events.retrieve().compareTo(e) == 0) {
                events.retrieve().toString();
            }

            events.findNext();

        }//end for

    }//end method
    
        public static void printAlphebeticllyOrder(Event e) {

        if (events.isEmpty()) {
            System.out.println("No events found !");
            return;
        }//end if

        events.findFirst();
        for (int i = 1; i <= events.size; i++) {
         events.retrieve();
        
        events.findNext();

        }//end for

    }//end method
    

public static void displayMenu() {
    System.out.println ("Welcome to the linked tree phonebook!");
    System.out.println("Please choose an option:");
    System.out.println ("1. Add a contact");
    System.out.println ("2. Search for a contact");
    System.out.println ("3. Delete a contact");
    System.out.println ("4. Schedule an event");
    System.out.println ("5. Print event detail");
    System.out.println ("6. Print contacts by first name");
    System.out.println ("7. Print all events alphebetically");
    System.out.println ("8. Exit");
    
     System.out.println ("Enter your choice :");
     
}

    
    }