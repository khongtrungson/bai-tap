package TH5.bai1;

public class Journalist extends Employee {
    private int articalNumber;
    public Journalist(String name, String newPaperName,int articalNumber) {
        super(name, newPaperName);
        this.articalNumber = articalNumber;
    }
    @Override
    public void printEmployeeCard() {
        System.out.println("[Journalist] Name: " + super.getName() + ", Published Articles: " + publishedArticles);
    }


}
