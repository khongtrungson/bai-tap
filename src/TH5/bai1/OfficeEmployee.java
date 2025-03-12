package TH5.bai1;

public class OfficeEmployee extends Employee {
    private String position;

    public OfficeEmployee(String name, String newPaperName,String position) {
        super(name, newPaperName);
        this.position = position;
    }
    @Override
    public void printEmployeeCard() {
        System.out.println("[Office Employee] Name: " + super.getName() + ", Position: " + position);
    }
}
