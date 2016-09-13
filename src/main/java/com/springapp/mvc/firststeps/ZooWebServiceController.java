package com.springapp.mvc.firststeps;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by sktifa on 13/09/2016.
 */
@RestController
@RequestMapping("/animal")
public class ZooWebServiceController {

    @Autowired
    private ZooService zooService;

    @RequestMapping(method = RequestMethod.GET)
    public List<Animal> animals() {
        return zooService.retrieveAnimals();
    }

    @RequestMapping(value = "{name}", method = RequestMethod.GET)
    public Animal animals(@PathVariable String name) throws UnknownAnimalException {
        return zooService.retrieveAnimal(name);
    }

    @ExceptionHandler
    @ResponseBody
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public String handleException(UnknownAnimalException e) {
        return e.getMessage();
    }
}
