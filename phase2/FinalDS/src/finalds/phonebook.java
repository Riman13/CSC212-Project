
package finalds;

 import java.util.Scanner;

public class phonebook {

    public static BST <String, Contact> contacts ;
    public static BST <String, Event> events ;

    //Constructor


    //Constructor
    public phonebook() {
        phonebook.contacts  = new BST <String, Contact>();
        phonebook.events  = new BST <String, Event>();
    }
    
    


//method add for event and contact
    public boolean addContact(Contact c) {

        
        if (!contacts.empty() && contacts.findkey(c.getContact_name()))
        {
                
                return false;
        }
        
        if (!contacts.empty() && (contacts.SearchPhone(c.getPhoneNumber()))){
            return false;
        }
                 
        contacts.insert(c.getContact_name(), c);
           
        return true;
        
    
    
    }
    
    public  boolean addEvent(Event e) {
        if (!events.empty() && events.findkey(e.getTitle()))
        {
                
                return false;
        }
        
                 
        events.insert(e.getTitle(), e);
           
        return true;
    }
 /*   
   public boolean removeContact(Contact c) {

        Contact tmp = contacts.remove(c);
        if (tmp != null) {
            return true;
        } else {
            return false;
        }

    }
    
    public  boolean removeEvent(Event e) {

        Event tmp = events.remove(e);
        if (tmp != null) {
            return true;
        } else {
            return false;
        }

    }
 
 public  void deleteContactwithEvents(String con) {

        if (contacts.isEmpty() == false) {
            Contact d;
            contacts.findFirst();

            for (int j = 0; j < contacts.size; j++) {

                if (contacts.retrieve().getContact_name().equalsIgnoreCase(con)) {

                    d = contacts.retrieve();

                    if (!d.events_contact.isEmpty() && d.events_contact.size > 1) {
                        d.events_contact.findFirst();
                        for (int i = 0; i < d.events_contact.size; i++) {
                            if (d.events_contact.retrieve().contcts_Name.size <= 1) {
                                events.remove(d.events_contact.retrieve());
                            }//end if check for there is another contact shared same event if not we will remove event 
                        }
                    } else {
                        events.remove(d.events_contact.retrieve());
                    }

                    contacts.remove(d);
                    System.out.println("contact " + con + " has been deleted successfully");
                    return;
                }
                contacts.findNext();
            }//end for 
        }// end outer if 
        else {
            System.out.println("The list is empty you can't delete it");
        }//end else 
    } 

 */

 public boolean removeContact(Contact c) {
    return contacts.removeKey(c.getContact_name());
}

public boolean removeEvent(Event e) {
    return events.remove(e);
}

public void deleteContactWithEvents(String name) {
    if (!contacts.empty()) {
        if (contacts.findkey(name)) {
            Contact deletedContact = (Contact) contacts.retrieve();
            contacts.removeKey(name);

            if (!deletedContact.events_contact.isEmpty()) {
                deletedContact.events_contact.findFirst();
                for (int i = 0; i < deletedContact.events_contact.size; i++) {
                    Event event = (Event) deletedContact.events_contact.retrieve();
                    if (events.findkey(event.getTitle())) {
                        Event updatedEvent = (Event) events.retrieve();
                        updatedEvent.removeContact(name);

                        if (updatedEvent.getContcts_Name().isEmpty()) {
                            events.removeKey(event.getTitle());
                            System.out.println("the event has been deleted because it doesn't have any contacts.");
                        } else {
                            events.update(updatedEvent.getTitle(), updatedEvent);
                        }
                    }
                    deletedContact.events_contact.findNext();
                }
            }

            System.out.println("contact Info:\n " + deletedContact + "\nhas been deleted successfully");
        } else {
            System.out.println("Contact not found!");
        }
    } else {
        System.out.println("The contact list is empty.");
    }
}

