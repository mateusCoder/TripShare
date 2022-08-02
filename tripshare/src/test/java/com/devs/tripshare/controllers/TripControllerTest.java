package com.devs.tripshare.controllers;

import com.devs.tripshare.builder.TripBuilder;
import com.devs.tripshare.dto.trip.TripDto;
import com.devs.tripshare.entities.Trip;
import com.devs.tripshare.services.TripServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
class TripControllerTest {

    private final TripDto EXPECTED_TRIP_DTO = TripBuilder.getTripDTO();
    private final Trip EXPECTED_TRIP = TripBuilder.getTrip();
    private final List<TripDto> EXPECTED_LIST_TRIP_DTO = TripBuilder.getListOfTripDTO();
    private final List<Trip> EXPECTED_LIST_TRIP = TripBuilder.getListOfTrip();
    private final Page<TripDto> EXPECTED_PAGE_TRIP_DTO = new PageImpl<>(EXPECTED_LIST_TRIP_DTO);

    @InjectMocks
    private TripController tripController;

    @Mock
    private TripServiceImpl tripService;


    @BeforeEach
    void setUp(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void findAll() {
        when(tripService.findAll(any())).thenReturn(new PageImpl<>(TripBuilder.getListOfTripDTO()));

        ResponseEntity<Page<TripDto>> tripDtoPageActual = tripController.findAll(any());

        assertNotNull(tripDtoPageActual);
        assertNotNull(tripDtoPageActual.getBody());
        assertEquals(ResponseEntity.class, tripDtoPageActual.getClass());
        assertEquals(EXPECTED_PAGE_TRIP_DTO.getContent(), tripDtoPageActual.getBody().getContent());
    }

    @Test
    void findById() {
        when(tripService.findById(anyLong())).thenReturn(TripBuilder.getTripDTO());

        ResponseEntity<TripDto> tripDtoActual = tripController.findById(anyLong());

        assertEquals(EXPECTED_TRIP_DTO, tripDtoActual.getBody());
    }

    @Test
    void create() {
        URI uri = ServletUriComponentsBuilder.fromPath("/trips/{id}").build(TripBuilder.getTripDTO().getId());
        when(tripService.create(any())).thenReturn(uri);

        ResponseEntity<TripDto> tripDtoActual = tripController.create(TripBuilder.getTripForm());

        assertEquals("/trips/1", tripDtoActual.getHeaders().getLocation().getPath());
    }

    @Test
    void update() {
        when(tripService.update(anyLong(), any())).thenReturn(TripBuilder.getTripDTO());

        ResponseEntity<TripDto> tripDtoActual = tripController.update(anyLong(), any());

        assertEquals(EXPECTED_TRIP_DTO, tripDtoActual.getBody());
    }

    @Test
    void deleteById(){
        doNothing().when(tripService).deleteById(anyLong());

        tripController.deleteById(anyLong());

        verify(tripService, times(1)).deleteById(anyLong());
    }
}