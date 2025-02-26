package com.debuggeandoideas.airbnb.service;

import com.debuggeandoideas.airbnb.utils.DataTest;
import com.debuggeandoideas.airdnd.services.RoomService;
import com.debuggeandoideas.airdnd.repositories.RoomRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


/**
 * Esta es una configuracion para poder usar las anotaciones y no hacerlo de la manera
 * manual
* */
@ExtendWith(MockitoExtension.class)
class RoomServiceTest {

    //private RoomRepository roomRepositoryMock;
    //private RoomService roomService;

    @Mock
    private RoomRepository roomRepositoryMock;

    @InjectMocks
    private RoomService roomService;


    //@BeforeEach
    //void init(){
        /**
         * Esto es incorrecto, al crear los objetos se está haciendo uso de la clase
         * Lo que se requiere es que
         *
         *   this.roomRepository = new RoomRepository();
         *   this.roomService = new RoomService(roomRepository);
         *
         * */

        //this.roomRepositoryMock = mock(RoomRepository.class);
        //this.roomService = new RoomService(roomRepositoryMock);

    //}

    @Test
    @DisplayName("Should_Get_Available_Rooms")
    void testFindAvailableRoom(){
        when(this.roomRepositoryMock.findAll()).thenReturn(DataTest.default_rooms);
        var expected = 3;
        var target = this.roomService.findAllAvailableRooms();
        assertEquals(expected,target.size());
    }

}