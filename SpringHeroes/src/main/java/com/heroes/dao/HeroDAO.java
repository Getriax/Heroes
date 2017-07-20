package com.heroes.dao;

import org.springframework.data.repository.CrudRepository;

import com.heroes.model.Hero;

public interface HeroDAO extends CrudRepository<Hero, Integer>
{
}
