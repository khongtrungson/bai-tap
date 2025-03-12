package TH3;
enum Gender {
    MALE, FEMALE
}
class Person {
    private static int idCounter = 1;
    private final int id;
    private String name;
    private final int yearOfBirth;
    private Gender gender;
    private boolean isMarried;

    public Person(String name, int yearOfBirth, Gender gender, boolean isMarried) {
        this.id = idCounter++;
        this.name = name;
        this.yearOfBirth = yearOfBirth;
        this.gender = gender;
        this.isMarried = isMarried;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public boolean isMarried() {
        return isMarried;
    }

    public void setMarried(boolean isMarried) {
        this.isMarried = isMarried;
    }

    public void display() {
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Year of Birth: " + yearOfBirth);
        System.out.println("Gender: " + gender);
        System.out.println("Marital Status: " + (isMarried ? "Married" : "Single"));
        System.out.println("--------------------------");
    }
}
