package org.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    private Integer id;
    private String name;
    private String description;
    private String picturePath;
    private Integer categoryId;
    private Integer brandId;

    public Product(String name, String description, String picturePath, Integer categoryId, Integer brandId) {
        this.name = name;
        this.description = description;
        this.picturePath = picturePath;
        this.categoryId = categoryId;
        this.brandId = brandId;
    }
}
