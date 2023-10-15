

public class Contact implements Comparable<Contact> {

    //Attributes
    private String Contact_name;
    private String phoneNumber;
    private String emailAddress;
    private String address;
    private String birthday;
    private String notes;
    LinkedList<Event> events;

    //Constructor
    public Contact() {
        events = new LinkedList<Event>();
    }

    //Constructor to initialize contact
    public Contact(String Contact_name, String phoneNumber, String emailAddress, String address, String birthday, String notes) {
        this.Contact_name = Contact_name;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
        this.address = address;
        this.birthday = birthday;
        this.notes = notes;
        events = new LinkedList<Event>();
    }

    public Contact(String Contact_name) {
        this.Contact_name = Contact_name;
    }

    public int compareTo(String s) {
        return Contact_name.compareTo(s);
    }

    public int compareTo(Contact c) {
        return Contact_name.compareTo(c.Contact_name);
    }

    public boolean addEvent(Event e) {

        if (!events.isEmpty()) {

            events.findFirst();

            for (int i = 0; i < events.size; i++) {

                if ((events.retrieve().getDate().compareTo(e.getDate()) == 0)  && (events.retrieve().getTime().compareTo(e.getTime()) == 0)) {
                    return false;
                }

                events.findNext();

            } // END FOR , CHECK CONFLICT EVENT 
        }//End if
        events.insertSort(e);
        return true;
    }//End Method

    public boolean removeEvent(Event e) {
        if (events.isEmpty()) {
            return false;
        }

        if (events.search(e)) {
            events.remove(e);
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
        return "Contact Name: " + Contact_name
                + "/nPhone Number: " + phoneNumber
                + "/nEmail Address: " + emailAddress
                + "/nAddress: " + address
                + "/nBirthday: " + birthday
                + "/nNotes: " + notes;

    }

}//end class

