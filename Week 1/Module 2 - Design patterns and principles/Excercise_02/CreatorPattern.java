public class CreatorPattern {

    // File interface
    public interface File {
        void openFile();

        void closeFile();
    }

    // WordFile class
    public static class WordFile implements File {
        @Override
        public void openFile() {
            System.out.println("Opening Word File");
        }

        @Override
        public void closeFile() {
            System.out.println("Closing Word File");
        }
    }

    // PdfFile class
    public static class PdfFile implements File {
        @Override
        public void openFile() {
            System.out.println("Opening PDF File");
        }

        @Override
        public void closeFile() {
            System.out.println("Closing PDF File");
        }
    }

    // ExcelFile class
    public static class ExcelFile implements File {
        @Override
        public void openFile() {
            System.out.println("Opening Excel File");
        }

        @Override
        public void closeFile() {
            System.out.println("Closing Excel File");
        }
    }

    // FileCreator abstract class
    public static abstract class FileCreator {
        public abstract File createFile();
    }

    // WordFileCreator class
    public static class WordFileCreator extends FileCreator {
        @Override
        public File createFile() {
            return new WordFile();
        }
    }

    // PdfFileCreator class
    public static class PdfFileCreator extends FileCreator {
        @Override
        public File createFile() {
            return new PdfFile();
        }
    }

    // ExcelFileCreator class
    public static class ExcelFileCreator extends FileCreator {
        @Override
        public File createFile() {
            return new ExcelFile();
        }
    }

    // Test the Factory Method Implementation
    public static void main(String[] args) {
        FileCreator wordCreator = new WordFileCreator();
        File wordFile = wordCreator.createFile();
        wordFile.openFile();
        wordFile.closeFile();

        FileCreator pdfCreator = new PdfFileCreator();
        File pdfFile = pdfCreator.createFile();
        pdfFile.openFile();
        pdfFile.closeFile();

        FileCreator excelCreator = new ExcelFileCreator();
        File excelFile = excelCreator.createFile();
        excelFile.openFile();
        excelFile.closeFile();
    }
}
