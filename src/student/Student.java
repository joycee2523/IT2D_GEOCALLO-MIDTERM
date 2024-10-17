
package student;



import java.util.Scanner;

public class Student{

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String response;

        do {
            System.out.println("1. ADD");
            System.out.println("2. VIEW");
            System.out.println("3. UPDATE");
            System.out.println("4. DELETE");
            System.out.println("5. EXIT");

            System.out.print("Enter Action: ");
            int action = sc.nextInt();
           Student student = new Student();
            switch (action) {
                case 1:
                  student.addStudent();
                    break;
                case 2:
                    student.viewStudents();
                    break;
                case 3:
                    student.viewStudents();
                    student.updateStudent();
                    student.viewStudents();
                    break;
                case 4:
                    student.viewStudents();
                    student.deleteStudent();
                    student.viewStudents();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }

            System.out.print("Do you want to continue? (yes/no): ");
            response = sc.next();
        } while (response.equalsIgnoreCase("yes"));

        System.out.println("Thank you, See you soon!");
    }

    public void addStudent() {
        Scanner sc = new Scanner(System.in);
        config conf = new config();
        System.out.print("Name: ");
        String name = sc.next();
        System.out.print("Age: ");
        int age = sc.nextInt();
        System.out.print("Email: ");
        String email = sc.next();
        System.out.print("Address: ");
        String address = sc.next();
        System.out.print("Phone Number: ");
        String phoneNumber = sc.next();

        String sql = "INSERT INTO tbl_students (name, age, email, address, phone_number) VALUES (?, ?, ?, ?, ?)";
        conf.addStudent(sql, name, age, email, address, phoneNumber);
    }

    public void viewStudents() {
        config conf = new config();
        String query = "SELECT * FROM tbl_students";
        String[] headers = {"ID", "Name", "Age", "Email", "Address", "Phone Number"};
        String[] columns = {"id", "name", "age", "email", "address", "phone_number"};
        conf.viewStudents(query, headers, columns);
    }

    public void updateStudent() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Student ID to update: ");
        int id = sc.nextInt();
        System.out.print("New Name: ");
        String name = sc.next();
        System.out.print("New Age: ");
        int age = sc.nextInt();
        System.out.print("New Email: ");
        String email = sc.next();
        System.out.print("New Address: ");
        String address = sc.next();
        System.out.print("New Phone Number: ");
        String phoneNumber = sc.next();

        String qry = "UPDATE tbl_students SET name = ?, age = ?, email = ?, address = ?, phone_number = ? WHERE id = ?";
        config conf = new config();
        conf.updateStudent(qry, name, age, email, address, phoneNumber, id);
        System.out.println("Student updated successfully.");
    }

    public void deleteStudent() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Student ID to delete: ");
        int id = sc.nextInt();

        String sql = "DELETE FROM tbl_student WHERE id = ?";
        config conf = new config();
        conf.deleteStudent(sql, id);
        System.out.println("Student deleted successfully.");
    }
}
