package com.bot.dto;

import com.bot.model.City;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CityDTO {

    private String name;
    private String description;

    public City toCity(){
        return setFields();
    }


    private City setFields(){
        City city = new City();
        city.setName(name);
        city.setDescription(description);
        return city;
    }

}
