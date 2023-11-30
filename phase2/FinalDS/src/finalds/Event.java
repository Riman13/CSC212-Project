
package finalds;





    
public class Event implements Comparable<Event> {
    String title;
    String date;
    String time;
    String location;
    boolean EventType;  // event true , appointment = false;
    LinkedList <Contact> contcts_Name;

    public Event(String title, String date, String time, String location, boolean t, Contact c) {
        this.title = title;
        this.date = date;
        this.time = time;
        this.location = location;
        this.EventType =t;
        this.contcts_Name = new LinkedList<Contact> ();
        this.addContactInEvent(c);
    }

    public Event() {
        this.title = "";
        this.date = null;
        this.time = "";
        this.location = "";
        this.EventType = true;
        this.contcts_Name = new LinkedList<Contact> ();
    }

    public boolean addContactInEvent(Contact c) {
             
    
        if ((this.EventType == true) || ((this.EventType == false)&&(contcts_Name.size == 0)))
            return contcts_Name.insertSort(c);
        
        System.out.println("Could not add more than contact for an appoinment");
        return false;
  

    }

    public boolean removeContactFromEvent(Contact c) {

        Contact tmp = contcts_Name.remove(c);
        if (tmp != null) 
            return true;
      
            return false;
        

    }

    //setter and getter

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public boolean isEventType() {
        return EventType;
    }

    public void setEventType(boolean EventType) {
        this.EventType = EventType;
    }

    public LinkedList<Contact> getContcts_Name() {
        return contcts_Name;
    }

    public void setContcts_Name(LinkedList<Contact> contcts_Name) {
        this.contcts_Name = contcts_Name;
    }
    




    @Override
    public String toString() {
        String EventT = (this.EventType == true)? "Event ": "Appoinment ";     
        String str = "\nEvent title: " + title +
                    "\nEvent date and time (MM/DD/YYYY HH:MM): " + date+" " + time +
                   "\nEvent location: " + location + "\n" +
                   "\nType: " + EventT + "\n" +
                    "\nContacts names:   \n" + contcts_Name.toString();
                
          return str;
    }
    
            public void Print() {
        String EventT = (this.EventType == true)? "Event ": "Appoinment ";     
        String str = "\nEvent title: " + title +
                    "\nEvent date and time (MM/DD/YYYY HH:MM): " + date + time +
                   "\nEvent location: " + location + "\n" +
                   "\nType: " + EventT + "\n" +
                    "\nContacts names:   \n"  + contcts_Name.toString();
                
            System.out.println(str);
    }
@Override
    public int compareTo(Event obj) {
        try {
            return (this.title.compareToIgnoreCase(obj.title));
        }
        catch (Exception e)
        {
             //To change body of generated methods, choose Tools | Templates.
            throw new UnsupportedOperationException("Not supported yet.");
        }
    }

    public boolean compareToSameEvent(Event obj) {
        try {
            return ((this.title.compareToIgnoreCase(obj.title) == 0) && 
                    (this.date.compareTo(obj.date) == 0) &&
                    (this.time.compareToIgnoreCase(obj.time) == 0) && (this.EventType == obj.EventType));
        }
        catch (Exception e)
        {
             //To change body of generated methods, choose Tools | Templates.
            throw new UnsupportedOperationException("Not supported yet.");
        }
    }
    
}
    

