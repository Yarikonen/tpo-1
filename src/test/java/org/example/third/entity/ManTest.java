package org.example.third.entity;

import org.example.third.entity.enums.GamblerType;
import org.example.third.entity.enums.HeartType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class ManTest {

    Man man = new Man("TestMan", HeartType.BRAVE, GamblerType.BRAVE);

    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp(){
        System.setOut(new PrintStream(outputStream));
    }

    @Test
    void testIsReal() {
        Assertions.assertTrue(man.isReal());
    }


    @ParameterizedTest
    @ValueSource(strings = {"ordinary","timid"})
    void testIsRealIfOtherGamblerType(String type) {
        man.setGamblerType(type);
        Assertions.assertFalse(man.isReal());
    }

    @ParameterizedTest
    @ValueSource(strings = {"ordinary","timid"})
    void testIsRealIfOtherHeartType(String type){
        man.setHeartType(type);
        Assertions.assertFalse(man.isReal());
    }


    @Test
    void testSpeak() {
        man.speak();
        String expected = "Моё сердце бьеться отважно\n" +
                "Я - TestMan, и я играю и ставлю всё на зеленое\n" +
                "Поэтому - Я крутой настоящий мужчина\n";
        Assertions.assertEquals(expected, outputStream.toString());
    }

    @Test
    void testSpeakIfNotReal() {
        man.setGamblerType("ORDINARY");
        man.speak();
        String expected = "Моё сердце бьеться отважно\n" +
                "Я - TestMan, и я играю в блекджек\n" +
                "Поэтому - Я обычный семьянин\n";
        Assertions.assertEquals(expected, outputStream.toString());
    }


}