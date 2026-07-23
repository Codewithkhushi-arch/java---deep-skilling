interface Image { void display(); }
class RealImage implements Image {
    private String filename;
    public RealImage(String filename) { this.filename = filename; loadFromDisk(); }
    private void loadFromDisk() { System.out.println("Loading " + filename); }
    public void display() { System.out.println("Displaying " + filename); }
}
class ProxyImage implements Image {
    private String filename;
    private RealImage realImage;
    public ProxyImage(String filename) { this.filename = filename; }
    public void display() {
        if(realImage == null) realImage = new RealImage(filename);
        realImage.display();
    }
}
public class ProxyPatternExample {
    public static void main(String[] args) {
        Image image = new ProxyImage("test.jpg");
        image.display(); // Loads and displays
        image.display(); // Only displays
    }
}

/*
Output:
Loading test.jpg
Displaying test.jpg
Displaying test.jpg
*/
