package com.turkcell.rentacar.business.concretes;

import com.turkcell.rentacar.business.abstracts.ModelService;
import com.turkcell.rentacar.business.dtos.requests.models.CreateModelRequest;
import com.turkcell.rentacar.business.dtos.requests.models.UpdateModelRequest;
import com.turkcell.rentacar.business.dtos.responses.models.*;
import com.turkcell.rentacar.business.rules.BrandBusinessRules;
import com.turkcell.rentacar.business.rules.FuelBusinessRules;
import com.turkcell.rentacar.business.rules.ModelBusinessRules;
import com.turkcell.rentacar.business.rules.TransmissionBusinessRules;
import com.turkcell.rentacar.core.utilities.mapping.ModelMapperService;
import com.turkcell.rentacar.dataAccess.abstracts.ModelRepository;
import com.turkcell.rentacar.entities.concretes.Model;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class ModelManager implements ModelService {
    private ModelRepository modelRepository;
    private ModelMapperService modelMapperService;
    private ModelBusinessRules modelBusinessRules;
    private FuelBusinessRules fuelBusinessRules;
    private TransmissionBusinessRules transmissionBusinessRules;
    private BrandBusinessRules brandBusinessRules;
    @Override
    public CreatedModelResponse add(CreateModelRequest createModelRequest) {
        this.brandBusinessRules.isBrandExistById(createModelRequest.getBrandId());
        this.fuelBusinessRules.isFuelExistById(createModelRequest.getFuelId());
        this.transmissionBusinessRules.isTransmissionExistById(createModelRequest.getTransmissionId());

        Model model = this.modelMapperService.forRequest().map(createModelRequest, Model.class);
        model.setCreatedDate(LocalDateTime.now());
        Model createdModel = this.modelRepository.save(model);
        return this.modelMapperService.forResponse().map(createdModel, CreatedModelResponse.class);
    }
    @Override
    public GetByIdModelResponse getById(int id) {
        Model model = this.modelRepository.findById(id).orElse(null);
        this.modelBusinessRules.isModelExistById(model.getId());

        return this.modelMapperService.forResponse().
                map(model, GetByIdModelResponse.class);
    }
    @Override
    public List<GetAllModelResponse> getAll() {
        List<Model> models = this.modelRepository.findAll();
        return models.stream().map(model -> this.modelMapperService.forResponse().
                map(model, GetAllModelResponse.class)).collect(Collectors.toList());
    }
    @Override
    public UpdatedModelResponse update(UpdateModelRequest updateModelRequest) {
        Model model = modelRepository.findById(updateModelRequest.getId()).orElse(null);
        this.modelBusinessRules.isModelExistById(updateModelRequest.getId());

        model.setUpdatedDate(LocalDateTime.now());
        this.modelRepository.save(model);
        return this.modelMapperService.forResponse().map(model, UpdatedModelResponse.class);
    }
    @Override
    public DeletedModelResponse delete(int id) {
        Model model = this.modelRepository.findById(id).orElse(null);
        this.modelBusinessRules.isModelExistById(id);
        model.setDeletedDate(LocalDateTime.now());

        return this.modelMapperService.forResponse().map(model, DeletedModelResponse.class);
    }
}
