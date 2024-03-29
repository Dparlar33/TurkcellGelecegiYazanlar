package com.turkcell.rentacar.business.concretes;

import com.turkcell.rentacar.business.abstracts.BrandService;
import com.turkcell.rentacar.business.dtos.requests.brands.CreateBrandRequest;
import com.turkcell.rentacar.business.dtos.requests.brands.UpdateBrandRequest;
import com.turkcell.rentacar.business.dtos.responses.brands.*;
import com.turkcell.rentacar.business.rules.BrandBusinessRules;
import com.turkcell.rentacar.core.utilities.mapping.ModelMapperService;
import com.turkcell.rentacar.dataAccess.abstracts.BrandRepository;
import com.turkcell.rentacar.entities.concretes.Brand;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class BrandManager implements BrandService {
    private BrandRepository brandRepository;
    private ModelMapperService modelMapperService;
    private BrandBusinessRules brandBusinessRules;
//AOP aspect orient programming
    @Override
    public CreatedBrandResponse add(CreateBrandRequest createBrandRequest) {
        this.brandBusinessRules.brandNameCanNotBeDuplicated(createBrandRequest.getName());

        Brand brand = this.modelMapperService.forRequest().map(createBrandRequest,Brand.class);
        brand.setCreatedDate(LocalDateTime.now());

        Brand createdBrand =  brandRepository.save(brand);
        return this.modelMapperService.forResponse().map(createdBrand,CreatedBrandResponse.class);
    }

    @Override
    public GetByIdBrandResponse getById(int id) {
        this.brandBusinessRules.isBrandExistById(id);
        Brand brand = this.brandRepository.findById(id).orElse(null);

        return this.modelMapperService.forResponse().map(brand, GetByIdBrandResponse.class);
    }

    @Override
    public List<GetAllBrandResponse> getAll() {
        List<Brand> brands = this.brandRepository.findAll();
        this.brandBusinessRules.processActiveBrandsOnly();

        return brands.stream().map(brand -> this.modelMapperService.forResponse().
                map(brand, GetAllBrandResponse.class)).collect(Collectors.toList());
    }

    @Override
    public UpdatedBrandResponse update(UpdateBrandRequest updateBrandRequest) {
        this.brandBusinessRules.isBrandExistById(updateBrandRequest.getId());
        this.brandBusinessRules.brandNameCanNotBeDuplicated(updateBrandRequest.getName());

        Brand brand = this.modelMapperService.forRequest().map(updateBrandRequest,Brand.class);
        brand.setUpdatedDate(LocalDateTime.now());

        this.brandRepository.save(brand);
        return this.modelMapperService.forResponse().map(brand,UpdatedBrandResponse.class);
    }

    @Override
    public DeletedBrandResponse delete(int id) {
        this.brandBusinessRules.isBrandExistById(id);
        Brand brand = this.brandRepository.findById(id).orElse(null);
        brand.setDeletedDate(LocalDateTime.now());
        return this.modelMapperService.forResponse().map(brand,DeletedBrandResponse.class);
    }
}
