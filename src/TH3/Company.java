package TH3;

import java.time.LocalDate;

class Company {
    private String name;
    private LocalDate dateCreate;
    private Employee[] employees = new Employee[10];
    private int employeeCount = 0;

    public Company(String name, LocalDate dateCreate) {
        this.name = name;
        this.dateCreate = dateCreate;
    }

    public String getName() {
        return name;
    }

    public void showListEmployees() {
        System.out.println("Employees in " + name + ":");
        for (int i = 0; i < employeeCount; i++) {
            employees[i].display();
        }
    }

    public void addNewEmployee(Employee e) {
        if (employeeCount < 10) {
            employees[employeeCount++] = e;
            System.out.println("Employee added successfully.");
        } else {
            info();
        }
    }
    public Employee getEmployeeById(int id) {
        for (int i = 0; i < employeeCount; i++) {
            if (employees[i].getId() == id) {
                return employees[i];
            }
        }
        return null;
    }

    public void info() {
        System.out.println("The company has reached the maximum number of employees.");
    }
}