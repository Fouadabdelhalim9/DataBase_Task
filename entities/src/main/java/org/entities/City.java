package org.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class City {
    private Integer id;
    private String name;

    public City(String name) {
        this.name = name;
    }
}
