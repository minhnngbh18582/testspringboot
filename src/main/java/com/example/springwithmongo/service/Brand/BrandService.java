package com.example.springwithmongo.service.Brand;

import com.example.springwithmongo.entity.Brand;

import java.util.List;

public interface BrandService {
    Brand createBrand(Brand brand);

    Brand updateBrand(Brand brand);

    List<Brand> getAllBrand();

    Brand getBrandById(long brandId);

    void deleteBrand(long brandId);
}
