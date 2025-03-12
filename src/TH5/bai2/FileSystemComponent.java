package TH5.bai2;

abstract class FileSystemComponent {
    protected String name;

    public FileSystemComponent(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract void open();
}