  /*   
public  Contact SearchsearchByNameOrPhone (String c) {
        

        if (contacts.isEmpty())
        	return null ;
        
            contacts.findFirst();
            while (!contacts.last()) {
            if ((contacts.retrieve().getContact_name().compareTo(c)) == 0 ||
            (contacts.retrieve().getPhoneNumber().compareTo(c)) == 0 )
            	return contacts.retrieve();
            
            
             contacts.findNext(); 
            }
            if ((contacts.retrieve().getContact_name().compareTo(c)) == 0 ||
            (contacts.retrieve().getPhoneNumber().compareTo(c)) == 0 )
            	return contacts.retrieve();
            
       
      return null;
      
  }//search

    public  LinkedList <Contact> searchByEmailorAdressOrBirthday(String o) {
        
        
        LinkedList<Contact> contactShared = new LinkedList<Contact>();
        if (contacts.isEmpty()) 
        	return contactShared ;
            contacts.findFirst();
            while (!contacts.last()) {
                if ((contacts.retrieve().getEmailAddress().compareTo(o))==0 ||
                (contacts.retrieve().getAddress().compareTo(o))==0  ||
                (contacts.retrieve().getBirthday().compareTo(o))==0 )
                    contactShared.insertSort(contacts.retrieve());
                    contacts.findNext();
               
            }//while
            if ((contacts.retrieve().getEmailAddress().compareTo(o))==0 ||
                (contacts.retrieve().getAddress().compareTo(o))==0  ||
                (contacts.retrieve().getBirthday().compareTo(o))==0 )
                contactShared.insertSort(contacts.retrieve());
            
       
        return contactShared;
  
    }
*/
public Contact searchByNameOrPhone(String c) {
    if (contacts.empty())
        return null;

    // Try searching by name OR by phone number
    if (contacts.findkey(c) || contacts.SearchPhone(c)) {
        return contacts.retrieve();
    }
    // If not found by either, return null
    return null;
}

public Contact searchByEmailOrAddressOrBirthday(String o) {
    if (!contacts.empty()) {
        if (contacts.SearchEmail(o) || contacts.SearchBirthday(o) || contacts.SearchAddress(o)) {
            return contacts.retrieve();
        }
    }
    return null;
}
public Event searchByEventTiltle(String title) {
    if (!events.empty()) {
        if (events.findkey(title)) {
            return (Event) events.retrieve();
        } else {
            System.out.println("Event not found!");
        }
    } else {
        System.out.println("The events list is empty.");
    }
    return null;
}

/* 
    public  Event searchByEventTiltle(String title) {

        if (events.empty() == false) {
            events.findFirst();
            while (events.last() == false) {
                if (events.retrieve().getTitle().equalsIgnoreCase(title)) {
                    return events.retrieve();
                }
                events.findNext();
            }
            if (events.retrieve().getTitle().equalsIgnoreCase(title)) {
                return events.retrieve();
            }
        }
        return null;
    }
    */
/* 
    public void searchEventBycontact(String con) {


        if (!contacts.isEmpty()) {
            contacts.findFirst();

            for (int j = 0; j < contacts.size; j++) {
                if (contacts.retrieve().getContact_name().compareTo(con) == 0) {
                   
                    System.out.print("contact found!\n");
                    contacts.retrieve().events_contact.print();
                    
                    return;
              
                }//End if 
                
                contacts.findNext();
            }//end for 
        }
        System.out.println("There is no event in the contact!");
    }


*/
public void searchEventBycontact(String contactName) {
    if (!contacts.empty()) {
        if (contacts.findkey(contactName)) {
            Contact contact = (Contact) contacts.retrieve();
            System.out.println("Contact found!");
            
            if (!contact.events_contact.isEmpty()) {
                contact.events_contact.findFirst();
                for (int i = 0; i < contact.events_contact.size; i++) {
                    Event event = (Event) contact.events_contact.retrieve();
                    System.out.println(event.toString());
                    contact.events_contact.findNext();
                }
            } else {
                System.out.println("No events found for this contact!");
            }
        } else {
            System.out.println("Contact not found!");
        }
    } else {
        System.out.println("The contact list is empty.");
    }
}


 
    
    

    public void printContactsSharingFirstName(String firstName) {
        
                if (contacts.isEmpty())
            System.out.println("No Contacts found !");
                else{
        contacts.findFirst();
        for ( int i = 0 ; i < contacts.size ; i++)
        {
            String name = contacts.retrieve().getContact_name();
            String [] All = name.split(" ");

            if (All[0].compareTo(firstName) == 0)
                System.out.println(contacts.retrieve().toString() + "\n");
            contacts.findNext();
        }}
    }


