package com.turkcell.rentacar.business.rules;

import com.turkcell.rentacar.business.messages.BrandMessages;
import com.turkcell.rentacar.core.utilities.exceptions.types.BusinessException;
import com.turkcell.rentacar.dataAccess.abstracts.BrandRepository;
import com.turkcell.rentacar.entities.concretes.Brand;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class BrandBusinessRules {
   private BrandRepository brandRepository;
    public void brandNameCanNotBeDuplicated(String brandName){
        Optional<Brand> brand = brandRepository.findByNameIgnoreCase(brandName);
        if(brand.isPresent()){
            throw new BusinessException(BrandMessages.BRAND_NOT_EXIST);
        }
    }
    public void isBrandExistById(int id){
        Optional<Brand> brand = brandRepository.findById(id);
        if(brand.isEmpty()){
            throw new BusinessException(BrandMessages.BRAND_NOT_EXIST);
        }
    }
    public void processActiveBrandsOnly() {
        List<Brand> brands = brandRepository.findByDeletedDateIsNull();
        if (brands.isEmpty()) {
            throw new BusinessException(BrandMessages.ALL_BRANDS_DELETED);
        }
    }

}
