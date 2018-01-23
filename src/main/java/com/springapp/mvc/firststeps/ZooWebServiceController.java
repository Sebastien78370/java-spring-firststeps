package com.springapp.mvc.firststeps;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/animal")
public class ZooWebServiceController {

    private final ZooService zooService;

    @Autowired
    public ZooWebServiceController(ZooService zooService) {
        this.zooService = zooService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Animal> retrieveAnimals() {
        return zooService.retrieveAnimals();
    }

    @RequestMapping(value = "{name}", method = RequestMethod.GET)
    public Animal retrieveAnimal(@PathVariable String name) throws UnknownAnimalException {
        return zooService.retrieveAnimal(name);
    }

    @RequestMapping(value = "/allHerbivores", method = RequestMethod.GET, produces = "application/json")
    public List<Animal> getAllHerbivores() {
        return zooService.retrieveHerbivores();
    }

    @RequestMapping(value = "/allCarnivores", method = RequestMethod.GET, produces = "application/json")
    public List<Animal> getAllCarnivores(){
        return zooService.retrieveCarnivores();
    }


    @RequestMapping(value = "/getOlderAnimal", method = RequestMethod.GET, produces = "application/json")
    public Animal getOlderAnimal(){
        return zooService.retrieveOlderAnimal();
    }

    @RequestMapping(value = "/getYoungerAnimal", method = RequestMethod.GET, produces = "application/json")
    public Animal getYoungerAnimal(){
        return zooService.retrieveYoungerAnimal();
    }

    @RequestMapping(value = "/{name}/hello", method = RequestMethod.GET, produces = "application/json")
    public String sayHello(@PathVariable String name){
        return zooService.animalShouldSayHello(name);
    }

    @ExceptionHandler(UnknownAnimalException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public @ResponseBody String expression(UnknownAnimalException e) {
        return e.getMessage();
    }
}
