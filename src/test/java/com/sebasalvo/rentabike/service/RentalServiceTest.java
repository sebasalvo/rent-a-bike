package com.sebasalvo.rentabike.service;

import com.sebasalvo.rentabike.model.RentalDTO;
import com.sebasalvo.rentabike.model.RentalType;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

@RunWith(MockitoJUnitRunner.class)
public class RentalServiceTest {

    @InjectMocks
    private RentalService rentalService = new RentalServiceImpl();

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test(expected = Exception.class)
    public void testCalculateRegularRentalCostNullRentalDTO() throws Exception {

        final RentalDTO rentalDTO = null;
        int cost = rentalService.calculateRegularRentalCost(rentalDTO);

    }

    @Test
    public void testCalculateRegularHourRentalCost() throws Exception {

        final RentalDTO rentalDTO = new RentalDTO();
        rentalDTO.setRentalType(RentalType.HOUR);
        rentalDTO.setDuration(1);
        int cost = rentalService.calculateRegularRentalCost(rentalDTO);
        assertThat(cost, is(5));

    }

    @Test
    public void testCalculateRegularDayRentalCost() throws Exception {

        final RentalDTO rentalDTO = new RentalDTO();
        rentalDTO.setRentalType(RentalType.DAY);
        rentalDTO.setDuration(4);
        int cost = rentalService.calculateRegularRentalCost(rentalDTO);
        assertThat(cost, is(80));

    }

    @Test
    public void testCalculateRegularWeekRentalCost() throws Exception {

        final RentalDTO rentalDTO = new RentalDTO();
        rentalDTO.setRentalType(RentalType.WEEK);
        rentalDTO.setDuration(2);
        int cost = rentalService.calculateRegularRentalCost(rentalDTO);
        assertThat(cost, is(120));

    }

    @Test
    public void testCalculateFamilyRentalCost() throws Exception {

        final List<RentalDTO> rentalDTOList = new ArrayList<>();

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

        double cost = rentalService.calculateFamilyRentalCost(rentalDTOList);
        assertThat(cost, is(rentalDTOList.size() * RentalType.DAY.getPrice() * 0.7));

    }

    @Test(expected = Exception.class)
    public void testCalculateFamilyRentalCostNotEnoughRentals() throws Exception {

        final List<RentalDTO> rentalDTOList = dummyRentalDTOList();
        double cost = rentalService.calculateFamilyRentalCost(rentalDTOList);

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

        return rentalDTOList;
    }

}
