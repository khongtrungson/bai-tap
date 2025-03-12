package TH3;

import java.time.LocalDate;

public class Test {
    public static void main(String[] args) {
        Employee.setBasicSalary(5000);
        Company company = new Company("A", LocalDate.now());

        Employee e1 = new Employee(1, "John Doe", 1990, Gender.MALE, false, LocalDate.now(), "Developer", 1.2);
        Employee e2 = new Employee(2, "Jane Smith", 1985, Gender.FEMALE, true, LocalDate.now(), "Manager", 2.0);

        company.addNewEmployee(e1);
        company.addNewEmployee(e2);

        company.showListEmployees();

        System.out.println("\nDetails of Employee with ID 1:");
        Employee emp = company.getEmployeeById(1);
        if (emp != null) {
            emp.display();
        } else {
            System.out.println("Employee not found.");
        }
    }
}
