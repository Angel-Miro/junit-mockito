package com.debuggeandoideas.airdnd.dto;

import java.time.LocalDate;
import java.util.Objects;

public class BookingDto {

    private String userId;
    private LocalDate from;
    private LocalDate to;
    private Integer totalGuest;
    private Boolean isPrepaid;
    private RoomDto room;

    public BookingDto(String userId,
                               LocalDate from,
                               LocalDate to,
                               Integer totalGuest,
                               Boolean isPrepaid
    ) {
        this.userId = userId;
        this.from = from;
        this.to = to;
        this.totalGuest = totalGuest;
        this.isPrepaid = isPrepaid;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public LocalDate getFrom() {
        return from;
    }

    public void setFrom(LocalDate from) {
        this.from = from;
    }

    public LocalDate getTo() {
        return to;
    }

    public void setTo(LocalDate to) {
        this.to = to;
    }

    public Integer getTotalGuest() {
        return totalGuest;
    }

    public void setTotalGuest(Integer totalGuest) {
        this.totalGuest = totalGuest;
    }

    public Boolean getPrepaid() {
        return isPrepaid;
    }

    public void setPrepaid(Boolean prepaid) {
        isPrepaid = prepaid;
    }

    public RoomDto getRoom() {
        return room;
    }

    public void setRoom(RoomDto room) {
        this.room = room;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookingDto that = (BookingDto) o;
        return Objects.equals(userId, that.userId) && Objects.equals(from, that.from) && Objects.equals(to, that.to) && Objects.equals(totalGuest, that.totalGuest) && Objects.equals(isPrepaid, that.isPrepaid) && Objects.equals(room, that.room);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, from, to, totalGuest, isPrepaid, room);
    }
}
