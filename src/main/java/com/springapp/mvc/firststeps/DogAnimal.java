package com.springapp.mvc.firststeps;

import org.springframework.stereotype.Component;

@Component
public class DogAnimal extends AbstractAnimal {

    public DogAnimal() {
        super("Dog", 1, Constants.CARNIVORE);
    }

    @Override
    public String sayHello() {
        return "I'm a Dog !";
    }
}
