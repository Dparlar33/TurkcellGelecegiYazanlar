package com.turkcell.rentacar.business.abstracts;

import com.turkcell.rentacar.business.dtos.requests.brands.CreateBrandRequest;
import com.turkcell.rentacar.business.dtos.requests.brands.UpdateBrandRequest;
import com.turkcell.rentacar.business.dtos.responses.brands.*;

import java.util.List;

public interface BrandService {
    public CreatedBrandResponse add(CreateBrandRequest createBrandRequest);
    public GetByIdBrandResponse getById(int id);
    public List<GetAllBrandResponse> getAll();
    public UpdatedBrandResponse update(UpdateBrandRequest updateBrandRequest);
    public DeletedBrandResponse delete(int id);
}
