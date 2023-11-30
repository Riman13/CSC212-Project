
package finalds;





    
    public class Event implements Comparable<Event> {

    private String Title;
    private String date;
    private String time;
    private String location;
    LinkedList<Contact> contcts_Name;

    public Event(String Title, String date, String time, String location, Contact c) {
        this.Title = Title;
        this.date = date;
        this.time = time;
        this.location = location;
        contcts_Name = new LinkedList<Contact>();
        this.addContactInEvent(c);
    }

    public Event() {
        this.Title = "";
        this.date = "";
        this.time = "";
        this.location = "";
        contcts_Name = new LinkedList<Contact>();

    }

    public boolean addContactInEvent(Contact c) {


       if(contcts_Name.insertSort(c)) 
        return true;
       else
           return false;

    }

    public boolean removeContactFromEvent(Contact c) {

        Contact tmp = contcts_Name.remove(c);
        if (tmp != null) {
            return true;
        } else {
            return false;
        }

    }

    //setter and getter
    public String getTitle() {
        return Title;
    }

    public void setTitle(String Title) {
        this.Title = Title;
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

    @Override
    public String toString() {
        String str = "\nEvent title: " + Title
                + "\nEvent date and time (MM/DD/YYYY HH:MM): " + date+" " + time
                + "\nEvent location: " + location + "\n";
            /*    + "Contacts names:\n";

        contcts_Name.findFirst();
        for (int i = 0; i < contcts_Name.size; i++) {
            str = str+ contcts_Name.retrieve().getContact_name() + "\n";
            contcts_Name.findNext();
        }
        if( contcts_Name.size == 0)
            str+="\nThere is no Contacts ";*/
        return str;
    }

    public int compareTo(String s) {
        return this.Title.compareTo(s);
    }

    public int compareTo(Event e) {
        return this.Title.compareTo(e.Title);
    }

}
    

