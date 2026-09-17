public class Bed {
    private int bedId;
    private boolean occupied;

    public Bed(int bedId) {
        this.bedId = bedId;
        this.occupied = false;
    }

    public int getBedId() { return bedId; }
    public boolean isOccupied() { return occupied; }
    public void setOccupied(boolean occupied) { this.occupied = occupied; }
}
