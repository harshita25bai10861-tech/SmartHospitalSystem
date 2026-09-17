
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

public class AuditLogger {
    private static final String LOG_FILE = "hospital_audit.log";

    public static synchronized void logAllocation(String logMessage) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(LOG_FILE, true))) {
            writer.write(LocalDateTime.now() + " - " + logMessage);
            writer.newLine();
        } catch (IOException e) {
            System.err.println("File I/O Error: " + e.getMessage());
        }
    }
}
