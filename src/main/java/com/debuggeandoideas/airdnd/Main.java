package com.debuggeandoideas.airdnd;

import com.debuggeandoideas.airdnd.services.BookingService;
import com.debuggeandoideas.airdnd.services.PaymentService;
import com.debuggeandoideas.airdnd.services.RoomService;
import com.debuggeandoideas.airdnd.dto.BookingDto;
import com.debuggeandoideas.airdnd.helpers.MailHelper;
import com.debuggeandoideas.airdnd.repositories.BookingRepository;
import com.debuggeandoideas.airdnd.repositories.PaymentRepository;
import com.debuggeandoideas.airdnd.repositories.RoomRepository;

import java.time.LocalDate;
import java.util.UUID;

public class Main {
    public static void main(String[] args) {
        final var paymentService = new PaymentService(new PaymentRepository());
        final var roomService = new RoomService(new RoomRepository());
        final var bookingRepository = new BookingRepository();
        final var mailHelper = new MailHelper();
        final var bookingService = new BookingService(
                paymentService,
                roomService,
                bookingRepository,
                mailHelper
        );

        var randomId = UUID.randomUUID().toString();
        var bookingDto = new BookingDto(
                "1.1",
                LocalDate.of(2023, 06, 10),
                LocalDate.of(2023, 06, 20),
                2,
                true
        );
        var bookingResult = bookingService.booking(bookingDto);
        System.out.println(bookingResult);

        bookingService.unbook(bookingResult);

        var price = bookingService.calculatePrice(bookingDto);

        System.out.println(price);

        var priceMxn = bookingService.calculateInMxn(bookingDto);
        System.out.println(priceMxn);

        var roomsAvailable = bookingService.getAvailablePlaceCount();

        System.out.println(roomsAvailable);
    }
}