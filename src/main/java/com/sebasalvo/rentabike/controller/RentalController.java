package com.sebasalvo.rentabike.controller;

import com.sebasalvo.rentabike.model.RentalDTO;
import com.sebasalvo.rentabike.service.RentalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1")
public class RentalController {

    @Autowired
    private RentalService rentalService;

    @RequestMapping(value = "rental/regular", method = RequestMethod.POST)
    public int regularRental(@RequestBody RentalDTO rentalDTO) throws Exception{
        return rentalService.calculateRegularRentalCost(rentalDTO);
    }

    @RequestMapping(value = "rental/family", method = RequestMethod.POST)
    public double familyRental(@RequestBody List<RentalDTO> rentalDTOList) throws Exception {
        return rentalService.calculateFamilyRentalCost(rentalDTOList);
    }

}
