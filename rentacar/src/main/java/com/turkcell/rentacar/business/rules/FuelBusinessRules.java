package com.turkcell.rentacar.business.rules;

import com.turkcell.rentacar.business.dtos.requests.fuels.UpdateFuelRequest;
import com.turkcell.rentacar.business.messages.FuelMessages;
import com.turkcell.rentacar.core.utilities.exceptions.types.BusinessException;
import com.turkcell.rentacar.dataAccess.abstracts.FuelRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class FuelBusinessRules {
    private FuelRepository fuelRepository;

    public void isFuelExistByUpdateRequest(UpdateFuelRequest updateFuelRequest){
        if (this.fuelRepository.findById(updateFuelRequest.getId()).isEmpty()){
            throw new BusinessException(FuelMessages.FUEL_NOT_EXIST);
        }
    }
    public void isFuelExistById (int id){
        if(this.fuelRepository.findById(id).isEmpty()){
            throw new BusinessException(FuelMessages.FUEL_NOT_EXIST);
        }
    }
}
