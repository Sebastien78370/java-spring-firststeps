package com.springapp.mvc.firststeps;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Optional;

/**
 * Created by sktifa on 13/09/2016.
 */
@Component
public class Lion extends AbstractAnimal {

    @Autowired
    private transient PixaBayService pixaBayService;

    public Lion() {
        super("Lion", Constants.CARNIVORE);
    }

    @PostConstruct
    public void init() {
        Optional<String> url = pixaBayService.retrievePicture(getName());
        if (url.isPresent()) {
            setPreviewUrl(url.get());
        }
    }

    @Override
    public String sayHello() {
        return "Roooaarrr";
    }
}
