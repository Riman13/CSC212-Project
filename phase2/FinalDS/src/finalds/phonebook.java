
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

        
        if (!contacts.isEmpty()&& contacts.search(c))
        {
                
                return false;
        }
        
        if (!contacts.isEmpty())
        {
            contacts.findFirst();
            for (int i = 0; i < contacts.size ; i++)
            {
                    if (contacts.retrieve().getPhoneNumber().compareTo(c.getPhoneNumber()) == 0)
                    {
                            
                            return false;
                    }
                    contacts.findNext();
            }
        }    

        
        contacts.insertSort(c);
           
        return true;
        
    
    
    }
    
    public  boolean addEvent(Event e) {
        if (events.search(e) == false) {
            events.insertSort(e);
            return true ;
        }
        else 
            return false ;
    }
    
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


    public  Event searchByEventTiltle(String title) {

        if (events.isEmpty() == false) {
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

        if (events.isEmpty()) {
            System.out.println("No events found !");
            return;
        }//end if
        


        events.findFirst();
        for (int i = 1; i <= events.size; i++) {
        	
         System.out.println("Event title:"+events.retrieve().getTitle());
         System.out.println("Event date and time (MM/DD/YYYY HH:MM):"+events.retrieve().getDate()+events.retrieve().getTime());
         System.out.println("Event location: "+events.retrieve().getLocation());
        
        events.findNext();

        }//end for

    }//end method
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

}
    

