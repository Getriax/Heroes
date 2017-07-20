package com.heroes.dao;

import org.springframework.data.repository.CrudRepository;

import com.heroes.model.Item;

public interface ItemDAO extends CrudRepository<Item, Integer>
{

}
