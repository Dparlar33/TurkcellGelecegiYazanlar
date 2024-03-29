package com.turkcell.rentacar.business.rules;

import com.turkcell.rentacar.adapter.FindexService;
import com.turkcell.rentacar.adapter.result.FindexResult;
import com.turkcell.rentacar.business.messages.CarMessages;
import com.turkcell.rentacar.business.messages.RentalMessages;
import com.turkcell.rentacar.business.outService.BankService;
import com.turkcell.rentacar.core.utilities.exceptions.types.BusinessException;
import com.turkcell.rentacar.dataAccess.abstracts.CarRepository;
import com.turkcell.rentacar.dataAccess.abstracts.RentalRepository;
import com.turkcell.rentacar.entities.concretes.Car;
import com.turkcell.rentacar.entities.concretes.Rental;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.temporal.ChronoUnit;
import java.util.Optional;

@Service
@AllArgsConstructor
public class RentalBusinessRules {
    private CarRepository carRepository;
    private FindexService findexService;
    private CarBusinessRules carBusinessRules;
    private RentalRepository rentalRepository;
    private BankService bankService;

    public int calculateTotalPriceofRental(Rental rental) {
        int days = (int) ChronoUnit.DAYS.between(rental.getStartDate(), rental.getEndDate());
        Car car = this.carRepository.findById(rental.getCar().getId()).orElse(null);
        return car.getDailyPrice() * days;
    }

    public void isCarAvailable(Rental rental){
        Car car = this.carRepository.findById(rental.getCar().getId()).orElse(null);
        assert car != null;
        if (!(car.getState() == Car.State.Available)){  //1 available 2- maintenance 3- rented
            throw new BusinessException(RentalMessages.CAR_NOT_AVAILABLE);
        }
    }
    public void isCarExistById(Rental rental){
        Optional<Car> car = this.carRepository.findById(rental.getCar().getId());
        this.carBusinessRules.isCarExistById(rental.getCar().getId());
        if (car.isEmpty()){
            throw new BusinessException(CarMessages.CAR_NOT_EXIST);
        }
    }
    public void compareCarAndCustomerFindexScore(Rental rental){
        FindexResult findexResult = this.findexService.getFindexScoreofCustomer(rental.getCustomer().getId());
        Car car = this.carRepository.findById(rental.getCar().getId()).orElse(null);
        if (findexResult.getFindexScore() <= car.getFindexScore()){
            throw new BusinessException(RentalMessages.CUSTOMER_FINDEXSCORE_NOT_ENOUGH);
        }
    }
    public void isRentalExistById(int id){
        Optional<Rental> rental = this.rentalRepository.findById(id);
        if (rental.isEmpty()){
            throw  new BusinessException(RentalMessages.RENTAL_NOT_EXIST);
        }
    }
   public void isRentalEmptyById(int id){
        Optional<Rental> rental = this.rentalRepository.findById(id);
        if (rental.isEmpty()){
            throw new BusinessException(RentalMessages.RENTAL_IS_NULL);
        }
   }
   public void checkDatesAreCorrect(Rental rental){
        if (calculateTotalPriceofRental(rental) < 0){
            throw new BusinessException(RentalMessages.DATES_ARE_INCORRECT);
        }
   }
   public void checkCustomerBalanceForPayment(Rental rental){
       if ( ! this.bankService.makePayment(rental).isMakePayment()){
           throw new BusinessException(RentalMessages.BALANCE_NOT_ENOUGH);
       }
   }
}
