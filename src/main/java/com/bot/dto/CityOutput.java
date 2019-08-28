package com.bot.dto;

import com.bot.model.City;
import lombok.Data;

@Data
public class CityOutput {

    private Long id;
    private String name;
    private String description;
    private String url;


    public static CityOutput fromCity(City city) {
        CityOutput cityOutput = new CityOutput();
        cityOutput.setId(city.getId());
        cityOutput.setName(city.getName());
        cityOutput.setDescription(city.getDescription());
        cityOutput.setUrl(city.getUrl());
        return cityOutput;
    }

    @Override
    public String toString() {
        return
                name + " \n" +
                        description + '\n' +
                        (url == null ? "" : url);

    }
}
