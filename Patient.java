public class Patient extends User implements Comparable<Patient> {
    private SeverityLevel severity;

    public Patient(int id, String name, SeverityLevel severity) {
        super(id, name);
        this.severity = severity;
    }

    public SeverityLevel getSeverity() { return severity; }
    public int getId() { return id; }
    public String getName() { return name; }

    @Override
    public void displayDetails() {
        System.out.println("Patient ID: " + id + " | Name: " + name + " | Severity: " + severity);
    }

    @Override
    public int compareTo(Patient other) {
        // Lower priorityRank value means higher triage priority
        return Integer.compare(this.severity.getPriorityRank(), other.severity.getPriorityRank());
    }
}
