
package finalds;

        

import java.util.Scanner;

public class FinalDS {

    public static phonebook p1 = new phonebook();

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
                            Contact c1 = p1.searchByNameOrPhone(input.nextLine());
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
                            Contact c2 = p1.searchByNameOrPhone(input.nextLine());

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
                            Contact c3 = p1.searchByEmailOrAddressOrBirthday(email2);

                            if (c3 != null) {
                                System.out.println("\nContact found:\n");
                                System.out.println(c3.toString());
                            } else {
                                System.out.println("\nContact not found.");
                            }

                            break;

                        case 4:
                            System.out.print("\nEnter the address: ");
                            input.nextLine();
                            String add = input.nextLine();
                           
                            Contact c4 = p1.searchByEmailOrAddressOrBirthday(add);

                            if (c4 != null) {
                                System.out.println("\nContact found:\n");
                                System.out.println(c4.toString());
                            } else {
                                System.out.println("\nContact not found.");
                            }
                            break;

                        case 5:
                            System.out.print("\nEnter the birthday: ");
                            input.nextLine();
                            String birth = input.nextLine();
                            Contact c5 = p1.searchByEmailOrAddressOrBirthday(birth);

                            if (c5 != null) {
                                System.out.println("\nContact found:\n");
                                System.out.println(c5.toString());
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



                    break;

                case 4:
                 System.out.println("Enter type:\n");
                    System.out.println("1. event");
                    System.out.println("2. appointment\n");
                    
                    System.out.print("Enter your choice: ");
                    
                    int ScheduleEA = input.nextInt();
                    

                    switch(ScheduleEA){
                        case 1:
        input.nextLine();
                System.out.print("\nEnter event title: ");
                String eventTitle = input.nextLine();
                System.out.print("Enter contact name: ");
                String contactName1 = input.nextLine();
                System.out.print("Enter event date: ");
                String eventDate = input.nextLine();
                System.out.print("Enter event Time: ");
                String eventTime = input.nextLine();
                System.out.print("Enter event location: ");
                String location = input.nextLine();

                Contact contactForEvent = new Contact(contactName1);
                Event event = new Event(eventTitle, eventDate, eventTime, location, true);
                p1.schedule(event, contactName1);

                    break;

                    case 2:
     input.nextLine();
                System.out.print("\nEnter appointment title: ");
                String eventTitle2 = input.nextLine();
                System.out.print("Enter contact name: ");
                String contactName2 = input.nextLine();
                System.out.print("Ent1er appointment date: ");
                String eventDate2 = input.nextLine();
                System.out.print("Enter appointment Time: ");
                String eventTime2 = input.nextLine();
                System.out.print("Enter appointment location: ");
                String location2 = input.nextLine();

                Contact contactForEvent2 = new Contact(contactName2);
                Event event2 = new Event(eventTitle2, eventDate2, eventTime2, location2,false);
                p1.schedule(event2, contactName2);

                    break;
                         
                default:
                    System.out.println("Invalid choice. Please select a valid option.");


                    }
                    break;

                    case 5:
                    System.out.println("Enter search criteria:");
                    System.out.println("1. Contact name");
                    System.out.println("2. Event title");
                    System.out.println("Enter your choice: ");
                    
                    
                    
                    int searchEvent = input.nextInt();
                    input.nextLine(); // Consume the newline character

                    
                    
                    switch (searchEvent) {
                        case 1:
                            System.out.print("Enter the contact name: ");
                            
                            String searchContactName = input.nextLine();
                            p1.searchEventBycontact(searchContactName);
                            break;
                
                        case 2:
                            System.out.print("Enter the event title: ");
                            String searchEventTitle = input.nextLine();
                            Event result = p1.searchByEventTiltle(searchEventTitle);
                            if (result != null)
                                System.out.println("\nEvent found!\n" + result.toString());
                            else
                                System.out.println("No Event found!");
                            break;
                
                        default:
                            System.out.println("Invalid choice. Please try again.");
                    }
                    break;
                

                case 6:
                    System.out.print("Enter the first name: ");
                    input.nextLine();
                    String searchFirstName = input.next();
                    p1.SearchSamefName(searchFirstName);

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

    
    

