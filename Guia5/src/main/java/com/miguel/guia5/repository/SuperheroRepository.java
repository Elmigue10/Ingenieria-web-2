package com.miguel.guia5.repository;

import com.miguel.guia5.model.Superhero;
import org.springframework.data.repository.CrudRepository;

public interface SuperheroRepository extends CrudRepository<Superhero, Integer> { }
