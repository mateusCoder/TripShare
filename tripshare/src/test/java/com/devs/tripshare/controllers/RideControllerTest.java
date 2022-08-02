package com.devs.tripshare.controllers;

import com.devs.tripshare.builder.RideBuilder;
import com.devs.tripshare.builder.TripBuilder;
import com.devs.tripshare.dto.ride.RideDto;
import com.devs.tripshare.dto.trip.TripDto;
import com.devs.tripshare.entities.Ride;
import com.devs.tripshare.entities.Trip;
import com.devs.tripshare.services.RideServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


@AutoConfigureTestDatabase
class RideControllerTest {

    private final RideDto EXPECTED_RIDE_DTO = RideBuilder.getRideDTO();
    private final Ride EXPECTED_RIDE = RideBuilder.getRide();
    private final List<RideDto> EXPECTED_LIST_RIDE_DTO = RideBuilder.getListOfRideDTO();
    private final List<Ride> EXPECTED_LIST_RIDE = RideBuilder.getListOfRide();
    private final Page<RideDto> EXPECTED_PAGE_RIDEDTO = new PageImpl<>(EXPECTED_LIST_RIDE_DTO);

    @InjectMocks
    private RideController rideController;

    @Mock
    private RideServiceImpl rideService;

    @BeforeEach
    void setUp(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void findAll() {
        when(rideService.findAll(any())).thenReturn(EXPECTED_PAGE_RIDEDTO);

        ResponseEntity<Page<RideDto>> actualPageDtoResponse = rideController.findAll(any());

        assertNotNull(actualPageDtoResponse.getBody());
        assertEquals(200, actualPageDtoResponse.getStatusCode().value());
        assertEquals(EXPECTED_PAGE_RIDEDTO.getContent(), actualPageDtoResponse.getBody().getContent());
    }

    @Test
    void findById() {
        when(rideService.findById(anyLong())).thenReturn(EXPECTED_RIDE_DTO);

        ResponseEntity<RideDto> actualPageDtoResponse = rideController.findById(anyLong());

        assertNotNull(actualPageDtoResponse.getBody());
        assertEquals(EXPECTED_RIDE_DTO, actualPageDtoResponse.getBody());
    }

    @Test
    void save() {
        URI uri = ServletUriComponentsBuilder.fromPath("/tripshare/rides{id}").build(EXPECTED_RIDE.getId());

        when(rideService.saveRide(any())).thenReturn(uri);

        ResponseEntity<RideDto> actualPageDtoResponse = rideController.save(any());

        assertNotNull(actualPageDtoResponse);
        assertEquals(uri.getPath(), actualPageDtoResponse.getHeaders().getLocation().getPath());
        assertEquals(HttpStatus.CREATED.value(), actualPageDtoResponse.getStatusCode().value());
    }

    @Test
    void deleteById() {
        doNothing().when(rideService).deleteById(anyLong());

        rideController.deleteById(anyLong());

        verify(rideService, times(1)).deleteById(anyLong());
    }
}