package org.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Brand {
    private Integer id;
    private String name;
    private String logoPath;

    public Brand(String name, String logoPath) {
        this.name = name;
        this.logoPath = logoPath;
    }
}
