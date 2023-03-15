package Student_Manager;


import java.util.Arrays;

public class Modules {

    private String ModuleID;
    // to store enrolled students
    private Student[] class_list;
    private Integer enrol;

    // Private field to store the number of unenrolled students
    private Integer unenrol;

    public Integer getEnrol()
    {
        return enrol;
    }

    public void setEnrol(Integer enrol)
    {
        this.enrol = enrol;
    }

    // Private field to store the number of enrolled students


    // Constructor to initialize the module ID and create an empty list of enrolled students
    public Modules(String ModuleID)
    {
        this.ModuleID = ModuleID;
        this.class_list = new Student[5];
        this.enrol = 0;
        this.unenrol = 0;
    }

    // Method to return the string representation of the module, including the module ID and the list of enrolled students
    public String toString() {
        String output = "";
        output += "Module\n";
        output += "ModuleID:" + this.ModuleID + "\n";
        for (int i = 0; i < this.enrol; i++) {
            output += this.class_list[i] + "\n";
        }
        return output;
    }

    // Method to enroll a student in the module
    public void enrol(Student s) {
        // Check if the student is already enrolled in the module
        if (search(s) == -1) {
            // Sort the list of enrolled students in ascending order by student ID

            // Add the student to the list of enrolled students
            this.class_list[this.enrol] = s;
            // Increment the number of enrolled students
            this.enrol += 1;
            Arrays.sort(class_list,0,enrol);
        } else {
            // Print a message if the student is already
            System.out.println("Already enrolled! So we cannot enroll\n" + s + " again to the course!!");
        }

    }



    // Method to search for a student in the list of enrolled students
    public int search(Student s) {
        // Loop through the list of enrolled students
        for (int i = 0; i < this.enrol; i++) {
            // Check if the student is in the list
            if (this.class_list[i].compareTo(s) == 0) {
                // Return the index of the student if found
                return i;
            }
        }
        // Return -1 if the student is not found in the list
        return -1;
    }

    public void unenrol(Student s) //method to unenrol a student from module
    {
        // Loop through the list of enrolled students
        for (int i = 0; i < this.enrol; i++) {
            // Check if the student is in the list
            if (this.class_list[i].compareTo(s) == 0) {
                // Shift the elements in the list to the left by one position to remove the student from the list
                for (int j = i; j < this.enrol - 1; j++) {
                    this.class_list[j] = this.class_list[j + 1];
                }
                // Decrement the number of enrolled students
                this.enrol -= 1;
            }
        }
    }


}




