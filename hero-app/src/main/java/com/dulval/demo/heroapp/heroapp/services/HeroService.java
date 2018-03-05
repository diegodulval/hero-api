/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dulval.demo.heroapp.heroapp.services;

import com.dulval.demo.heroapp.heroapp.domain.Hero;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Primary;
import org.springframework.hateoas.Resources;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author diego
 */
@FeignClient(value = "${hero-api.name:null}", url = "${hero-api.url:}", fallback = HeroServiceFallback.class)
@Primary
public interface HeroService {

    @RequestMapping("/heroes")
    Resources<Hero> findAll();

    @RequestMapping(value = "/heroes", method = RequestMethod.POST)
    Hero add(@RequestBody Hero hero);

    @RequestMapping(value = "/heroes/{id}", method = RequestMethod.PUT)
    Hero update(@PathVariable("id") Long id, @RequestBody Hero company);

    @RequestMapping(value = "/heroes/{id}", method = RequestMethod.DELETE)
    void delete(@PathVariable("id") Long id);

}
