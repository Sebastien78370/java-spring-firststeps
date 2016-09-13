package com.springapp.mvc.firststeps;

import org.springframework.stereotype.Component;

/**
 * Created by sktifa on 13/09/2016.
 */
@Component
public class Zebra extends AbstractAnimal {

    public Zebra() {
        super("Zebra", Constants.HERBIVORE);
    }

    @Override
    public String sayHello() {
        return "hiiiiiiiiiiiiiii";
    }
}
