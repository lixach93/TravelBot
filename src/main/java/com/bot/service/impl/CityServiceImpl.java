package com.bot.service.impl;

import com.bot.dto.CityDTO;
import com.bot.dto.CityOutput;
import com.bot.model.City;
import com.bot.repository.CityRepository;
import com.bot.service.CityService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CityServiceImpl implements CityService {

    private final CityRepository cityRepository;

    public CityServiceImpl(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    @Override
    public CityOutput getByName(String name) {

        Optional<City> optionalCity  = cityRepository.findByName(name);
        optionalCity.orElseThrow(RuntimeException::new);
        return CityOutput.fromCity(optionalCity.get());

    }

    @Override
    public List<CityOutput> getAll(){

        return cityRepository.findAll()
                .stream().
                        map(CityOutput::fromCity)
                .collect(Collectors.toList());
    }

    @Override
    public City getById(long id) {
        return cityRepository.findById(id).orElse(null);
    }

    @Override
    public void create(CityDTO cityDTO) {
        cityRepository.save(cityDTO.toCity());
    }
}
