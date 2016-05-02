package com.controller;

import com.model.Country;
import com.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/country")
public class CountryController {
    @Autowired
    private CountryRepository countryRepository;

    @RequestMapping(value = "/{countryId}", method = RequestMethod.GET)
    Country readCountry(@PathVariable Long countryId) {

        Country country = this.countryRepository.findOne(countryId);
        return country;
    }
}
