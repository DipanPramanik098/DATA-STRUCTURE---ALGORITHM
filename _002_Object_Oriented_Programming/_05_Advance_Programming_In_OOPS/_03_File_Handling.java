import java.io.*;   // Importing all necessary IO classes

public class _03_File_Handling {

    public static void main(String[] args) {

        // File path (stored in same project directory)
        String filePath = "example.txt";

        // ==============================
        // 1️⃣ CREATE A FILE
        // ==============================
        try {
            File file = new File(filePath);

            // createNewFile() creates file if it doesn't exist
            if (file.createNewFile()) {
                System.out.println("File created successfully: " + file.getName());
            } else {
                System.out.println("File already exists.");
            }

        } catch (IOException e) {
            System.out.println("Error while creating file.");
            e.printStackTrace();
        }


        // ==============================
        // 2️⃣ WRITE TO FILE (Overwrite Mode)
        // ==============================
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {

            // Writing text to file
            writer.write("Hello, this is File Handling in Java.");
            writer.newLine();  // Moves to next line
            writer.write("This line is written using BufferedWriter.");

            System.out.println("Data written successfully (Overwrite Mode).");

        } catch (IOException e) {
            System.out.println("Error while writing to file.");
            e.printStackTrace();
        }


        // ==============================
        // 3️⃣ APPEND DATA TO FILE
        // ==============================
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {

            // true enables append mode
            writer.newLine();
            writer.write("This line is appended to the file.");

            System.out.println("Data appended successfully.");

        } catch (IOException e) {
            System.out.println("Error while appending to file.");
            e.printStackTrace();
        }


        // ==============================
        // 4️⃣ READ FROM FILE
        // ==============================
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {

            String line;
            int lineNumber = 1;

            System.out.println("\nReading file content:");

            // readLine() reads file line by line
            while ((line = reader.readLine()) != null) {
                System.out.println("Line " + lineNumber + ": " + line);
                lineNumber++;
            }

        } catch (IOException e) {
            System.out.println("Error while reading file.");
            e.printStackTrace();
        }


        // ==============================
        // 5️⃣ CHECK FILE PROPERTIES
        // ==============================
        File file = new File(filePath);

        if (file.exists()) {

            System.out.println("\nFile Properties:");
            System.out.println("File Name: " + file.getName());
            System.out.println("Absolute Path: " + file.getAbsolutePath());
            System.out.println("File Size (bytes): " + file.length());
            System.out.println("Readable: " + file.canRead());
            System.out.println("Writable: " + file.canWrite());

        } else {
            System.out.println("File does not exist.");
        }


        // ==============================
        // 6️⃣ SIMPLE LOGGING FUNCTION
        // ==============================
        logMessage("Application Started");
        logMessage("Performing file operations...");
        logMessage("Application Ended");


        // ==============================
        // 7️⃣ DELETE FILE (Optional)
        // ==============================
        /*
        if (file.delete()) {
            System.out.println("File deleted successfully.");
        } else {
            System.out.println("Failed to delete file.");
        }
        */
    }


    // ==========================================
    // LOGGING METHOD (APPEND MODE)
    // ==========================================
    public static void logMessage(String message) {

        String logFile = "application.log";

        // try-with-resources ensures file is automatically closed
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(logFile, true))) {

            writer.write(message);
            writer.newLine();

        } catch (IOException e) {
            System.out.println("Logging failed: " + message);
        }
    }
}