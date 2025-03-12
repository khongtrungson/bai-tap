package TH5.bai1;

import java.util.ArrayList;
import java.util.List;

public class Newspaper {
    private String name;
    private List<Employee> employees;

    public Newspaper(String name) {
        this.name = name;
        this.employees = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void addEmployee(Employee employee) {
        employees.add(employee);
        employee.setNewPaperName(name);
    }

    public void removeEmployee(Employee employee) {
        employees.remove(employee);
        employee.setNewPaperName("");
    }

    public void printAllEmployees() {
        System.out.println("Newspaper: " + name);
        for (Employee employee : employees) {
            employee.printEmployeeCard();
        }
    }
}
