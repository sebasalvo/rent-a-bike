package com.sebasalvo.rentabike.service;

import com.sebasalvo.rentabike.model.RentalDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RentalService {

    double FAMILY_DISCOUNT = 0.30;

    int calculateRegularRentalCost(RentalDTO rentalDTO) throws Exception;

    double calculateFamilyRentalCost(List<RentalDTO> rentalDTOList) throws Exception;

}
