package com.bot.service;

import com.bot.dto.CityDTO;
import com.bot.dto.CityOutput;
import com.bot.model.City;

import java.util.List;

public interface CityService {

    CityOutput getByName(String name);

    List<CityOutput> getAll();

    City getById(long id);

    void create(CityDTO cityDTO);
}
