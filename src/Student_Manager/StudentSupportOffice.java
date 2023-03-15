package Student_Manager;



public class StudentSupportOffice {
    public static void main(String[] args) {
        // Creates five Student objects
        Student s1 = new Student("U0000001");
        Student s2 = new Student("U0000002");
        Student s3 = new Student("U0000003");
        Student s4 = new Student("U0000004");
        Student s5 = new Student("U0000005");

        // Creates three Modules objects
        Modules m1 = new Modules("CIS2206");
        Modules m2 = new Modules("CIS2360");
        Modules m3 = new Modules("CIS2205");

        // Enrolls students in module m1
        m1.enrol(s5);
        //m1.enrol(s1);

        m1.enrol(s1);

        // Print the list of enrolled students in m1
        System.out.println("First batch of Module1: CIS2206 ");
        System.out.println(m1);

        // Unrolls s5 from m1
        m1.unenrol(s5);

        // Enrolls s3 and s4 in m1
        m1.enrol(s3);
        m1.enrol(s4);

        // Prints the updated list of enrolled students in m1
        System.out.println("2nd batch of Module1: CIS2206 ");
        System.out.println(m1);

        // Enrolls students in module m2
        m2.enrol(s1);
        m2.enrol(s4);
        m2.enrol(s3);

        // Prints the list of enrolled students in m2
        System.out.println("First batch of Module2: CIS2360 ");
        System.out.println(m2);

        // Enrolls s5 and s2 in m2
        m2.enrol(s5);
        m2.enrol(s2);

        // Prints the updated list of enrolled students in m2
        System.out.println("2nd batch of Module2: CIS2360");
        System.out.println(m2);

        // Enrolls students in module m3
        m3.enrol(s5);
        m3.enrol(s2);
        m3.enrol(s4);

        // Prints the list of enrolled students in m3
        System.out.println("First batch of Module3: CIS2205 ");
        System.out.println(m3);

        // unenrols s2 from m3
        m3.unenrol(s2);

        // Unenrolls s5 from m3
        m3.unenrol(s5);

        // Enroll s3 and s4 in m3
        m3.enrol(s3);
        // m3.enrol(s4);

        // Enrolls s1 in m3
        m3.enrol(s1);

        // Prints the updated list of enrolled students in m3
        System.out.println("2nd batch of Module3: CIS2205 ");
        System.out.println(m3);
    }
}

