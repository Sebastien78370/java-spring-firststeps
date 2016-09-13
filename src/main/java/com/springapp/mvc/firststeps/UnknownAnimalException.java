package com.springapp.mvc.firststeps;

/**
 * Created by sktifa on 13/09/2016.
 */
public class UnknownAnimalException extends Exception {
    public UnknownAnimalException(String name) {
        super("No animal found with name :" + name);
    }
}
