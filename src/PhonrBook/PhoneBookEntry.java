package PhonrBook;


public class PhoneBookEntry {

    private String address;
    private String Name;

    private String Phone_Number;
    private String email;

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }


    public String getPhone_Number() {
        return Phone_Number;
    }

    public void setPhone_Number(String phone_Number) {
        Phone_Number = phone_Number;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public PhoneBookEntry(String Name, String Phone_Number, String email, String address) {

        this.Name = Name;
        this.Phone_Number = Phone_Number;
        this.email = email;
        this.address = address;
    }

    /**
     * This method creates a String representation of
     * the object in a human friendly fashion.
     *
     * @return A String representation of the person
     * +
     */
    @Override
    public String toString() {
        return "" +
                "Name:" + Name + "\t|\t" +
                "Phone Number:" + Phone_Number + "\t|\t" +
                "Email:" + email + "\t|\t" +
                "Address:" + address + "\t|\t" +
                "\n";
    }
}
