
public class phonebook {
 static LinkedList<Contact> contacts ;
  static LinkedList<Event> events ;
 public phonebook () {
this.contacts = contacts ;
this.events = events
}
 public boolean Search (Contact c) {
     if (contacts.isEmpty()== false) {
 contacts.findFirst();
 while (contacts.last()== false) {
  if ((contacts.retrieve().getContact_name().equalsIgnoreCase(c.getContact_name()))||
        (contacts.retrieve().getPhoneNumber().equals(c.getPhoneNumber())))
           return true;
      contacts.findNext(); }
      if ((contacts.retrieve().getContact_name().equalsIgnoreCase(c.getContact_name()))||
        (contacts.retrieve().getPhoneNumber().equals(c.getPhoneNumber())))
           return true;
      }
     return false;}
 
public void addContact (Contact c) {
 if (Search(c)==false)
 
 contacts.insert(c);   
    }
 

public void deleteContactwithEvents (String con) {
if (contacts.isEmpty()== false){

contacts.findFirst();
while (contacts.last()== false) {
    if (contacts.retrieve().getContact_name().equalsIgnoreCase(con)){
    contacts.delete();
    System.out.println ("contact" + con + " has been deleted successfully");
    return;
    }
    contacts.findNext();
}
  if (contacts.retrieve().getContact_name().equalsIgnoreCase(con)){
    contacts.delete();
    System.out.println ("contact" + con + " has been deleted successfully");
    return; } }
  else
System.out.println ("The list is empty you can't delete it");
        return;
}




public LinkedList<Contact> searchByEmail(String eml){ 
 LinkedList<Contact> eventByType = new LinkedList<Contact> ()  ;    
  if (contacts.isEmpty()==false){
contacts.findFirst();
while (contacts.last()== false) {
    if (contacts.retrieve().getEmailAddress().equalsIgnoreCase(eml)){
    eventByType.insert(contacts.retrieve());
    contacts.findNext();
    } }
        if (contacts.retrieve().getEmailAddress().equalsIgnoreCase(eml))
         eventByType.insert(contacts.retrieve());
}
 return eventByType ;
}
 
 public LinkedList<Contact> searchByAdress(String adrs){
      LinkedList<Contact> eventByType = new LinkedList<Contact> ()  ;    
  if (contacts.isEmpty()==false){
contacts.findFirst();
while (contacts.last()== false) {
    if (contacts.retrieve().getAddress().equalsIgnoreCase(adrs)){
    eventByType.insert(contacts.retrieve());
    contacts.findNext();
    } }
        if (contacts.retrieve().getAddress().equalsIgnoreCase(adrs))
         eventByType.insert(contacts.retrieve());
}
 return eventByType ;
}
 
 public LinkedList<Contact> searchByBirthday(String birth){
           LinkedList<Contact> eventByType = new LinkedList<Contact> ()  ;    
  if (contacts.isEmpty()==false){
contacts.findFirst();
while (contacts.last()== false) {
    if (contacts.retrieve().getBirthday().equals(birth)){
    eventByType.insert(contacts.retrieve());
    contacts.findNext();
    } }
       if (contacts.retrieve().getAddress().equals(birth))
         eventByType.insert(contacts.retrieve());
}
 return eventByType ;
}
public Event searchByEventTiltle(String title){
            
  if (events.isEmpty()==false){
events.findFirst();
while (events.last()== false) {
    if (events.retrieve().getTitle().equalsIgnoreCase(title))
        return events.retrieve();
    events.findNext();
     }
    if (events.retrieve().getTitle().equalsIgnoreCase(title)){
        return events.retrieve();
}
}
  return null ;
}
public LinkedList<Event> searchEventBycontact(String eve){

}

public void schedule (Contact ev, Event r){
   if (Search(ev)==true &&ev.addEvent(r)== true)
    System.out.println("schedulling contact" + ev.getContact_name() + "" + r.getTitle());
   else{
       if (Search(ev)== false) 
         System.out.println("contact does't exit");
       if (ev.addEvent(r)== false)
         System.out.println("there's conflict");
   } }

public static void printContactsSharingFirstName( String firstName){

if (contact.isEmpty()){
System.out.println("No Contacts found !");
return;}


String name;
int j;

if(!contact.isEmpty()){
    
contact.findFirst();

for( int i = 1 ; i<= contact.size ; i++){

name = contact.retrieve().getContact_name();


j = name.indexOf(" ");
name = name.substring(j);

if(name.equalsIgnoreCase(firstName)){
    
System.out.println("Contact found!");
System.out.println(contact.retrieve().toString() + "\n");
}//End inner if 

contact.findNext();
}//end for


}//end if

}//End method 

public static void printContactsSharingEvent(Event e ){

if(events.isEmpty()){
System.out.println("No events found !");
return;
}//end if


events.findFirst();

for(int i =1 ; i <= events.size ; i++){

if (events.retrieve().compareTo(e) == 0)
events.retrieve().toString();

events.findNext();

}//end for

}//end method
 
 

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
