package org.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Time;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Branch {
    private Integer id;
    private String name;
    private String building;
    private String streetName;
    private Time workingStartTime;
    private Time workingEndTime;
    private String telephone;
    private Integer zoneId;


    public Branch(String name, String building, String streetName, Time workingStartTime, Time workingEndTime, String telephone, Integer zoneId) {
        this.name = name;
        this.building = building;
        this.streetName = streetName;
        this.workingStartTime = workingStartTime;
        this.workingEndTime = workingEndTime;
        this.telephone = telephone;
        this.zoneId = zoneId;
    }
}
