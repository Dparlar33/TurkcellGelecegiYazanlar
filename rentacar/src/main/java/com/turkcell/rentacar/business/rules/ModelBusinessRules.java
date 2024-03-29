package com.turkcell.rentacar.business.rules;

import com.turkcell.rentacar.business.messages.ModelMessages;
import com.turkcell.rentacar.core.utilities.exceptions.types.BusinessException;
import com.turkcell.rentacar.dataAccess.abstracts.ModelRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class ModelBusinessRules {
    private ModelRepository modelRepository;
    public void isModelExistById(int id){
        if (this.modelRepository.findById(id).isEmpty()){
            throw new BusinessException(ModelMessages.MODEL_NOT_EXIST);
        }
    }
}
