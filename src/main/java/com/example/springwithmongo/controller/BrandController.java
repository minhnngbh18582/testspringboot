package com.example.springwithmongo.controller;

import com.example.springwithmongo.entity.Brand;
import com.example.springwithmongo.service.Brand.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BrandController {
    @Autowired
    private BrandService brandService;

    public BrandController(BrandService brandService) {
        this.brandService = brandService;
    }

    @GetMapping("/brand")
    public ResponseEntity<List<Brand>> getAllBrand() {
        return ResponseEntity.ok().body(brandService.getAllBrand());
    }

    @GetMapping("/brand/{id}")
    public ResponseEntity<Brand> getBrandById(@PathVariable long id) {
        return ResponseEntity.ok().body(brandService.getBrandById(id));
    }

    @PostMapping("/brand")
    public ResponseEntity<Brand> createBrand(@RequestBody Brand brand) {
        return ResponseEntity.ok().body(brandService.createBrand(brand));
    }

    @PutMapping("/brand/{id}")
    public ResponseEntity<Brand> updateBrand(@PathVariable long id, @RequestBody Brand brand) {
        brand.setId(id);
        return ResponseEntity.ok().body(this.brandService.updateBrand(brand));
    }

    @DeleteMapping("/brand/{id}")
    public HttpStatus deleteBrand(@PathVariable long id) {
        brandService.deleteBrand(id);
        return HttpStatus.OK;
    }
}
