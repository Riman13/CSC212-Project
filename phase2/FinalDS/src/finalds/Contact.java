
package finalds;




    
    public class Contact implements Comparable<Contact> {

    //Attributeshhh
    private String Contact_name;
    private String phoneNumber;
    private String emailAddress;
    private String address;
    private String birthday;
    private String notes;
    LinkedList<Event> events_contact;

    //Constructor
    public Contact() {
        events_contact = new LinkedList<Event>();
    }

    //Constructor to initialize contact
    public Contact(String Contact_name, String phoneNumber, String emailAddress, String address, String birthday, String notes) {
        this.Contact_name = Contact_name;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
        this.address = address;
        this.birthday = birthday;
        this.notes = notes;
        events_contact = new LinkedList<Event>();
    }

    public Contact(String Contact_name) {
        this.Contact_name = Contact_name;
    }



        public boolean addEventInContact(Event e) {

            if (!events_contact.isEmpty()) {

                events_contact.findFirst();

                for (int i = 0; i < events_contact.size; i++) {

                    if ((events_contact.retrieve().getDate().compareTo(e.getDate()) == 0) && (events_contact.retrieve().getTime().compareTo(e.getTime()) == 0)) {
                        return false;
                    }

                    events_contact.findNext();

                } // END FOR , CHECK CONFLICT EVENT 
            }//End if
            events_contact.insertSort(e);
            return true;
        }



    public boolean removeEventFromContac(Event e) {
        if (events_contact.isEmpty()) {
            return false;
        }

        if (events_contact.search(e)) {
            events_contact.remove(e);
            return true;
        }
        return false;
    }

    // Getter methods to retrieve contact information
    public String getContact_name() {
        return Contact_name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public String getAddress() {
        return address;
    }

    public String getBirthday() {
        return birthday;
    }

    public String getNotes() {
        return notes;
    }

    // Setter methods to modify contact information
    public void setContact_name(String Contact_name) {
        this.Contact_name = Contact_name;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    // toString method
    public String toString() {
        String str = "\nContact Name: " + Contact_name
                + "\nPhone Number: " + phoneNumber
                + "\nEmail Address: " + emailAddress
                + "\nAddress: " + address
                + "\nBirthday: " + birthday
                + "\nNotes: " + notes;
            /*    + "\nEvents details:";

        events_contact.findFirst();
        for (int i = 0; i < events_contact.size; i++) {
            str += "\nEvent title: "+events_contact.retrieve().getTitle()  
                +"\nEvent date and time (MM/DD/YYYY HH:MM): "+ events_contact.retrieve().getDate()+"  "+ events_contact.retrieve().getTime() 
                +"\nEvent location: "+events_contact.retrieve().getLocation() +"\n";
            events_contact.findNext();
        }
        
                if( events_contact.size == 0)
            str+="\nThere is no Events\n ";*/
        return str;
    }
    
    public int compareTo(String s) {
        return Contact_name.compareTo(s);
    }

    public int compareTo(Contact c) {
        return Contact_name.compareTo(c.Contact_name);
    }


}//end class

    
