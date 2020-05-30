package com.acn.texchxplore.repository;

import org.springframework.data.repository.CrudRepository;

import com.acn.texchxplore.entity.Item;

public interface ItemRepository extends CrudRepository<Item, Long> {

}
