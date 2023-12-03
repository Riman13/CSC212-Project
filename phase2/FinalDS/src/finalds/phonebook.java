package finalds;

import java.util.Scanner;

public class phonebook {

    public static BST<String, Contact> contacts;
    public static BST<String, Event> events;

    //Constructor
    //Constructor
    public phonebook() {
        phonebook.contacts = new BST<String, Contact>();
        phonebook.events = new BST<String, Event>();
    }

//method add for event and contact
    public boolean addContact(Contact c) {

        if (!contacts.empty() && contacts.findkey(c.getContact_name())) {

            return false;
        }

        if (!contacts.empty() && (contacts.SearchPhone(c.getPhoneNumber()))) {
            return false;
        }

        if(contacts.insert(c.getContact_name(), c))
        return true;
        
        return false;

    }

    public boolean addEvent(Event e) {
        if (!events.empty() && events.findkey(e.getTitle())) {

            return false;
        }

        events.insert(e.getTitle(), e);

        return true;
    }



    public boolean removeContact(Contact c) {
        return contacts.removeKey(c.getContact_name());
    }

    public boolean removeEvent(Event e) {
        return events.removeKey(e.getTitle());
    }

    public void deleteContactWithEvents(String name) {

        if (!contacts.empty()) {
            if (contacts.findkey(name)) {
                Contact deletedContact = contacts.retrieve();
                contacts.removeKey(name);

                if (!deletedContact.events_contact.isEmpty()) {
                    deletedContact.events_contact.findFirst();
                    for (int i = 0; i < deletedContact.events_contact.size; i++) {
                        Event event = deletedContact.events_contact.retrieve();
                        if (events.findkey(event.getTitle())) {
                            Event updatedEvent = events.retrieve();
                            updatedEvent.removeContactFromEvent(deletedContact);

                            if (updatedEvent.contcts_Name.isEmpty()) {
                                events.removeKey(event.getTitle());
                                System.out.println("\nthe event has been deleted because it doesn't have any contacts.");
                            } else {
                                events.update(updatedEvent.getTitle(), updatedEvent);
                            }
                        }
                        deletedContact.events_contact.findNext();
                    }
                }

                System.out.println("\ncontact Info:\n " + deletedContact + "\nhas been deleted successfully");
            } else {
                System.out.println("Contact not found!");
            }
        } else {
            System.out.println("The contact list is empty.");
        }
    }


    public Contact searchByNameOrPhone(String c) {
        if (contacts.empty()) {
            return null;
        }

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


    public void searchEventBycontact(String contactName) {
        if (!contacts.empty()) {
            if (contacts.findkey(contactName)) {
                Contact contact = contacts.retrieve();
                System.out.println("\nContact found!\n");
                System.out.println("contact Name : " + contact.getContact_name());

                if (!contact.events_contact.isEmpty()) {
                    contact.events_contact.findFirst();
                    System.out.println("\nevents info: \n");
                    for (int i = 0; i < contact.events_contact.size; i++) {
                        Event event = contact.events_contact.retrieve();
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

    public Event searchByEventTiltle(String title) {
        if (!events.empty()) {
            if (events.findkey(title)) {
                return events.retrieve();
            } else {
                return null;
            }
        }

        return null;
    }


    public void printAlphebeticllyOrder() {

        if (!events.empty())
            System.out.println(events.toString());
        else
            System.out.println("No events found !");

    }//end for

    //end method
    public static void displayMenu() {

        System.out.println("\nPlease choose an option:");
        System.out.println("1. Add a contact");
        System.out.println("2. Search for a contact");
        System.out.println("3. Delete a contact");
        System.out.println("4. Schedule an event/appointment");
        System.out.println("5. Print event detail");
        System.out.println("6. Print contacts by first name");
        System.out.println("7. Print all events alphebetically");
        System.out.println("8. Exit");

        System.out.println("Enter your choice :");
    }



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


    public boolean conflict(Event e, Contact c) {
        LinkedList<Event> events_contact = c.events_contact;
        if (events_contact.isEmpty()) {
            return false;
        }

        events_contact.findFirst();
        for (int i = 0; i < events_contact.size; i++) {
            if (((events_contact.retrieve().getDate().compareTo(e.getDate()) == 0))
                    && (events_contact.retrieve().getTime().compareTo(e.getTime()) == 0)) {
                return true;
            }
            events_contact.findNext();
        }

        return false;
    }


    public void schedule(Event e, String con) {

        Contact c = new Contact();

        boolean event_Updated = false;
        boolean Added_Event_To_Contact = false;

        if (!contacts.empty() && contacts.findkey(con) == true) {
            c = contacts.retrieve();
            Added_Event_To_Contact = c.addEventInContact(e);

            if (Added_Event_To_Contact) {
                // event added to contact
                contacts.update(con, c);
                if (!events.empty() && events.findkey(e.title)) {
                    Event eventFound = events.retrieve();
                    if (eventFound.EventType && (eventFound.EventType == e.EventType) 
                            && (eventFound.date.compareTo(e.date)== 0 ) 
                            && (eventFound.time.compareTo(e.time)== 0 ))
                    {
                        eventFound.contcts_Name.insertSort(c);
                        events.update(eventFound.title, eventFound);
                        event_Updated = true;
                        
                    }
                    
                    else if (! eventFound.EventType && (eventFound.EventType == e.EventType) 
                            && (eventFound.date.compareTo(e.date)== 0 ) 
                            && (eventFound.time.compareTo(e.time)== 0 ))
                    {
                        System.out.println("\nCould not add more than contact for an appoinment");
                         c.removeEventFromContact(e);
                        return;                        
                    }
                }
                if (!event_Updated) {
                    e.contcts_Name.insertSort(c);
                    events.insert(e.title, e);
                }
                System.out.println("\nEvent/appoinment scheduled successfully!   ");
            } else {
                System.out.println("\nContact has conflict Event !  ");
            }
        } else {
            System.out.println("\nCantcat not found !");
        }

    }


    void SearchSamefName(String fname) {
        if (contacts.empty()) {
            System.out.println("\nContact not found!");
        } else {
            contacts.SearchSameFirstName(fname);
        }
    }

}
