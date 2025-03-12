package TH3;

import java.time.LocalDate;

class Employee extends Person {

    private LocalDate dateJoin;
    private String position;
    private double salaryLevel;
    private static double basicSalary;

    public Employee(int id, String name, int yearOfBirth, Gender gender, boolean isMarried, LocalDate dateJoin, String position, double salaryLevel) {
        super(name, yearOfBirth, gender, isMarried);

        this.dateJoin = dateJoin;
        this.position = position;
        this.salaryLevel = salaryLevel;
    }


    public double getIncome() {
        return salaryLevel * basicSalary;
    }

    public void setSalaryLevel(double salaryLevel) {
        this.salaryLevel = salaryLevel;
    }

    public static void setBasicSalary(double basicSalary) {
        Employee.basicSalary = basicSalary;
    }


    @Override
    public void display() {
        super.display();
        System.out.println("Date Join: " + dateJoin);
        System.out.println("Position: " + position);
        System.out.println("Income: " + getIncome());
        System.out.println("--------------------------");
    }
}

