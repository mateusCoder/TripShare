package com.devs.tripshare.services;

import com.devs.tripshare.builder.TripBuilder;
import com.devs.tripshare.dto.trip.TripDto;
import com.devs.tripshare.entities.Trip;
import com.devs.tripshare.exceptions.ObjectNotFound;
import com.devs.tripshare.repository.TripRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

@SpringBootTest
class TripServiceImplTest {

    @InjectMocks TripServiceImpl tripService;

    @Mock
    TripRepository tripRepository;

    @Spy
    ModelMapper modelMapper;


    private final TripDto EXPECTED_TRIP_DTO = TripBuilder.getTripDTO();
    private final Trip EXPECTED_TRIP = TripBuilder.getTrip();
    private final List<TripDto> EXPECTED_LIST_TRIP_DTO = TripBuilder.getListOfTripDTO();
    private final List<Trip> EXPECTED_LIST_TRIP = TripBuilder.getListOfTrip();

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void findAll() {

        when(tripRepository.findAll((Pageable) any())).thenReturn(new PageImpl<>(TripBuilder.getListOfTrip()));

        Page<TripDto> tripDtoPageable = tripService.findAll(any());

        assertEquals(2, tripDtoPageable.getTotalElements());
        assertEquals("Sem Juninho", tripDtoPageable.getContent().get(0).getName());
    }

    @Test
    void findById() {

        when(tripRepository.findById(anyLong())).thenReturn(Optional.of(TripBuilder.getTrip()));

        TripDto actualTripDto = tripService.findById(anyLong());

        assertNotNull(actualTripDto);
        assertEquals(EXPECTED_TRIP_DTO, actualTripDto);
        assertEquals(EXPECTED_TRIP_DTO.getId(), actualTripDto.getId());

    }

    @Test
    void create(){
        when(tripRepository.save(any())).thenReturn(TripBuilder.getTrip());

        tripService.create(TripBuilder.getTripForm());

        verify(tripRepository, times(1)).save(any());
    }

    @Test
    void update() {

        when(tripRepository.findById(anyLong())).thenReturn(Optional.of(TripBuilder.getTrip()));
        when(tripRepository.save(any())).thenReturn(TripBuilder.getTrip());

        TripDto actualTripDto = tripService.update(1L, TripBuilder.getTripForm());

        assertNotNull(actualTripDto);
        assertEquals(EXPECTED_TRIP_DTO, actualTripDto);

    }

    @Test
    void deleteById() {
        when(tripRepository.findById(anyLong())).thenReturn(Optional.of(TripBuilder.getTrip()));
        doNothing().when(tripRepository).deleteById(anyLong());

        tripService.deleteById(anyLong());

        verify(tripRepository, times(1)).deleteById(anyLong());

    }

    @Test
    void throwExceptionWhenTripNotFound() {

        when(tripRepository.findById(anyLong())).thenThrow(new ObjectNotFound("Trip not found!"));

        try {
            tripService.checkExistence(anyLong());
        }catch(Exception e){
            assertEquals(ObjectNotFound.class, e.getClass());
            assertEquals("Trip not found!", e.getMessage());
        }
    }
}