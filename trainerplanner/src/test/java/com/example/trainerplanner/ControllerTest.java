package com.example.trainerplanner;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.example.trainerplanner.trainerController.*;

//Smoke-testing, testaa toimiiko päätoiminnot ennen kuin aloitetaan viralliset testaukset

@RunWith(SpringRunner.class)
@SpringBootTest
public class ControllerTest {

    @Autowired
    private TrainerController tcontroller;

    @Test
    public void contexLoads() throws Exception {
        assertThat(tcontroller).isNotNull();
    }	
}