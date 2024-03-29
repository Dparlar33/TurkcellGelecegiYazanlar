package com.turkcell.rentacar.business.concretes;

import com.turkcell.rentacar.business.abstracts.TransmissionService;
import com.turkcell.rentacar.business.dtos.requests.transmissions.CreateTransmissionRequest;
import com.turkcell.rentacar.business.dtos.requests.transmissions.UpdateTransmissionRequest;
import com.turkcell.rentacar.business.dtos.responses.transmissions.*;
import com.turkcell.rentacar.business.rules.TransmissionBusinessRules;
import com.turkcell.rentacar.core.utilities.exceptions.types.BusinessException;
import com.turkcell.rentacar.core.utilities.mapping.ModelMapperService;
import com.turkcell.rentacar.dataAccess.abstracts.TransmissionRepository;
import com.turkcell.rentacar.entities.concretes.Transmission;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class TransmissionManager implements TransmissionService {
    private TransmissionRepository transmissionRepository;
    private ModelMapperService modelMapperService;
    private TransmissionBusinessRules transmissionBusinessRules;
    @Override
    public CreatedTransmissionResponse add(CreateTransmissionRequest createTransmissionRequest) {
        Transmission transmission = this.modelMapperService.forRequest().
                map(createTransmissionRequest,Transmission.class);
        transmission.setCreatedDate(LocalDateTime.now());
        Transmission createdTransmission =  this.transmissionRepository.save(transmission);

        return this.modelMapperService.forResponse().
                map(createdTransmission,CreatedTransmissionResponse.class);
    }
    @Override
    public GetByIdTransmissionResponse getById(int id) {
        Optional<Transmission> transmission = this.transmissionRepository.findById(id);
        if (transmission.isPresent()){
            return this.modelMapperService.forResponse().map(transmission, GetByIdTransmissionResponse.class);
        }else {
            throw new BusinessException("Transmission Does not exist!");
        }
    }
    @Override
    public List<GetAllTransmissionResponse> getAll() {
        List<Transmission> transmissions = this.transmissionRepository.findAll();
        return transmissions.stream().map(transmission -> this.modelMapperService.forResponse().
                map(transmission, GetAllTransmissionResponse.class)).collect(Collectors.toList());
    }
    @Override
    public UpdatedTransmissionResponse update(UpdateTransmissionRequest updateTransmissionRequest) {
        this.transmissionBusinessRules.isTransmissionExistByUpdateRequest(updateTransmissionRequest);
        Transmission transmission = transmissionRepository.findById(updateTransmissionRequest.getId()).orElse(null);

        transmission.setUpdatedDate(LocalDateTime.now());
        this.transmissionRepository.save(transmission);

        return this.modelMapperService.forResponse().
                map(transmission,UpdatedTransmissionResponse.class);
    }
    @Override
    public DeletedTransmissionResponse delete(int id) {
        this.transmissionBusinessRules.isTransmissionExistById(id);
        Transmission transmission = this.transmissionRepository.findById(id).orElse(null);
        transmission.setDeletedDate(LocalDateTime.now());

        return this.modelMapperService.forResponse().map(transmission,DeletedTransmissionResponse.class);
    }
}
