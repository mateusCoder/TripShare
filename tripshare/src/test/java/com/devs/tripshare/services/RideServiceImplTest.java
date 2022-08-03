package com.devs.tripshare.services;

import com.devs.tripshare.builder.PersonBuilder;
import com.devs.tripshare.builder.RideBuilder;
import com.devs.tripshare.builder.TripBuilder;
import com.devs.tripshare.dto.ride.RideDto;
import com.devs.tripshare.dto.trip.TripDto;
import com.devs.tripshare.entities.Ride;
import com.devs.tripshare.entities.Trip;
import com.devs.tripshare.repository.PersonRepository;
import com.devs.tripshare.repository.RideRepository;
import com.devs.tripshare.repository.TripRepository;
import org.apache.coyote.Request;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.modelmapper.ModelMapper;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.ServletRequest;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class RideServiceImplTest {

    @InjectMocks
    private RideServiceImpl rideService;

    @Mock
    private RideRepository rideRepository;

    @Mock
    private PersonRepository personRepository;

    @Mock
    private TripRepository tripRepository;

    @Spy
    private ModelMapper modelMapper;

    private final RideDto EXPECTED_RIDE_DTO = RideBuilder.getRideDTO();
    private final Ride EXPECTED_RIDE = RideBuilder.getRide();
    private final List<RideDto> EXPECTED_LIST_RIDE_DTO = RideBuilder.getListOfRideDTO();
    private final List<Ride> EXPECTED_LIST_RIDE = RideBuilder.getListOfRide();
    private final Page<Ride> EXPECTED_PAGE_RIDE = new PageImpl<>(EXPECTED_LIST_RIDE);

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void findAll() {
        when(rideRepository.findAll((Pageable) any())).thenReturn(EXPECTED_PAGE_RIDE);

        Page<RideDto> actualRideDtoPage = rideService.findAll((Pageable) any());

        assertEquals(2, actualRideDtoPage.getTotalElements());
        assertEquals(1L, actualRideDtoPage.getContent().get(0).getId());
    }

    @Test
    void findById() {
        when(rideRepository.findById(anyLong())).thenReturn(Optional.of(RideBuilder.getRide()));

        RideDto actualRideDto = rideService.findById(anyLong());

        assertEquals(EXPECTED_RIDE_DTO, actualRideDto);
    }

    @Test
    void saveRide() {
        when(personRepository.findByName(anyString())).thenReturn(Optional.of(PersonBuilder.getPerson()));
        when(tripRepository.findById(anyLong())).thenReturn(Optional.of(TripBuilder.getTrip()));
        when(rideRepository.save(any())).thenReturn(RideBuilder.getRide());

        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));

        rideService.saveRide(RideBuilder.getRideForm());

        verify(rideRepository, times(1)).save(any());
    }

    @Test
    void deleteById() {
        when(rideRepository.findById(any())).thenReturn(Optional.of(EXPECTED_RIDE));
        doNothing().when(rideRepository).deleteById(anyLong());

        rideService.deleteById(anyLong());

        verify(rideRepository, times(1)).deleteById(anyLong());
    }

}