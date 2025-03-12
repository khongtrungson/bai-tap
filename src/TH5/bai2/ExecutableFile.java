package TH5.bai2;

class ExecutableFile extends File {
    public ExecutableFile(String name) {
        super(name);
    }

    @Override
    public void open() {
        System.out.println("Executing program: " + name);
    }
}