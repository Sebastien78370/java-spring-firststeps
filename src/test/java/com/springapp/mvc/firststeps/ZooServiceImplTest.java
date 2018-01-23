package com.springapp.mvc.firststeps;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.annotation.Resource;
import java.util.Collections;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration
public class ZooServiceImplTest {

    @Autowired
    private ZooService zooService;

    @Test(expected = UnknownAnimalException.class)
    public void retrieveAnimal() throws Exception {
        zooService.retrieveAnimal("unknowAnimal");
    }

    @Configuration
    static class TestConfiguration {

        @Bean
        public ZooService getZooService() {
            return new ZooServiceImpl(Collections.singletonList(new DogAnimal()));
        }
    }

}