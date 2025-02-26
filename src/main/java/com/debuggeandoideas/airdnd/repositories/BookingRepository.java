package com.debuggeandoideas.airdnd.repositories;

import com.debuggeandoideas.airdnd.dto.BookingDto;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class BookingRepository {

    /*
     *Simulate a database
     */
    private final Map<String, BookingDto> bookingData = new HashMap<>();

    public String save(final BookingDto booking) {
        var id = UUID.randomUUID().toString();
        this.bookingData.put(id, booking);
        return id;
    }

    public BookingDto findById(final String id) {
        return this.bookingData.get(id);
    }

    public void deleteById(final String id) {
        this.bookingData.remove(id);
    }
}
