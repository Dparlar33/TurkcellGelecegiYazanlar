package com.turkcell.rentacar.dataAccess.abstracts;

import com.turkcell.rentacar.entities.concretes.Brand;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BrandRepository extends JpaRepository<Brand,Integer> {
    Optional<Brand> findByNameIgnoreCase(String name);
    List<Brand> findByDeletedDateIsNull();
}
//select * from brands where name = @name or AbcField = @abcField gibi çalışır.(reserve kelimeler)