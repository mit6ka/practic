public interface RoomService<T extends Room> {
    void clean(T room);
    boolean reserve(T room);
    boolean free(T room);
}