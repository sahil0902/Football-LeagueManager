package PhonrBook;


import java.util.HashMap;
import java.util.Map;

public class PhoneBook {
    private Map<String, PhoneBookEntry> pb1;

    public PhoneBook() {

        this.pb1 = new HashMap();

    }

    /*
    Adds entry with new Name
     */
    public void addEntry(String Name, String Phone_Number, String email, String address) {

        PhoneBookEntry pb_1 = new PhoneBookEntry(Name, Phone_Number, email, address);
        pb1.put(Name, pb_1);
    }

    /*
    //  Updates the details of  an entry using its Name
    */
    public void ReplaceEntry(String Name, String Phone_Number, String email, String address) {

        PhoneBookEntry pb_1 = new PhoneBookEntry(Name, Phone_Number, email, address);
        pb1.replace(Name, pb_1);//Name is the key, so it can't be updated
    }
/*

Removes the entry using its name(Key)
 */
    public void RemoveEntry(String Name) {
        pb1.remove(Name);//it will remove an entry just by using its Name
    }

    /*
    This function can be used to find an entry a for replacing as well as to stop duplicate entries
    */
    public boolean containsName(String Name) {
        return pb1.containsKey(Name);
    }

    /*
    it will display all the details of entry using its key(Name)
     */
    public void searchEntry(String Name) {
        PhoneBookEntry entry = pb1.get(Name);
        if (entry != null) {
            String dottedLine = "-------------------";
            String dottedSide = "|";
            System.out.println(dottedLine);
            System.out.println(dottedSide + " Name: " + entry.getName() + " " + dottedSide);
            System.out.println(dottedSide + " Phone number: " + entry.getPhone_Number() + " " + dottedSide);
            System.out.println(dottedSide + " Email: " + entry.getEmail() + " " + dottedSide);
            System.out.println(dottedSide + " Address: " + entry.getAddress() + " " + dottedSide);
            System.out.println(dottedLine);

        } else // if it's not in the map
        {
            System.out.println("No entry found for that name.");
        }
    }

    public String toString() {
        String output = "------------\n";
        output += "PhoneBook\n";
        output += "------------\n";
        for (PhoneBookEntry value : pb1.values()) {
            output += "Name: " + value.getName() + "\n";
            output += "Phone number: " + value.getPhone_Number() + "\n";
            output += "Email: " + value.getEmail() + "\n";
            output += "Address: " + value.getAddress() + "\n";
            output += "------------\n";
        }
        return output;
    }

}
