public class HotelTest {
    public static void main(String[] args) {
        HotelRoomService<Room> service = new HotelRoomService<>();

        Room[] rooms = {
                new EconomyRoom(101),
                new StandardRoom(102),
                new LuxRoom(201),
                new UltraLuxRoom(202)
        };

        for (Room room : rooms) {
            testRoom(service, room);
        }
    }

    private static void testRoom(RoomService<Room> service, Room room) {
        System.out.println("\nTesting room #" + room.getRoomNumber());

        service.clean(room);
        System.out.println("Booked: " + room.isBooked());

        System.out.println("Reserving: " + service.reserve(room));
        System.out.println("Booked: " + room.isBooked());

        try {
            System.out.println("Reserving again: ");
            service.reserve(room);
        } catch (RoomAlreadyBookedException e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("Freeing: " + service.free(room));
        System.out.println("Booked: " + room.isBooked());
    }
}