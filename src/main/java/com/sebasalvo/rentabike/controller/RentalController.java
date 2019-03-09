package com.sebasalvo.rentabike.controller;

import com.sebasalvo.rentabike.model.RentalDTO;
import com.sebasalvo.rentabike.service.RentalServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1")
public class RentalController {

    @Autowired
    RentalServiceImpl rentalService;

    @RequestMapping(value = "rental/regular")
    public int regularRental(@RequestBody RentalDTO rentalDTO) throws Exception{
        return rentalService.calculateRentalCost(rentalDTO);
    }

    @RequestMapping(value = "rental/family")
    public double familyRental(@RequestBody List<RentalDTO> rentalDTOList) throws Exception {
        return rentalService.calculateFamilyRentalCost(rentalDTOList);
    }

}
