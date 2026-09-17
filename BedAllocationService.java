import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class BedAllocationService {
    private List<Bed> beds = new ArrayList<>();
    private PriorityQueue<Patient> triageQueue = new PriorityQueue<>();
    private PatientDAO dao = new PatientDAO();

    public BedAllocationService(int totalBeds) {
        for (int i = 1; i <= totalBeds; i++) {
            beds.add(new Bed(i));
        }
    }

    public synchronized void registerPatient(Patient p) {
        triageQueue.add(p);
        System.out.println("[Queue] Registered: " + p.getName() + " (" + p.getSeverity() + ")");
    }

    public synchronized void allocateBedNext() throws BedUnavailableException {
        if (triageQueue.isEmpty()) {
            return;
        }

        Patient patient = triageQueue.poll();
        Bed targetBed = null;

        for (Bed bed : beds) {
            if (!bed.isOccupied()) {
                targetBed = bed;
                break;
            }
        }

        if (targetBed == null) {
            throw new BedUnavailableException("Allocation Failed: No beds available for " + patient.getName());
        }

        targetBed.setOccupied(true);
        String logMsg = "Bed #" + targetBed.getBedId() + " assigned to Patient " + patient.getName();
        System.out.println("[SUCCESS] " + logMsg);

        AuditLogger.logAllocation(logMsg);
        dao.saveAdmissionRecord(patient, targetBed.getBedId());
    }
}
