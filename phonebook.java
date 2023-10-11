
import java.util.Scanner ;
public class phonebook {
 static LinkedList<Contact> contact ;
 public phonebook () {
this.Contact = Contact ;
}
 public boolean Search (Contact c) {
     if (!contact.isEmpty()) {
 contact.findFirst();
  if (contact.retrieve().getCongetContact_name().copmareTo(c.getContact_name())||
          contact.retrieve().getPhoneNumber().compareTO(c.getPhoneNumber())){
 }
 retun false ; }
public void addContact (Contact c) {
 if (Search(c)!=false)
 {contact.Adding(c);
 for (int i = ; )
 
 }   
    
    
}
 
 
 
 

 
public void deleteContact (String con) {
if (contact.isEmpty()){
System.out.println ("The list is empty you can't delete it");
        return;
}
contact.findFirst();
while (!contact.last()) {
    if (contact.retrieve().getCongetContact_name().equalsIgnoreCase(con)){
    contact.remove();
    System.out.println ("contact" + n + " has been deleted successfully");
    return;
    }
    contact.findNext();
}
  if (contact.retrieve().getCongetContact_name().equalsIgnoreCase(con)){
    contact.remove();
    System.out.println ("contact" + n + " has been deleted successfully");
    return;

}}

public LinkedList<Contact> searchByEmail(String eml){   
    
}
 
 public LinkedList<Contact> searchByAdress(String adrs){}
 
 public LinkedList<Contact> searchByBirthday(String birth){}
 
 
    public static void displayMenu () {
    Scanner input = new Scanner (System.in);
    System.out.println ("Welcome to the linked tree phonebook! \nPlease choose an option :");
    System.out.println ("1. Add a contact");
    System.out.println ("2. Search for a contact");
    System.out.println ("3. Delete a contact");
    System.out.println ("4. Schedule an event");
    System.out.println ("5. Print event detail");
    System.out.println ("6. Print contacts by first name");
    System.out.println ("7. Print all events alphebetically");
    System.out.println ("8. Exit");
     System.out.println ("Enter your choice :");
    int choice = input.nextInt();
    
    switch(choice)    
            case 1:
                
                break ;
                
            case 2 :
                break;
                
            case 3:
                break;
            
            case 4 :
                break;
                
            case 5:
                
                break ;
                
            case 6 :
                break;
                
            case 7:
                break;
                
                
            case 8:
                break; 
                
                
            default :
                break;
            
        
         
            
    
    }
}
}
