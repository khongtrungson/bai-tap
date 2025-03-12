package TH5.bai2;

import java.util.ArrayList;
import java.util.List;

class Directory extends FileSystemComponent {
    private List<FileSystemComponent> components;

    public Directory(String name) {
        super(name);
        this.components = new ArrayList<>();
    }

    public void addComponent(FileSystemComponent component) {
        components.add(component);
    }

    public void removeComponent(FileSystemComponent component) {
        components.remove(component);
    }

    @Override
    public void open() {
        System.out.println("Opening directory: " + name);
        for (FileSystemComponent component : components) {
            System.out.println(" - " + component.getName());
        }
    }

    public List<FileSystemComponent> getAllFiles() {
        List<FileSystemComponent> files = new ArrayList<>();
        for (FileSystemComponent component : components) {
            if (component instanceof File) {
                files.add(component);
            } else if (component instanceof Directory) {
                files.addAll(((Directory) component).getAllFiles());
            }
        }
        return files;
    }
}