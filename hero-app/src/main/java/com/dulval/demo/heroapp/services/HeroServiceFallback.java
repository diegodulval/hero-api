/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dulval.demo.heroapp.services;

import com.dulval.demo.heroapp.domain.Hero;
import org.springframework.hateoas.Resources;
import org.springframework.stereotype.Service;

/**
 *
 * @author diego
 */
@Service
public class HeroServiceFallback implements HeroService {

    @Override
    public Resources<Hero> findAll() {
        return null;
    }

    @Override
    public Hero add(Hero hero) {
        return null;
    }

    @Override
    public Hero update(Long id, Hero hero) {
        return null;
    }

    @Override
    public void delete(Long id) {
    }

}
