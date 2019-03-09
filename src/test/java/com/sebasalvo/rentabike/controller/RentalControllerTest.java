package com.sebasalvo.rentabike.controller;

import com.sebasalvo.rentabike.model.RentalDTO;
import com.sebasalvo.rentabike.model.RentalType;
import com.sebasalvo.rentabike.service.RentalService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class RentalControllerTest {

    @InjectMocks
    private RentalController rentalController;

    @Mock
    private RentalService mockedRentalService;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testRegularRental() throws Exception {

        RentalDTO rentalDTO = new RentalDTO();
        rentalDTO.setRentalType(RentalType.HOUR);
        rentalDTO.setDuration(2);

        when(mockedRentalService.calculateRegularRentalCost(rentalDTO)).thenReturn(10);

        int cost = rentalController.regularRental(rentalDTO);

        verify(mockedRentalService).calculateRegularRentalCost(rentalDTO);

        assertThat("Invalid cost. Less than zero.", cost > 0);

    }

    @Test
    public void testFamilyRental() throws Exception {

        List<RentalDTO> rentalDTOList = dummyRentalDTOList();

        when(mockedRentalService.calculateFamilyRentalCost(rentalDTOList)).thenReturn(80*0.7);

        double cost = rentalController.familyRental(rentalDTOList);

        verify(mockedRentalService).calculateFamilyRentalCost(rentalDTOList);

        assertThat("Invalid cost. Less than zero.", cost > 0);

    }

    private List<RentalDTO> dummyRentalDTOList(){
        List<RentalDTO> rentalDTOList = new ArrayList<>();

        RentalDTO rentalDTO = new RentalDTO();
        rentalDTO.setRentalType(RentalType.DAY);
        rentalDTO.setDuration(1);
        rentalDTOList.add(rentalDTO);

        rentalDTO = new RentalDTO();
        rentalDTO.setRentalType(RentalType.DAY);
        rentalDTO.setDuration(1);
        rentalDTOList.add(rentalDTO);

        rentalDTO = new RentalDTO();
        rentalDTO.setRentalType(RentalType.DAY);
        rentalDTO.setDuration(1);
        rentalDTOList.add(rentalDTO);

        rentalDTO = new RentalDTO();
        rentalDTO.setRentalType(RentalType.DAY);
        rentalDTO.setDuration(1);
        rentalDTOList.add(rentalDTO);

        return rentalDTOList;
    }

}
