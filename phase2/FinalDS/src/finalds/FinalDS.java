
package finalds;

        
import java.util.Scanner;

public class FinalDS {

    public static phonebook p1 = new phonebook();
    static LinkedList<Contact> c3 = new LinkedList<Contact>();

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("Welcome to the linked tree phonebook!");
        while (true) {
            phonebook.displayMenu();
            int choice = input.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter the contact's name: ");
                    input.nextLine();
                    String contactName = input.nextLine();

                    System.out.print("Enter the contact's phone number: ");
                    String phoneNumber = input.nextLine();

                    System.out.print("Enter the contact's email address: ");
                    String emailAddress = input.nextLine();

                    System.out.print("Enter the contact's address: ");
                    String address = input.nextLine();

                    System.out.print("Enter the contact's birthday: ");
                    String birthday = input.nextLine();

                    System.out.print("Enter any notes for the contact: ");
                    String notes = input.nextLine();

                    Contact n1 = new Contact(contactName, phoneNumber, emailAddress, address, birthday, notes);

                    if (p1.addContact(n1)) {
                        System.out.println("\nContact added successfully!");
                    } else {
                        System.out.println("\nContact already exist!");
                    }

                    break;

                case 2:

                    System.out.println("Enter search criteria:");
                    System.out.println("1. Name");
                    System.out.println("2. Phone Number");
                    System.out.println("3. Email Address");
                    System.out.println("4. Address");
                    System.out.println("5. Birthday");
                    System.out.print("Enter your choice: ");
                    int choiceSearch = input.nextInt();

                    switch (choiceSearch) {

                        case 1:

                            System.out.print("\nEnter the contact's name: ");
                            input.nextLine();
                            Contact c1 = p1.SearchsearchByNameOrPhone(input.nextLine());
                            if (c1 != null) {
                                System.out.println("\nContact found!\n");
                                System.out.println(c1.toString());
                            } else {
                                System.out.println("\nContact not found.");
                            }
                            break;

                        case 2:

                            System.out.print("\nEnter the contact's phone number: ");
                            input.nextLine();
                            Contact c2 = p1.SearchsearchByNameOrPhone(input.nextLine());

                            if (c2 != null) {
                                System.out.println("\nContact found:\n" + c2.toString());
                            } else {
                                System.out.println("\nContact not found.");
                            }
                            break;

                        case 3:
                            System.out.print("\nEnter the email address: ");
                            input.nextLine();
                            String email2 = input.nextLine();
                            c3 = p1.searchByEmailorAdressOrBirthday(email2);

                            if (!c3.isEmpty()) {
                                System.out.println("\nContact found:\n");
                                c3.print();
                            } else {
                                System.out.println("\nContact not found.");
                            }

                            break;

                        case 4:
                            System.out.print("\nEnter the address: ");
                            input.nextLine();
                            String add = input.nextLine();
                           
                            c3 = p1.searchByEmailorAdressOrBirthday(add);

                            if (!c3.isEmpty()) {
                                System.out.println("\nContact found:\n");
                                c3.print();
                            } else {
                                System.out.println("\nContact not found.");
                            }
                            break;

                        case 5:
                            System.out.print("\nEnter the birthday: ");
                            input.nextLine();
                            String birth = input.nextLine();
                            c3 = p1.searchByEmailorAdressOrBirthday(birth);

                            if (!c3.isEmpty()) {
                                System.out.println("\nContact found:\n");
                                c3.print();
                            } else {
                                System.out.println("\nContact not found.");
                            }
                            break;
                    }//second switch
                    break;

                case 3://delete
                    System.out.print("\nEnter the contact name: ");
                    input.nextLine();
                    Contact cc = new Contact();
                    // cc.setContact_name(input.nextLine());
                    p1.deleteContactWithEvents(input.nextLine());

                  /*  if (p1.removeContact(cc)) {
                        System.out.print("\nContacte deleted succsecfilly\n ");
                    } else {
                        System.out.print("\nContacte was not found\n ");
                    }*/

                    break;

                case 4:
                    input.nextLine();
                    System.out.print("Enter event title: ");
                    String eventT = input.nextLine();
                    System.out.print("Enter contact name: ");
                    String ContactN = input.nextLine();
                    System.out.print("Enter event date: ");
                    String dateEvent = input.nextLine();
                    System.out.print("Enter event Time: ");
                    String eventTime = input.nextLine();
                    System.out.print("Enter event location: ");
                    String loc = input.nextLine();

                    Contact c3 = new Contact(ContactN);

                    Event e = new Event(eventT, dateEvent, eventTime, loc, c3);
                    p1.schedule(e, ContactN);

                    break;

                case 5:
                    System.out.println("Enter search criteria:");
                    System.out.println("1. Contact name");
                    System.out.println("2. Event title");
                    System.out.println("Enter your choice: ");
                    int searchEvent = input.nextInt();

                    switch (searchEvent) {
                        case 1:
                            System.out.print("Enter the contact name: ");
                            input.nextLine();
                            String searchContactName = input.nextLine();
                            p1.searchEventBycontact(searchContactName);
                            

                            break;

                        case 2:
                            System.out.print("Enter the event title: ");
                            input.nextLine();
                            String searchEventTitle = input.nextLine();
                            Event result =p1.searchByEventTiltle(searchEventTitle);
                            if ( result != null)
                            System.out.println("Event found!\n" + result.toString());
                            else
                            System.out.println("No Event found!" );
                                

                            break;
                        default:
                            System.out.println("Invalid choice. Please try again.");

                    }
                    break;

                case 6:
                    System.out.print("Enter the first name: ");
                    input.nextLine();
                    String searchFirstName = input.next();
                    p1.printContactsSharingFirstName(searchFirstName);

                    break;
                case 7:

                    p1.printAlphebeticllyOrder();

                    break;

                case 8:
                    System.out.println("Goodbye!");
                    return;

                    
                default:
                    System.out.println("Invalid choice. Please select a valid option.");

            }//switch   

        }//while

    }//main

}//class

    
    

