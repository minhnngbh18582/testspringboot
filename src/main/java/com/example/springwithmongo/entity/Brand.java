package com.example.springwithmongo.entity;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "BrandDB")
@Data
public class Brand {
    @Id
    private long id;
    @NotBlank
    @Size(max = 100)
    @Indexed(unique = true)
    private String name;
    private String description;
    @DBRef
    List<Product> products;
}
