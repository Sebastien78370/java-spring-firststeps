package com.springapp.mvc.firststeps;

import org.springframework.stereotype.Component;

@Component
public class HorseAnimal extends AbstractAnimal {

    public HorseAnimal() {
        super("Horse", 5, Constants.CARNIVORE);
    }

    @Override
    public String sayHello() {
        return "I'm a Horse !";
    }
}
