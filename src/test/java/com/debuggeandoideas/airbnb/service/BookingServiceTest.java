package com.debuggeandoideas.airbnb.service;

import com.debuggeandoideas.airbnb.utils.DataTest;
import com.debuggeandoideas.airdnd.dto.BookingDto;
import com.debuggeandoideas.airdnd.dto.RoomDto;
import com.debuggeandoideas.airdnd.helpers.MailHelper;
import com.debuggeandoideas.airdnd.repositories.BookingRepository;
import com.debuggeandoideas.airdnd.services.BookingService;
import com.debuggeandoideas.airdnd.services.PaymentService;
import com.debuggeandoideas.airdnd.services.RoomService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.function.Executable;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class BookingServiceTest {

    @Mock
    private PaymentService paymentServiceMock;
    @Mock
    private RoomService roomServiceMock;
    @Mock
    private BookingRepository bookingRepositoryMock;
    @Mock
    private MailHelper mailHelperMock;

    @InjectMocks
    private BookingService bookingService;


    @Test
    @DisplayName("Total de personas")
    void getAvailablePlaceCountTest(){
        var expected = 14;
        when(this.roomServiceMock.findAllAvailableRooms()).thenReturn(DataTest.default_list_rooms);
        var target = this.bookingService.getAvailablePlaceCount();
        assertEquals(expected,target);

    }


    @Test
    @DisplayName("shouldBooking")
    void testBookingMethod(){
        var id = UUID.randomUUID().toString();
        //when(this.roomServiceMock.findAvailableRoom(DataTest.default_booking_req_1)).thenReturn(DataTest.default_list_rooms.get(0));
        //when(this.bookingRepositoryMock.save(DataTest.default_booking_req_1)).thenReturn(id);

        /***
         * otra forma de probar comportamiento es con el
         * doReturn(ValorEsperando).when(DependenciaProbar).métodoDeLaDependencia(argumentos)
         */
        doReturn(DataTest.default_list_rooms.get(0)).when(this.roomServiceMock).findAvailableRoom(DataTest.default_booking_req_1);
        doReturn(id).when(this.bookingRepositoryMock).save(DataTest.default_booking_req_1);

        //este es para testear un metodo void
        doNothing().when(this.roomServiceMock).bookRoom(anyString());

        var result = this.bookingService.booking(DataTest.default_booking_req_1);


        //El verifiy(mock,times()) ayuda para validar que una llamada a codigo se ejecuta
        //times es para validar cuantas veces se ejecuta un codigo esperado
        verify(this.roomServiceMock, times(1)).findAvailableRoom(any(BookingDto.class));
        verify(this.bookingRepositoryMock,times(1)).save(any(BookingDto.class));
        verify(this.roomServiceMock, times(1)).bookRoom(anyString());
        assertEquals(id,result);
    }


    @Test
    @DisplayName("shouldFailBooking")
    void testBookingMethodFailed(){
        var id = UUID.randomUUID().toString();
        doReturn(DataTest.default_list_rooms.get(0)).when(this.roomServiceMock).findAvailableRoom(DataTest.default_booking_req_3);

        doThrow(new IllegalArgumentException("Max 3 guest")).when(this.paymentServiceMock).pay(any(BookingDto.class),anyDouble());

        Executable executable = () -> this.bookingService.booking(DataTest.default_booking_req_3);
        assertThrows(IllegalArgumentException.class, executable);


    }
}