package com.turkcell.rentacar.business.rules;

import com.turkcell.rentacar.business.dtos.requests.transmissions.UpdateTransmissionRequest;
import com.turkcell.rentacar.business.messages.TransmissionMessages;
import com.turkcell.rentacar.core.utilities.exceptions.types.BusinessException;
import com.turkcell.rentacar.dataAccess.abstracts.TransmissionRepository;
import com.turkcell.rentacar.entities.concretes.Transmission;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class TransmissionBusinessRules {
    private TransmissionRepository transmissionRepository;
    public void isTransmissionExistByUpdateRequest(UpdateTransmissionRequest updateTransmissionRequest ){
        Optional<Transmission> transmission = this.transmissionRepository.findById(updateTransmissionRequest.getId());
        if (transmission.isEmpty()){
            throw new BusinessException(TransmissionMessages.TRANSMISSION_NOT_EXIST);
        }
    }
    public void isTransmissionExistById(int id  ){
        Optional<Transmission> transmission = this.transmissionRepository.findById(id);
        if (transmission.isEmpty()){
            throw new BusinessException(TransmissionMessages.TRANSMISSION_NOT_EXIST);
        }
    }
}
