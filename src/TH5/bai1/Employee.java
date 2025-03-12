package TH5.bai1;

public abstract class Employee {
    private String name;
    private String newPaperName;

    public Employee(String name, String newPaperName) {
        this.name = name;
        this.newPaperName = newPaperName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNewPaperName() {
        return newPaperName;
    }
    public abstract void printEmployeeCard();

    public void setNewPaperName(String newPaperName) {
        this.newPaperName = newPaperName;
    }
}
