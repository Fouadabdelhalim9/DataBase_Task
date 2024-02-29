package org.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductSize {
    private Integer id;
    private Float price;
    private Integer quantity;
    private Integer productId;
    private Integer sizeId;

    public ProductSize(Float price, Integer quantity, Integer productId, Integer sizeId) {
        this.price = price;
        this.quantity = quantity;
        this.productId = productId;
        this.sizeId = sizeId;
    }
}
