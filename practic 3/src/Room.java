
public abstract class Room {
    private final int roomNumber;
    private final int maxCapacity;
    private final int pricePerNight;
    private boolean isBooked;

    public Room(int roomNumber, int maxCapacity, int pricePerNight) {
        this.roomNumber = roomNumber;
        this.maxCapacity = maxCapacity;
        this.pricePerNight = pricePerNight;
        this.isBooked = false;
    }

    public int getRoomNumber() { return roomNumber; }
    public int getMaxCapacity() { return maxCapacity; }
    public int getPricePerNight() { return pricePerNight; }
    public boolean isBooked() { return isBooked; }

    protected void setBooked(boolean booked) { isBooked = booked; }
}