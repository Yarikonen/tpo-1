package org.example.third.entity;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CreatureTest {
    Creature creature = new Creature("TestCreature");

    @Test
    void testBraveHeartBeat() {
        creature.setHeartType("BRaVE");
        Assertions.assertEquals("Моё сердце бьеться отважно", creature.heartBeat());
    }

    @Test
    void testTimidHeartBeat() {
        creature.setHeartType("TIMID");
        Assertions.assertEquals("Моё сердце бьеться так как оно чувствует", creature.heartBeat());
    }

    @Test
    void testOrdinaryHeartBeat() {
        creature.setHeartType("ORDINARY");
        Assertions.assertEquals("Моё сердце бьеться сомнительно, но окей", creature.heartBeat());
    }

    @Test
    void testHeartBeatIfIllegalHeartType() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> creature.setHeartType("ILLEGAL"));
    }

    @Test
    void testBraveGamble() {
        creature.setGamblerType("BRAVE");
        Assertions.assertEquals("Я - TestCreature, и я играю и ставлю всё на зеленое", creature.gamble());
    }

    @Test
    void testOrdinaryGamble() {
        creature.setGamblerType("Ordinary");
        Assertions.assertEquals("Я - TestCreature, и я играю в блекджек", creature.gamble());
    }

    @Test
    void testTimidGamble() {
        creature.setGamblerType("Timid");
        Assertions.assertEquals("Я - TestCreature, и я играю в русскую рулетку", creature.gamble());

    }

    @Test
    void testGambleIfIllegalGamblerType() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> creature.setGamblerType("ILLEGAL"));
    }

}