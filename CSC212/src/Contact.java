import java.util.Date;

public class Contact {
	
	 private String name;
	    private String phoneNumber;
	    private String emailAddress;
	    private String address;
	    private Date birthday;
	    private String notes;

		//Constructor to initialize contact
		    public Contact(String name, String phoneNumber, String emailAddress, String address, Date birthday, String notes) {
		        this.name = name;
		        this.phoneNumber = phoneNumber;
		        this.emailAddress = emailAddress;
		        this.address = address;
		        this.birthday = birthday;
		        this.notes = notes;
		    }

		     // Getter methods to retrieve contact information

		    public String getName() {
		        return name;
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

		    public Date getBirthday() {
		        return birthday;
		    }

		    public String getNotes() {
		        return notes;
		    }

		     // Setter methods to modify contact information
		    public void setName(String name) {
				this.name = name;
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

			public void setBirthday(Date birthday) {
				this.birthday = birthday;
			}

			public void setNotes(String notes) {
				this.notes = notes;
			}


		    // toString method

		    public String toString() {
		        return "Name: "+ name+
		               "/nPhone Number: "+ phoneNumber+
		               "/nEmail Address: " +emailAddress  +
		               "/nAddress: " +address  +
		               "/nBirthday: "+ birthday +
		               "/nNotes: "+ notes;

	}

}
