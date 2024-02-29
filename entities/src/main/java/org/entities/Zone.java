package org.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Zone {
    private Integer id;
    private String name;
    private  Integer cityId;

    public Zone(String name, Integer cityId) {
        this.name = name;
        this.cityId = cityId;
    }
}
