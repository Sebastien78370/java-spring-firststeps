package com.springapp.mvc.firststeps;

import java.util.List;

/**
 * Created by sktifa on 13/09/2016.
 */
public interface ZooService {
    List<Animal> retrieveAnimals();
    List<Animal> retrieveHerbivores();
    List<Animal> retrieveCarnivores();
    Animal retrieveAnimal(String name) throws UnknownAnimalException;
    Animal retrieveOlderAnimal();
    Animal retrieveYoungerAnimal();
    String animalShouldSayHello(String name);
}
