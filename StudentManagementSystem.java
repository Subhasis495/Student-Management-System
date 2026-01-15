package StudentManagementSystem;

import java.util.*;

public class StudentManagementSystem {
    static ArrayList<Student> students = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            try {
                System.out.println("\n--- Student Management System ---");
                System.out.println("1. Add Student");
                System.out.println("2. Display All Students");
                System.out.println("3. Search Student by ID");
                System.out.println("4. Update Student Marks");
                System.out.println("5. Remove Student by ID");
                System.out.println("6. Sort Students by Marks");
                System.out.println("7. Exit");
                System.out.print("Enter choice: ");

                int choice = sc.nextInt();

                switch (choice) {
                    case 1 -> addStudent();
                    case 2 -> displayStudents();
                    case 3 -> searchStudent();
                    case 4 -> updateMarks();
                    case 5 -> removeStudent();
                    case 6 -> sortStudents();
                    case 7 -> {
                        System.out.println("Exiting...");
                        return;
                    }
                    default -> System.out.println("Invalid choice!");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Try again.");
                sc.nextLine();
            }
        }
    }

    static void addStudent() {
        System.out.print("Enter ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Course: ");
        String course = sc.nextLine();

        System.out.print("Enter Marks: ");
        double marks = sc.nextDouble();

        Student s = new Student(id, name, course, marks);

        if (students.contains(s))
            System.out.println("Student with this ID already exists!");
        else {
            students.add(s);
            System.out.println("Student added successfully.");
        }
    }

    static void displayStudents() {
        if (students.isEmpty()) {
            System.out.println("No students found.");
            return;
        }
        students.forEach(System.out::println);
    }

    static void searchStudent() {
        System.out.print("Enter ID to search: ");
        int id = sc.nextInt();

        for (Student s : students) {
            if (s.getId() == id) {
                System.out.println(s);
                return;
            }
        }
        System.out.println("Student not found.");
    }

    static void updateMarks() {
        System.out.print("Enter ID: ");
        int id = sc.nextInt();

        for (Student s : students) {
            if (s.getId() == id) {
                System.out.print("Enter new marks: ");
                s.setMarks(sc.nextDouble());
                System.out.println("Marks updated.");
                return;
            }
        }
        System.out.println("Student not found.");
    }

    static void removeStudent() {
        System.out.print("Enter ID: ");
        int id = sc.nextInt();

        students.removeIf(s -> s.getId() == id);
        System.out.println("Student removed if ID existed.");
    }

    static void sortStudents() {
        students.sort(Comparator.comparingDouble(Student::getMarks));
        System.out.println("Students sorted by marks.");
    }
}

