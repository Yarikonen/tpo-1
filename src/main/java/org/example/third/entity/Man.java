package org.example.third.entity;

import org.example.third.entity.enums.GamblerType;
import org.example.third.entity.enums.HeartType;
import org.example.third.interfaces.Reflector;
import org.example.third.interfaces.Speaker;

public class Man extends Creature implements Reflector, Speaker {

    public Man(String name, HeartType heartType, GamblerType gamblerType) {
        super(heartType,name,gamblerType);
    }

    @Override
    public boolean isReal() {
        return super.getHeartType()==HeartType.BRAVE && super.getGamblerType()==GamblerType.BRAVE;
    }

    @Override
    public void speak() {
        System.out.println(super.heartBeat());
        System.out.println(super.gamble());
        if (this.isReal()) {
            System.out.println("Поэтому - Я крутой настоящий мужчина");
        } else {
            System.out.println("Поэтому - Я обычный семьянин");
        }
    }

}
