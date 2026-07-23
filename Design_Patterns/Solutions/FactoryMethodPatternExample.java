interface Document { void open(); }
class WordDocument implements Document { public void open() { System.out.println("Opening Word document..."); } }
class PdfDocument implements Document { public void open() { System.out.println("Opening PDF document..."); } }
class ExcelDocument implements Document { public void open() { System.out.println("Opening Excel document..."); } }

abstract class DocumentFactory { abstract Document createDocument(); }
class WordFactory extends DocumentFactory { Document createDocument() { return new WordDocument(); } }
class PdfFactory extends DocumentFactory { Document createDocument() { return new PdfDocument(); } }
class ExcelFactory extends DocumentFactory { Document createDocument() { return new ExcelDocument(); } }

public class FactoryMethodPatternExample {
    public static void main(String[] args) {
        DocumentFactory factory = new WordFactory();
        Document doc = factory.createDocument();
        doc.open();
    }
}

/*
Output:
Opening Word document...
*/
