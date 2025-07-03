public class HotelRoomService<T extends Room> implements RoomService<T> {

    @Override
    public void clean(T room) {
        System.out.printf("Уборка комнаты №%d (вместимость: %d, цена: %d)%n",
                room.getRoomNumber(),
                room.getMaxCapacity(),
                room.getPricePerNight()
        );
    }

    @Override
    public boolean reserve(T room) {
        if (room.isBooked()) {
            throw new RoomAlreadyBookedException(
                    String.format("Комната №%d (цена %d) уже забронирована",
                            room.getRoomNumber(),
                            room.getPricePerNight()
                    )
            );
        }
        room.setBooked(true);
        System.out.printf("Бронирование комнаты №%d (вместимость %d)%n",
                room.getRoomNumber(),
                room.getMaxCapacity()
        );
        return true;
    }

    @Override
    public boolean free(T room) {
        if (!room.isBooked()) {
            return false;
        }
        room.setBooked(false);
        System.out.printf("Освобождение комнаты №%d%n", room.getRoomNumber());
        return true;
    }
}