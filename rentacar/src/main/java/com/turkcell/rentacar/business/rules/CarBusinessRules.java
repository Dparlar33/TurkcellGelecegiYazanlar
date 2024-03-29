package com.turkcell.rentacar.business.rules;


import com.turkcell.rentacar.business.messages.CarMessages;
import com.turkcell.rentacar.core.utilities.exceptions.types.BusinessException;
import com.turkcell.rentacar.dataAccess.abstracts.CarRepository;
import com.turkcell.rentacar.entities.concretes.Car;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CarBusinessRules {
    private CarRepository carRepository;
    public void isCarExistById(int id){
        if(this.carRepository.findById(id).isEmpty()){
            throw new BusinessException(CarMessages.CAR_NOT_EXIST);
        }
    }
    public Car.State setCarStateFromIntegerToEnum(int stateId){
        for (Car.State state: Car.State.values()){
            if (state.getValue() == stateId){
                return state;
            }
        }
        throw new BusinessException(CarMessages.INVALID_STATE_VALUE);
    }
}