package com.example.springwithmongo.service.Brand;

import com.example.springwithmongo.entity.Brand;
import com.example.springwithmongo.exception.ResourceNotFoundException;
import com.example.springwithmongo.repository.BrandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class BrandServiceImpl implements BrandService {
    @Autowired
    private BrandRepository brandRepository;

    public BrandServiceImpl(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }

    @Override
    public Brand createBrand(Brand brand) {
        return brandRepository.save(brand);
    }

    @Override
    public Brand updateBrand(Brand brand) {
        Optional<Brand> brandOptional = brandRepository.findById(brand.getId());
        if (brandOptional.isPresent()) {
            Brand updateValue = brandOptional.get();
            updateValue.setId(brand.getId());
            updateValue.setName(brand.getName());
            updateValue.setDescription(brand.getDescription());
            brandRepository.save(updateValue);
            return updateValue;
        } else {
            throw new ResourceNotFoundException("Record not found with id: " + brand.getId());
        }
    }

    @Override
    public List<Brand> getAllBrand() {
        return brandRepository.findAll();
    }

    @Override
    public Brand getBrandById(long brandId) {
        Optional<Brand> brandOptional = brandRepository.findById(brandId);
        if (brandOptional.isPresent()) {
            return brandOptional.get();
        } else {
            throw new ResourceNotFoundException("Record not found with Id: " + brandId);
        }
    }

    @Override
    public void deleteBrand(long brandId) {
        Optional<Brand> brandOptional = brandRepository.findById(brandId);
        if (brandOptional.isPresent()) {
            brandRepository.delete(brandOptional.get());
        } else {
            throw new ResourceNotFoundException("Record not found with id: " + brandId);
        }
    }
}
