
import java.util.Scanner ;
public class phonebook {
 static LinkedList<Contact> contact ;
  static LinkedList<Contact> event ;
 public phonebook () {
this.contact = contact ;
this.event = event
}
 public boolean Search (Contact c) {
     if (contact.isEmpty()== false) {
 contact.findFirst();
 while (contact.last()== false) {
  if ((contact.retrieve().getContact_name().equalsIgnoreCase(c.getContact_name()))||
        (contact.retrieve().getPhoneNumber().equals(c.getPhoneNumber())))
           return true;
      contact.findNext(); }
      if ((contact.retrieve().getContact_name().equalsIgnoreCase(c.getContact_name()))||
        (contact.retrieve().getPhoneNumber().equals(c.getPhoneNumber())))
           return true;
      return true;
      }
     return false;}
 
public void addContact (Contact c) {
 if (Search(c)==false)
 
 contact.insert(c);   
    }
 
 
 
 

 
public void deleteContact (String con) {
if (contact.isEmpty()== false){

contact.findFirst();
while (contact.last()== false) {
    if (contact.retrieve().getContact_name().equalsIgnoreCase(con)){
    contact.delete();
    System.out.println ("contact" + con + " has been deleted successfully");
    return;
    }
    contact.findNext();
}
  if (contact.retrieve().getContact_name().equalsIgnoreCase(con)=0){
    contact.delete();
    System.out.println ("contact" + con + " has been deleted successfully");
    return; }
System.out.println ("The list is empty you can't delete it");
        return;
}}

public LinkedList<Contact> searchByEmail(String eml){ 
 LinkedList<Contact> eventByType = new LinkedList<Contact> ()  ;    
  if (contact.isEmpty()==false){
contact.findFirst();
while (contact.last()== false) {
    if (contact.retrieve().getEmailAddress().equalsIgnoreCase(eml)){
    eventByType.insert(contact.retrieve());
    contact.findNext();
    } }
        if (contact.retrieve().getEmailAddress().equalsIgnoreCase(eml))
         eventByType.insert(contact.retrieve());
}
 return eventByType ;
}
 
 public LinkedList<Contact> searchByAdress(String adrs){
      LinkedList<Contact> eventByType = new LinkedList<Contact> ()  ;    
  if (contact.isEmpty()==false){
contact.findFirst();
while (contact.last()== false) {
    if (contact.retrieve().getAddress().equalsIgnoreCase(adrs)){
    eventByType.insert(contact.retrieve());
    contact.findNext();
    } }
        if (contact.retrieve().getAddress().equalsIgnoreCase(adrs))
         eventByType.insert(contact.retrieve());
}
 return eventByType ;
}
 
 public LinkedList<Contact> searchByBirthday(String birth){
           LinkedList<Contact> eventByType = new LinkedList<Contact> ()  ;    
  if (contact.isEmpty()==false){
contact.findFirst();
while (contact.last()== false) {
    if (contact.retrieve().getBirthday().equals(birth)){
    eventByType.insert(contact.retrieve());
    contact.findNext();
    } }
       if (contact.retrieve().getAddress().equals(birth))
         eventByType.insert(contact.retrieve());
}
 return eventByType ;
}
 }
 
 
    public static void displayMenu () {
    do {
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
            
        
         
            
    
    } while(true);
}
}
