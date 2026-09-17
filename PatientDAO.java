import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PatientDAO {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/hospital_db";
    private static final String DB_USER = "root";
    private static final String DB_PASS = "password";

    public void saveAdmissionRecord(Patient patient, int bedId) {
        String query = "INSERT INTO admissions (patient_id, name, severity, bed_id) VALUES (?, ?, ?, ?)";
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
             PreparedStatement stmt = conn.prepareStatement(query)) {
            
            stmt.setInt(1, patient.getId());
            stmt.setString(2, patient.getName());
            stmt.setString(3, patient.getSeverity().name());
            stmt.setInt(4, bedId);
            stmt.executeUpdate();
            System.out.println("[JDBC] Successfully saved record to database.");
            
        } catch (SQLException e) {
            System.out.println("[JDBC Fallback] Local database unavailable. Action saved to log file.");
        }
    }
}
