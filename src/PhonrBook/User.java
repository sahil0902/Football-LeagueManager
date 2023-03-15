package PhonrBook;

import java.util.Scanner;

public class User {
    private int Opt;

    // Getter and setter for Opt
    public int getOpt() {
        return Opt;
    }

    public void setOpt(int opt) {
        Opt = opt;
    }

    // Reads user input for Opt
    public static void UserInp(User user) {
        Scanner inp = new Scanner(System.in);

        int Opt = inp.nextInt();
        inp.nextLine();
        user.setOpt(Opt);
    }

    // Asks user for to perform different options on phone book
    public static void AskUSer(PhoneBook pp1, User user) {
        Scanner inp = new Scanner(System.in);

        String Name;
        String Phone_Number;
        String email;
        String address;

        System.out.println("Press 1 to Enter a Contact:");
        System.out.println("Press 2 To update your a contact ");
        System.out.println("Press 3 to remove a contact");
        System.out.println("Press 4 to find the details of a contact");
        System.out.println("Press 5 to Exit");

        UserInp(user);
        int Opt = user.getOpt();

        switch (Opt) {
            //adds Entry
            case 1:
                System.out.println("Enter Name:");
                Name = inp.nextLine();
                if (!pp1.containsName(Name))//to stop duplicate entries
                {
                    System.out.println("Enter PhoneNumber:");
                    Phone_Number = inp.nextLine();
                    System.out.println("Enter Email");
                    email = inp.nextLine();
                    System.out.println("Enter Address:");
                    address = inp.nextLine();
                    pp1.addEntry(Name, Phone_Number, email, address);
                } else//if a name already exists
                {
                    System.out.println("A contact with the name " + Name + " already exists.");
                }

                break;
            case 2:
                //updates an entry
                System.out.println("Enter the name of your Contact: ");
                Name = inp.nextLine();
                if (pp1.containsName(Name)) {
                    System.out.println("Found!!");
                    System.out.println("Enter PhoneNumber:");
                    Phone_Number = inp.nextLine();
                    System.out.println("Enter Email");
                    email = inp.nextLine();
                    System.out.println("Enter Address:");
                    address = inp.nextLine();
                    pp1.ReplaceEntry(Name, Phone_Number, email, address);
                } else  //if the entry doesn't exist
                {
                    System.out.println("This entry is not in your Phonebook!!\n");
                }
                break;
            case 3:
                //Removes entry
                System.out.println("Enter the name of your Contact:");
                Name = inp.nextLine();
                if (pp1.containsName(Name))//its checking if the name of the contact is present or not
                {
                    pp1.RemoveEntry(Name);
                    System.out.println("it has been removed!");

                } else {
                    System.out.println("The name is not in the list");//if the user enters an invalid contact name which isnt present in the list then this condition will be satisfied
                }
                break;
            case 4:
                //display details of an entry
                System.out.println("Entry the Name of your Contact: ");
                Name = inp.nextLine();
                pp1.searchEntry(Name);
                break;
            case 5:
                //exits the program
                System.out.println("Exiting the Program!!");
                break;
            default:
                //if the user inputs something else
                System.out.println("Invalid input!");
                break;
        }


    }

    public static void main(String[] args) {


        PhoneBook pp2 = new PhoneBook();
        User user = new User();

        while (true) {
            AskUSer(pp2, user);
            if (user.getOpt() == 5)//if the user enters 5 the program will end
            {
                break;
            }
            System.out.println(pp2);
        }
    }
}


