package com.springapp.mvc.firststeps;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ZooServiceImpl implements ZooService {

    private final List<Animal> animals;

    @Autowired
    public ZooServiceImpl(List<Animal> animals) {
        this.animals = animals;
    }

    @Override
    public List<Animal> retrieveAnimals() {
        return animals;
    }

    @Override
    public List<Animal> retrieveHerbivores() {
        return animals
                .stream()
                .filter(a -> Constants.HERBIVORE.equals(((AbstractAnimal)a).getNature()))
                .collect(Collectors.toList());
    }

    @Override
    public List<Animal> retrieveCarnivores() {
        return animals
                .stream()
                .filter(a -> Constants.CARNIVORE.equals(((AbstractAnimal)a).getNature()))
                .collect(Collectors.toList());
    }

    @Override
    public Animal retrieveAnimal(String name) throws UnknownAnimalException {
        final Optional<Animal> optional = animals
                .stream()
                .filter(a -> name.equalsIgnoreCase(((AbstractAnimal) a).getName()))
                .findFirst();

        if (!optional.isPresent()){
            throw new UnknownAnimalException(name);
        }
        return optional.get();
    }

    @Override
    public Animal retrieveOlderAnimal() {
        return animals
                .stream()
                .max(Comparator.comparingInt(o -> ((AbstractAnimal) o).getAge()))
                .orElse(null);
    }

    @Override
    public Animal retrieveYoungerAnimal() {
        return animals
                .stream()
                .min(Comparator.comparingInt(o -> ((AbstractAnimal) o).getAge()))
                .orElse(null);
    }

    @Override
    public String animalShouldSayHello(String name) {
        try {
            return retrieveAnimal(name).sayHello();
        } catch (UnknownAnimalException e) {
            e.printStackTrace();
        }
        return "";
    }
}
