package TH5.bai2;
class TextFile extends File {
    private String content;

    public TextFile(String name, String content) {
        super(name);
        this.content = content;
    }

    @Override
    public void open() {
        System.out.println("Opening text file: " + name);
        System.out.println("Content: " + content);
    }
}