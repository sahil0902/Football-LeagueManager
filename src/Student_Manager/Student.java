package Student_Manager;


public class Student implements Comparable<Student> {
    private String student_ID;

    // Constructor to initialize the student ID
    public Student(String student_ID) {
        this.student_ID = student_ID;
    }

    // toString method to return the string representation of the student object
    public String toString() {
        return "Student ID:" + this.student_ID + "\n";
    }

    // Method to return the student ID
    public String getStudentID() {
        return this.student_ID;
    }

    // Overridden compareTo method to compare two student objects based on their student IDs
    @Override
    public int compareTo(Student s) {
        return this.student_ID.compareTo(s.getStudentID());
    }

}
