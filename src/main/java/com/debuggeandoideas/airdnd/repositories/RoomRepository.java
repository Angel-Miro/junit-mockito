package com.debuggeandoideas.airdnd.repositories;

import com.debuggeandoideas.airdnd.dto.RoomDto;

import java.util.HashMap;
import java.util.Map;

public class RoomRepository {

    private final Map<RoomDto, Boolean> rooms = new HashMap<>() {{
        put(new RoomDto("1,1", 2), true);
        put(new RoomDto("1,2", 2), true);
        put(new RoomDto("1,3", 3), false);
        put(new RoomDto("2,1", 2), true);
        put(new RoomDto("2,2", 2), false);
        put(new RoomDto("2,3", 3), true);
    }};


    public Map<RoomDto, Boolean> findAll() {
        return this.rooms;
    }

    public void save(final RoomDto room, final Boolean isBooking) {
        this.rooms.put(room, isBooking);
    }
}
