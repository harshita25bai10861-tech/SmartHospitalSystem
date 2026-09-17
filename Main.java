public class Main {
    public static void main(String[] args) {
        // System with 2 available beds
        BedAllocationService system = new BedAllocationService(2);

        // Intentionally registering lower priority patient first
        system.registerPatient(new Patient(101, "Alice", SeverityLevel.LOW));
        system.registerPatient(new Patient(102, "Bob", SeverityLevel.CRITICAL));
        system.registerPatient(new Patient(103, "Charlie", SeverityLevel.HIGH));

        // Multithreaded execution processing triage requests concurrently
        Runnable task = () -> {
            try {
                system.allocateBedNext();
            } catch (BedUnavailableException e) {
                System.err.println("[EXCEPTION HANDLED] " + e.getMessage());
            }
        };

        Thread thread1 = new Thread(task, "Nurse-Thread-1");
        Thread thread2 = new Thread(task, "Nurse-Thread-2");
        Thread thread3 = new Thread(task, "Nurse-Thread-3");

        thread1.start();
        thread2.start();
        thread3.start();
    }
}
