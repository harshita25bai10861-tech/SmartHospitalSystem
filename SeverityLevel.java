public enum SeverityLevel {
    CRITICAL(1),
    HIGH(2),
    MEDIUM(3),
    LOW(4);

    private final int priorityRank;

    SeverityLevel(int priorityRank) {
        this.priorityRank = priorityRank;
    }

    public int getPriorityRank() {
        return priorityRank;
    }
}