package com.sebasalvo.rentabike.service;

import com.sebasalvo.rentabike.model.RentalDTO;

import java.util.List;

public interface RentalService {

    double FAMILY_DISCOUNT = 0.30;

    int calculateRentalCost(RentalDTO rentalDTO) throws Exception;

    double calculateFamilyRentalCost(List<RentalDTO> rentalDTOList) throws Exception;

}