    public void printContactsSharingEvent(String search) {

        if (events.isEmpty()) {
            System.out.println("No events found !");
            return;
        }//end if

        events.findFirst();

        for (int i = 1; i <= events.size; i++) {

            if (events.retrieve().compareTo(search) == 0) {
                System.out.println("Event found!");

                events.retrieve().toString();
                return;
            }
 
            events.findNext();

        }//end for

    }//end method
    
    public void printAlphebeticllyOrder() {

        if (events.empty()) {
            System.out.println("No events found !");
            return;
        }//end if
        

        System.out.println(events.toString());

        }//end for

    //end method
public static void displayMenu() {
    
    System.out.println("\nPlease choose an option:");
    System.out.println ("1. Add a contact");
    System.out.println ("2. Search for a contact");
    System.out.println ("3. Delete a contact");
    System.out.println ("4. Schedule an event");
    System.out.println ("5. Print event detail");
    System.out.println ("6. Print contacts by first name");
    System.out.println ("7. Print all events alphebetically");
    System.out.println ("8. Exit");
    
     System.out.println ("Enter your choice :");}
     

/* 
public Contact searchByName(String n) {
        if (contacts.isEmpty()) {
            return null;
        }

        contacts.findFirst();
        while (!contacts.last()) {
            if (contacts.retrieve().getContact_name().equalsIgnoreCase(n)) {
                return contacts.retrieve();
            }

            contacts.findNext();
        }//while

        if (contacts.retrieve().getContact_name().equalsIgnoreCase(n)) {
            return contacts.retrieve();
        }

        return null;
    }
*/ 

public Contact searchByName(String name) {
    if (!contacts.empty()) {
        if (contacts.findkey(name)) {
            return contacts.retrieve();
        } else {
            System.out.println("Contact not found!");
        }
    } else {
        System.out.println("The contacts list is empty.");
    }
    return null;
}




//معدل خلاص  هذا رقم 4
    public boolean conflict(Event e, Contact c) {
        LinkedList<Event> events_contact = c.events_contact;
        if (events_contact.isEmpty()) {
            return false;
        }
    
        events_contact.findFirst();
        for (int i = 0; i < events_contact.size; i++) {
            if (((events_contact.retrieve().getDate().compareTo(e.getDate()) == 0))
                    && (events_contact.retrieve().getTime().compareTo(e.getTime()) == 0))
                return true;
            events_contact.findNext();
        }
    
        return false;
    }



    
    public void schedule(Event e, String con) {
        Contact contact = contacts.searchByName(con);
        if (contact == null) {
            System.out.println("The contact does not exist");
            return;
        }
    
        boolean conflict = conflict(e, contact);
    
        if (contact != null && !conflict) {
            System.out.println("\nEvent scheduled successfully!\n");
    
            contact.events_contact.insertSort(e);
            e.addContactInEvent(contact);
            events.insert(e.getTitle(), e);
        } else {
            if (contact == null)
                System.out.println("\nThe contact does not exist");
            if (conflict)
                System.out.println("\nThere is a conflict with an existing event");
        }
    }
    
 /* 
 public boolean conflict(Event e , Contact C){
 LinkedList<Event>events_contact = C.events_contact;
 if (events_contact.isEmpty()){
 return false;}
 events_contact.findFirst();
 for( int i = 0 ; i<events_contact.size ; i++ ){
 if(((events_contact.retrieve().getDate().compareTo(e.getDate())== 0 ) ) && (events_contact.retrieve().getTime().compareTo(e.getTime())== 0 ))
       return true;
 events_contact.findNext();
 }
 
return false;
 }

public void schedule(Event e, String con) {
        Contact contacts = searchByName(con);
        if(contacts==null){
        System.out.println("the contact not Exist");
        return;}
        boolean conflict = conflict(e, contacts);
        if(contacts!=null&& !conflict){
            System.out.println("\nEvent scheduled successfully!\n ");
        
        contacts.events_contact.insertSort(e);
        e.addContactInEvent(contacts);
        addEvent(e);
        }
        else{
       if(contacts==null) 
           System.out.println("\nthe contact not exit");
        if(conflict)
            System.out.println("\nthere's coflict");
            
    }}
*/
    void SearchSamefName(String fname) {
        contacts.SearchSameFirstName(fname);
    }

}

    

