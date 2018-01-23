package com.springapp.mvc.firststeps;

import org.springframework.stereotype.Component;

@Component
public class LionAnimal extends AbstractAnimal {

    public LionAnimal() {
        super("Lion", 12, Constants.CARNIVORE);
    }

    @Override
    public String sayHello() {
        return "I'm a Lion !";
    }
}
