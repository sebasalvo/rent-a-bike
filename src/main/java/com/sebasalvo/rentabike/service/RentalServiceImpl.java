package com.sebasalvo.rentabike.service;

import com.sebasalvo.rentabike.model.RentalDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class RentalServiceImpl implements RentalService {

    public int calculateRegularRentalCost(RentalDTO rentalDTO) throws Exception {

        if(Objects.nonNull(rentalDTO)) {
            return rentalDTO.getDuration() * rentalDTO.getRentalType().getPrice();
        } else {
            throw new Exception("Invalid rental.");
        }

    }

    public double calculateFamilyRentalCost(List<RentalDTO> rentalDTOList) throws Exception {

        if( Objects.nonNull(rentalDTOList) && rentalDTOList.size() >= 3 && rentalDTOList.size() <= 5) {

            Stream<RentalDTO> rentalDTOStream = rentalDTOList.stream();
            int rawCost =
                    rentalDTOStream.collect(Collectors.summingInt(r -> r.getDuration() * r.getRentalType().getPrice()));
            return rawCost * (1 - FAMILY_DISCOUNT);

        } else {
          throw new Exception("Invalid family rent.");
        }

    }

}
