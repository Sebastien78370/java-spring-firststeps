package com.springapp.mvc.firststeps;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Created by sktifa on 13/09/2016.
 */
@Service
public class ZooServiceImpl implements ZooService {

    @Autowired
    private List<Animal> animals;

    @Override
    public List<Animal> retrieveAnimals() {
        return animals;
    }

    @Override
    public List<Animal> retrieveHerbivores() {
        return null;
    }

    @Override
    public List<Animal> retrieveCarnivores() {
        return null;
    }

    @Override
    public Animal retrieveAnimal(String name) throws UnknownAnimalException {
        Optional<Animal> animal = animals.stream().filter(a -> ((AbstractAnimal) a).getName().equals(name)).findFirst();
        if (!animal.isPresent()) {
            throw new UnknownAnimalException(name);
        }
        return animal.get();
    }

    @Override
    public String animalShouldSayHello(String name) {
        return null;
    }

    @Override
    public Animal retrieveOlderAnimal() {
        return null;
    }

    @Override
    public Animal retrieveYoungerAnimal() {
        return null;
    }
}
