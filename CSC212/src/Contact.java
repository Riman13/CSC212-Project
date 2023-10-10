import java.util.Scanner;

public class Contact implements Comparable<String> {
	//Attributes
	    private String Contact_name;
	    private String phoneNumber;
	    private String emailAddress;
	    private String address;
	    private String birthday;
	    private String notes;

	    //Constructor
	    public Contact() {
	    }
	    
		//Constructor to initialize contact
		    public Contact(String Contact_name, String phoneNumber, String emailAddress, String address, String birthday, String notes) {
		        this.Contact_name = Contact_name;
		        this.phoneNumber = phoneNumber;
		        this.emailAddress = emailAddress;
		        this.address = address;
		        this.birthday = birthday;
		        this.notes = notes;
		    }
		    
		    public Contact(Contact c) {
		        this.Contact_name = c.Contact_name;
		        this.phoneNumber = c.phoneNumber;
		        this.emailAddress = c.emailAddress;
		        this.address = c.address;
		        this.birthday = c.birthday;
		        this.notes = c.notes;
		    }

			@Override
			public int compareTo(String s) {
				return Contact_name.compareTo(s);
			}
			
			public int compareTo(Contact c) {
				return Contact_name.compareTo(c.Contact_name);
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
		        return "Contact Name: "+ Contact_name+
		               "/nPhone Number: "+ phoneNumber+
		               "/nEmail Address: " +emailAddress  +
		               "/nAddress: " +address  +
		               "/nBirthday: "+ birthday +
		               "/nNotes: "+ notes;

	}

}//end class

