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

class WomanTest {
    Woman woman = new Woman("TestWoman", HeartType.TIMID, GamblerType.TIMID);

    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp(){
        System.setOut(new PrintStream(outputStream));
    }

    @Test
    void testIsReal() {
        Assertions.assertTrue(woman.isReal());
    }

    @ParameterizedTest
    @ValueSource(strings = {"ordinary","brave"})
    void testIsRealIfOtherGamblerType(String type) {
        woman.setGamblerType(type);
        Assertions.assertFalse(woman.isReal());
    }

    @ParameterizedTest
    @ValueSource(strings = {"ordinary","brave"})
    void testIsRealIfOtherHeartType(String type){
        woman.setHeartType(type);
        Assertions.assertFalse(woman.isReal());
    }

    @Test
    void testSpeak() {
        woman.speak();
        String expected = "Моё сердце бьеться так как оно чувствует\n" +
                "Я - TestWoman, и я играю в русскую рулетку\n" +
                "Поэтому - я крутая настоящая женщина\n";
        Assertions.assertEquals(expected, outputStream.toString());
    }

    @Test
    void testSpeakIfNotReal() {
        woman.setGamblerType("ORDINARY");
        woman.speak();
        String expected = "Моё сердце бьеться так как оно чувствует\n" +
                "Я - TestWoman, и я играю в блекджек\n" +
                "Поэтому - я обычная женщина\n";
        Assertions.assertEquals(expected, outputStream.toString());
    }

}