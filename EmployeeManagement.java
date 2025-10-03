import java.io.*;
import java.util.Scanner;

class Employee {
    int id;
    String name;
    double salary;

    Employee(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public String toString() {
        return id + "," + name + "," + salary;
    }
}

public class EmployeeManagement {
    static final String FILE_NAME = "employees.txt";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            System.out.println("1. Add Employee");
            System.out.println("2. View Employees");
            System.out.println("3. Exit");
            choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1 -> addEmployee(sc);
                case 2 -> viewEmployees();
                case 3 -> System.out.println("Exiting...");
                default -> System.out.println("Invalid choice");
            }
        } while (choice != 3);
        sc.close();
    }

    private static void addEmployee(Scanner sc) {
        try (FileWriter fw = new FileWriter(FILE_NAME, true);
             BufferedWriter bw = new BufferedWriter(fw)) {
            int id = sc.nextInt();
            sc.nextLine();
            String name = sc.nextLine();
            double salary = sc.nextDouble();
            Employee emp = new Employee(id, name, salary);
            bw.write(emp.toString());
            bw.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void viewEmployees() {
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                System.out.println("ID: " + parts[0] + " | Name: " + parts[1] + " | Salary: " + parts[2]);
            }
        } catch (IOException e) {
            System.out.println("No employees found");
        }
    }
}
