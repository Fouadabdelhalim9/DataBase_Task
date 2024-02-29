package org.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Size {
    private Integer id;
    private String name;

    public Size(String name) {
        this.name = name;
    }
}
