import java.util.ArrayList;
import java.util.Scanner;

public class StudentSystem {
    public static void main(String[] args) {

        ArrayList<Student> list = new ArrayList<>();
        while (true) {
            System.out.println("-------------Welcome to this student management system!-------------");

            System.out.println("1: Add student information");
            System.out.println("2: Delete student information");
            System.out.println("3: Update student information");
            System.out.println("4: Query student information");
            System.out.println("5: Quit");
            System.out.println("Please enter your choice: ");

            Scanner scan = new Scanner(System.in);
            String choice = scan.next();

            switch (choice) {
                case "1" -> addStudent(list);
                case "2" -> deleteStudent(list);
                case "3" -> updateStudent(list);
                case "4" -> queryStudent(list);
                case "5" -> {
                        System.out.println("Quit");
                    System.exit(0);
                }
                default -> System.out.println("There is no such option, please enter your choice again.");
            }
        }


    }

    public static void addStudent(ArrayList<Student> list){
        System.out.println("Add student information");
        Scanner scanner = new Scanner(System.in);
        Student student = new Student();

        String id = null;
        while (true) {
            System.out.println("please enter student id:");
            id = scanner.next();
            if (contains(list, id)) {
                System.out.println("The student information already exists, please try again.");
            } else {
                student.setId(id);
                break;
            }
        }


        System.out.println("Please enter the student's name:");
        String name = scanner.next();
        student.setName(name);
        System.out.println("Please enter the student's age:");
        int age = Integer.valueOf(scanner.next());
        student.setAge(age);
        System.out.println("Please enter the student's address:");
        String address = scanner.next();
        student.setAddress(address);

        list.add(student);
        System.out.println("Student information added successfully!");



    }

    public static void deleteStudent(ArrayList<Student> list){
        System.out.println("Delete student information");
        System.out.println("Please enter the student id to delete:");

        Scanner scanner = new Scanner(System.in);
        String id = scanner.next();
        if (contains(list, id)) {
            list.remove(getIndex(list, id));
            System.out.println("The student with id " + id + " is successfully deleted!");
        } else {
            System.out.println("Id does not exist, failed to delete.");
        }


    }

    public static void updateStudent(ArrayList<Student> list){
        System.out.println("Update student information");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the student id to update student information:");
        String id = scanner.next();
        if (contains(list, id)) {
            int index = getIndex(list, id);
            Student stu = list.get(index);
            stu.setId(id);
            System.out.println("Please enter the student name:");
            String newName = scanner.next();
            stu.setName(newName);
            System.out.println("Please enter the student age:");
            int newAge = scanner.nextInt();
            stu.setAge(newAge);
            System.out.println("Please enter the student address:");
            String newAddress = scanner.next();
            stu.setAddress(newAddress);

        } else {
            System.out.println("Id does not exist, failed to update.");
        }

    }

    public static void queryStudent(ArrayList<Student> list){
        System.out.println("Query student information");
        if (list.size() == 0) {
            System.out.println("There is no student information in the current system, please add it and then check.");
            //end method
            return;
        }
        System.out.println("id\tname\tage\taddress");

        for (int i = 0; i < list.size(); i++) {


            Student student = list.get(i);
            System.out.println(student.getId() + "\t" + student.getName() + "\t" + student.getAge() + "\t" + student.getAddress());

        }


    }

    public static boolean contains(ArrayList<Student> list, String id) {
        for (int i = 0; i < list.size(); i++) {
            Student stu = list.get(i);
            if (id.equals(stu.getId())) {

                return true;
            }

        }
        return false;
        // method two
        // return getIndex(list, id) >= 0;
    }

    public static int getIndex(ArrayList<Student> list, String id) {

        for (int i = 0; i < list.size(); i++) {
            Student stu = list.get(i);
            if (id.equals(stu.getId())) {

                return i;
            }
        }
        return -1;
    }


}
